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
package tests.javaQuery;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.topcased.model2doc.query2table.exception.QueryExecutionException;
import org.topcased.model2doc.query2table.query.IJavaQuery;

/**
 * @author ahaugomm
 * 
 */
public class JavaQueryForTests implements IJavaQuery {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.topcased.model2doc.query2table.query.IJavaQuery#executeJavaQuery(
	 * java.lang.Object, java.util.Map)
	 */
	public List<?> executeJavaQuery(Object o, Map<Integer, Object> env)
			throws QueryExecutionException {

		if (o instanceof EObject) {
			return ((EObject) o).eContents();
		}
		return Collections.EMPTY_LIST;

	}

}
