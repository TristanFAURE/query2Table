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

import java.util.Map;

import org.topcased.model2doc.query2table.exception.QueryExecutionException;
import org.topcased.model2doc.query2table.query.IJavaQuery;

public class IvanQuery implements IJavaQuery {

	public static int i = 0 ;
	
	public Object executeJavaQuery(Object o, Map<Integer, Object> env)
			throws QueryExecutionException {
		return "Ivan " + i++ ;
	}

}
