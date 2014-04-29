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
package org.topcased.model2doc.query2table.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.DependencyManagement;
import org.topcased.model2doc.query2table.util.ColumnTreeNode;
import org.topcased.model2doc.query2table.util.EmptyColumn;
import org.topcased.model2doc.query2table.util.TableTree;
import org.topcased.model2doc.query2table.util.TableTreeNode;
import org.topcased.model2doc.query2table.util.TreeNode;

/**
 * Export a tree to an HTML table inside a html file
 * 
 */
public class HTMLTableExporter implements TableExporter
{

    private static Column EMPTY_COLUMN = new EmptyColumn();

    private Map<Column, ColumnTreeNode> columns = new HashMap<Column, ColumnTreeNode>();

    public String exportToTable(TableTree tree, String outputFilePath, DependencyManagement dependencyManagement) throws IOException
    {
        if (DependencyManagement.SUBTABLE.equals(dependencyManagement))
        {
            initColumnsMap(tree.getDataStructure());
        }
        StringBuffer htmlContent = exportToTable(tree, dependencyManagement);
        return exportToFile(htmlContent, outputFilePath);
    }

    private void initColumnsMap(ColumnTreeNode root)
    {
        columns.put(root.getColumn(), root);
        for (TreeNode child : root.getChildren())
        {
            if (child instanceof ColumnTreeNode)
            {
                initColumnsMap((ColumnTreeNode) child);
            }
        }
    }

    private String exportToFile(StringBuffer stringBuffer, String outputFilePath) throws IOException
    {

        // Write content into result file
        File f = new File(outputFilePath);
        FileWriter fWriter = new FileWriter(f);
        fWriter.write(stringBuffer.toString());
        fWriter.close();
        return outputFilePath;
    }

    private StringBuffer exportToTable(TableTree tree, DependencyManagement dependencyManagement)
    {

        StringBuffer htmlContent = new StringBuffer();

        htmlContent.append("<html>");
        htmlContent.append("<body>");

        List<List<Column>> columnLists = getColumnLists(tree.getDataStructure(), dependencyManagement);
        
        for (List<Column> columnList : columnLists)
        {
            createTable(tree.hasCellSpan(), tree.getRootElement(), htmlContent, dependencyManagement, columnList);
        }

        // close document
        htmlContent.append("</body></html>");

        return htmlContent;
    }

    private void createTable(boolean cellSpan, TableTreeNode treeRoot, StringBuffer htmlContent, DependencyManagement dependencyManagement, List<Column> columnList)
    {
        htmlContent.append("<p>");
        htmlContent.append("<table border='1'>");

        createTableHeader(columnList, htmlContent);

        // Table body
        htmlContent.append("<tbody>");

        for (TreeNode firstLevelNode : treeRoot.getChildren())
        {
            displayFirstLevelNode(cellSpan,(TableTreeNode) firstLevelNode, htmlContent, dependencyManagement, columnList);
        }

        // close body
        htmlContent.append("</tbody>");

        // close table and document
        htmlContent.append("</table>");
        htmlContent.append("</p>");
    }

    private void createTableHeader(List<Column> columns, StringBuffer htmlContent)
    {
        htmlContent.append("<thead>");
        htmlContent.append("<tr>");
        for (Column column : columns)
        {
            htmlContent.append("<th>");
            if (column instanceof EmptyColumn || column.getTitle() == null || "".equals(column.getTitle()))
            {
                htmlContent.append("&nbsp;");
            }
            else
            {
                htmlContent.append(cleanText(column.getTitle()));
            }
            htmlContent.append("</th>");
        }
        htmlContent.append("</tr>");
        htmlContent.append("</thead>");
    }

    private List<List<Column>> getSubTableColumns(ColumnTreeNode columnNode)
    {

        List<List<Column>> columnLists = new LinkedList<List<Column>>();
        if (columnNode != null && columnNode.getChildCount() > 1)
        {
            for (TreeNode child : columnNode.getChildren())
            {
                List<Column> columns = new LinkedList<Column>();
                columns.add(((ColumnTreeNode) child).getColumn());
                addChildrenColumnsToSubtable((ColumnTreeNode) child, columns);
                columnLists.add(columns);
            }
        }
        return columnLists;

    }

    private void addChildrenColumnsToSubtable(ColumnTreeNode columnNode, List<Column> columns)
    {
        if (columnNode.getChildCount() > 0)
        {
            for (TreeNode child : columnNode.getChildren())
            {
                columns.add(((ColumnTreeNode) child).getColumn());
                addChildrenColumnsToSubtable((ColumnTreeNode) child, columns);
            }
        }
    }

    /**
     * Get the list of columns to use for table generation
     * 
     * @param firstColumn the root column
     * @param dependencyManagement describes how to manage columns with multiple dependencies
     * @return list of lists of columns
     */
    public List<List<Column>> getColumnLists(ColumnTreeNode firstColumn, DependencyManagement dependencyManagement)
    {
        List<List<Column>> columnLists = new LinkedList<List<Column>>();
        List<Column> columns = new LinkedList<Column>();
        columns.add(firstColumn.getColumn());
        columnLists.add(columns);

        addChildrenColumns(firstColumn, dependencyManagement, columnLists);
        return columnLists;

    }

    private void addChildrenColumns(ColumnTreeNode columnNode, DependencyManagement dependencyManagement, List<List<Column>> columnLists)
    {

        List<List<Column>> columnListsToDuplicate = new LinkedList<List<Column>>();
        if (columnNode.getChildCount() == 1)
        {
            ColumnTreeNode childColumn = ((ColumnTreeNode) columnNode.getChildAt(0));
            for (List<Column> columnList : columnLists)
            {
                if ((columnNode.getColumn() != null) && columnNode.getColumn().equals(columnList.get(columnList.size() - 1)))
                {
                    columnList.add(childColumn.getColumn());
                }
            }

            addChildrenColumns(childColumn, dependencyManagement, columnLists);
        }
        else if (columnNode.getChildCount() > 1)
        {

            switch (dependencyManagement)
            {
                case DUPLICATE:

                    for (List<Column> columnList : columnLists)
                    {
                        if ((columnNode.getColumn() != null) && columnNode.getColumn().equals(columnList.get(columnList.size() - 1)))
                        {
                            columnListsToDuplicate.add(columnList);
                        }
                    }
                    if (!columnListsToDuplicate.isEmpty())
                    {
                        for (TreeNode child : columnNode.getChildren())
                        {
                            // Duplicate all column lists containing current node (except first)
                            for (List<Column> columnList : columnListsToDuplicate)
                            {
                                // Duplication of the columns
                                List<Column> newColumnList = new ArrayList<Column>(columnList.size());
                                for (Column c : columnList)
                                {
                                    newColumnList.add(c);
                                }
                                // Addition of the new Column as last element
                                newColumnList.add(((ColumnTreeNode) child).getColumn());
                                columnLists.add(newColumnList);

                            }
                            columnLists.removeAll(columnListsToDuplicate);
                            addChildrenColumns((ColumnTreeNode) child, dependencyManagement, columnLists);
                        }
                    }
                    break;

                case SUBTABLE:
                    // Do not add children
                    // Add a unique EMPTY column for all children
                    columnLists.get(0).add(EMPTY_COLUMN);
                    break;
            }

        }
    }

    private static boolean newLine = false;

    private void displayFirstLevelNode(boolean cellSpan, TableTreeNode node, StringBuffer htmlContent, DependencyManagement dependencyManagement, List<Column> dataStructure)
    {
        if (node.getColumn() != null && node.getColumn().equals(dataStructure.get(0)))
        {
            int columnIndex = displayNode(cellSpan, "", node, htmlContent, dataStructure, dependencyManagement, 0);
            if (columnIndex < dataStructure.size() && !newLine)
            {
                while (columnIndex < dataStructure.size())
                {
                    htmlContent.append("<td>&nbsp;</td>");
                    columnIndex++;
                }
                htmlContent.append("</tr>");
            }
        }

    }

    private int displayNode(boolean cellSpan, String prefix, TableTreeNode node, StringBuffer htmlContent, List<Column> dataStructure, DependencyManagement dependencyManagement, int columnIndex)
    {
        StringBuffer lineContent = new StringBuffer(prefix);
        if (columnIndex == 0 || newLine)
        {
            htmlContent.append("<tr>");
            if( !cellSpan){
        		htmlContent.append(prefix);
        	}
            lineContent = new StringBuffer(prefix);
            newLine = false;
        }
        
        // Column is the expected column : display node value
        if (node.refersToColumn(dataStructure.get(columnIndex)))
        {
        	
        	StringBuffer nodeContent = new StringBuffer();
            // display cell for node
        	nodeContent.append("<td");
            if( cellSpan){
            int rowSpan = node.computeRowSpan(dataStructure);
            if (rowSpan > 1)
            {
                nodeContent.append(" rowspan=\"");
                nodeContent.append(rowSpan);
                nodeContent.append("\" ");
            }
            }
            nodeContent.append(">");

            nodeContent.append(cleanText(node.getDisplayValue()));
            nodeContent.append("</td>");
            
            // Add node content to htmlContent buffer
            htmlContent.append(nodeContent.toString());
            lineContent.append(nodeContent.toString());
            

            if (DependencyManagement.SUBTABLE.equals(dependencyManagement))
            {
                if ((dataStructure.size() > columnIndex + 1) && (dataStructure.get(columnIndex + 1) instanceof EmptyColumn))
                {

                    htmlContent.append("<td>");
                    for (List<Column> columnList : getSubTableColumns(columns.get(node.getColumn())))
                    {
                        createTable(cellSpan, node, htmlContent, dependencyManagement, columnList);
                    }
                    htmlContent.append("</td>");
                    columnIndex++;
                }
            }
        }
        else if (dataStructure.contains(node.getColumn()))
        {
            htmlContent.append("<td>");
            int dataColumnIndex = dataStructure.indexOf(node.getColumn());
            // Current node should be displayed in future columns
            if (dataColumnIndex > columnIndex)
            {
                int nbColumnsToAdd = dataColumnIndex - columnIndex;
                for (int i = 0; i < nbColumnsToAdd; i++)
                {
                    htmlContent.append("</td>");
                    htmlContent.append("<td>");
                    columnIndex++;
                }
            }
            htmlContent.append("</td>");
        }

        if (columnIndex + 1 == dataStructure.size())
        { // End of table row
          // -> Start a new row
            htmlContent.append("</tr>");
            newLine = true;
            columnIndex = 0;
        }
        else
        {
            columnIndex++;
        }
        int index = columnIndex;
        for (TreeNode child : node.getChildren())
        {
            if (dataStructure.contains(((TableTreeNode) child).getColumn()))
            {
                index = displayNode(cellSpan, lineContent.toString(), (TableTreeNode) child, htmlContent, dataStructure, dependencyManagement, columnIndex);
                if (index != 0 && index < dataStructure.size())
                {
                    while (index < dataStructure.size())
                    {
                        htmlContent.append("<td>&nbsp;</td>");
                        index++;
                    }
                    htmlContent.append("</tr>");
                    newLine = true;
                }
            }
        }
        columnIndex = index;
        return columnIndex;
    }

    public String cleanText(String initialValue)
    {
        return initialValue.replace("<", "&lt;").replace(">", "&gt;").replace(" ", "&nbsp;").replace("\n", "<br style='mso-data-placement:same-cell;'/>");
    }

}
