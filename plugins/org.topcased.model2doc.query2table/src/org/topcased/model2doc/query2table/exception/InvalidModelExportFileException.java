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
 * The ModelExport file (.ocl2html) is invalid
 *
 */
public class InvalidModelExportFileException extends Exception {

	/**
	 * 
	 */
	public InvalidModelExportFileException() {
		super();
	}

	/**
	 * @param message
	 */
	public InvalidModelExportFileException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidModelExportFileException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidModelExportFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
