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

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {

	private TreeNode parent;

	private Object content;

	private List<TreeNode> children = new LinkedList<TreeNode>();

	public TreeNode() {
		// Nothing to initialize
	}

	public TreeNode(Object content) {
		this.content = content;
	}
	
	private void setParent(TreeNode node) {
		this.parent = node;
	}

	public TreeNode getParent() {
		return parent;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public boolean isLeaf() {
		return children.isEmpty();
	}

	public Object getContent() {
		return content;
	}

	public int getChildCount() {
		return children.size();
	}


	/**
	 * Get the index of a given child
	 * 
	 * @param child
	 *            child to look for
	 * @return -1 if not found
	 */
	public int getChildIndex(TreeNode child) {
		return children.indexOf(child);
	}

	public TreeNode getChildAt(int position) {
		return children.get(position);
	}

	public void addChild(TreeNode child) {
		children.add(child);
		child.setParent(this);
	}

	public void addChildAt(int position, TreeNode child) {
		children.add(position, child);
		child.setParent(this);
	}

	public void removeChild(TreeNode child) {
		child.setParent(null);
		children.remove(child);
	}

	public void removeChildAt(int position) {
		children.remove(position);
	}

	public int getNbLevelsInSubTree() {
		if (isLeaf()) {
			return 0;
		} else {
			return 1 + Collections.max(children, new SubTreeLevelComparator())
					.getNbLevelsInSubTree();
		}
	}

	
	private class SubTreeLevelComparator implements Comparator<TreeNode> {

		public int compare(TreeNode o1, TreeNode o2) {
			return o1.getNbLevelsInSubTree() - o2.getNbLevelsInSubTree();
		}
	}
	
	public List<Object> getAllContainedObjects() {
		List<Object> result = new LinkedList<Object>();
		addContentToList(this, result);
		return result;
	}
	
	private void addContentToList(TreeNode node, List<Object> list) {
		if (node.getContent() != null) {
			list.add(node.getContent());
		}
		for (TreeNode child : node.getChildren()) {
			addContentToList(child, list);
		}
	}

}
