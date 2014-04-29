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

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.topcased.model2doc.query2table.ModelExport;
import org.topcased.model2doc.query2table.exception.InvalidModelExportFileException;
import org.topcased.model2doc.query2table.export.Export2TableAction;
import org.topcased.model2doc.query2table.util.Tree;
import org.topcased.model2doc.query2table.util.TreeNode;

public class TestQuery2Table extends TestCase {

	private ModelExport getModelExport(String fileUri)
			throws InvalidModelExportFileException {

		ResourceSet resourceSet = new ResourceSetImpl();
		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(fileUri);
		// Create a resource for this file.
		Resource resource = resourceSet.getResource(fileURI, true);
		if (resource.getContents() != null && !resource.getContents().isEmpty()) {
			EObject root = resource.getContents().get(0);
			if (root != null && root instanceof ModelExport) {
				return (ModelExport) root;
			}
		}
		throw new InvalidModelExportFileException();
	}

	public void testTreeExec() throws InvalidModelExportFileException {
		Export2TableAction action = new Export2TableAction();
		Tree tree = action
				.generateTreeFromModel(getModelExport("D:/AHD/Workspaces/Workspace_Ocl2Excel/org.topcased.model2doc.query2table.junit/resources/testModel.query2table"));

		displayTree(tree);
		
	}

	private void displayTree(Tree tree) {
		TreeNode root = tree.getRootElement();
		System.out.println(displayNode("", root));
	}

	private String displayNode(String prefix, TreeNode treeNode) {
		String s = "->" + treeNode.getContent() + "\n";
		for (TreeNode n : treeNode.getChildren()) {
			s += " " + prefix + displayNode(" " + prefix, n) + "\n";
		}
		return s;
	}

}
