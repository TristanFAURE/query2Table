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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.model2doc.query2table.JavaQuery;
import org.topcased.model2doc.query2table.Query2tablePackage;
import org.topcased.model2doc.query2table.exception.QueryExecutionException;
import org.topcased.model2doc.query2table.query.IJavaQuery;
import org.topcased.model2doc.query2table.util.QueryUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Java Query</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.impl.JavaQueryImpl#getExtensionId <em>Extension Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaQueryImpl extends QueryImpl implements JavaQuery {
	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The default value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getExtensionId()
     * @generated
     * @ordered
     */
	protected static final String EXTENSION_ID_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getExtensionId()
     * @generated
     * @ordered
     */
	protected String extensionId = EXTENSION_ID_EDEFAULT;

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected JavaQueryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Query2tablePackage.Literals.JAVA_QUERY;
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public String getExtensionId() {
        return extensionId;
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public void setExtensionId(String newExtensionId) {
        String oldExtensionId = extensionId;
        extensionId = newExtensionId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.JAVA_QUERY__EXTENSION_ID, oldExtensionId, extensionId));
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID)
        {
            case Query2tablePackage.JAVA_QUERY__EXTENSION_ID:
                return getExtensionId();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID)
        {
            case Query2tablePackage.JAVA_QUERY__EXTENSION_ID:
                setExtensionId((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID)
        {
            case Query2tablePackage.JAVA_QUERY__EXTENSION_ID:
                setExtensionId(EXTENSION_ID_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID)
        {
            case Query2tablePackage.JAVA_QUERY__EXTENSION_ID:
                return EXTENSION_ID_EDEFAULT == null ? extensionId != null : !EXTENSION_ID_EDEFAULT.equals(extensionId);
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (extensionId: ");
        result.append(extensionId);
        result.append(')');
        return result.toString();
    }

	@Override
	public Object executeQuery(Object contextValue) {

		IJavaQuery javaQuery = QueryUtils.getJavaQuery(this.getExtensionId());
		
		if( javaQuery == null){
		    throw new QueryExecutionException("JavaQuery with ID '"+this.getExtensionId()+"' could not be found.");
		}
		// TODO get context from previous columns : Map(columnIndex,
        // objects in columns) for columns that have already been
        // computed.
        return javaQuery.executeJavaQuery(contextValue, null);

	}

} // JavaQueryImpl
