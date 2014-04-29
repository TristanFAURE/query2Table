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
package org.topcased.model2doc.query2table.launcher.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.topcased.model2doc.query2table.launcher.Activator;
import org.topcased.model2doc.query2table.launcher.run.Export2TableRunnable;

public class Export2TableLauncher implements IWorkbenchWindowActionDelegate
{

    private IStructuredSelection selection;

    public void run(IAction arg0)
    {
        if (selection.getFirstElement() instanceof IFile)
        {
            final IFile currentFile = (IFile) selection.getFirstElement();
            Job queryToTableJob = new Job("Transform query2Table")
            {
                @Override
                protected IStatus run(IProgressMonitor arg0)
                {
                    try
                    {
                        new Export2TableRunnable(currentFile).run(arg0);
                    }
                    catch (InvocationTargetException e)
                    {
                        Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
                        Activator.getDefault().getLog().log(status);
                        return status;
                    }
                    catch (InterruptedException e)
                    {
                        Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
                        Activator.getDefault().getLog().log(status);
                        return status;
                    }
                    return Status.OK_STATUS;
                }
            };
            queryToTableJob.setUser(true);
            queryToTableJob.schedule(0);
        }

    }

    public void selectionChanged(IAction action, ISelection newSelection)
    {
        this.selection = (IStructuredSelection) newSelection;

    }

    public void dispose()
    {
        // do nothing

    }

    public void init(IWorkbenchWindow arg0)
    {
        // do nothing
    }

}
