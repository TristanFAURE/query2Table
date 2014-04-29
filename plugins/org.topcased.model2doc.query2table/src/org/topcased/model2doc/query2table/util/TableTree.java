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

import java.util.LinkedList;
import java.util.List;

import org.topcased.model2doc.query2table.Column;

public class TableTree extends Tree {

	/**
	 * Datastructure associated to this tree (organization of the levels)
	 */
	private ColumnTreeNode columnDataStructure;
	
	private boolean cellSpan;

	public TableTree(TableTreeNode rootNode) {
		super(rootNode);
	}

	public TableTreeNode getRootElement() {
		return (TableTreeNode)(super.getRootElement());
	}

	public ColumnTreeNode getDataStructure() {
		return columnDataStructure;
	}

	public void setDataStructure(ColumnTreeNode dataStructure) {
		this.columnDataStructure = dataStructure;
	}

	
	public boolean hasCellSpan() {
		return cellSpan;
	}

	public void setCellSpan(boolean cellSpan) {
		this.cellSpan = cellSpan;
	}

	/**
	 * Recursive method getting all nodes matching a given Column inside the tree.
	 */
	private void addTableTreeNodesMatchingColumn(Column c , List<TableTreeNode> list, TableTreeNode currentNode){
		if( currentNode.refersToColumn(c)){
			list.add(currentNode);
		}
		for (TreeNode child : currentNode.getChildren()){
			addTableTreeNodesMatchingColumn(c, list, (TableTreeNode)child);
		}
	}
	
	/**
	 * Get all nodes matching a given Column inside the tree.
	 */
	public List<TableTreeNode> getNodesMatchingColumn(Column c){
		List<TableTreeNode> nodesForExecution = new LinkedList<TableTreeNode>();
		addTableTreeNodesMatchingColumn(c, nodesForExecution, this.getRootElement());
		return nodesForExecution;
	}

}
