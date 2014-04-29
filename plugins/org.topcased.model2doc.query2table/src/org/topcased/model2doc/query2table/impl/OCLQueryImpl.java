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
import org.eclipse.ocl.ParserException;
import org.topcased.model2doc.query2table.OCLQuery;
import org.topcased.model2doc.query2table.Query2tablePackage;
import org.topcased.model2doc.query2table.exception.QueryExecutionException;
import org.topcased.model2doc.query2table.util.OCLUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OCL Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.impl.OCLQueryImpl#getOclQuery <em>Ocl Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OCLQueryImpl extends QueryImpl implements OCLQuery {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The default value of the '{@link #getOclQuery() <em>Ocl Query</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOclQuery()
     * @generated
     * @ordered
     */
	protected static final String OCL_QUERY_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getOclQuery() <em>Ocl Query</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOclQuery()
     * @generated
     * @ordered
     */
	protected String oclQuery = OCL_QUERY_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OCLQueryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Query2tablePackage.Literals.OCL_QUERY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getOclQuery() {
        return oclQuery;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOclQuery(String newOclQuery) {
        String oldOclQuery = oclQuery;
        oclQuery = newOclQuery;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.OCL_QUERY__OCL_QUERY, oldOclQuery, oclQuery));
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
            case Query2tablePackage.OCL_QUERY__OCL_QUERY:
                return getOclQuery();
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
            case Query2tablePackage.OCL_QUERY__OCL_QUERY:
                setOclQuery((String)newValue);
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
            case Query2tablePackage.OCL_QUERY__OCL_QUERY:
                setOclQuery(OCL_QUERY_EDEFAULT);
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
            case Query2tablePackage.OCL_QUERY__OCL_QUERY:
                return OCL_QUERY_EDEFAULT == null ? oclQuery != null : !OCL_QUERY_EDEFAULT.equals(oclQuery);
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (oclQuery: ");
        result.append(oclQuery);
        result.append(')');
        return result.toString();
    }
	
	/**
	 * @throws QueryExecutionException
	 * @generated NOT
	 */
	public Object executeQuery(Object contextValue)
			throws QueryExecutionException {

		try {
			return OCLUtils.processOCLConstraint(contextValue,
					this.oclQuery);
		} catch (ParserException e) {
			throw new QueryExecutionException(
					"Parsing error while executing the query '" + this.oclQuery
							+ "'." + e.getMessage(), e);
		}

	}

} //OCLQueryImpl
