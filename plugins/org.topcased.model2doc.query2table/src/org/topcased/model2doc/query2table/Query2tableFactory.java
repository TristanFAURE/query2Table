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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.topcased.model2doc.query2table.Query2tablePackage
 * @generated
 */
public interface Query2tableFactory extends EFactory {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	Query2tableFactory eINSTANCE = org.topcased.model2doc.query2table.impl.Query2tableFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Model Export</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Model Export</em>'.
     * @generated
     */
	ModelExport createModelExport();

	/**
     * Returns a new object of class '<em>Column</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Column</em>'.
     * @generated
     */
	Column createColumn();

	/**
     * Returns a new object of class '<em>OCL Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>OCL Query</em>'.
     * @generated
     */
	OCLQuery createOCLQuery();

	/**
     * Returns a new object of class '<em>Java Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Java Query</em>'.
     * @generated
     */
	JavaQuery createJavaQuery();

	/**
     * Returns a new object of class '<em>Column Context</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Column Context</em>'.
     * @generated
     */
	ColumnContext createColumnContext();

	/**
     * Returns a new object of class '<em>EMF Context</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>EMF Context</em>'.
     * @generated
     */
	EMFContext createEMFContext();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	Query2tablePackage getQuery2tablePackage();

} //Query2tableFactory
