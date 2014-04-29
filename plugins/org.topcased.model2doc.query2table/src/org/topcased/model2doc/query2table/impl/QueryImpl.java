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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.topcased.model2doc.query2table.Context;
import org.topcased.model2doc.query2table.Query;
import org.topcased.model2doc.query2table.Query2tablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.impl.QueryImpl#getExecutionContext <em>Execution Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class QueryImpl extends EObjectImpl implements Query {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The cached value of the '{@link #getExecutionContext() <em>Execution Context</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExecutionContext()
     * @generated
     * @ordered
     */
	protected Context executionContext;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected QueryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Query2tablePackage.Literals.QUERY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Context getExecutionContext() {
        return executionContext;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetExecutionContext(Context newExecutionContext, NotificationChain msgs) {
        Context oldExecutionContext = executionContext;
        executionContext = newExecutionContext;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Query2tablePackage.QUERY__EXECUTION_CONTEXT, oldExecutionContext, newExecutionContext);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExecutionContext(Context newExecutionContext) {
        if (newExecutionContext != executionContext)
        {
            NotificationChain msgs = null;
            if (executionContext != null)
                msgs = ((InternalEObject)executionContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Query2tablePackage.QUERY__EXECUTION_CONTEXT, null, msgs);
            if (newExecutionContext != null)
                msgs = ((InternalEObject)newExecutionContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Query2tablePackage.QUERY__EXECUTION_CONTEXT, null, msgs);
            msgs = basicSetExecutionContext(newExecutionContext, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.QUERY__EXECUTION_CONTEXT, newExecutionContext, newExecutionContext));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object executeQuery(Object contextValue) {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID)
        {
            case Query2tablePackage.QUERY__EXECUTION_CONTEXT:
                return basicSetExecutionContext(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID)
        {
            case Query2tablePackage.QUERY__EXECUTION_CONTEXT:
                return getExecutionContext();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID)
        {
            case Query2tablePackage.QUERY__EXECUTION_CONTEXT:
                setExecutionContext((Context)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID)
        {
            case Query2tablePackage.QUERY__EXECUTION_CONTEXT:
                setExecutionContext((Context)null);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID)
        {
            case Query2tablePackage.QUERY__EXECUTION_CONTEXT:
                return executionContext != null;
        }
        return super.eIsSet(featureID);
    }

} //QueryImpl
