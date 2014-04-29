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

import org.topcased.model2doc.query2table.Column;

public class TableTreeNode extends TreeNode
{

    private Column column;

    private String displayValue;

    public TableTreeNode()
    {
        super();
    }

    public TableTreeNode(Object content, Column column)
    {
        super(content);
        this.column = column;
    }

    public String getDisplayValue()
    {
        if( displayValue == null){
            displayValue = QueryUtils.computeDisplayValue(column, getContent());
        }
        return displayValue;

    }
    
    public Column getColumn()
    {
        return column;
    }

    public boolean refersToColumn(Column c)
    {
        if (c == null)
        {
            return false;
        }
        return c.equals(column);
    }

    @Override
    public TableTreeNode getChildAt(int position)
    {
        return (TableTreeNode) super.getChildAt(position);
    }

    public void addChild(TableTreeNode child)
    {
        super.addChild(child);
    }

    public void addChildAt(int position, TableTreeNode child)
    {
        super.addChildAt(position, child);
    }

    public void setColumn(Column column)
    {
        this.column = column;
    }

    /**
     * Computes the max number of children of this node or each sub node
     * 
     * @return the nb of rowpan to indicate for table generation
     */
    public int computeRowSpan(List<Column> dataStructure)
    {
        int nbRowsForThisNode = 0;
        if (dataStructure.contains(this.column))
        {
            if (isLeaf())
            {
                nbRowsForThisNode = 1;
            }
            else
            {
                nbRowsForThisNode = 0;
                for (TreeNode child : getChildren())
                {
                    if (dataStructure.contains(((TableTreeNode) child).getColumn()))
                    {
                        nbRowsForThisNode += ((TableTreeNode) child).computeRowSpan(dataStructure);
                    }
                }
                // In case none of the children will be displayed, count at least 1 line for the current node
                if( nbRowsForThisNode == 0){
                    nbRowsForThisNode = 1;
                }
            }
        }
        return nbRowsForThisNode;
    }
}
