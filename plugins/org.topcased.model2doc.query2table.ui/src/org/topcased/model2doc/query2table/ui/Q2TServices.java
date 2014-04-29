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

import java.io.File;
import java.util.Collections;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.topcased.model2doc.query2table.DependencyManagement;
import org.topcased.model2doc.query2table.ExportExtension;
import org.topcased.model2doc.query2table.ModelExport;
import org.topcased.model2doc.query2table.Query2tableFactory;
import org.topcased.model2doc.query2table.Query2tablePackage;
import org.topcased.model2doc.query2table.ui.extension.RegisteredQuery2TableManager;

public class Q2TServices {

	private final Query2TableController query2TableController;
	private String outputPath;
	private String extension;
	private URI uri1;
	private String depencyManagement;
	private ModelExport modelExport = null;
	private ResourceSet set = new ResourceSetImpl();
	private Query2tableFactory factory = Query2tableFactory.eINSTANCE;

	public Q2TServices(Query2TableController query2TableController) {
		this.query2TableController = query2TableController;
	}

	public String getSaveMode() {
		String mode = query2TableController.getRadioConfig().toString();
		return mode;
	}

	public ModelExport getModelExport() {
		if (modelExport == null) {
			switch (query2TableController.getRadioConfig()) {
			case BROWSE:
				Resource res = set.getResource(URI
						.createURI(query2TableController
								.getExistingConfigurationFile()), true);
				if (!res.getContents().isEmpty()) {
					modelExport = (ModelExport) res.getContents().get(0);
				}
				break;
			case NEW:
				modelExport = factory.createModelExport();
				break;
			case REGISTERED:
				Resource res2 = set.getResource(RegisteredQuery2TableManager
						.getURIFromRegisteredName(query2TableController
								.getRegisteredExport()), true);
				if (!res2.getContents().isEmpty()) {
					modelExport = (ModelExport) res2.getContents().get(0);
				}
				break;

			default:
				break;
			}
		}
		initModelExport();
		return modelExport;
	}

	public URI resourcesSave() throws Exception {

		switch (query2TableController.getRadioConfig()) {
		case NEW:
			URI uri = getNewURI();
			if (uri != null) {
				ResourceSet set = new ResourceSetImpl();
				Resource newResource = set.createResource(uri);
				newResource.getContents().add(getModelExport());
				newResource.setURI(uri);
				newResource.save(Collections.EMPTY_MAP);
				query2TableController.setIsSaved(true);
				return uri;
			} else {
				throw new Exception("The outpath location is not correct");
			}

		case BROWSE:
			Resource eResource = getModelExport().eResource();
			eResource.save(Collections.EMPTY_MAP);
			return eResource.getURI();

		case REGISTERED:
			Resource eResource1 = getModelExport().eResource();
			if (eResource1 != null && eResource1.getURI().isPlatformPlugin()) {
				uri1 = getNewURI();
				if (uri1 != null) {
					eResource1.setURI(uri1);
					eResource1.save(Collections.EMPTY_MAP);
					return uri1;
				} else {
					throw new Exception("The outpath location is not correct");
				}
			} else {
				eResource1.save(Collections.EMPTY_MAP);
				return uri1;
			}
		}
		return null;
	}

	private URI getNewURI() {
		URI uri = null;
		ResourceDialog dialog = new ResourceDialog(Display.getDefault()
				.getActiveShell(), "Choose location : ", SWT.SAVE);
		if (dialog.open() == ResourceDialog.OK) {
			String text = dialog.getURIText();
			if (!text.endsWith(".query2table")) {
				text += ".query2table";
			}
			uri = URI.createURI(text);
		}
		return uri;
	}

	private void initModelExport() {

		getExtension(query2TableController.getOutputPath());

		modelExport.setOutputPath(outputPath);

		for (EEnumLiteral e : Query2tablePackage.Literals.EXPORT_EXTENSION
				.getELiterals()) {
			if (e.getName().equals(extension)) {
				modelExport.setExportExtension((ExportExtension) e
						.getInstance());
			}
		}

		isNested(query2TableController.getIsNestedTableType());

		for (EEnumLiteral f : Query2tablePackage.Literals.DEPENDENCY_MANAGEMENT
				.getELiterals()) {
			if (f.getName().equals(depencyManagement)) {
				modelExport.setDependencyManagement((DependencyManagement) f
						.getInstance());
			}
		}

	}

	public void reinitModelExport() {
		modelExport = null;
		for (Resource r : set.getResources()) {
			r.unload();
		}
		set.getResources().clear();
	}

	public void saveModelExport(URI path) {

	}

	public void handleModification() {

		if (modelExport != null)
			initModelExport();
	}

	public void getExtension(String s) {

		outputPath = s;

		for (EEnumLiteral e : Query2tablePackage.Literals.EXPORT_EXTENSION
				.getELiterals()) {
			if (outputPath.endsWith(e.getName())) {
				extension = e.getName();
				outputPath = outputPath.substring(0, outputPath.length()
						- extension.length() - 1);
				break;
			} else {
				extension = "false";
			}
		}
	}

	public void isNested(boolean n) {
		if (n) {
			depencyManagement = "SUBTABLE";
		} else {
			depencyManagement = "DUPLICATE";
		}
	}

	public boolean validatePath(String out) {
		URI uri = URI.createURI(out);
		if (uri.isPlatform()) {
		    String platformString = uri.trimSegments(1).toPlatformString(true);
            Path p = new Path(platformString);
            IProject project = null;
            if(p.segmentCount()==1) {
                project = ResourcesPlugin.getWorkspace().getRoot().getProject(platformString);
            }
            if (project == null)
            {
                IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(platformString));
                return (folder.exists());
            }
            else
            {
                return project.exists();
            }
		} else if (uri.isFile()) {
			File f = new File(uri.trimSegments(1).toFileString());
			return (f.exists());
		}
		else
		{
			uri = URI.createFileURI(out);
			File f = new File(uri.trimSegments(1).toFileString());
			return (f.exists());
		}

	}

	public boolean validateExtension(String out) {

		getExtension(out);

		for (EEnumLiteral e : Query2tablePackage.Literals.EXPORT_EXTENSION
				.getELiterals()) {
			if (e.getName().equals(extension) && (outputPath != extension)) {
				return true;
			}
		}
		return false;

	}

}
