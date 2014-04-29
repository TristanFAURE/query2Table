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
package org.topcased.model2doc.query2table.ui.pages.utils;

import java.util.Collection;
import java.util.LinkedList;

import org.topcased.model2doc.query2table.util.TableTree;
import org.topcased.model2doc.query2table.util.TableTreeNode;
import org.topcased.model2doc.query2table.util.TreeNode;

public class TreeUtils {
	public static Collection<Object> getTreeElements(TableTree inputElement) {
		Collection<Object> result = new LinkedList<Object>();
		getTreeElements(inputElement.getRootElement(), result) ; //afegirem els elements que no tenn fills
		return result ;
	}
	
	public static void getTreeElements(TreeNode inputElement, Collection<Object> result) {
		if (inputElement.getChildren().isEmpty())
		{
			result.add(inputElement); 
		}
		else
		{
			for(TreeNode n : inputElement.getChildren()){ 
				getTreeElements(n,result);
			}
		}
	}
	
	public static int getIndex (TreeNode node)
	{
		
		int p=0;
		TreeNode parent=node;
		
		while (parent.getParent() != null)  
		{
			parent = parent.getParent(); 
			p++ ;
		}
		
		return p-1 ;
	}
	
	public static TableTreeNode getParent (TableTreeNode current , int index)
	{ // retornem els pares
		int i = 0 ;
		TreeNode parent = current ; 
		while (i < index && parent != null)  // diem la "columna" del element actual
		{
			parent = parent.getParent(); 	// busquem els pares guiant-nos per els indexs inidcats
			i++ ;
		}
		if (parent instanceof TableTreeNode) {
			return (TableTreeNode) parent; //retornem ael pare
			
		}
		return null ;
	}
}
