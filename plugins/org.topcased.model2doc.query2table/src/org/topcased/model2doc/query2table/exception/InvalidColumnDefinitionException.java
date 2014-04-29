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

package org.topcased.model2doc.query2table.exception;

/**
 * Invalid definition of the columns for the model export
 * (Ex : more than one column depending on model)
 */
public class InvalidColumnDefinitionException extends RuntimeException {

	/**
	 * 
	 */
	public InvalidColumnDefinitionException() {
		super();
	}

	/**
	 * @param message
	 */
	public InvalidColumnDefinitionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidColumnDefinitionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidColumnDefinitionException(String message, Throwable cause) {
		super(message, cause);
	}

}
