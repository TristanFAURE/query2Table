/*****************************************************************************
 * Copyright (c) 2014 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.topcased.model2doc.query2table.ui;

public class StringFormatter {
	public enum kind 
	{
		standard,
		bool
	}
	
	public static String format (String s)
	{
		return format(s,kind.standard) ;
	}
	
	
	public static String format (String s, kind type)
	{
		return s ;
	}
}
