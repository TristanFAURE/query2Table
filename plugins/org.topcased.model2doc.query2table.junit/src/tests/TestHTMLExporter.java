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
package tests;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.DependencyManagement;
import org.topcased.model2doc.query2table.ModelExport;
import org.topcased.model2doc.query2table.exception.InvalidModelExportFileException;
import org.topcased.model2doc.query2table.export.Export2TableAction;
import org.topcased.model2doc.query2table.export.HTMLTableExporter;
import org.topcased.model2doc.query2table.util.EmptyColumn;

public class TestHTMLExporter extends TestCase {


	public void testTreeExport() throws IOException, InvalidModelExportFileException {
		
		Export2TableAction action = new Export2TableAction();
		ResourceSet resourceSet = new ResourceSetImpl();
		// Get the URI of the model file.
//		String fileName = "modelWithJavaQuery.query2table";
//		String fileName = "model3.query2table";
		String fileName = "model4.query2table";
//		String fileName = "multipleDependencies.query2table";
//		String fileName = "dependencies.query2table";
//		String fileName = "testModel.query2table";
		
		
		URI fileURI = URI.createFileURI("D:/AHD/Workspaces/Workspace_Ocl2Excel/org.topcased.model2doc.query2table.junit/resources/"+fileName);
		// Create a resource for this file.
		Resource resource = resourceSet.getResource(fileURI, true);
		if (resource.getContents() != null && !resource.getContents().isEmpty()) {
			EObject root = resource.getContents().get(0);
			if (root != null && root instanceof ModelExport) {
				action.queryToTable((ModelExport)root);
				System.out.println("Exported to  :"+((ModelExport)root).getOutputPath());
			}
		}
		
	}
	
	
	public void testColumnDependency(){
	    String fileName = "dependencies.query2table";
      ResourceSet resourceSet = new ResourceSetImpl();
	    
	    URI fileURI = URI.createFileURI("D:/AHD/Workspaces/Workspace_Ocl2Excel/org.topcased.model2doc.query2table.junit/resources/"+fileName);
        // Create a resource for this file.
        Resource resource = resourceSet.getResource(fileURI, true);
        if (resource.getContents() != null && !resource.getContents().isEmpty()) {
            EObject root = resource.getContents().get(0);
            if (root != null && root instanceof ModelExport) {
                ModelExport modelExport = (ModelExport)root;
                
                HTMLTableExporter html = new HTMLTableExporter();
                List<List<Column>> columns = html.getColumnLists(modelExport.getColumnDependancyTree(), DependencyManagement.DUPLICATE);
                displayColumns(columns);
                System.out.println("Exported to  :"+((ModelExport)root).getOutputPath());
            }
        }
	}
	
	
	private void displayColumns(List<List<Column>> columns){
	    for (List<Column> columnList : columns){
	        System.out.println("New LIST ---------------");
	        for (Column column : columnList){
	            if(column instanceof EmptyColumn){
	                System.out.println("- EMPTY");
	            }
	            else{
	                System.out.println("- "+column.getTitle());
	            }
	        }
	    }
	}
}
