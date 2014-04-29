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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.ColumnContext;
import org.topcased.model2doc.query2table.Query2tablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ColumnContextImpl#getDependsOn <em>Depends On</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnContextImpl extends ContextImpl implements ColumnContext {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDependsOn()
     * @generated
     * @ordered
     */
	protected Column dependsOn;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ColumnContextImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Query2tablePackage.Literals.COLUMN_CONTEXT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Column getDependsOn() {
        if (dependsOn != null && dependsOn.eIsProxy())
        {
            InternalEObject oldDependsOn = (InternalEObject)dependsOn;
            dependsOn = (Column)eResolveProxy(oldDependsOn);
            if (dependsOn != oldDependsOn)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Query2tablePackage.COLUMN_CONTEXT__DEPENDS_ON, oldDependsOn, dependsOn));
            }
        }
        return dependsOn;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Column basicGetDependsOn() {
        return dependsOn;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDependsOn(Column newDependsOn) {
        Column oldDependsOn = dependsOn;
        dependsOn = newDependsOn;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.COLUMN_CONTEXT__DEPENDS_ON, oldDependsOn, dependsOn));
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
            case Query2tablePackage.COLUMN_CONTEXT__DEPENDS_ON:
                if (resolve) return getDependsOn();
                return basicGetDependsOn();
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
            case Query2tablePackage.COLUMN_CONTEXT__DEPENDS_ON:
                setDependsOn((Column)newValue);
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
            case Query2tablePackage.COLUMN_CONTEXT__DEPENDS_ON:
                setDependsOn((Column)null);
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
            case Query2tablePackage.COLUMN_CONTEXT__DEPENDS_ON:
                return dependsOn != null;
        }
        return super.eIsSet(featureID);
    }

} //ColumnContextImpl
