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
package org.topcased.model2doc.query2table.util;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.Query;
import org.topcased.model2doc.query2table.query.IJavaQuery;

public class QueryUtils {

	private static Map<String, IJavaQuery> javaQueries;

	/**
	 * ReflectiveItemProvider used to get text from an EObject (for
	 * displayValues)
	 */
	private static ReflectiveItemProvider reflectiveItemProvider = new ReflectiveItemProvider(
			new ReflectiveItemProviderAdapterFactory());

	/**
	 * If no specific pattern is defined, get text from Reflective Item provider
	 * Else compute display queries and apply pattern to query results
	 * 
	 * @param pColumn
	 *            current Column (containing the display queries)
	 * @param pContent
	 *            content of the current object for which to display a text
	 *            value)
	 * 
	 * @return display value
	 */
	public static String computeDisplayValue(Column pColumn, Object pContent) {

		String pattern = pColumn.getPattern();
		List<Query> displayQueries = pColumn.getDisplays();
		if (pattern == null || "".equals(pattern)) {
		    if(pContent == null){
		        if(pColumn.getDefaultValueToDisplay() != null){
		            return pColumn.getDefaultValueToDisplay();
		        }
		        else {
		            return " ";
		        }
		    }
		    else if (pContent instanceof EObject) {
    			// If no specific pattern is defined, get text from Reflective Item
    			// provider
    			return reflectiveItemProvider.getText(pContent);
		    }
		    else {
		        return pContent.toString();
		    }
		} else {
		    pattern = pattern.replace("\\n", "\n").replace("'", "''");
			// Else compute display queries and apply pattern to query results
			if (displayQueries != null) {
				Object[] queryResults = new Object[displayQueries.size()];
				int i = 0;
				for (Query q : displayQueries) {
					queryResults[i] = q.executeQuery(pContent);

					// When result is an EObject -> display the result with
					// itemProvider
					if (queryResults[i] instanceof EObject) {
						queryResults[i] = reflectiveItemProvider
								.getText(queryResults[i]);
					}

					i++;
				}
				return MessageFormat.format(pattern, queryResults);
			}
			return pattern;
		}
	}

	/**
	 * Get list of IDs for all java queries
	 * @return list of IDs for all java queries registered by extension point
	 */
	public static Collection<String> getJavaQueryIDs() {
		if (javaQueries == null) {
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(
							"org.topcased.model2doc.query2table.query");

			javaQueries = new HashMap<String, IJavaQuery>();
			
				for (IConfigurationElement element : elements) {
					String id = element.getAttribute("javaQueryID");
					try {
					IJavaQuery javaQuery = (IJavaQuery) element
							.createExecutableExtension("javaQuery");
					javaQueries.put(id, javaQuery);
					} catch (CoreException e) {
						e.printStackTrace();
						//DO NOTHING : Invalid query
					}
				}
		}
		return javaQueries.keySet();
	}
	
	public static IJavaQuery getJavaQuery (String javaQueryID){
	    if( javaQueries == null){
	        getJavaQueryIDs();
	    }
	    return javaQueries.get(javaQueryID);
	}

}
