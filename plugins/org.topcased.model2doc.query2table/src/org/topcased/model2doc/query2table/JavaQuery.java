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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.JavaQuery#getExtensionId <em>Extension Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.model2doc.query2table.Query2tablePackage#getJavaQuery()
 * @model
 * @generated
 */
public interface JavaQuery extends Query {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * Returns the value of the '<em><b>Extension Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Id of the extension to JavaQuery extension point
     * <!-- end-model-doc -->
     * @return the value of the '<em>Extension Id</em>' attribute.
     * @see #setExtensionId(String)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getJavaQuery_ExtensionId()
     * @model required="true"
     * @generated
     */
	String getExtensionId();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.JavaQuery#getExtensionId <em>Extension Id</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Extension Id</em>' attribute.
     * @see #getExtensionId()
     * @generated
     */
	void setExtensionId(String value);

} // JavaQuery
