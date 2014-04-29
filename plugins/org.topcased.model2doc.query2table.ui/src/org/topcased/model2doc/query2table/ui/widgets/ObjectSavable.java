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
package org.topcased.model2doc.query2table.ui.widgets;

import org.eclipse.emf.ecore.EObject;
import org.topcased.model2doc.query2table.ui.Query2TableController;



public class ObjectSavable extends AbstractPreferenceSavable{

	private final Query2TableController controller;
	
	public ObjectSavable(Query2TableController controller, String key) {
		super(key);
		this.controller = controller;
	}

	@Override
	public String getText() {
		EObject elementSelected = controller.getElementSelected();
		return elementSelected.eResource().getURIFragment(elementSelected);
	}

}
