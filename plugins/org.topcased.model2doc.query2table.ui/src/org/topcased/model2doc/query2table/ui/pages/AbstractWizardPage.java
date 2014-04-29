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

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.topcased.model2doc.query2table.ui.Query2TableController;
import org.topcased.model2doc.query2table.ui.widgets.Query2TableToolkit;

public class AbstractWizardPage extends WizardPage {

	protected Query2TableToolkit toolkit;
	private ManagedForm managedForm;
	protected Composite topComposite;
	private Query2TableController controller;
	protected Section topSection;
	public static Color greenScreen;
	
	protected AbstractWizardPage(String string, Query2TableToolkit toolkit, Query2TableController controller) {
		super("Description", string, null );
		this.toolkit = toolkit;
		this.controller = controller;
	}
	
	

	public void createControl(Composite parent) {
		greenScreen = new Color(parent.getDisplay(),
				222, 223, 224);
		ScrolledForm sform = toolkit.createScrolledForm(parent, SWT.V_SCROLL);
		sform.setAlwaysShowScrollBars(false);
		sform.setExpandHorizontal(true);
		sform.setExpandVertical(true);
		managedForm = new ManagedForm(toolkit, sform);
		topComposite = sform.getBody();
		GridLayout layout = new GridLayout(1, true);
		topComposite.setLayout(layout);
		this.setDescription("Description");
		setControl(sform);
	}

	/**
	 * Creates the section.
	 * 
	 * @param parent
	 *            the mform
	 * @param title
	 *            the title
	 * @param numColumns
	 *            the num columns
	 * 
	 * @return the composite
	 */
	protected Composite createSection(Composite parent, String title,
			int numColumns) {
		topSection = toolkit.createSection(parent, Section.TITLE_BAR);
		topSection.addExpansionListener(new ExpansionAdapter() {
			
			public void expansionStateChanged(ExpansionEvent e) {
				managedForm.reflow(true);
			}
		});
		topSection.setText(title);
		topSection.setLayoutData(getTopLayoutData());
		Composite client = toolkit.createComposite(topSection);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 1;
		layout.marginHeight = 1;
		layout.numColumns = numColumns;
		layout.makeColumnsEqualWidth = false;
		client.setLayout(layout);
		topSection.setClient(client);
		return client;
	}
	
	public void refresh ()
	{
		getWizard().getContainer().updateButtons();
		getWizard().getContainer().updateMessage();
	}
	/**
	 * Get the layout data for sections in top composite
	 * 
	 * @return griddata
	 */
	private Object getTopLayoutData() {
		return new GridData(SWT.FILL, SWT.FILL, true, true);
	}

	public Query2TableController getController() {
		return controller;
	}
	
}
