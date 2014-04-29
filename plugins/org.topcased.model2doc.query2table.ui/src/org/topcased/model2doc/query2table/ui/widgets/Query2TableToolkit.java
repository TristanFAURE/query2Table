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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.topcased.model2doc.query2table.ui.Activator;
import org.topcased.model2doc.query2table.ui.Query2TableController;
import org.topcased.model2doc.query2table.ui.preferences.IPreferenceSaver;

public class Query2TableToolkit extends FormToolkit {

	public Query2TableToolkit(Display display) {
		super(display);
	}

	/**
	 * Create a text which save the message
	 * 
	 * @param parent
	 * @param value
	 * @param keyPreferences
	 * @param saver
	 * @return
	 */
	public Text createText(Composite parent, String value,
			String keyPreferences, IPreferenceSaver saver) {
		Text t = this.createText(parent, value);
		TextSavable savable = new TextSavable(t, keyPreferences);
		saver.add(savable);
		if (value == null || value.length() == 0) {
			IPreferenceStore store = Activator.getDefault()
					.getPreferenceStore();
			t.setText(store.getString(keyPreferences));
		}
		return t;
	}

	public Text createObjectText(Composite parent, String value,
			String keyPreferences, IPreferenceSaver saver,
			Query2TableController query2TableController, String input) {
		Text t = this.createText(parent, value);

		ObjectSavable savable = new ObjectSavable(query2TableController,
				keyPreferences);
		saver.add(savable);

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String id = store.getString(keyPreferences);
		Resource r = query2TableController.getInputModelResource();
		if (id != null && id.length() != 0 && r != null) {
			EObject e = r.getEObject(id);
			if (e != null)
			{
				query2TableController.setElementSelected(e);
				t.setText(new ReflectiveItemProvider(
						new ReflectiveItemProviderAdapterFactory()).getText(e));
			}
		}

		return t;
	}

	/**
	 * Default create text with border
	 */
	@Override
	public Text createText(Composite parent, String value, int style) {
		return super.createText(parent, value, style | SWT.BORDER);
	}

	/**
	 * Creates a scrolled form widget in the provided parent. If you do not
	 * require scrolling because there is already a scrolled composite up the
	 * parent chain, use 'createForm' instead.
	 * 
	 * @param parent
	 *            the scrolled form parent
	 * @param style
	 *            the style to create the scrolled form
	 * @return the form that can scroll itself
	 * @see #createForm
	 */
	public ScrolledForm createScrolledForm(Composite parent, int style) {
		ScrolledForm form = new ScrolledForm(parent, style);
		form.setExpandHorizontal(true);
		form.setExpandVertical(true);
		form.setBackground(getColors().getBackground());
		form.setForeground(getColors().getForeground());
		form.setFont(JFaceResources.getHeaderFont());
		return form;
	}

	public Combo createCombo(Composite parent, int style,
			String keyPreferences, IPreferenceSaver saver, String[] items) {
		Combo c = new Combo(parent, style);
		ComboSavable savable = new ComboSavable(c, keyPreferences);
		saver.add(savable);
		c.setItems(items);
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String valueFromPref = store.getString(keyPreferences);
		if (valueFromPref != null && valueFromPref.length() > 0) {
			for (int i = 0; i <= c.getItemCount(); i++) {
				if (c.getItem(i).equals(valueFromPref)) {
					c.setText(valueFromPref);
					return c;
				}
			}
		}
		return c;
	}

	public Button createRadioButton(Composite parent, String value, int radio,
			String keyPreferences, IPreferenceSaver saver) {
		Button b = createButton(parent, value, radio);
		ButtonSavable savable = new ButtonSavable(b, keyPreferences);
		saver.add(savable);
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		b.setSelection(store.getBoolean(keyPreferences));
		return b;
	}

	public Button createBrowseButton(Composite parent) {
		return createButton(parent, "Browse", SWT.PUSH);
	}

	public List createList(Composite parent, int style) {
		return new List(parent, style);
	}

	public Group createGroup(Composite parent, int style) {
		return new Group(parent, style);
	}

	public Combo createCombo(Composite parent, int style) {
		return new Combo(parent, style);
	}


}
