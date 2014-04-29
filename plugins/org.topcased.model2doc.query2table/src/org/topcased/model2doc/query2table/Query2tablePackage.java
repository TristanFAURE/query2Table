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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.topcased.model2doc.query2table.Query2tableFactory
 * @model kind="package"
 * @generated
 */
public interface Query2tablePackage extends EPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "query2table";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://www.topcased.org/query2table/1.0";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "query2table";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	Query2tablePackage eINSTANCE = org.topcased.model2doc.query2table.impl.Query2tablePackageImpl.init();

	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.impl.ModelExportImpl <em>Model Export</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.impl.ModelExportImpl
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getModelExport()
     * @generated
     */
	int MODEL_EXPORT = 0;

	/**
     * The feature id for the '<em><b>Output Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_EXPORT__OUTPUT_PATH = 0;

	/**
     * The feature id for the '<em><b>Export Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_EXPORT__EXPORT_EXTENSION = 1;

	/**
     * The feature id for the '<em><b>Columns</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_EXPORT__COLUMNS = 2;

	/**
     * The feature id for the '<em><b>Emf Context</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_EXPORT__EMF_CONTEXT = 3;

	/**
     * The feature id for the '<em><b>Dependency Management</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_EXPORT__DEPENDENCY_MANAGEMENT = 4;

	/**
     * The feature id for the '<em><b>Cell Span</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_EXPORT__CELL_SPAN = 5;

	/**
     * The number of structural features of the '<em>Model Export</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_EXPORT_FEATURE_COUNT = 6;

	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.impl.ColumnImpl <em>Column</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.impl.ColumnImpl
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getColumn()
     * @generated
     */
	int COLUMN = 1;

	/**
     * The feature id for the '<em><b>Index</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLUMN__INDEX = 0;

	/**
     * The feature id for the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLUMN__TITLE = 1;

	/**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLUMN__PATTERN = 2;

	/**
     * The feature id for the '<em><b>Displays</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLUMN__DISPLAYS = 3;

	/**
     * The feature id for the '<em><b>Executes</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLUMN__EXECUTES = 4;

	/**
     * The feature id for the '<em><b>Default Value To Display</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN__DEFAULT_VALUE_TO_DISPLAY = 5;

    /**
     * The number of structural features of the '<em>Column</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLUMN_FEATURE_COUNT = 6;

	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.impl.QueryImpl <em>Query</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.impl.QueryImpl
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getQuery()
     * @generated
     */
	int QUERY = 2;

	/**
     * The feature id for the '<em><b>Execution Context</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__EXECUTION_CONTEXT = 0;

	/**
     * The number of structural features of the '<em>Query</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.impl.OCLQueryImpl <em>OCL Query</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.impl.OCLQueryImpl
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getOCLQuery()
     * @generated
     */
	int OCL_QUERY = 3;

	/**
     * The feature id for the '<em><b>Execution Context</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_QUERY__EXECUTION_CONTEXT = QUERY__EXECUTION_CONTEXT;

	/**
     * The feature id for the '<em><b>Ocl Query</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_QUERY__OCL_QUERY = QUERY_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>OCL Query</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OCL_QUERY_FEATURE_COUNT = QUERY_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.impl.JavaQueryImpl <em>Java Query</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.impl.JavaQueryImpl
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getJavaQuery()
     * @generated
     */
	int JAVA_QUERY = 4;

	/**
     * The feature id for the '<em><b>Execution Context</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int JAVA_QUERY__EXECUTION_CONTEXT = QUERY__EXECUTION_CONTEXT;

	/**
     * The feature id for the '<em><b>Extension Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int JAVA_QUERY__EXTENSION_ID = QUERY_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Java Query</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int JAVA_QUERY_FEATURE_COUNT = QUERY_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.impl.ContextImpl
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getContext()
     * @generated
     */
	int CONTEXT = 5;

	/**
     * The number of structural features of the '<em>Context</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.impl.ColumnContextImpl <em>Column Context</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.impl.ColumnContextImpl
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getColumnContext()
     * @generated
     */
	int COLUMN_CONTEXT = 6;

	/**
     * The feature id for the '<em><b>Depends On</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLUMN_CONTEXT__DEPENDS_ON = CONTEXT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Column Context</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLUMN_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.impl.EMFContextImpl <em>EMF Context</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.impl.EMFContextImpl
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getEMFContext()
     * @generated
     */
	int EMF_CONTEXT = 7;

	/**
     * The feature id for the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EMF_CONTEXT__MODEL_ELEMENT = CONTEXT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>EMF Context</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EMF_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.ExportExtension <em>Export Extension</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.ExportExtension
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getExportExtension()
     * @generated
     */
	int EXPORT_EXTENSION = 8;


	/**
     * The meta object id for the '{@link org.topcased.model2doc.query2table.DependencyManagement <em>Dependency Management</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.topcased.model2doc.query2table.DependencyManagement
     * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getDependencyManagement()
     * @generated
     */
	int DEPENDENCY_MANAGEMENT = 9;


	/**
     * Returns the meta object for class '{@link org.topcased.model2doc.query2table.ModelExport <em>Model Export</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Model Export</em>'.
     * @see org.topcased.model2doc.query2table.ModelExport
     * @generated
     */
	EClass getModelExport();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.ModelExport#getOutputPath <em>Output Path</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Output Path</em>'.
     * @see org.topcased.model2doc.query2table.ModelExport#getOutputPath()
     * @see #getModelExport()
     * @generated
     */
	EAttribute getModelExport_OutputPath();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.ModelExport#getExportExtension <em>Export Extension</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Export Extension</em>'.
     * @see org.topcased.model2doc.query2table.ModelExport#getExportExtension()
     * @see #getModelExport()
     * @generated
     */
	EAttribute getModelExport_ExportExtension();

	/**
     * Returns the meta object for the containment reference list '{@link org.topcased.model2doc.query2table.ModelExport#getColumns <em>Columns</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Columns</em>'.
     * @see org.topcased.model2doc.query2table.ModelExport#getColumns()
     * @see #getModelExport()
     * @generated
     */
	EReference getModelExport_Columns();

	/**
     * Returns the meta object for the reference '{@link org.topcased.model2doc.query2table.ModelExport#getEmfContext <em>Emf Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Emf Context</em>'.
     * @see org.topcased.model2doc.query2table.ModelExport#getEmfContext()
     * @see #getModelExport()
     * @generated
     */
	EReference getModelExport_EmfContext();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.ModelExport#getDependencyManagement <em>Dependency Management</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dependency Management</em>'.
     * @see org.topcased.model2doc.query2table.ModelExport#getDependencyManagement()
     * @see #getModelExport()
     * @generated
     */
	EAttribute getModelExport_DependencyManagement();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.ModelExport#isCellSpan <em>Cell Span</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cell Span</em>'.
     * @see org.topcased.model2doc.query2table.ModelExport#isCellSpan()
     * @see #getModelExport()
     * @generated
     */
	EAttribute getModelExport_CellSpan();

	/**
     * Returns the meta object for class '{@link org.topcased.model2doc.query2table.Column <em>Column</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Column</em>'.
     * @see org.topcased.model2doc.query2table.Column
     * @generated
     */
	EClass getColumn();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.Column#getIndex <em>Index</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Index</em>'.
     * @see org.topcased.model2doc.query2table.Column#getIndex()
     * @see #getColumn()
     * @generated
     */
	EAttribute getColumn_Index();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.Column#getTitle <em>Title</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Title</em>'.
     * @see org.topcased.model2doc.query2table.Column#getTitle()
     * @see #getColumn()
     * @generated
     */
	EAttribute getColumn_Title();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.Column#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern</em>'.
     * @see org.topcased.model2doc.query2table.Column#getPattern()
     * @see #getColumn()
     * @generated
     */
	EAttribute getColumn_Pattern();

	/**
     * Returns the meta object for the containment reference list '{@link org.topcased.model2doc.query2table.Column#getDisplays <em>Displays</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Displays</em>'.
     * @see org.topcased.model2doc.query2table.Column#getDisplays()
     * @see #getColumn()
     * @generated
     */
	EReference getColumn_Displays();

	/**
     * Returns the meta object for the containment reference '{@link org.topcased.model2doc.query2table.Column#getExecutes <em>Executes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Executes</em>'.
     * @see org.topcased.model2doc.query2table.Column#getExecutes()
     * @see #getColumn()
     * @generated
     */
	EReference getColumn_Executes();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.Column#getDefaultValueToDisplay <em>Default Value To Display</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Value To Display</em>'.
     * @see org.topcased.model2doc.query2table.Column#getDefaultValueToDisplay()
     * @see #getColumn()
     * @generated
     */
    EAttribute getColumn_DefaultValueToDisplay();

    /**
     * Returns the meta object for class '{@link org.topcased.model2doc.query2table.Query <em>Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query</em>'.
     * @see org.topcased.model2doc.query2table.Query
     * @generated
     */
	EClass getQuery();

	/**
     * Returns the meta object for the containment reference '{@link org.topcased.model2doc.query2table.Query#getExecutionContext <em>Execution Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Execution Context</em>'.
     * @see org.topcased.model2doc.query2table.Query#getExecutionContext()
     * @see #getQuery()
     * @generated
     */
	EReference getQuery_ExecutionContext();

	/**
     * Returns the meta object for class '{@link org.topcased.model2doc.query2table.OCLQuery <em>OCL Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>OCL Query</em>'.
     * @see org.topcased.model2doc.query2table.OCLQuery
     * @generated
     */
	EClass getOCLQuery();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.OCLQuery#getOclQuery <em>Ocl Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ocl Query</em>'.
     * @see org.topcased.model2doc.query2table.OCLQuery#getOclQuery()
     * @see #getOCLQuery()
     * @generated
     */
	EAttribute getOCLQuery_OclQuery();

	/**
     * Returns the meta object for class '{@link org.topcased.model2doc.query2table.JavaQuery <em>Java Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Java Query</em>'.
     * @see org.topcased.model2doc.query2table.JavaQuery
     * @generated
     */
	EClass getJavaQuery();

	/**
     * Returns the meta object for the attribute '{@link org.topcased.model2doc.query2table.JavaQuery#getExtensionId <em>Extension Id</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Extension Id</em>'.
     * @see org.topcased.model2doc.query2table.JavaQuery#getExtensionId()
     * @see #getJavaQuery()
     * @generated
     */
	EAttribute getJavaQuery_ExtensionId();

	/**
     * Returns the meta object for class '{@link org.topcased.model2doc.query2table.Context <em>Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context</em>'.
     * @see org.topcased.model2doc.query2table.Context
     * @generated
     */
	EClass getContext();

	/**
     * Returns the meta object for class '{@link org.topcased.model2doc.query2table.ColumnContext <em>Column Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Column Context</em>'.
     * @see org.topcased.model2doc.query2table.ColumnContext
     * @generated
     */
	EClass getColumnContext();

	/**
     * Returns the meta object for the reference '{@link org.topcased.model2doc.query2table.ColumnContext#getDependsOn <em>Depends On</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Depends On</em>'.
     * @see org.topcased.model2doc.query2table.ColumnContext#getDependsOn()
     * @see #getColumnContext()
     * @generated
     */
	EReference getColumnContext_DependsOn();

	/**
     * Returns the meta object for class '{@link org.topcased.model2doc.query2table.EMFContext <em>EMF Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>EMF Context</em>'.
     * @see org.topcased.model2doc.query2table.EMFContext
     * @generated
     */
	EClass getEMFContext();

	/**
     * Returns the meta object for the reference '{@link org.topcased.model2doc.query2table.EMFContext#getModelElement <em>Model Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Model Element</em>'.
     * @see org.topcased.model2doc.query2table.EMFContext#getModelElement()
     * @see #getEMFContext()
     * @generated
     */
	EReference getEMFContext_ModelElement();

	/**
     * Returns the meta object for enum '{@link org.topcased.model2doc.query2table.ExportExtension <em>Export Extension</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Export Extension</em>'.
     * @see org.topcased.model2doc.query2table.ExportExtension
     * @generated
     */
	EEnum getExportExtension();

	/**
     * Returns the meta object for enum '{@link org.topcased.model2doc.query2table.DependencyManagement <em>Dependency Management</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Dependency Management</em>'.
     * @see org.topcased.model2doc.query2table.DependencyManagement
     * @generated
     */
	EEnum getDependencyManagement();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	Query2tableFactory getQuery2tableFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.impl.ModelExportImpl <em>Model Export</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.impl.ModelExportImpl
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getModelExport()
         * @generated
         */
		EClass MODEL_EXPORT = eINSTANCE.getModelExport();

		/**
         * The meta object literal for the '<em><b>Output Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MODEL_EXPORT__OUTPUT_PATH = eINSTANCE.getModelExport_OutputPath();

		/**
         * The meta object literal for the '<em><b>Export Extension</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MODEL_EXPORT__EXPORT_EXTENSION = eINSTANCE.getModelExport_ExportExtension();

		/**
         * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODEL_EXPORT__COLUMNS = eINSTANCE.getModelExport_Columns();

		/**
         * The meta object literal for the '<em><b>Emf Context</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODEL_EXPORT__EMF_CONTEXT = eINSTANCE.getModelExport_EmfContext();

		/**
         * The meta object literal for the '<em><b>Dependency Management</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MODEL_EXPORT__DEPENDENCY_MANAGEMENT = eINSTANCE.getModelExport_DependencyManagement();

		/**
         * The meta object literal for the '<em><b>Cell Span</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MODEL_EXPORT__CELL_SPAN = eINSTANCE.getModelExport_CellSpan();

		/**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.impl.ColumnImpl <em>Column</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.impl.ColumnImpl
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getColumn()
         * @generated
         */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
         * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COLUMN__INDEX = eINSTANCE.getColumn_Index();

		/**
         * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COLUMN__TITLE = eINSTANCE.getColumn_Title();

		/**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COLUMN__PATTERN = eINSTANCE.getColumn_Pattern();

		/**
         * The meta object literal for the '<em><b>Displays</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLUMN__DISPLAYS = eINSTANCE.getColumn_Displays();

		/**
         * The meta object literal for the '<em><b>Executes</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLUMN__EXECUTES = eINSTANCE.getColumn_Executes();

		/**
         * The meta object literal for the '<em><b>Default Value To Display</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN__DEFAULT_VALUE_TO_DISPLAY = eINSTANCE.getColumn_DefaultValueToDisplay();

        /**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.impl.QueryImpl <em>Query</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.impl.QueryImpl
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getQuery()
         * @generated
         */
		EClass QUERY = eINSTANCE.getQuery();

		/**
         * The meta object literal for the '<em><b>Execution Context</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY__EXECUTION_CONTEXT = eINSTANCE.getQuery_ExecutionContext();

		/**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.impl.OCLQueryImpl <em>OCL Query</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.impl.OCLQueryImpl
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getOCLQuery()
         * @generated
         */
		EClass OCL_QUERY = eINSTANCE.getOCLQuery();

		/**
         * The meta object literal for the '<em><b>Ocl Query</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute OCL_QUERY__OCL_QUERY = eINSTANCE.getOCLQuery_OclQuery();

		/**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.impl.JavaQueryImpl <em>Java Query</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.impl.JavaQueryImpl
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getJavaQuery()
         * @generated
         */
		EClass JAVA_QUERY = eINSTANCE.getJavaQuery();

		/**
         * The meta object literal for the '<em><b>Extension Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute JAVA_QUERY__EXTENSION_ID = eINSTANCE.getJavaQuery_ExtensionId();

		/**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.impl.ContextImpl <em>Context</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.impl.ContextImpl
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getContext()
         * @generated
         */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.impl.ColumnContextImpl <em>Column Context</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.impl.ColumnContextImpl
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getColumnContext()
         * @generated
         */
		EClass COLUMN_CONTEXT = eINSTANCE.getColumnContext();

		/**
         * The meta object literal for the '<em><b>Depends On</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLUMN_CONTEXT__DEPENDS_ON = eINSTANCE.getColumnContext_DependsOn();

		/**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.impl.EMFContextImpl <em>EMF Context</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.impl.EMFContextImpl
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getEMFContext()
         * @generated
         */
		EClass EMF_CONTEXT = eINSTANCE.getEMFContext();

		/**
         * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EMF_CONTEXT__MODEL_ELEMENT = eINSTANCE.getEMFContext_ModelElement();

		/**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.ExportExtension <em>Export Extension</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.ExportExtension
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getExportExtension()
         * @generated
         */
		EEnum EXPORT_EXTENSION = eINSTANCE.getExportExtension();

		/**
         * The meta object literal for the '{@link org.topcased.model2doc.query2table.DependencyManagement <em>Dependency Management</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.topcased.model2doc.query2table.DependencyManagement
         * @see org.topcased.model2doc.query2table.impl.Query2tablePackageImpl#getDependencyManagement()
         * @generated
         */
		EEnum DEPENDENCY_MANAGEMENT = eINSTANCE.getDependencyManagement();

	}

} //Query2tablePackage
