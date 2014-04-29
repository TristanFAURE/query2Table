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


import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.topcased.model2doc.query2table.ui.Q2TServices;
import org.topcased.model2doc.query2table.ui.Query2TableController;
import org.topcased.model2doc.query2table.ui.Query2TableWizard;
import org.topcased.model2doc.query2table.ui.StringFormatter;
import org.topcased.model2doc.query2table.ui.extension.RegisteredQuery2TableManager;
import org.topcased.model2doc.query2table.ui.preferences.IPreferenceSaver;
import org.topcased.model2doc.query2table.ui.widgets.Query2TableToolkit;

public class SelectionWizardPage extends AbstractWizardPage {

	private Query2TableWizard query2TableWizard;
	/** Description page */
	private String description = Messages.SelectionWizardPage_0;
	private String inputModelErrorMessage = Messages.SelectionWizardPage_1;
	
	
	private static String KEY_PREF_OUTPUT = "KEY_PREF_OUTPUT" ; 
	private static String KEY_PREF_BROWSE = "KEY_PREF_BROWSE" ; 
	private static String KEY_PREF_INPUT = "KEY_PREF_INPUT" ; 
	public String KEY_PREF_ELEMENT = "KEY_PREF_ELEMENT" ; 
	private static String KEY_PREF_REGISTRED = "KEY_PREF_REGISTRED" ; 
	private static String KEY_PREF_RADIO_REGISTRED = "KEY_PREF_RADIO_REGISTRED" ; 
	private static String KEY_PREF_RADIO_BROWSE = "KEY_PREF_RADIO_BROWSE" ; 
	private static String KEY_PREF_RADIO_NEW = "KEY_PREF_RADIO_NEW" ; 
	private static String KEY_PREF_RADIO_NESTED = "KEY_PREF_RADIO_NESTED" ;
	private static String KEY_PREF_RADIO_DUPLICATE = "KEY_PREF_RADIO_DUPLICATE" ; 
	
	/**set
	 * Sections texts
	 */
	private String outputSectionText = StringFormatter.format(Messages.SelectionWizardPage_2);
	private String configurationSectionText = StringFormatter.format(Messages.SelectionWizardPage_3);
	private String modelSectionText = StringFormatter.format(Messages.SelectionWizardPage_4);
	private String typeTableText = StringFormatter.format(Messages.SelectionWizardPage_5);
	
	/**
	 * Labels texts
	 */
	private String outputPathLabel = Messages.SelectionWizardPage_6;
	private String inputModelLabel = Messages.SelectionWizardPage_7;
	private String elementSelectionLabel = Messages.SelectionWizardPage_8;
	
	/**
	 * Radio buttons texts
	 */
	private String radioButton1Text = Messages.SelectionWizardPage_9;
	private String radioButton2Text = Messages.SelectionWizardPage_10;
	private String radioButton3Text = Messages.SelectionWizardPage_11;
	private String radioButtonNestedTableText = Messages.SelectionWizardPage_12;
	private String radioButtonDuplicateTableText = Messages.SelectionWizardPage_13;
	
	/**
	 * A default grid data which have a horizontal alignment to fill
	 */
	private GridData defaultFillGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
	
	private ConfigurationWizardPage nextPage;
	Q2TServices q2t = new Q2TServices(getController());
	private Query2TableController query2TableController;
	
	/**
	 * Texts
	 */
	public Text outputPathText;
	public Text browseExistingConfigText;
	public Text inputModelText;
	public Text elementSelectionText;
	
	public Combo combo;
	
	/**
	 * Buttons
	 */
	public Button radioButton1;
	public Button radioButton2;
	public Button radioButton3;
	private Button browseExistingConfigButton;
	private Button browseElementSelectionButton;
	public Button nestedButton;
	public Button duplicateNested;
	
	
	
	/**
	 * This class create a resourceDialog to select your file and update the text with selected file
	 */
	private class ResourceSelectionListener implements SelectionListener
    {
		private Text text;
		private int style;
		//determinates if we use the ResourceDialog or the OutputResourceDialog, 
		//to show the extension Combo
		private int section;
		
		public ResourceSelectionListener(Text t, int style, int section) {
			this.text = t;
			this.style = style;
			this.section=section;
		}
		
        public void widgetDefaultSelected(SelectionEvent e)
        {
        }

        public void widgetSelected(SelectionEvent e)
        {
        	if(section==0){
            ResourceDialog dialog = new OutputPathResourceDialog(getShell(), Messages.SelectionWizardPage_14, style | SWT.SINGLE);
            if (dialog.open() == ResourceDialog.OK){
            	String text = dialog.getURIText();
            	URI uri = URI.createURI(text);
            	if (uri.isFile())
            	{
            		text = uri.toFileString();
            	}
            	else if (uri.isPlatform())
            	{
            		text = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true))).getLocationURI().getPath();
            	}
            	outputPathText.setText(text);	
            }
        	}
        	if(section==1){
                ResourceDialog dialog = new ResourceDialog(getShell(), Messages.SelectionWizardPage_14, style | SWT.SINGLE);
                if (dialog.open() == ResourceDialog.OK){
                	String text = dialog.getURIText();
                	browseExistingConfigText.setText(text);
                }
            	}
        	if(section==2){
                ResourceDialog dialog = new ResourceDialog(getShell(), Messages.SelectionWizardPage_14, style | SWT.SINGLE);
                if (dialog.open() == ResourceDialog.OK){
                	String text = dialog.getURIText();
                	inputModelText.setText(text);
                }
            	}
        }
    };
    
	
    
    private SelectionAdapter radioConfigurationAdapter = new SelectionAdapter()
    {
    	public void widgetSelected(SelectionEvent event)
    	{
    		Button button = (Button)event.getSource();
    		manageButton(button);
    		setPageComplete(true);
    	}
    };
    
    private SelectionAdapter radioTableTypeAdapter = new SelectionAdapter() {
    	public void widgetSelected(SelectionEvent event)
    	{
    		Button button = (Button)event.getSource();
    		if(button.getText().equals(radioButtonNestedTableText)) {
    			getController().setIsNestedTableType(true);
    			getController().setRadioTableSelected(true);
    		}
    		else {
    			getController().setIsNestedTableType(false);
    			getController().setRadioTableSelected(true);
    		}
    		refresh();
    	}
    };
	
    
    
	/**
	 * Constructor
	 * @param pageName
	 * @param toolkit
	 * @param controller 
	 */
	public SelectionWizardPage(Query2TableToolkit toolkit, Query2TableController controller) {
		super("Query2Table Wizard",toolkit, controller);
		//parent.getShell().setText("Whatever");
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);		
		this.setDescription(description);
		
		
		Composite outputSection = createSection(topComposite, outputSectionText, 3);
		createOutputPathComponent(outputSection);
		
		Composite configurationSection = createSection(topComposite, configurationSectionText, 3);
		createConfigurationComponent(configurationSection);
		
		Composite modelSection = createSection(topComposite, modelSectionText, 3);
		createModelComponent(modelSection);
		
		Composite typeTable = createSection(topComposite, typeTableText, 1);
		createTypeTableComponent(typeTable);
		
		initValues();
		manageButton(radioButton1);
		manageButton(radioButton2);
		manageButton(radioButton3);
		refresh();
	}

	/**
	 * Create all components of output path section
	 * @param section
	 * 			the output path section
	 */
	private void createOutputPathComponent(Composite section) {
		// Output path label
		toolkit.createLabel(section, outputPathLabel);
		// Output path text
		outputPathText = toolkit.createText(section, "",KEY_PREF_OUTPUT,(IPreferenceSaver) getWizard());//$NON-NLS-1$
		if (!Query2TableWizard.isEmpty(outputPathText.getText()))
		{
			getController().setOutputPath(outputPathText.getText());
		}
		outputPathText.setLayoutData(defaultFillGridData);
		outputPathText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent event) {
				
				if (event.getSource()!= null && event.getSource() instanceof Text) {
					Text text = (Text) event.getSource();
					if(text.getText() != null) {
						getController().setOutputPath(text.getText());
					}
					setPageComplete(true);
				}
				refresh();
			}
		});
		// Output path browse button
		Button browseOutputPathButton = toolkit.createBrowseButton(section);
		browseOutputPathButton.addSelectionListener(new ResourceSelectionListener(outputPathText, SWT.SAVE, 0));
	}
	

	/**
	 * Create all components of configuration section
	 * @param section
	 * 			the configuration section
	 */
	private void createConfigurationComponent(Composite section) {
		// Registered export
		radioButton1 = toolkit.createRadioButton(section, radioButton1Text, SWT.RADIO, "KEY_PREF_RADIO_REGISTRED", (IPreferenceSaver) getWizard());
		getController().setRadioConfig(Query2TableController.RadioConfig.REGISTERED);
		radioButton1.addSelectionListener(radioConfigurationAdapter);
		combo = toolkit.createCombo(section, SWT.READ_ONLY | SWT.DROP_DOWN,  "KEY_PREF_REGISTRED", (IPreferenceSaver) getWizard(),RegisteredQuery2TableManager.getRegisteredNameModelExports());
		if (!Query2TableWizard.isEmpty(combo.getText()))
		{
			getController().setRegisteredExport(combo.getText());
		}
		toolkit.adapt(combo);
		
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		combo.setLayoutData(data);
		
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				if(event.getSource() != null && event.getSource() instanceof Combo) {
					Combo combo = ((Combo)event.getSource());
					if(combo.getText() != null) {
						getController().setRegisteredExport(combo.getText());
					}
					setPageComplete(true);
				}
			}
		});
		enabledRegisteredExport();
		
		// Browse existing configuration
		radioButton2 = toolkit.createRadioButton(section, radioButton2Text, SWT.RADIO, "KEY_PREF_RADIO_BROWSE", (IPreferenceSaver) getWizard());
		radioButton2.addSelectionListener(radioConfigurationAdapter);
		browseExistingConfigText = toolkit.createText(section, "",KEY_PREF_BROWSE,(IPreferenceSaver) getWizard()); //$NON-NLS-1$
		if (!Query2TableWizard.isEmpty(browseExistingConfigText.getText()))
		{
			getController().setExistingConfigurationFile(browseExistingConfigText.getText());
		}
		browseExistingConfigText.setLayoutData(defaultFillGridData);
		browseExistingConfigText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				if (event.getSource()!= null && event.getSource() instanceof Text) {
					Text text = (Text) event.getSource();
					if(text.getText() != null) {
						getController().setExistingConfigurationFile(text.getText());
					}
					setPageComplete(true);
				}
				refresh();
			}
		});
		browseExistingConfigButton = toolkit.createBrowseButton(section);
		browseExistingConfigButton.addSelectionListener(new ResourceSelectionListener(browseExistingConfigText, SWT.OPEN, 1));
		disabledBrowseExistingConfiguration();
		
		// Create new configuration
		radioButton3 = toolkit.createRadioButton(section, radioButton3Text, SWT.RADIO,  "KEY_PREF_RADIO_NEW", (IPreferenceSaver) getWizard());
		radioButton3.addSelectionListener(radioConfigurationAdapter);
	}
	
	/**
	 * Create all components of model section
	 * @param section
	 * 			the model section
	 */
	private void createModelComponent(Composite section) {
		// Input model component
		toolkit.createLabel(section, inputModelLabel);
		inputModelText = toolkit.createText(section, "",KEY_PREF_INPUT,(IPreferenceSaver) getWizard()); //$NON-NLS-1$
		if(inputModelText.getText() != null) {
			getController().setInputModel(inputModelText.getText());
		}
		inputModelText.setLayoutData(defaultFillGridData);
		inputModelText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {		
				if (event.getSource()!= null && event.getSource() instanceof Text) {
					Text text = (Text) event.getSource();
					if(text.getText() != null) {
						getController().setInputModel(text.getText());
						if(getController().inputModelIsValid() && q2t.validatePath(text.getText())) {
							enabledElementSelection();
							getController().setErrorMessageSelectionPage(null);
							EObject input = getController().getInputModelResource().getContents().get(0);
							getController().setElementSelected(input);
							elementSelectionText.setText(new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory()).getText(input));						
						}else {
							if(text.getText().length()>1) {
								getController().setElementSelected(null);
								elementSelectionText.setText("");
								
							}
							disabledElementSelection();
							getController().setErrorMessageSelectionPage(inputModelErrorMessage);
						}
					}
					setPageComplete(true);
				}
				refresh();
			}
		});
		Button browseInputModelButton = toolkit.createBrowseButton(section);
		browseInputModelButton.addSelectionListener(new ResourceSelectionListener(inputModelText, SWT.OPEN, 2));
		
		// Element selection component
		toolkit.createLabel(section, elementSelectionLabel);
		elementSelectionText = toolkit.createObjectText(section, "",KEY_PREF_ELEMENT,(IPreferenceSaver) getWizard(), getController(),inputModelText.getText()); //$NON-NLS-1$
		elementSelectionText.setEditable(false);
		elementSelectionText.setLayoutData(defaultFillGridData);
		elementSelectionText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				refresh();
			}
		});
		
		
		
		browseElementSelectionButton = toolkit.createBrowseButton(section);
		browseElementSelectionButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				selectElement();
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		disabledElementSelection();
	}
	
	/**
	 * Create all components of type table section
	 * @param section
	 * 			the type of table section
	 */
	private void createTypeTableComponent(Composite section) {
		nestedButton = toolkit.createRadioButton(section, radioButtonNestedTableText, SWT.RADIO, "KEY_PREF_ELEMENT_RADIO_NESTED", (IPreferenceSaver) getWizard());
		if(nestedButton.getSelection()){
			getController().setRadioTableSelected(true);
		}
		nestedButton.addSelectionListener(radioTableTypeAdapter);
		duplicateNested = toolkit.createRadioButton(section, radioButtonDuplicateTableText, SWT.RADIO, "KEY_PREF_ELEMENT_RADIO_DUPLICATE", (IPreferenceSaver) getWizard());
		if(duplicateNested.getSelection()){
			getController().setRadioTableSelected(true);
		}
		duplicateNested.addSelectionListener(radioTableTypeAdapter);
	}
	
	private void enabledRegisteredExport() {
		combo.setEnabled(true);
	}
	
	private void disabledRegisteredExport() {
		combo.setEnabled(false);
	}
	
	private void enabledBrowseExistingConfiguration() {
		browseExistingConfigText.setBackground(browseExistingConfigText.getParent().getBackground());
		browseExistingConfigButton.setEnabled(true);
	}
	
	private void disabledBrowseExistingConfiguration() {
		browseExistingConfigText.setBackground(greenScreen);
		browseExistingConfigButton.setEnabled(false);
	}
	
	private void enabledElementSelection() {
		elementSelectionText.setBackground(elementSelectionText.getParent().getBackground());
		browseElementSelectionButton.setEnabled(true);
	}
	
	private void disabledElementSelection() {
		elementSelectionText.setBackground(greenScreen);
		browseElementSelectionButton.setEnabled(false);
	}
	
	private void selectElement() {
		EObject input = getController().getInputModelResource().getContents().get(0);

		ComposedAdapterFactory composed = new ComposedAdapterFactory();
		composed.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		ReflectiveItemProviderAdapterFactory adapterFactory = new ReflectiveItemProviderAdapterFactory();
		composed.addAdapterFactory(adapterFactory);
		AdapterFactoryContentProvider contentFactory = new AdapterFactoryContentProvider(composed);
		AdapterFactoryLabelProvider labelFactory = new AdapterFactoryLabelProvider(composed);

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), labelFactory, contentFactory);
		
		dialog.setTitle(Messages.SelectionWizardPage_20);
		dialog.setMessage(Messages.SelectionWizardPage_21);
		dialog.setInput(input.eResource());
		if(dialog.open() == ElementTreeSelectionDialog.OK) {
			Object object = dialog.getResult()[0];

			if (object instanceof EObject) {
				EObject eobject = (EObject) object;
				getController().setElementSelected(eobject);
				elementSelectionText.setText(new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory()).getText(eobject));
				setPageComplete(true);
			}
		}
	}
	
	private void initValues()
	{
		if(getController().getInputModel() != null && getController().getInputModel().length() >0)
		{
			inputModelText.setText(getController().getInputModel());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		
		nextPage = new ConfigurationWizardPage(toolkit, getController());
		nextPage.setWizard(getWizard());
		((Query2TableWizard)getWizard()).setConfiguration(nextPage);
		return nextPage;
	}
	
	
	@Override
	public boolean canFlipToNextPage() {
		// the method is overridden to avoid next page creation in canFlipToNExtPage
		return isPageComplete()	;
	}

	public boolean isPageComplete() {
		return getController().isSelectionPageComplete(this);
	}

	private void manageButton(Button button) {
		if(button.getText().equals(radioButton1Text) && button.getSelection()) {
			enabledRegisteredExport();
			disabledBrowseExistingConfiguration();
			getController().setRadioConfig(Query2TableController.RadioConfig.REGISTERED);
			browseExistingConfigText.setText("");
			browseExistingConfigText.setEnabled(false);
		}
		else if(button.getText().equals(radioButton2Text) && button.getSelection()) {
			enabledBrowseExistingConfiguration();
			disabledRegisteredExport();
			getController().setRadioConfig(Query2TableController.RadioConfig.BROWSE);
			browseExistingConfigText.setEnabled(true);
			combo.deselectAll();
		}
		else if(button.getText().equals(radioButton3Text) && button.getSelection()) {
			disabledRegisteredExport();
			disabledBrowseExistingConfiguration();
			getController().setRadioConfig(Query2TableController.RadioConfig.NEW);
			browseExistingConfigText.setText("");
			combo.deselectAll();
		}
	}
	
}
