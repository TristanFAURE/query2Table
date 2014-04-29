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

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.ColumnContext;
import org.topcased.model2doc.query2table.ModelExport;
import org.topcased.model2doc.query2table.exception.InvalidModelExportFileException;
import org.topcased.model2doc.query2table.util.ColumnTreeNode;
import org.topcased.model2doc.query2table.util.TableTree;
import org.topcased.model2doc.query2table.util.TableTreeNode;
import org.topcased.model2doc.query2table.util.Tree;
import org.topcased.model2doc.query2table.util.TreeNode;

public class Export2TableAction
{

    private static final String MODEL_FILE_EXTENSION = "query2table";

    /**
     * Main method : Execute queries and generate a table file from a .query2table model file
     * 
     * @param modelFile .query2table file
     * @return generated file path
     * @throws IOException
     * @throws InvalidModelExportFileException
     */
    public String queryToTable(IFile modelFile, IProgressMonitor monitor) throws IOException, InvalidModelExportFileException
    {
        if (!MODEL_FILE_EXTENSION.equals(modelFile.getFileExtension()))
        {
            throw new InvalidModelExportFileException(modelFile.getFullPath() + " is not a valid .query2table file.");
        }
        if (monitor == null)
        {
            monitor = new NullProgressMonitor();
        }
        if (monitor.isCanceled())
        {
            return null;
        }
        monitor.beginTask("Query2Table", 10);
        ModelExport modelExport = getModelExport(modelFile);
        if (monitor.isCanceled())
        {
            return null;
        }
        monitor.worked(4);
        String result = queryToTable(modelExport);
        if (monitor.isCanceled())
        {
            return null;
        }
        monitor.worked(6);
        if (monitor.isCanceled())
        {
            return null;
        }
        return result;
    }

    public String queryToTable(ModelExport modelExport) throws IOException, InvalidModelExportFileException
    {

        TableTree tree = generateTreeFromModel(modelExport);
        TableExporter tableExporter = null;

        switch (modelExport.getExportExtension())
        {
            case XLS:
            case HTML:
                tableExporter = new HTMLTableExporter();
                break;

            case CSV:
                throw new UnsupportedOperationException("CSV Export is not available yet");
        }

        // Get Output path (add extension to existing output path if not valid)
        String outputPath = ((ModelExport) modelExport).getOutputPath();
        if (!outputPath.endsWith(modelExport.getExportExtension().getLiteral()))
        {
            outputPath += "." + modelExport.getExportExtension();
        }

        return tableExporter.exportToTable(tree, outputPath, modelExport.getDependencyManagement());

    }

    /**
     * Generate a tree from a model file
     * 
     * @param modelFile the file containing the model export configuration (EMF model .query2table)
     * @return a tree containing the results of the queries as objects
     */
    public Tree generateTreeFromModel(IFile modelFile) throws InvalidModelExportFileException
    {

        // Extract model
        ModelExport modelExport = getModelExport(modelFile);

        return generateTreeFromModel(modelExport);

    }

    /**
     * Generate a tree from a model
     * 
     * @param modelExport the model export configuration (EMF model)
     * @return a tree containing the results of the queries as objects
     */
    public TableTree generateTreeFromModel(ModelExport modelExport)
    {
        // Get column list sorted after dependency check
        ColumnTreeNode rootColumn = modelExport.getColumnDependancyTree();

        // Create a tree

        TableTreeNode rootNode = new TableTreeNode();
        TableTree tree = new TableTree(rootNode);
        tree.setCellSpan(modelExport.isCellSpan());
        tree.setDataStructure(rootColumn);

        executeColumn(rootColumn, tree);

        return tree;

    }

    /**
     * Recursive execution of a column and its children columns
     * 
     * @param columnNode Current treeNode corresponding to a column in the dependency tree
     * @param tree Result tree
     */
    private void executeColumn(ColumnTreeNode columnNode, TableTree tree)
    {

        if (columnNode.isPrincipalColumn())
        {
            // Execute root column (with EMF element as query context)
            Object executionResult = columnNode.executeEMFQuery();
            if (executionResult instanceof Iterable)
            {
                for (Object element : ((Iterable<Object>) executionResult))
                {
                    tree.getRootElement().addChild(new TableTreeNode(element, columnNode.getColumn()));
                }
            }
            else
            {
                tree.getRootElement().addChild(new TableTreeNode(executionResult, columnNode.getColumn()));
            }

        }
        else
        {

            Column c = columnNode.getColumn();

            // In case of dependent columns execute the query on each element
            // from the previous column execution

            // Get the list of elements in column "dependsOn" defined in
            // execution context
            List<TableTreeNode> nodesToUseForExecution = getNodeListToExecuteColumn(c, tree);

            // For all elements in this column,
            for (TableTreeNode node : nodesToUseForExecution)
            {
                Object nodeContent = node.getContent();

                Object executionResult;

                // if the content is a collection, execute the query for
                // each element of the collection
                if (nodeContent instanceof Iterable)
                {
                    executionResult = new LinkedList<Object>();
                    for (Object nodeContentValue : (Iterable<Object>) nodeContent)
                    {
                        ((Collection<Object>) executionResult).add(c.getExecutes().executeQuery(nodeContentValue));
                    }
                }
                // if the content is a single element, execute the query for
                // this element
                else
                {
                    executionResult = c.getExecutes().executeQuery(nodeContent);
                }

                // Add execution result into the tree (as N children if it
                // is a collection or as a single child if not)

                if (executionResult instanceof Iterable)
                {
                    for (Object element : ((Iterable<Object>) executionResult))
                    {
                        node.addChild(new TableTreeNode(element, c));
                    }
                }
                else
                {
                    node.addChild(new TableTreeNode(executionResult, c));
                }
            }
        }
        if (columnNode.getChildCount() == 1)
        {
            executeColumn((ColumnTreeNode) columnNode.getChildren().get(0), tree);
        }
        else
        {
            for (TreeNode child : columnNode.getChildren())
            {
                executeColumn((ColumnTreeNode) child, tree);
            }
        }
    }

    /**
     * Get the modelExport element from the .query2table model file.
     * 
     * @param modelFile IFile (extension .query2table)
     * @return the ModelExport object containing the full export definition
     * @throws InvalidModelExportFileException when the modelFile is not a valid ModelExport definition file
     */
    private ModelExport getModelExport(IFile modelFile) throws InvalidModelExportFileException
    {
        ResourceSet resourceSet = new ResourceSetImpl();

        if (!MODEL_FILE_EXTENSION.equals(modelFile.getFileExtension()))
        {
            throw new InvalidModelExportFileException("File '" + modelFile.getFullPath() + "' is not a ." + MODEL_FILE_EXTENSION + " file.");
        }

        // Get the URI of the model file.
        URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
        // Create a resource for this file.
        Resource resource = resourceSet.getResource(fileURI, true);
        if (resource.getContents() != null)
        {
            EObject root = resource.getContents().get(0);
            if (root != null && root instanceof ModelExport)
            {
                return (ModelExport) root;
            }
        }
        throw new InvalidModelExportFileException("The root element in '" + modelFile.getFullPath() + "'is not from type ModelExport");
    }

    /**
     * Get the list of nodes for a specific column in the tree
     * 
     * @param c the column with elements to look for
     * @param tree the tree containing data & data structure
     * @return the list of nodes at a given level of the tree
     */
    private List<TableTreeNode> getNodeListToExecuteColumn(Column c, TableTree tree)
    {

        if (c.getExecutes().getExecutionContext() instanceof ColumnContext)
        {
            Column dependency = ((ColumnContext) c.getExecutes().getExecutionContext()).getDependsOn();

            return tree.getNodesMatchingColumn(dependency);

        }
        return Collections.EMPTY_LIST;

        // // Find index of the tree level necessary to compute the execution
        // int index = 0;
        // if (c.getExecutes().getExecutionContext() instanceof ColumnContext) {
        // Column dependency = ((ColumnContext) c.getExecutes()
        // .getExecutionContext()).getDependsOn();
        // index = tree.getDataStructure().indexOf(dependency);
        // }
        //
        // // Get the data corresponding to this level on the tree (call of a
        // // recursive method)
        // // Note : called with index+1 because of the tree root node
        // return tree.getNodeListForLevel(index + 1);

    }

}
