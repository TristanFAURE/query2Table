/*****************************************************************************
 * Copyright (c) 2014 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.topcased.model2doc.query2table.ui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.topcased.model2doc.query2table.ModelExport;
import org.topcased.model2doc.query2table.export.Export2TableAction;
import org.topcased.model2doc.query2table.ui.Query2TableController.RadioConfig;
import org.topcased.model2doc.query2table.ui.pages.ConfigurationWizardPage;
import org.topcased.model2doc.query2table.ui.pages.SelectionWizardPage;
import org.topcased.model2doc.query2table.ui.preferences.IPreferenceSavable;
import org.topcased.model2doc.query2table.ui.preferences.IPreferenceSaver;
import org.topcased.model2doc.query2table.ui.widgets.Query2TableToolkit;

public class Query2TableWizard extends Wizard implements IWorkbenchWizard, IPreferenceSaver {

	private SelectionWizardPage selectionPage;
	private ConfigurationWizardPage configurationPage;
	private Query2TableController controller;
	private List<IPreferenceSavable> list = new LinkedList<IPreferenceSavable>();
	/**
	 * Constructor
	 */
	public Query2TableWizard() {
		this.controller = new Query2TableController();
	}
 

	@Override
	public IWizardPage getPage(String name) {
		return super.getPage(name);
	}

	@Override
	public String getWindowTitle() {
		return "Query 2 table creation wizard";
	}


	@Override
	public boolean performFinish() {
		for (IPreferenceSavable s : list)
		{
			s.save();
		}
		ModelExport export = controller.getQ2T().getModelExport();
		if(controller.getRadioConfig() == RadioConfig.NEW && !controller.getIsSaved()){
			if  (MessageDialog.openQuestion(getShell(), "Save before leaving?", "You have not saved, do you want to?")){
				if(!controller.getIsSaved()){
				try {
					controller.getQ2T().resourcesSave() ;
					controller.setIsSaved(true);
				} catch (Exception e) {
					MessageDialog.openError(getShell(), "Error", e.getMessage());
				}
				}
			}else{
				return false;
			}
		}
		Export2TableAction action = new Export2TableAction();
		try
		{
			String result = action.queryToTable(export);
			MessageDialog.openInformation(getShell(), "Result", "File has been generated at : " + result);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			((WizardPage)getContainer().getCurrentPage()).setErrorMessage(e.getMessage() == null ? e.toString() : e.getMessage());
			return false ;
		}
	}

	public void addPages() {
		Query2TableToolkit toolkit = new Query2TableToolkit(Display.getDefault());
		selectionPage = new SelectionWizardPage(toolkit, controller);
		addPage(selectionPage);
	}
	
	

	@Override
	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
	}


	public void init(IWorkbench arg0, IStructuredSelection arg1) {
		if (arg1.getFirstElement() instanceof IFile) {
			IFile file = (IFile) arg1.getFirstElement();
			controller.setInputModel(file.getLocationURI().toString());
			if(!controller.inputModelIsValid()) {
				controller.setInputModel("");
			}
		}
			
	}
	
	public static boolean isEmpty (String s )
	{
		return s == null || s.length() == 0 ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return selectionPage.isPageComplete() && (getContainer().getCurrentPage() != selectionPage || controller.getRadioConfig() != RadioConfig.NEW) ;
	}

	@Override
	public void dispose() {
		super.dispose();
		if (configurationPage != null)
		{
			configurationPage.dispose();
		}
	}

	public void setConfiguration(ConfigurationWizardPage nextPage) {
		configurationPage = nextPage ;		
	}

	public void add(IPreferenceSavable savable) {
		list.add(savable) ;
	}
	
	
}
