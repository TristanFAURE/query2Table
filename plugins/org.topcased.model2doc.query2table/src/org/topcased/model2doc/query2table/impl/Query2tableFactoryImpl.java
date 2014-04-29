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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.topcased.model2doc.query2table.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Query2tableFactoryImpl extends EFactoryImpl implements Query2tableFactory {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Query2tableFactory init() {
        try
        {
            Query2tableFactory theQuery2tableFactory = (Query2tableFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/query2table/1.0"); 
            if (theQuery2tableFactory != null)
            {
                return theQuery2tableFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new Query2tableFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Query2tableFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID())
        {
            case Query2tablePackage.MODEL_EXPORT: return createModelExport();
            case Query2tablePackage.COLUMN: return createColumn();
            case Query2tablePackage.OCL_QUERY: return createOCLQuery();
            case Query2tablePackage.JAVA_QUERY: return createJavaQuery();
            case Query2tablePackage.COLUMN_CONTEXT: return createColumnContext();
            case Query2tablePackage.EMF_CONTEXT: return createEMFContext();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID())
        {
            case Query2tablePackage.EXPORT_EXTENSION:
                return createExportExtensionFromString(eDataType, initialValue);
            case Query2tablePackage.DEPENDENCY_MANAGEMENT:
                return createDependencyManagementFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID())
        {
            case Query2tablePackage.EXPORT_EXTENSION:
                return convertExportExtensionToString(eDataType, instanceValue);
            case Query2tablePackage.DEPENDENCY_MANAGEMENT:
                return convertDependencyManagementToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ModelExport createModelExport() {
        ModelExportImpl modelExport = new ModelExportImpl();
        return modelExport;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Column createColumn() {
        ColumnImpl column = new ColumnImpl();
        return column;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLQuery createOCLQuery() {
        OCLQueryImpl oclQuery = new OCLQueryImpl();
        return oclQuery;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public JavaQuery createJavaQuery() {
        JavaQueryImpl javaQuery = new JavaQueryImpl();
        return javaQuery;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ColumnContext createColumnContext() {
        ColumnContextImpl columnContext = new ColumnContextImpl();
        return columnContext;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EMFContext createEMFContext() {
        EMFContextImpl emfContext = new EMFContextImpl();
        return emfContext;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExportExtension createExportExtensionFromString(EDataType eDataType, String initialValue) {
        ExportExtension result = ExportExtension.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertExportExtensionToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DependencyManagement createDependencyManagementFromString(EDataType eDataType, String initialValue) {
        DependencyManagement result = DependencyManagement.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertDependencyManagementToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Query2tablePackage getQuery2tablePackage() {
        return (Query2tablePackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static Query2tablePackage getPackage() {
        return Query2tablePackage.eINSTANCE;
    }

} //Query2tableFactoryImpl
