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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMF Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.EMFContext#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.model2doc.query2table.Query2tablePackage#getEMFContext()
 * @model
 * @generated
 */
public interface EMFContext extends Context {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * Returns the value of the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Model Element</em>' reference.
     * @see #setModelElement(EObject)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getEMFContext_ModelElement()
     * @model
     * @generated
     */
	EObject getModelElement();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.EMFContext#getModelElement <em>Model Element</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Model Element</em>' reference.
     * @see #getModelElement()
     * @generated
     */
	void setModelElement(EObject value);

} // EMFContext
