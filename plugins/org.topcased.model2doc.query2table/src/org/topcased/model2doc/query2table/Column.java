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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.Column#getIndex <em>Index</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.Column#getTitle <em>Title</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.Column#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.Column#getDisplays <em>Displays</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.Column#getExecutes <em>Executes</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.Column#getDefaultValueToDisplay <em>Default Value To Display</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.model2doc.query2table.Query2tablePackage#getColumn()
 * @model
 * @generated
 */
public interface Column extends EObject {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * Returns the value of the '<em><b>Index</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Index</em>' attribute.
     * @see #setIndex(int)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getColumn_Index()
     * @model required="true"
     * @generated
     */
	int getIndex();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.Column#getIndex <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Index</em>' attribute.
     * @see #getIndex()
     * @generated
     */
	void setIndex(int value);

	/**
     * Returns the value of the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Title</em>' attribute.
     * @see #setTitle(String)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getColumn_Title()
     * @model
     * @generated
     */
	String getTitle();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.Column#getTitle <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Title</em>' attribute.
     * @see #getTitle()
     * @generated
     */
	void setTitle(String value);

	/**
     * Returns the value of the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pattern</em>' attribute.
     * @see #setPattern(String)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getColumn_Pattern()
     * @model
     * @generated
     */
	String getPattern();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.Column#getPattern <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pattern</em>' attribute.
     * @see #getPattern()
     * @generated
     */
	void setPattern(String value);

	/**
     * Returns the value of the '<em><b>Displays</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.model2doc.query2table.Query}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Displays</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Displays</em>' containment reference list.
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getColumn_Displays()
     * @model containment="true"
     * @generated
     */
	EList<Query> getDisplays();

	/**
     * Returns the value of the '<em><b>Executes</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Executes</em>' containment reference.
     * @see #setExecutes(Query)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getColumn_Executes()
     * @model containment="true" required="true"
     * @generated
     */
	Query getExecutes();

	/**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.Column#getExecutes <em>Executes</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Executes</em>' containment reference.
     * @see #getExecutes()
     * @generated
     */
	void setExecutes(Query value);

    /**
     * Returns the value of the '<em><b>Default Value To Display</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Value To Display</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Value To Display</em>' attribute.
     * @see #setDefaultValueToDisplay(String)
     * @see org.topcased.model2doc.query2table.Query2tablePackage#getColumn_DefaultValueToDisplay()
     * @model
     * @generated
     */
    String getDefaultValueToDisplay();

    /**
     * Sets the value of the '{@link org.topcased.model2doc.query2table.Column#getDefaultValueToDisplay <em>Default Value To Display</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value To Display</em>' attribute.
     * @see #getDefaultValueToDisplay()
     * @generated
     */
    void setDefaultValueToDisplay(String value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void addDisplayQuery(Query displayQuery);
    
    

} // Column
