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

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.topcased.model2doc.query2table.ui.pages.SelectionWizardPage;

public class Query2TableController {

	private boolean radioTableType = false;
	private ResourceSet resourceSet = new ResourceSetImpl();
	private String outputPath;
	private String registeredExport;
	private String existingConfigurationFile;
	private String inputModel;
	private EObject elementSelected;
	private boolean saved=false;

	public static enum RadioConfig {
		REGISTERED, BROWSE, NEW
	};

	private RadioConfig radioConfig = null ;
	private boolean isNestedTableType;
	private String errorMessageSelectionPage;
	private Q2TServices q2t = new Q2TServices(this);
	private ISelection selection;

	public boolean isOutputPathValid() {
		return outputPath != null;
	}

	public boolean isConfigurationValid() {
		boolean result = false;
		if (radioConfig.equals(RadioConfig.REGISTERED)) {
			result = registeredExport != null;
		} else if (radioConfig.equals(RadioConfig.BROWSE)) {
			result = existingConfigurationFile != null;
		} else if (radioConfig.equals(RadioConfig.NEW)) {
			result = true;
		}
		return result;
	}

	public boolean inputModelIsValid() {
		String expectedValue = "org.topcased.ocl.checker.ui.contentType";
		if (inputModel != null) {
			IContentType[] contentTypeArray = Platform.getContentTypeManager()
					.findContentTypesFor(inputModel);
			for (IContentType contentType : contentTypeArray) {
				if (expectedValue.equals(contentType.getId())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isSelectionPageComplete(
			SelectionWizardPage selectionWizardPage) {
		if (errorMessageSelectionPage != null
				&& errorMessageSelectionPage.length() > 1) {
			selectionWizardPage.setErrorMessage(errorMessageSelectionPage);
		} else {
			selectionWizardPage.setErrorMessage(null);
		}
		return selectionPageCompleted(selectionWizardPage);

	}

	public Resource getInputModelResource() {
		Resource r = null;
		try {
			r = resourceSet.getResource(URI.createURI(inputModel), true);
			if (r.getErrors().isEmpty()) {
				BusyIndicator.showWhile(Display.getDefault(), new Runnable() {
					public void run() {
						EcoreUtil.resolveAll(resourceSet.getResource(
								URI.createURI(inputModel), true));
					}
				});
			}
		} catch (RuntimeException e) {
			e.getMessage();
		}
		return r;
	}

	public void isNestedTableType(boolean b) {
		this.isNestedTableType = b;
	}

	/**
	 * Get the output path
	 * 
	 * @return output path
	 */
	public String getOutputPath() {
		return outputPath;
	}

	/**
	 * Set the output path
	 * 
	 * @param outputPath
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
		q2t.handleModification();
	}

	/**
	 * Get the existing configuration file
	 * 
	 * @return the existing configuration file
	 */
	public String getExistingConfigurationFile() {
		return existingConfigurationFile;
	}

	/**
	 * Set the existing configuration file
	 * 
	 * @param existingConfigurationFile
	 *            the existingConfigurationFile to set
	 */
	public void setExistingConfigurationFile(String existingConfigurationFile) {
		this.existingConfigurationFile = existingConfigurationFile;
	}

	/**
	 * Get the input model
	 * 
	 * @return the inputModel
	 */
	public String getInputModel() {
		return inputModel;
	}

	/**
	 * Set the input model
	 * 
	 * @param inputModel
	 *            the inputModel to set
	 */
	public void setInputModel(String inputModel) {
		this.inputModel = inputModel;
	}

	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * @return the registeredExport
	 */
	public String getRegisteredExport() {
		return registeredExport;
	}

	/**
	 * @param registeredExport
	 *            the registeredExport to set
	 */
	public void setRegisteredExport(String registeredExport) {
		this.registeredExport = registeredExport;
	}

	/**
	 * @return the elementSelected
	 */
	public EObject getElementSelected() {
		return elementSelected;
	}

	/**
	 * @param elementSelected
	 *            the elementSelected to set
	 */
	public void setElementSelected(EObject elementSelected) {
		this.elementSelected = elementSelected;
	}

	/**
	 * @param radioConfig
	 *            the radioConfig to set
	 */
	//Comprovem quin radioConfig tenim, i al agegir una columna el creem
	public void setRadioConfig(RadioConfig radioConfig) {
		this.radioConfig = radioConfig;
		q2t.reinitModelExport();
	}

	/**
	 * @return the radioConfig
	 */
	public RadioConfig getRadioConfig() {
		return radioConfig;
	}

	/**
	 * @return the isNestedTableType
	 */
	public boolean getIsNestedTableType() {
		return isNestedTableType;	
	}
	
	public void setIsNestedTableType(boolean isNestedTableType) {
		this.isNestedTableType=isNestedTableType;	
	}
	
	public boolean getRadioTableSelected() {
		return radioTableType;	
	}
	
	public void setRadioTableSelected(boolean radioTableType) {
		this.radioTableType=radioTableType;	
	}

	/**
	 * @param errorMessageSelectionPage
	 *            the errorMessageSelectionPage to set
	 */
	public void setErrorMessageSelectionPage(String errorMessageSelectionPage) {
		this.errorMessageSelectionPage = errorMessageSelectionPage;
	}

	public Q2TServices getQ2T() {
		return q2t;
	}
	
	public void setIsSaved(boolean saved){
		this.saved=saved;
	}
	
	public boolean getIsSaved(){
		return saved;
	}
	
public boolean selectionPageCompleted(SelectionWizardPage selectionWizardPage){	
		if (inputModel == null || getRadioConfig() == null || elementSelected == null)
		{
			return false ;
		}
		if (inputModel != null && !"".equals(inputModel) && elementSelected!=null && 
				(getRadioConfig() == RadioConfig.REGISTERED && !Query2TableWizard.isEmpty(registeredExport)||
				getRadioConfig() == RadioConfig.BROWSE && !Query2TableWizard.isEmpty(existingConfigurationFile) || 
				getRadioConfig() == RadioConfig.NEW)){
			
			if (!q2t.validatePath(outputPath) || !q2t.validateExtension(outputPath)){ 
				selectionWizardPage.setErrorMessage("The output path or its final file extension is not correct");
				return false;
			}
			
			if(getRadioConfig().name().equals("BROWSE") && !q2t.validatePath(existingConfigurationFile)){
				selectionWizardPage.setErrorMessage("The browse configuration does not exist");
				return false;
	    	}
			
			if (!q2t.validatePath(inputModel)){ 
				selectionWizardPage.setErrorMessage("The input model is not correct");
				return false;
			}
			
			if (getRadioTableSelected()){
			   return true; 	
			}

	}else{
		return false;
	}
		return false;
}	


public ISelection getSelection() {
	return selection;
}

public void setSelection(ISelection event) {
	this.selection=event;
}


}
