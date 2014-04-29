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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.topcased.model2doc.query2table.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.topcased.model2doc.query2table.Query2tablePackage
 * @generated
 */
public class Query2tableAdapterFactory extends AdapterFactoryImpl {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static Query2tablePackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Query2tableAdapterFactory() {
        if (modelPackage == null)
        {
            modelPackage = Query2tablePackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage)
        {
            return true;
        }
        if (object instanceof EObject)
        {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected Query2tableSwitch<Adapter> modelSwitch =
		new Query2tableSwitch<Adapter>()
        {
            @Override
            public Adapter caseModelExport(ModelExport object)
            {
                return createModelExportAdapter();
            }
            @Override
            public Adapter caseColumn(Column object)
            {
                return createColumnAdapter();
            }
            @Override
            public Adapter caseQuery(Query object)
            {
                return createQueryAdapter();
            }
            @Override
            public Adapter caseOCLQuery(OCLQuery object)
            {
                return createOCLQueryAdapter();
            }
            @Override
            public Adapter caseJavaQuery(JavaQuery object)
            {
                return createJavaQueryAdapter();
            }
            @Override
            public Adapter caseContext(Context object)
            {
                return createContextAdapter();
            }
            @Override
            public Adapter caseColumnContext(ColumnContext object)
            {
                return createColumnContextAdapter();
            }
            @Override
            public Adapter caseEMFContext(EMFContext object)
            {
                return createEMFContextAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object)
            {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link org.topcased.model2doc.query2table.ModelExport <em>Model Export</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.model2doc.query2table.ModelExport
     * @generated
     */
	public Adapter createModelExportAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.topcased.model2doc.query2table.Column <em>Column</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.model2doc.query2table.Column
     * @generated
     */
	public Adapter createColumnAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.topcased.model2doc.query2table.Query <em>Query</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.model2doc.query2table.Query
     * @generated
     */
	public Adapter createQueryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.topcased.model2doc.query2table.OCLQuery <em>OCL Query</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.model2doc.query2table.OCLQuery
     * @generated
     */
	public Adapter createOCLQueryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.topcased.model2doc.query2table.JavaQuery <em>Java Query</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.model2doc.query2table.JavaQuery
     * @generated
     */
	public Adapter createJavaQueryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.topcased.model2doc.query2table.Context <em>Context</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.model2doc.query2table.Context
     * @generated
     */
	public Adapter createContextAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.topcased.model2doc.query2table.ColumnContext <em>Column Context</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.model2doc.query2table.ColumnContext
     * @generated
     */
	public Adapter createColumnContextAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.topcased.model2doc.query2table.EMFContext <em>EMF Context</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.model2doc.query2table.EMFContext
     * @generated
     */
	public Adapter createEMFContextAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //Query2tableAdapterFactory
