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
package org.topcased.model2doc.query2table.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.ColumnContext;
import org.topcased.model2doc.query2table.Context;
import org.topcased.model2doc.query2table.DependencyManagement;
import org.topcased.model2doc.query2table.EMFContext;
import org.topcased.model2doc.query2table.ExportExtension;
import org.topcased.model2doc.query2table.JavaQuery;
import org.topcased.model2doc.query2table.ModelExport;
import org.topcased.model2doc.query2table.OCLQuery;
import org.topcased.model2doc.query2table.Query;
import org.topcased.model2doc.query2table.Query2tableFactory;
import org.topcased.model2doc.query2table.Query2tablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Query2tablePackageImpl extends EPackageImpl implements Query2tablePackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass modelExportEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass columnEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass queryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass oclQueryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass javaQueryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass contextEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass columnContextEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass emfContextEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum exportExtensionEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum dependencyManagementEEnum = null;

	/**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.model2doc.query2table.Query2tablePackage#eNS_URI
     * @see #init()
     * @generated
     */
	private Query2tablePackageImpl() {
        super(eNS_URI, Query2tableFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link Query2tablePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static Query2tablePackage init() {
        if (isInited) return (Query2tablePackage)EPackage.Registry.INSTANCE.getEPackage(Query2tablePackage.eNS_URI);

        // Obtain or create and register package
        Query2tablePackageImpl theQuery2tablePackage = (Query2tablePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Query2tablePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Query2tablePackageImpl());

        isInited = true;

        // Create package meta-data objects
        theQuery2tablePackage.createPackageContents();

        // Initialize created meta-data
        theQuery2tablePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theQuery2tablePackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(Query2tablePackage.eNS_URI, theQuery2tablePackage);
        return theQuery2tablePackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getModelExport() {
        return modelExportEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getModelExport_OutputPath() {
        return (EAttribute)modelExportEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getModelExport_ExportExtension() {
        return (EAttribute)modelExportEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModelExport_Columns() {
        return (EReference)modelExportEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModelExport_EmfContext() {
        return (EReference)modelExportEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getModelExport_DependencyManagement() {
        return (EAttribute)modelExportEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getModelExport_CellSpan() {
        return (EAttribute)modelExportEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getColumn() {
        return columnEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getColumn_Index() {
        return (EAttribute)columnEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getColumn_Title() {
        return (EAttribute)columnEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getColumn_Pattern() {
        return (EAttribute)columnEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getColumn_Displays() {
        return (EReference)columnEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getColumn_Executes() {
        return (EReference)columnEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumn_DefaultValueToDisplay()
    {
        return (EAttribute)columnEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getQuery() {
        return queryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQuery_ExecutionContext() {
        return (EReference)queryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOCLQuery() {
        return oclQueryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOCLQuery_OclQuery() {
        return (EAttribute)oclQueryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getJavaQuery() {
        return javaQueryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getJavaQuery_ExtensionId() {
        return (EAttribute)javaQueryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getContext() {
        return contextEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getColumnContext() {
        return columnContextEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getColumnContext_DependsOn() {
        return (EReference)columnContextEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEMFContext() {
        return emfContextEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEMFContext_ModelElement() {
        return (EReference)emfContextEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getExportExtension() {
        return exportExtensionEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getDependencyManagement() {
        return dependencyManagementEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Query2tableFactory getQuery2tableFactory() {
        return (Query2tableFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        modelExportEClass = createEClass(MODEL_EXPORT);
        createEAttribute(modelExportEClass, MODEL_EXPORT__OUTPUT_PATH);
        createEAttribute(modelExportEClass, MODEL_EXPORT__EXPORT_EXTENSION);
        createEReference(modelExportEClass, MODEL_EXPORT__COLUMNS);
        createEReference(modelExportEClass, MODEL_EXPORT__EMF_CONTEXT);
        createEAttribute(modelExportEClass, MODEL_EXPORT__DEPENDENCY_MANAGEMENT);
        createEAttribute(modelExportEClass, MODEL_EXPORT__CELL_SPAN);

        columnEClass = createEClass(COLUMN);
        createEAttribute(columnEClass, COLUMN__INDEX);
        createEAttribute(columnEClass, COLUMN__TITLE);
        createEAttribute(columnEClass, COLUMN__PATTERN);
        createEReference(columnEClass, COLUMN__DISPLAYS);
        createEReference(columnEClass, COLUMN__EXECUTES);
        createEAttribute(columnEClass, COLUMN__DEFAULT_VALUE_TO_DISPLAY);

        queryEClass = createEClass(QUERY);
        createEReference(queryEClass, QUERY__EXECUTION_CONTEXT);

        oclQueryEClass = createEClass(OCL_QUERY);
        createEAttribute(oclQueryEClass, OCL_QUERY__OCL_QUERY);

        javaQueryEClass = createEClass(JAVA_QUERY);
        createEAttribute(javaQueryEClass, JAVA_QUERY__EXTENSION_ID);

        contextEClass = createEClass(CONTEXT);

        columnContextEClass = createEClass(COLUMN_CONTEXT);
        createEReference(columnContextEClass, COLUMN_CONTEXT__DEPENDS_ON);

        emfContextEClass = createEClass(EMF_CONTEXT);
        createEReference(emfContextEClass, EMF_CONTEXT__MODEL_ELEMENT);

        // Create enums
        exportExtensionEEnum = createEEnum(EXPORT_EXTENSION);
        dependencyManagementEEnum = createEEnum(DEPENDENCY_MANAGEMENT);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

	/**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        oclQueryEClass.getESuperTypes().add(this.getQuery());
        javaQueryEClass.getESuperTypes().add(this.getQuery());
        columnContextEClass.getESuperTypes().add(this.getContext());
        emfContextEClass.getESuperTypes().add(this.getContext());

        // Initialize classes and features; add operations and parameters
        initEClass(modelExportEClass, ModelExport.class, "ModelExport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getModelExport_OutputPath(), ecorePackage.getEString(), "outputPath", null, 1, 1, ModelExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModelExport_ExportExtension(), this.getExportExtension(), "exportExtension", null, 1, 1, ModelExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModelExport_Columns(), this.getColumn(), null, "columns", null, 0, -1, ModelExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModelExport_EmfContext(), this.getEMFContext(), null, "emfContext", null, 0, 1, ModelExport.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getModelExport_DependencyManagement(), this.getDependencyManagement(), "dependencyManagement", null, 0, 1, ModelExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModelExport_CellSpan(), ecorePackage.getEBoolean(), "cellSpan", null, 0, 1, ModelExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(columnEClass, Column.class, "Column", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getColumn_Index(), ecorePackage.getEInt(), "index", null, 1, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getColumn_Title(), ecorePackage.getEString(), "title", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getColumn_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getColumn_Displays(), this.getQuery(), null, "displays", null, 0, -1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getColumn_Executes(), this.getQuery(), null, "executes", null, 1, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getColumn_DefaultValueToDisplay(), ecorePackage.getEString(), "defaultValueToDisplay", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = addEOperation(columnEClass, null, "addDisplayQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getQuery(), "displayQuery", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(queryEClass, Query.class, "Query", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getQuery_ExecutionContext(), this.getContext(), null, "executionContext", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = addEOperation(queryEClass, ecorePackage.getEJavaObject(), "executeQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEJavaObject(), "contextValue", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(oclQueryEClass, OCLQuery.class, "OCLQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOCLQuery_OclQuery(), ecorePackage.getEString(), "oclQuery", null, 1, 1, OCLQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(javaQueryEClass, JavaQuery.class, "JavaQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getJavaQuery_ExtensionId(), ecorePackage.getEString(), "extensionId", null, 1, 1, JavaQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(contextEClass, Context.class, "Context", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(columnContextEClass, ColumnContext.class, "ColumnContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getColumnContext_DependsOn(), this.getColumn(), null, "dependsOn", null, 1, 1, ColumnContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(emfContextEClass, EMFContext.class, "EMFContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEMFContext_ModelElement(), ecorePackage.getEObject(), null, "modelElement", null, 0, 1, EMFContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(exportExtensionEEnum, ExportExtension.class, "ExportExtension");
        addEEnumLiteral(exportExtensionEEnum, ExportExtension.XLS);
        addEEnumLiteral(exportExtensionEEnum, ExportExtension.HTML);
        addEEnumLiteral(exportExtensionEEnum, ExportExtension.CSV);

        initEEnum(dependencyManagementEEnum, DependencyManagement.class, "DependencyManagement");
        addEEnumLiteral(dependencyManagementEEnum, DependencyManagement.SUBTABLE);
        addEEnumLiteral(dependencyManagementEEnum, DependencyManagement.DUPLICATE);

        // Create resource
        createResource(eNS_URI);
    }

} //Query2tablePackageImpl
