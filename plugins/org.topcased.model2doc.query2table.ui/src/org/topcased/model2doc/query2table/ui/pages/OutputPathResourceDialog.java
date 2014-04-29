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
package org.topcased.model2doc.query2table.ui.pages;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.topcased.model2doc.query2table.Query2tablePackage;

public class OutputPathResourceDialog extends ResourceDialog {
	private Combo combo;
	private String currentExtension = "" ;
	private String result = null ;
	public OutputPathResourceDialog(Shell parent, String title,
			int style) {
		super(parent, title, style);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Control element = super.createDialogArea(parent);
		Label label =new Label(parent, 0);
		label.setText("Select the output file format:");
		combo = new Combo(parent, SWT.NONE);
		Collection<String> collec = new ArrayList<String>();
		EDataType eAttributeType = Query2tablePackage.eINSTANCE.getModelExport_ExportExtension().getEAttributeType();
		if (eAttributeType instanceof EEnum) {
			EEnum enumeration = (EEnum) eAttributeType;
			for (EEnumLiteral l : enumeration.getELiterals())
			{
				collec.add(l.getName());
			}
		}
		String[] strings = collec.toArray(new String[]{});
		combo.setItems(strings);
		combo.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				currentExtension = combo.getText();
			}
		});
		return element;
	}

	@Override
	public String getURIText() {
		if (result == null)
		{
			result = super.getURIText();
			String extension = currentExtension.length() > 0 ? currentExtension : combo.getItem(0);
			result = result+"."+extension ;
		}
		return result;
	}
	

}