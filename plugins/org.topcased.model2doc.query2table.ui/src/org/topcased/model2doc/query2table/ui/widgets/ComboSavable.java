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

import org.eclipse.swt.widgets.Combo;

public class ComboSavable extends AbstractPreferenceSavable{

	private final Combo combo;

	public ComboSavable(Combo c, String key) {
		super(key);
		combo = c;
	}

	@Override
	public String getText() {
		return combo.getText();
	}

}
