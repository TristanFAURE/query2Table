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
package org.topcased.model2doc.query2table.util;

import java.util.List;


public class Tree {

	private TreeNode rootElement;

	public Tree(TreeNode rootNode) {
		rootElement = rootNode;
	}

	public TreeNode getRootElement() {
		return rootElement;
	}

	
	public List<Object> getAllContainedObjects() {
		return this.rootElement.getAllContainedObjects();
	}

	
	
}
