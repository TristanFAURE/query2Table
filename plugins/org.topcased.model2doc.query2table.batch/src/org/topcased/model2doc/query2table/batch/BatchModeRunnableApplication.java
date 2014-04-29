/*****************************************************************************
 * Copyright (c) 2014 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Anne Haugommard(Atos) anne.haugommard@atos.net - Initial API and implementation
 *  
 *****************************************************************************/
package org.topcased.model2doc.query2table.batch;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.statushandlers.AbstractStatusHandler;
import org.topcased.facilities.util.ArgOpt;
import org.topcased.facilities.util.GetOpt;
import org.topcased.model2doc.query2table.EMFContext;
import org.topcased.model2doc.query2table.ModelExport;
import org.topcased.model2doc.query2table.export.Export2TableAction;

@SuppressWarnings("restriction")
public class BatchModeRunnableApplication implements IApplication
{
    public static final String MODEL_FILE_ARG_NAME = "model_file";

    public static final String INPUT_FILE_ARG_NAME = "input_file";

    public static final String OUTPUT_FILE_ARG_NAME = "output_file";

    public static final String LOG_FILE_ARG_NAME = "log_file";

    public static final ArgOpt[] listOpts = new ArgOpt[] {
            new ArgOpt(MODEL_FILE_ARG_NAME, ArgOpt.REQUIRED_ARGUMENT, ArgOpt.REQUIRED_ARGUMENT_VALUE, "model", "query2table model uri or file path."),
            new ArgOpt(INPUT_FILE_ARG_NAME, ArgOpt.OPTIONAL_ARGUMENT, ArgOpt.REQUIRED_ARGUMENT_VALUE, "i",
                    "input uri or file path. If not specified the input specified in the context of the model is used."),
            new ArgOpt(OUTPUT_FILE_ARG_NAME, ArgOpt.OPTIONAL_ARGUMENT, ArgOpt.REQUIRED_ARGUMENT_VALUE, "o", "output uri or file path. If not specified the output specified in the model is used."),
            new ArgOpt(LOG_FILE_ARG_NAME, ArgOpt.OPTIONAL_ARGUMENT, ArgOpt.REQUIRED_ARGUMENT_VALUE, "log", "log file path.")};

    public static Logger logger = Logger.getRootLogger();

    /**
     * Start the batch mode
     */
    public Object start(IApplicationContext context) throws Exception
    {
        Display.getDefault().wake();
        setupWorkbench();
        PrintStream pStream = new PrintStream(new LoggingErrStream());
        System.setErr(pStream);
        String[] args = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);

        /*
         * Test arguments/options requirement and integrity
         */
        GetOpt getOpt = new GetOpt();
        String argFlat = getOpt.getFlatArguments(args);
        HashMap<String, String> parameters = new HashMap<String, String>();

        boolean validArguments = true;

        if (argFlat.indexOf("--help") >= 0 || argFlat.indexOf("-h") >= 0)
        {

            getOpt.printHelp(listOpts);
            validArguments = false;
        }
        else
        {
            parameters = getOpt.getArguments(listOpts, args);
            if (GetOpt.error == null || GetOpt.error.length() > 0)
            {
                System.out.println(GetOpt.error);
                validArguments = false;
            }

        }

        /**
         * If the arguments are valids
         */
        if (validArguments)
        {
            String argModelFile = parameters.get(MODEL_FILE_ARG_NAME);
            String argInputFile = parameters.get(INPUT_FILE_ARG_NAME);
            String argOutputFile = parameters.get(OUTPUT_FILE_ARG_NAME);
            String argLogFile = parameters.get(LOG_FILE_ARG_NAME);

            /*
             * Manage log file argument
             */
            if (argLogFile != null)
            {
                createLogFile(argLogFile);
            }

            log(Level.INFO, "Starting the batch mode...");
            log(Level.INFO, "---------------------");

            /*
             * Launch batch mode
             */

            try
            {
                ResourceSet resourceSet = new ResourceSetImpl();

                Resource modelResource = null;
                try
                {
                    URI modelURI = URI.createURI(argModelFile);
                    if (!(modelURI.isFile() || modelURI.isPlatform() || modelURI.isArchive()))
                    {
                        // not a standard eclipse uri, treat as file path
                        modelURI = URI.createFileURI(argModelFile);
                    }
                    modelResource = resourceSet.getResource(modelURI, true);
                }
                catch (Exception e)
                {
                }

                ModelExport modelExport = null;
                if (modelResource != null && !modelResource.getContents().isEmpty())
                {
                    EObject root = modelResource.getContents().get(0);
                    if (root != null && root instanceof ModelExport)
                    {
                        modelExport = (ModelExport) root;
                    }
                }

                if (modelExport == null)
                {
                    throw new Exception("Your query2table model does not exist or is invalid");
                }

                EObject initialEObject = null;
                Resource inputResource = null;
                try
                {
                    URI inputURI = URI.createURI(argInputFile);
                    if (!(inputURI.isFile() || inputURI.isPlatform() || inputURI.isArchive()))
                    {
                        // not a standard eclipse uri, treat as file path
                        inputURI = URI.createFileURI(argInputFile);
                    }
                    inputResource = resourceSet.getResource(inputURI, true);
                    if (inputURI.hasFragment())
                    {
                        initialEObject = inputResource.getEObject(inputURI.fragment());
                    }
                }
                catch (Exception e)
                {
                }

                if (initialEObject == null && inputResource != null && !inputResource.getContents().isEmpty())
                {
                    // treat the uri as a ressource uri
                    initialEObject = inputResource.getContents().get(0);
                }

                // if it is null it will try to use the value inside the query2table model
                if (initialEObject != null)
                {
                    EMFContext emfContext = modelExport.getEmfContext();
                    if (emfContext == null)
                    {
                        throw new Exception("The initial context of your query2table model is null which is invalid");
                    }

                    emfContext.setModelElement(initialEObject);
                }

                URI outputURI = null;
                try
                {
                    outputURI = URI.createURI(argOutputFile);
                    if (!outputURI.isFile())
                    {
                        // not a file uri, treat as file path
                        outputURI = URI.createFileURI(argOutputFile);
                    }
                }
                catch (Exception e)
                {
                }

                if (outputURI != null && outputURI.isFile())
                {
                    modelExport.setOutputPath(outputURI.toFileString());
                }

                Export2TableAction action = new Export2TableAction();
                action.queryToTable(modelExport);
            }
            catch (Exception e)
            {
                /*
                 * All exceptions are catches in this try/catch statement. If a log file is used, the details of the log
                 * is written in this file Else, only the simple message of the exception is displayed in the console
                 */
                if (parameters.containsKey(LOG_FILE_ARG_NAME))
                {
                    e.printStackTrace(pStream);
                    pStream.flush();
                    FileAppender fAppender = (FileAppender) logger.getAppender("logFile");
                    PatternLayout pLayout = (PatternLayout) fAppender.getLayout();
                    fAppender.setLayout(new PatternLayout(""));
                    logger.log(Level.INFO, "\n$$$$$$$$$$$$$--ERROR--$$$$$$$$$$$$$");
                    logger.log(Level.ERROR, " exception occured in the generation : " + e);
                    logger.log(Level.ERROR, "  Please, see error log for details");
                    logger.log(Level.INFO, "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
                    fAppender.setLayout(pLayout);
                }
                else
                {
                    log(Level.INFO, "\n$$$$$$$$$$$$$--ERROR--$$$$$$$$$$$$$");
                    log(Level.ERROR, " exception occured in the generation : " + e);
                    log(Level.INFO, "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
                }
            }
        }

        /*
         * Stop the application
         */
        stop();

        return EXIT_OK;
    }

    private void setupWorkbench()
    {
        Workbench.createAndRunWorkbench(Display.getDefault(), new WorkbenchAdvisor()
        {
            @Override
            public String getInitialWindowPerspectiveId()
            {
                return "";
            }

            @Override
            public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer)
            {
                return null;
            }

            @Override
            public IAdaptable getDefaultPageInput()
            {
                return null;
            }

            @Override
            public String getMainPreferencePageId()
            {
                return "";
            }

            @Override
            protected IWorkbenchConfigurer getWorkbenchConfigurer()
            {
                return null;
            }

            @Override
            public synchronized AbstractStatusHandler getWorkbenchErrorHandler()
            {
                return null;
            }

            @Override
            public void initialize(IWorkbenchConfigurer configurer)
            {
            }

            @Override
            public boolean openWindows()
            {
                return false;
            }

            @Override
            public IStatus restoreState(IMemento memento)
            {
                return null;
            }

            @Override
            public IStatus saveState(IMemento memento)
            {
                return null;
            }
        });
    }

    /**
     * Indicate the end of the generation
     */
    public void stop()
    {
        log(Level.INFO, "End of batch mode generation");
    }

    /**
     * Create a logger and specify a log file where to store log and trace messages
     */
    private void createLogFile(String logFilePath) throws IOException
    {
        if (logFilePath.endsWith(".log") || logFilePath.endsWith(".txt"))
        {
            if (logFilePath != null && logFilePath.length() > 0)
            {
                PatternLayout layout = new PatternLayout("%d %-5p %m%n");
                FileAppender fAppender = new FileAppender(layout, logFilePath);
                fAppender.setName("logFile");
                logger.addAppender(fAppender);
            }
        }
    }

    /**
     * Launch log in console and in log file
     * 
     * @param p
     * @param message
     */
    public static void log(Priority p, Object message)
    {
        FileAppender fAppender = (FileAppender) logger.getAppender("logFile");
        ConsoleAppender console = (ConsoleAppender) logger.getAppender("CONSOLE");
        PatternLayout fileLayout = null;
        PatternLayout consoleLayout = null;
        String patternString = "%d %-5p %m%n";
        String patternString4Console = "%m%n";
        if (p.equals(Level.ERROR))
        {
            patternString = "%d %-5p - %F:%L - %m%n";
            patternString4Console = "%d %-5p - %m%n";
        }
        fileLayout = new PatternLayout(patternString);
        if (fAppender != null)
            fAppender.setLayout(fileLayout);
        consoleLayout = new PatternLayout(patternString4Console);
        if (console != null)
            console.setLayout(consoleLayout);
        logger.log(p, message);
    }

    /**
     * Redirect a stream to the logger Used in this class for redirecting the System.err printstream to the logger.
     * 
     * @author asaintgi
     * 
     */
    private class LoggingErrStream extends ByteArrayOutputStream
    {
        public LoggingErrStream()
        {
            super();
        }

        private final Pattern patternForTokens = Pattern.compile("ID syst.me inconnu.*Jetons incorrects suppl.mentaires.*\\s*");

        public void flush() throws IOException
        {
            super.flush();
            String message = this.toString();
            super.reset();
            if (!patternForTokens.matcher(message).matches())
            {
                ConsoleAppender console = (ConsoleAppender) logger.getAppender("CONSOLE");
                FileAppender fAppender = (FileAppender) logger.getAppender("logFile");
                PatternLayout pLayout = (PatternLayout) console.getLayout();
                console.setLayout(new PatternLayout(""));
                PatternLayout filepLayout = (PatternLayout) fAppender.getLayout();
                fAppender.setLayout(new PatternLayout("%d %-5p - %F:%L - %m%n"));
                logger.log(Level.ERROR, message);
                console.setLayout(pLayout);
                fAppender.setLayout(filepLayout);
            }
        }
    }
}
