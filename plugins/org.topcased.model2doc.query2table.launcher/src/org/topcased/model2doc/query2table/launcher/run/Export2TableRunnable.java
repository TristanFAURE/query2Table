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
package org.topcased.model2doc.query2table.launcher.run;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.topcased.model2doc.query2table.exception.InvalidModelExportFileException;
import org.topcased.model2doc.query2table.export.Export2TableAction;
import org.topcased.model2doc.query2table.launcher.Activator;

public class Export2TableRunnable implements IRunnableWithProgress
{

    /** The current file. */
    private final IFile currentFile;
    
    public Export2TableRunnable(IFile selectedFile)
    {
        this.currentFile = selectedFile;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
    {
        try
        {
            Export2TableAction action = new Export2TableAction();
            String result = action.queryToTable(currentFile, monitor);
            handleDiagnostic(new BasicDiagnostic(Diagnostic.OK, Activator.PLUGIN_ID, 0, "Successful export" , null), "Successful export", result);
        }
        catch (IOException e)
        {
            handleDiagnostic(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), null), "An error occured during export.", null);
        }
        catch (InvalidModelExportFileException e)
        {
            handleDiagnostic(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), null), "An error occured during export.", null);
        }
        catch(Throwable t){
        	t.printStackTrace();
        	handleDiagnostic(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, t.getMessage(), t.getStackTrace()), "An unexpected error occured during export.", null);
        }

    }

    /**
     * Handle diagnostic.
     * 
     * @param resultDiagnostic the result diagnostic
     */
    private void handleDiagnostic(final Diagnostic resultDiagnostic, final String message, final String resultFilePath)
    {
        if (resultDiagnostic.getSeverity() == Diagnostic.OK)
        {
            Display.getDefault().syncExec(new Runnable()
            {
                public void run()
                {
                    MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Query to table", "The table has been successfully exported to the following location: \n"
                            + resultFilePath);
                }
            });
        }
        else
        {
            Display.getDefault().syncExec(new Runnable()
            {
                public void run()
                {
                    String path = "";
                    if (resultFilePath != null)
                    {
                        path = resultFilePath;
                    }
                    ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Query to table", message + path, BasicDiagnostic.toIStatus(resultDiagnostic));
                }
            });
        }

    }
    

}
