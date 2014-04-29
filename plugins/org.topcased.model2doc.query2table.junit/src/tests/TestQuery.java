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
package tests;

import org.topcased.model2doc.query2table.util.QueryUtils;

import junit.framework.TestCase;

public class TestQuery extends TestCase {

	public void testGetJavaQueryIDS(){
		assertTrue(QueryUtils.getJavaQueryIDs().contains("javaQueryForTests"));
	}
}
