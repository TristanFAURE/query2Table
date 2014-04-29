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
package org.topcased.model2doc.query2table.query;

import java.util.Map;

import org.topcased.model2doc.query2table.exception.QueryExecutionException;

/**
 * Interface for Java queries definition. Each one must be declared via
 * 'org.topcased.model2doc.query2table.query' extension point and must implement
 * this interface.
 * 
 */
public interface IJavaQuery {

	/**
	 * 
	 * Execute the java query on the object o, with an eventual execution
	 * environment, given by the map
	 * 
	 * @param o
	 *            object on which to execute the query
	 * @param env
	 *            execution environment (can be null). Map of (columnIndexe,
	 *            object from the column )
	 * @return object returned by the query
	 * @throws QueryExecutionException (list or single object)
	 *             In case of exception during the query execution.
	 */
	public Object executeJavaQuery(Object o, Map<Integer, Object> env)
			throws QueryExecutionException;
}
