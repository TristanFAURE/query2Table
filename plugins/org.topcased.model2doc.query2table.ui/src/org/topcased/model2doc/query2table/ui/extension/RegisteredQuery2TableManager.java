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
package org.topcased.model2doc.query2table.ui.extension;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;

/**
 * This class manage the registered model exports extension point
 */
public class RegisteredQuery2TableManager {
	
	/** Name of the registered export */
	private static String NAME_REGISTERED = "name";
	/** Model of the registered export */
	private static String MODEL_REGISTERED = "model";
	/** Extension point ID */
	private static String extensionPointID = "org.topcased.model2doc.query2table.ui.registeredQ2T";
	/** All registered export list */
	private static List<Registered> allRegistered = getAllRegistered();
	
	/** 
	 * Return all registered model exports
	 * @return list registered model exports
	 */
	public static List<Registered> getRegisteredModelExports()
	{
		return allRegistered;
	}
	
	public static String[] getRegisteredNameModelExports()
	{
		String[] registeredNames = new String[allRegistered.size()];
		for(int i=0; i<allRegistered.size(); i++) {
			registeredNames[i] = allRegistered.get(i).name;
		}
		return registeredNames;
	}
	
	/**
	 * Return all registered model exports in extension point
	 * @return list registered model exports
	 */
	private static List<Registered> getAllRegistered() {
		List<Registered> registeredList = new ArrayList<Registered>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointID);
		for(IConfigurationElement configElement : elements) {
			Registered r = new Registered();
			String modelUri = configElement.getAttribute(MODEL_REGISTERED);
			r.modelExportURI = URI.createPlatformPluginURI(configElement.getContributor().getName() + "/" + modelUri, true);
			String name = configElement.getAttribute(NAME_REGISTERED);
			r.name = name;
			registeredList.add(r);
		}
		return registeredList;
	}
	
	public static URI getURIFromRegisteredName(String name)
	{
		for (Registered r : allRegistered)
		{
			if (name != null && name.equals(r.name))
			{
				return r.modelExportURI ;
			}
		}	
		return null ;
		
	}
	
	/**
	 * This class represents a registered model export in the extension point
	 */
	public static class Registered 
	{
		/** Name of the model export */
		private String name ;
		/** URI of the model export */
		private URI modelExportURI ;
		
		/**
		 * Return the model export URI
		 * @return model export URI
		 */
		public URI getModelExportURI() {
			return modelExportURI;
		}
		
		/**
		 * Return the name of the model export
		 * @return the name of the model export
		 */
		public String getName() {
			return name;
		}
	}
}
