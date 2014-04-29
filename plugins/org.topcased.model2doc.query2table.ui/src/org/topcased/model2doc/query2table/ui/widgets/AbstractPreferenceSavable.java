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

import org.topcased.model2doc.query2table.ui.Activator;
import org.topcased.model2doc.query2table.ui.preferences.IPreferenceSavable;

public abstract class AbstractPreferenceSavable implements IPreferenceSavable {

	protected String key;
	
	public AbstractPreferenceSavable (String key)
	{
		this.key = key ;
	}
	
	public void save() {
		Activator.getDefault().getPreferenceStore().setValue(key,getText());
	}
	
	public abstract String getText();

}
