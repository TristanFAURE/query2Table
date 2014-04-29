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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Export Extension</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.topcased.model2doc.query2table.Query2tablePackage#getExportExtension()
 * @model
 * @generated
 */
public enum ExportExtension implements Enumerator {
	/**
     * The '<em><b>Xls</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #XLS_VALUE
     * @generated
     * @ordered
     */
	XLS(0, "xls", "xls"),

	/**
     * The '<em><b>Html</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #HTML_VALUE
     * @generated
     * @ordered
     */
	HTML(1, "html", "html"), /**
     * The '<em><b>Csv</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #CSV_VALUE
     * @generated
     * @ordered
     */
	CSV(2, "csv", "csv"),;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The '<em><b>Xls</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Xls</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #XLS
     * @model name="xls"
     * @generated
     * @ordered
     */
	public static final int XLS_VALUE = 0;

	/**
     * The '<em><b>Html</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Html</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #HTML
     * @model name="html"
     * @generated
     * @ordered
     */
	public static final int HTML_VALUE = 1;

	/**
     * The '<em><b>Csv</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Csv</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #CSV
     * @model name="csv"
     * @generated
     * @ordered
     */
	public static final int CSV_VALUE = 2;

	/**
     * An array of all the '<em><b>Export Extension</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final ExportExtension[] VALUES_ARRAY =
		new ExportExtension[]
        {
            XLS,
            HTML,
            CSV,
        };

	/**
     * A public read-only list of all the '<em><b>Export Extension</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<ExportExtension> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Export Extension</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ExportExtension get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            ExportExtension result = VALUES_ARRAY[i];
            if (result.toString().equals(literal))
            {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Export Extension</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ExportExtension getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            ExportExtension result = VALUES_ARRAY[i];
            if (result.getName().equals(name))
            {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Export Extension</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ExportExtension get(int value) {
        switch (value)
        {
            case XLS_VALUE: return XLS;
            case HTML_VALUE: return HTML;
            case CSV_VALUE: return CSV;
        }
        return null;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final int value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String name;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String literal;

	/**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private ExportExtension(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getValue() {
      return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
      return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getLiteral() {
      return literal;
    }

	/**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        return literal;
    }
	
} //ExportExtension
