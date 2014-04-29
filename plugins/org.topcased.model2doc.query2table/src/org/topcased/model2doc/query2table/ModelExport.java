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
package org.topcased.model2doc.query2table;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.topcased.model2doc.query2table.util.ColumnTreeNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Export</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.ModelExport#getOutputPath <em>Output Path</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.ModelExport#getExportExtension <em>Export Extension</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.ModelExport#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.ModelExport#getEmfContext <em>Emf Context</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.ModelExport#getDependencyManagement <em>Dependency Management</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.ModelExport#isCellSpan <em>Cell Span</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.model2doc.query2table.Query2tablePackage#getModelExport()
 * @model
 * @generated
 */
public interface ModelExport extends EObject {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * Returns the value of the '<em><b>Output Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Resource corresponding to the model to work with.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Output Path</em>' attribute.
     * @see #setOutputPath(String)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getModelExport_OutputPath()
     * @model required="true"
     * @generated
     */
	String getOutputPath();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.ModelExport#getOutputPath <em>Output Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Path</em>' attribute.
     * @see #getOutputPath()
     * @generated
     */
	void setOutputPath(String value);

	/**
     * Returns the value of the '<em><b>Export Extension</b></em>' attribute.
     * The literals are from the enumeration {@link org.topcased.model2doc.query2table.ExportExtension}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Export Extension</em>' attribute.
     * @see org.topcased.model2doc.query2table.ExportExtension
     * @see #setExportExtension(ExportExtension)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getModelExport_ExportExtension()
     * @model required="true"
     * @generated
     */
	ExportExtension getExportExtension();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.ModelExport#getExportExtension <em>Export Extension</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Export Extension</em>' attribute.
     * @see org.topcased.model2doc.query2table.ExportExtension
     * @see #getExportExtension()
     * @generated
     */
	void setExportExtension(ExportExtension value);

	/**
     * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.model2doc.query2table.Column}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Columns</em>' containment reference list.
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getModelExport_Columns()
     * @model containment="true"
     * @generated
     */
	EList<Column> getColumns();

	/**
     * Returns the value of the '<em><b>Emf Context</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emf Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Emf Context</em>' reference.
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getModelExport_EmfContext()
     * @model changeable="false" derived="true"
     * @generated
     */
	EMFContext getEmfContext();
	
	
	/**
     * Returns the value of the '<em><b>Dependency Management</b></em>' attribute.
     * The literals are from the enumeration {@link org.topcased.model2doc.query2table.DependencyManagement}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency Management</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Dependency Management</em>' attribute.
     * @see org.topcased.model2doc.query2table.DependencyManagement
     * @see #setDependencyManagement(DependencyManagement)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getModelExport_DependencyManagement()
     * @model
     * @generated
     */
	DependencyManagement getDependencyManagement();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.ModelExport#getDependencyManagement <em>Dependency Management</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dependency Management</em>' attribute.
     * @see org.topcased.model2doc.query2table.DependencyManagement
     * @see #getDependencyManagement()
     * @generated
     */
	void setDependencyManagement(DependencyManagement value);

	/**
     * Returns the value of the '<em><b>Cell Span</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Span</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Cell Span</em>' attribute.
     * @see #setCellSpan(boolean)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getModelExport_CellSpan()
     * @model
     * @generated
     */
	boolean isCellSpan();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.ModelExport#isCellSpan <em>Cell Span</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cell Span</em>' attribute.
     * @see #isCellSpan()
     * @generated
     */
	void setCellSpan(boolean value);

	/**
	 * @generated NOT
	 */
	public ColumnTreeNode getColumnDependancyTree();

} // ModelExport
