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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.ColumnContext;
import org.topcased.model2doc.query2table.Context;
import org.topcased.model2doc.query2table.EMFContext;
import org.topcased.model2doc.query2table.JavaQuery;
import org.topcased.model2doc.query2table.ModelExport;
import org.topcased.model2doc.query2table.OCLQuery;
import org.topcased.model2doc.query2table.Query;
import org.topcased.model2doc.query2table.Query2tableFactory;
import org.topcased.model2doc.query2table.Query2tablePackage;
import org.topcased.model2doc.query2table.export.Export2TableAction;
import org.topcased.model2doc.query2table.ui.Activator;
import org.topcased.model2doc.query2table.ui.Q2TServices;
import org.topcased.model2doc.query2table.ui.Query2TableController;
import org.topcased.model2doc.query2table.ui.extension.RegisteredQuery2TableManager;
import org.topcased.model2doc.query2table.ui.extension.RegisteredQuery2TableManager.Registered;
import org.topcased.model2doc.query2table.ui.pages.SM.event_execute;
import org.topcased.model2doc.query2table.ui.pages.utils.TreeUtils;
import org.topcased.model2doc.query2table.ui.widgets.Query2TableToolkit;
import org.topcased.model2doc.query2table.util.QueryUtils;
import org.topcased.model2doc.query2table.util.TableTree;
import org.topcased.model2doc.query2table.util.TableTreeNode;

public class ConfigurationWizardPage extends AbstractWizardPage {

	private static String EMPTY = "";
	/**
	 * Messages
	 */
	// private String column1Text = "Column 0 (default)";
	private String buttonExecuteQueryJavaText = "Java :";
	private String buttonExecuteQueryOCLText = "OCL :";

	private String buttonDisplayQueryJavaText = "Java display :";
	private String buttonDisplayQueryOCLText = "OCL display:";

	/** The image add. */
	private Image imageAdd;
	/** The image remove. */
	private Image imageRemove;
	private Image imageSave;
	private Image imageUp;
	private Image imageDown;
	private Image imageTable;

	/**
	 * Buttons
	 */
	public Button buttonSave;
	public Button buttonAddColumn;
	public Button buttonRemoveColumn;
	public Button radioButtonExecuteQueryJava;
	public Button radioButtonExecuteQueryOCL;
	public Button radioButtonDisplayQueryJava;
	public Button radioButtonDisplayQueryOCL;
	public Button queryAddButton;
	public Button queryDeleteButton;
	public Button queryEditButton;
	public Button queryUpButton;
	public Button queryDownButton;
	private Button buttonTable;

	/**
	 * Text
	 */
	Text executeQueryOCLText;
	Text displayQueryOCLText;
	Text patternText;
	Text stateMachineText;

	/**
	 * Combos
	 */
	Combo executeQueryJavaCombo;
	ComboViewer contextComboViewer;
	Combo contextCombo;
	Combo displayQueryJavaCombo;

	/**
	 * Table objects
	 */
	public Table table;
	private TableViewer columnsTableViewer;
	private Table displayQuerytable;
	private TableViewer queryTableViewer;

	/**
	 * Query2Table objects
	 */
	private Column columnSelected;
	private Query displayQuerySelected;

	private int highColumnIndex;
	private String[] extensionsID;

	/** The State Machine */
	SM sm = null;
	private Q2TServices q2t;

	@Override
	public void dispose() {
		super.dispose();
		imageAdd.dispose();
		imageDown.dispose();
		imageRemove.dispose();
		imageSave.dispose();
		imageUp.dispose();
		imageTable.dispose();
	}

	private SelectionAdapter executeQueryRadioButtonSelectionAdapter = new SelectionAdapter() {
		public void widgetSelected(SelectionEvent event) {
			Button radioButton = (Button) event.getSource();
			if (radioButton.getText().equals(buttonExecuteQueryJavaText)
					&& radioButton.getSelection()) {
				columnsTableViewer.refresh();
				unselectDisplay();
				sm.run(event_execute.selectJava);
				if ("COLUMN__COLUMN_SELECTED".equals(sm.getState_Machine())) {
					sm.run(event_execute.radioButtonExecuteJava);
				} else {
					sm.run(event_execute.changeToJava);
				}
			} else if (radioButton.getText().equals(buttonExecuteQueryOCLText)
					&& radioButton.getSelection()) {
				columnsTableViewer.refresh();
				unselectDisplay();
				sm.run(event_execute.selectOCL);
				if ("COLUMN__COLUMN_SELECTED".equals(sm.getState_Machine())) {
					sm.run(event_execute.radioButtonExecuteOCL);
				} else {
					sm.run(event_execute.changeToOCL);
				}
			}

		}
	};

	private SelectionAdapter displayQueryRadioButtonSelectionAdapter = new SelectionAdapter() {
		public void widgetSelected(SelectionEvent event) {
			int index = queryTableViewer.getTable().getSelectionIndex();
			Button radioButton = (Button) event.getSource();
			if (radioButton.getText().equals(buttonDisplayQueryJavaText)
					&& radioButton.getSelection()) {

				if ("DISPLAY_EDIT__COLUMN__DISPLAY_OCL".equals(sm
						.getState_Machine())) {
					sm.run(event_execute.changeToJava);
					displayQuerySelected = change(displayQuerySelected,
							Query2tablePackage.Literals.JAVA_QUERY);
				} else {
					sm.run(event_execute.selectDisplayQuerys);
					sm.run(event_execute.radioButtonDisplayJava);
				}

			} else if (radioButton.getText().equals(buttonDisplayQueryOCLText)
					&& radioButton.getSelection()) {
				if ("DISPLAY_EDIT__COLUMN__DISPLAY_JAVA".equals(sm
						.getState_Machine())) {
					sm.run(event_execute.changeToOCL);
					displayQuerySelected = change(displayQuerySelected,
							Query2tablePackage.Literals.OCL_QUERY);
				} else {
					sm.run(event_execute.selectDisplayQuerys);
					sm.run(event_execute.radioButtonDisplayOCL);
				}
			}
			queryTableViewer.setSelection(new StructuredSelection(
					(Query) displayQuerySelected), true);
			queryTableViewer.refresh();
			queryTableViewer.getTable().setSelection(index);
		}
	};

	private class ColumnLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public Image getColumnImage(Object arg0, int arg1) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {

			if (element instanceof Column) {
				Column column = (Column) element;
				switch (columnIndex) {
				case 0:

					String textColumn1 = "Column " + column.getIndex();

					highColumnIndex = column.getIndex();

					if (column.getIndex() == 0) {
						textColumn1 += " (default)";
					}
					return textColumn1;

				case 1:
					return column.getTitle();
				case 2:
					if (element instanceof Column) {
						Column c = (Column) element;
						if (c.getExecutes() instanceof JavaQuery) {
							return "Java";
						} else if (c.getExecutes() instanceof OCLQuery) {
							return "OCL";
						}
					}
					return "Select an execute query";
				}
				return null;
			}
			return null;

		}

	}

	private class ColumnCellModifier implements ICellModifier {

		private int getIndexTable(String property) {
			if ("Column index".equals(property)) {
				return 0;
			} else if ("Column name".equals(property)) {
				return 1;
			} else if ("Information".equals(property)) {
				return 2;
			}
			return -1;
		}

		public boolean canModify(Object element, String property) {
			int indexTable = getIndexTable(property);
			return (indexTable == 1 || indexTable == 0);
		}

		public Object getValue(Object element, String property) {
			int indexTable = getIndexTable(property);
			if (element instanceof Column) {
				Column column = (Column) element;
				switch (indexTable) {
				case 0:
					return Integer.toString(column.getIndex());
				case 1:
					return column.getTitle();
				}
			}
			return null;
		}

		public void modify(Object element, String property, Object value) {
			int indexTable = getIndexTable(property);
			if (element instanceof TableItem) {
				TableItem tableItem = (TableItem) element;
				if (tableItem.getData() instanceof Column) {
					Column column = (Column) tableItem.getData();
					switch (indexTable) {
					case 0:
						try {
							setErrorMessage(null);
							column.setIndex(Integer.parseInt((String) value));
						} catch (NumberFormatException e) {
							setErrorMessage("incorrect value : "
									+ e.getMessage());
						}
						break;
					case 1:
						column.setTitle(((String) value));
						break;
					}
				}
			}
			columnsTableViewer.refresh();
		}
	}

	private class QueryLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public Image getColumnImage(Object arg0, int arg1) {
			return null;
		}

		public String getColumnText(Object element, int column) {

			if (element instanceof JavaQuery) {
				switch (column) {
				case 0:
					return "JAVA";
				case 1:
					return ((JavaQuery) element).getExtensionId();
				}
			} else {
				switch (column) {
				case 0:
					return "OCL";
				case 1:
					return ((OCLQuery) element).getOclQuery();
				}
			}
			return null;
		}
	}

	private ISelectionChangedListener columnsTableSelectionChangeListener = new ISelectionChangedListener() {
		private void fillContextCombo() {
			contextComboViewer.setInput(q2t.getModelExport().getColumns());
			contextComboViewer.getCombo().add(new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory()).getText(getController().getElementSelected()));
			contextComboViewer.remove(columnSelected);
		}

		public void selectionChanged(SelectionChangedEvent event) {

			if (event.getSelection() instanceof StructuredSelection) {
				StructuredSelection structuredSelection = (StructuredSelection) event
						.getSelection();
				if (structuredSelection.getFirstElement() instanceof Column) {
					columnSelected = (Column) structuredSelection
							.getFirstElement();
					queryTableViewer.setInput(columnSelected);
					if (columnSelected.getDisplays() != null) {
						queryTableViewer.refresh();
					}
					if (columnSelected.getExecutes() != null) {
						Query execute = columnSelected.getExecutes();
						if (execute instanceof JavaQuery) {
							JavaQuery javaQuery = (JavaQuery) execute;
							unselectDisplay();
							if ("COLUMN__COLUMN_UNSELECTED".equals(sm
									.getState_Machine()))
								sm.run(event_execute.selectJava);
							if ("COLUMN__EXECUTE_OCL".equals(sm
									.getState_Machine()))
								sm.run(event_execute.changeToJava);
							if (javaQuery.getExtensionId() != null
									&& javaQuery.getExtensionId().length() > 1) {
								executeQueryJavaCombo.setText(javaQuery
										.getExtensionId());
								upDatePattern();
							}
						} else if (execute instanceof OCLQuery) {
							OCLQuery oclQuery = (OCLQuery) execute;
							unselectDisplay();
							if ("COLUMN__COLUMN_UNSELECTED".equals(sm
									.getState_Machine()))
								sm.run(event_execute.selectOCL);
							if ("COLUMN__EXECUTE_JAVA".equals(sm
									.getState_Machine()))
								sm.run(event_execute.changeToOCL);
							if (oclQuery.getOclQuery() != null
									&& oclQuery.getOclQuery().length() > 1) {
								executeQueryOCLText.setText(oclQuery
										.getOclQuery());
								upDatePattern();
							} else {
								executeQueryOCLText.setText("");
							}
						}
						fillContextCombo();
						if (execute.getExecutionContext() instanceof ColumnContext) {
							ColumnContext context = (ColumnContext) execute
									.getExecutionContext();
							if (context != null
									&& context.getDependsOn() != null) {
								contextComboViewer
										.setSelection(new StructuredSelection(
												context.getDependsOn()));
							} else {
								contextComboViewer
										.setSelection(new StructuredSelection(
												EMPTY));
							}
						} else if(execute.getExecutionContext() instanceof EMFContext) {
							EMFContext context = (EMFContext) execute
									.getExecutionContext();
							if(context.getModelElement()!=null){
								contextComboViewer.getCombo().setText(new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory()).getText(getController().getElementSelected()));
							}
						}
					} else {
						sm.run(event_execute.tableSelected);
						executeQueryJavaCombo.deselectAll();
						executeQueryOCLText.setText("");
						fillContextCombo();
						upDatePattern();
					}
				}
			}
		}
	};

	@Override
	public boolean canFlipToNextPage() {
		return super.canFlipToNextPage();
	}

	/**
	 * Constructor
	 * 
	 * @param toolkit
	 * @param controller
	 */
	public ConfigurationWizardPage(Query2TableToolkit toolkit,
			Query2TableController controller) {
		super("Query2Table Wizard",toolkit, controller);
		try {
			imageAdd = new Image(Display.getDefault(), Activator.getDefault()
					.getBundle().getResource("icons/add.gif").openStream());
			imageRemove = new Image(Display.getDefault(), Activator
					.getDefault().getBundle().getResource("icons/remove.gif")
					.openStream());
			imageSave = new Image(Display.getDefault(), Activator.getDefault()
					.getBundle().getResource("icons/save.gif").openStream());
			imageUp = new Image(Display.getDefault(), Activator.getDefault()
					.getBundle().getResource("icons/up.gif").openStream());
			imageDown = new Image(Display.getDefault(), Activator.getDefault()
					.getBundle().getResource("icons/down.gif").openStream());
			imageTable = new Image(Display.getDefault(), Activator.getDefault()
					.getBundle().getResource("icons/table.gif").openStream());

		} catch (IOException e) {
		}
		extensionsID = QueryUtils.getJavaQueryIDs().toArray(
				new String[QueryUtils.getJavaQueryIDs().size()]);
		q2t = getController().getQ2T();
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		this.setDescription("config");

		Composite columnsTableSection = createSection(topComposite, "Columns",
				2);
		createTableColumns(columnsTableSection);
		createButtonsColumns(columnsTableSection);

		Composite executeQuerySection = createSection(topComposite,
				"Execute query", 2);
		createExecuteQueryComponent(executeQuerySection);

		Composite displayQuerySection = createSection(topComposite,
				"Display queries", 2);
		createDisplayQuerySection(displayQuerySection);

		Composite patternQuerySection = createSection(topComposite, "Pattern",
				2);
		createPatternQuerySection(patternQuerySection);

		sm = new SM(this);
		initPage();

	}

	public void createTableColumns(Composite section) {
		table = new Table(section, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		columnsTableViewer = new TableViewer(table);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4);
		table.setLayoutData(data);
		String[] titles = { "Column index", "Column name", "Information" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE, i);
			column.setText(titles[i]);
			column.setWidth(200);
			column.setResizable(true);
		}

		CellEditor[] editors = new CellEditor[2];
		TextCellEditor textEditor = new TextCellEditor(table);
		editors[0] = textEditor;
		textEditor = new TextCellEditor(table);
		editors[1] = textEditor;

		// Assign the cell editors to the viewer
		columnsTableViewer.setColumnProperties(titles);
		columnsTableViewer.setCellEditors(editors);
		columnsTableViewer.setCellModifier(new ColumnCellModifier());
		columnsTableViewer.setLabelProvider(new ColumnLabelProvider());
		columnsTableViewer.setContentProvider(new IStructuredContentProvider() {
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof ModelExport) {
					List<Column> result = new LinkedList<Column>();
					result.addAll(((ModelExport) inputElement).getColumns());
					return result.toArray();
				}
				return null;
			}

			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}
		});
		columnsTableViewer
				.addSelectionChangedListener(columnsTableSelectionChangeListener);
		columnsTableViewer.setInput(getController().getQ2T().getModelExport());
	}

	private abstract class EventSelectionListener implements SelectionListener {
		public abstract SM.event_execute getEvent();

		public void widgetSelected(SelectionEvent e) {
			doWidgetSelected(e);
			if (e.getSource() instanceof Button) {
				sm.run(getEvent());
			}
		}

		public abstract void doWidgetSelected(SelectionEvent e);

		public void widgetDefaultSelected(SelectionEvent e) {

		}

	}

	/**
	 * Creates the buttons columns.
	 * 
	 * @param section
	 *            the section
	 */
	private void createButtonsColumns(Composite section) {
		buttonTable = toolkit.createButton(section, "", SWT.PUSH);
		buttonTable.setLayoutData(new GridData(SWT.CENTER, SWT.BOTTOM, false,
				false));
		buttonTable.setImage(imageTable);
		buttonTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = getShell();
				Dialog d = new Dialog(shell) {
					
					@Override
					protected void configureShell(Shell newShell) {
						super.configureShell(newShell);
						newShell.setText("Preview");
					}

					protected Control createDialogArea(Composite parent) {
						setErrorMessage(null);
						ModelExport modelExport = q2t.getModelExport();
						try {
							TableTree tree = new Export2TableAction()
									.generateTreeFromModel(modelExport);
							TableViewer viewer = new TableViewer(parent,
									SWT.V_SCROLL);
							Table t = viewer.getTable();
							t.setHeaderVisible(true);
							t.setLinesVisible(true);
							for (Column c : modelExport.getColumns()) {
								TableColumn col = new TableColumn(t, SWT.NONE,
										c.getIndex());
								col.setText(c.getTitle());
								col.setWidth(200);
								col.setResizable(true);
							}
							t.setLayoutData(new GridData(GridData.FILL,
									GridData.FILL, true, true));

							viewer.setContentProvider(new IStructuredContentProvider() {
								public void inputChanged(Viewer viewer,
										Object oldInput, Object newInput) {
								}

								public void dispose() {
								}

								public Object[] getElements(Object inputElement) {
									if (inputElement instanceof TableTree) {
										TableTree tree = (TableTree) inputElement;
										return TreeUtils.getTreeElements(tree)
												.toArray();
									}
									return Collections.EMPTY_LIST.toArray();
								}
							});
							viewer.setLabelProvider(new ITableLabelProvider() {

								public void removeListener(
										ILabelProviderListener listener) {
								}

								public boolean isLabelProperty(Object element,
										String property) {
									return true;
								}

								public void dispose() {
								}

								public void addListener(
										ILabelProviderListener listener) {
								}

								public String getColumnText(Object element,
										int columnIndex) {
									if (element instanceof TableTreeNode) {
										TableTreeNode node = (TableTreeNode) element;
										int index = TreeUtils.getIndex(node);
										if (columnIndex == index) {
											return node.getDisplayValue();
										} else if (columnIndex < index) {
											node = TreeUtils.getParent(node,
													index - columnIndex);
											return node.getDisplayValue();
										} else {
											return "";
										}
									}
									return "";
								}

								public Image getColumnImage(Object element,
										int columnIndex) {
									return null;
								}
							});
							viewer.setInput(tree);
						} 
						catch (NullPointerException npe) {
							setErrorMessage("internal occurs in Query2Table");
							throw new RuntimeException();
						}
						catch (Exception e) {
							setErrorMessage(e.getMessage());
							throw new RuntimeException();
						}
						return parent;
					}

				};
				try {
					d.open();

				} catch (RuntimeException ex) {
				}
			}
		});

		buttonSave = toolkit.createButton(section, "", SWT.PUSH);
		buttonSave.setLayoutData(new GridData(SWT.CENTER, SWT.BOTTOM, false,
				false));
		buttonSave.setImage(imageSave);
		buttonSave.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {

				try {
					URI uri = q2t.resourcesSave();
					setMessage("Saved at " + uri.toString(),
							DialogPage.INFORMATION);
				} catch (IOException io) {
					setErrorMessage("IO error occurs " + io.getMessage());
				} catch (Exception e1) {
					setErrorMessage(e1.getMessage());
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		buttonAddColumn = toolkit.createButton(section, "", SWT.PUSH);
		buttonAddColumn.addSelectionListener(new EventSelectionListener() {

			@Override
			public event_execute getEvent() {
				return SM.event_execute.buttonPlus;
			}

			@Override
			public void doWidgetSelected(SelectionEvent e) {
				Column column = Query2tableFactory.eINSTANCE.createColumn();
				if (table.getItemCount() == 0) {
					column.setIndex(highColumnIndex);
				} else {
					column.setIndex(highColumnIndex + 1);
				}
				column.setTitle("Title to modify");
				getController().getQ2T().getModelExport().getColumns()
						.add(column);
				columnsTableViewer.refresh();
				unselectDisplay();
			}
		});
		buttonAddColumn.setLayoutData(new GridData(SWT.CENTER, SWT.BOTTOM,
				false, false));
		buttonAddColumn.setImage(imageAdd);

		// Create remove button
		buttonRemoveColumn = toolkit.createButton(section, "", SWT.PUSH);
		buttonRemoveColumn.addSelectionListener(new EventSelectionListener() {

			@Override
			public event_execute getEvent() {
				return event_execute.buttonMoin;
			}

			@Override
			public void doWidgetSelected(SelectionEvent e) {
				unselectDisplay();
				ISelection selection = columnsTableViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection select = (IStructuredSelection) selection;
					for (Iterator<?> i = select.iterator(); i.hasNext();) {
						Object o = i.next();
						if (o instanceof Column) {
							Column column = (Column) o;
							getController().getQ2T().getModelExport()
									.getColumns().remove(column);
						}
					}
				}
				columnsTableViewer.refresh();
			}
		});
		buttonRemoveColumn.setLayoutData(new GridData(SWT.CENTER, SWT.TOP,
				false, false));
		buttonRemoveColumn.setImage(imageRemove);

	}

	private void createExecuteQueryComponent(Composite executeQuerySection) {
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		radioButtonExecuteQueryJava = toolkit.createButton(executeQuerySection,
				buttonExecuteQueryJavaText, SWT.RADIO);
		radioButtonExecuteQueryJava
				.addSelectionListener(executeQueryRadioButtonSelectionAdapter);
		radioButtonExecuteQueryJava.setSelection(false);
		executeQueryJavaCombo = toolkit.createCombo(executeQuerySection,
				SWT.READ_ONLY | SWT.DROP_DOWN);
		executeQueryJavaCombo.setLayoutData(data);
		executeQueryJavaCombo.setItems(extensionsID);
		executeQueryJavaCombo.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent event) {
				Combo t = (Combo) event.getSource();
				JavaQuery javaQuery = null;
				if (radioButtonExecuteQueryJava.getSelection()) {
					IStructuredSelection structuredSelection = (IStructuredSelection) columnsTableViewer
							.getSelection();
					if (structuredSelection != null
							&& structuredSelection.getFirstElement() instanceof Column) {
						Column column = (Column) structuredSelection
								.getFirstElement();
						if (column.getExecutes() instanceof JavaQuery) {
							javaQuery = (JavaQuery) column.getExecutes();
						} else if (column.getExecutes() == null) {
							javaQuery = Query2tableFactory.eINSTANCE
									.createJavaQuery();
							columnSelected.setExecutes(javaQuery);
						} else if (column.getExecutes() instanceof OCLQuery) {
							Context context = columnSelected.getExecutes()
									.getExecutionContext();
							javaQuery = Query2tableFactory.eINSTANCE
									.createJavaQuery();
							columnSelected.setExecutes(javaQuery);
							columnSelected.getExecutes().setExecutionContext(
									context);
						}

						if (javaQuery != null) {
							javaQuery.setExtensionId(t.getText());
						}
						columnsTableViewer.refresh();
					}
				}

			}

		});
		radioButtonExecuteQueryOCL = toolkit.createButton(executeQuerySection,
				buttonExecuteQueryOCLText, SWT.RADIO);
		radioButtonExecuteQueryOCL
				.addSelectionListener(executeQueryRadioButtonSelectionAdapter);
		radioButtonExecuteQueryOCL.setSelection(false);
		executeQueryOCLText = toolkit.createText(executeQuerySection, "",
				SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		executeQueryOCLText.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, true));
		executeQueryOCLText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text t = (Text) event.getSource();
				OCLQuery executeQuery = null;
				if (radioButtonExecuteQueryOCL.getSelection()) {
					StructuredSelection structuredSelection = (StructuredSelection) columnsTableViewer
							.getSelection();
					if (structuredSelection != null
							&& structuredSelection.getFirstElement() instanceof Column) {
						Column column = (Column) structuredSelection
								.getFirstElement();
						if (column.getExecutes() instanceof OCLQuery) {
							executeQuery = (OCLQuery) column.getExecutes();
						} else if (column.getExecutes() == null) {
							executeQuery = Query2tableFactory.eINSTANCE
									.createOCLQuery();
							column.setExecutes(executeQuery);
						} else if (column.getExecutes() instanceof JavaQuery) {
							Context context = columnSelected.getExecutes()
									.getExecutionContext();
							executeQuery = Query2tableFactory.eINSTANCE
									.createOCLQuery();
							columnSelected.setExecutes(executeQuery);
							columnSelected.getExecutes().setExecutionContext(
									context);
						}
						if (executeQuery != null) {
							executeQuery.setOclQuery(t.getText());
						}
					}

				}
			}
		});

		toolkit.createLabel(executeQuerySection, "Context:");
		contextCombo = toolkit.createCombo(executeQuerySection, SWT.READ_ONLY
				| SWT.DROP_DOWN);
		contextComboViewer = new ComboViewer(contextCombo);
		contextCombo.setLayoutData(data);
		contextComboViewer.setContentProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof List<?>) {
					List<Object> list = new ArrayList<Object>(
							(List<?>) inputElement);
					list.add(0, EMPTY);
					return list.toArray();
				} else {
					return Collections.singleton(inputElement).toArray();
				}
			}
		});
		contextComboViewer.setLabelProvider(new ILabelProvider() {

			public void removeListener(ILabelProviderListener listener) {
			}

			public boolean isLabelProperty(Object element, String property) {
				return true;
			}

			public void dispose() {
			}

			public void addListener(ILabelProviderListener listener) {
			}

			public String getText(Object element) {
				if (element instanceof Column) {
					Column col = (Column) element;
					return "Column " + col.getIndex();
				} else if (element instanceof EObject) {
					EObject ebj = (EObject) element;
					ReflectiveItemProvider reflectiveItemProvider = new ReflectiveItemProvider(
							new ReflectiveItemProviderAdapterFactory());
					return reflectiveItemProvider.getText(ebj);
				}
				return "";
			}

			public Image getImage(Object element) {
				return null;
			}
		});
		contextCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Column columnContextSelected = (Column) ((StructuredSelection) columnsTableViewer
						.getSelection()).getFirstElement();
				
				if (columnContextSelected != null) {
					ColumnContext context = Query2tableFactory.eINSTANCE
							.createColumnContext();
					EMFContext contextEMF = Query2tableFactory.eINSTANCE
							.createEMFContext();
					StructuredSelection selection = (StructuredSelection) contextComboViewer
							.getSelection();
					Object firstElement = selection.getFirstElement();
					
					if (firstElement instanceof Column) {
						context.setDependsOn((Column) firstElement);
						if (columnSelected.getExecutes() != null) {
							columnSelected.getExecutes().setExecutionContext(
									context);
						}
							
					} else if (contextCombo.getText().equals(new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory()).getText(getController().getElementSelected()))){
						contextEMF.setModelElement(getController().getElementSelected());
						if (columnSelected.getExecutes() != null) {
						columnSelected.getExecutes().setExecutionContext(contextEMF);
						}
						
					} else if (firstElement == EMPTY) {
						context.setDependsOn(null);	
					}
					
				} 
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	private void createPatternQuerySection(Composite patternQuerySection) {
		toolkit.createLabel(patternQuerySection, "Pattern: ");
		patternText = toolkit.createText(patternQuerySection, "");
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		patternText.setLayoutData(data);
		patternText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				if (radioButtonExecuteQueryJava.getSelection()
						|| radioButtonExecuteQueryOCL.getSelection()) {
					if (patternText.getText() != null) {
						columnSelected.setPattern(patternText.getText());
					}
				}
			}
		});
	}

	private void createDisplayQuerySection(Composite displayQuerySection) {

		displayQuerytable = toolkit
				.createTable(displayQuerySection, SWT.BORDER);
		queryTableViewer = new TableViewer(displayQuerytable);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4);
		displayQuerytable.setLayoutData(data);
		displayQuerytable.setLinesVisible(true);
		displayQuerytable.setHeaderVisible(true);
		displayQuerytable.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				;
			}
		});

		String[] titles = { "Type", "Information", "Index" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(displayQuerytable, SWT.NONE, i);
			column.setText(titles[i]);
			column.setWidth(200);
			column.setResizable(true);
		}

		queryTableViewer.setColumnProperties(titles);
		queryTableViewer.setLabelProvider(new QueryLabelProvider());
		queryTableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					public void selectionChanged(SelectionChangedEvent event) {

						if (event.getSelection() instanceof StructuredSelection) {
							StructuredSelection structuredSelection = (StructuredSelection) event
									.getSelection();
							if (structuredSelection.getFirstElement() instanceof JavaQuery) {
								displayQuerySelected = (Query) structuredSelection
										.getFirstElement();
								if ("COLUMN__EXECUTE_JAVA".equals(sm
										.getState_Machine())
										|| "COLUMN__EXECUTE_OCL".equals(sm
												.getState_Machine())) {
									sm.state_DISPLAY_EDIT__COLUMN__DISPLAY_JAVA();
								} else {
									if ("DISPLAY_EDIT__COLUMN__DISPLAY_OCL"
											.equals(sm.getState_Machine())) {
										sm.run(event_execute.changeToJava);
									} else {
										sm.run(event_execute.selectDisplayQuerys);
										sm.run(event_execute.tableSelected);
										sm.run(event_execute.selectJava);
									}
								}
								if (((JavaQuery) structuredSelection
										.getFirstElement()).getExtensionId() != null) {
									displayQueryJavaCombo
											.setText(((JavaQuery) structuredSelection
													.getFirstElement())
													.getExtensionId());
								}
							} else if (structuredSelection.getFirstElement() instanceof OCLQuery) {
								displayQuerySelected = (Query) structuredSelection
										.getFirstElement();
								if ("COLUMN__EXECUTE_JAVA".equals(sm
										.getState_Machine())
										|| "COLUMN__EXECUTE_OCL".equals(sm
												.getState_Machine())) {
									sm.state_DISPLAY_EDIT__COLUMN__DISPLAY_OCL();
								} else {
									if ("DISPLAY_EDIT__COLUMN__DISPLAY_JAVA"
											.equals(sm.getState_Machine())) {
										sm.run(event_execute.changeToOCL);
									} else {
										sm.run(event_execute.selectDisplayQuerys);
										sm.run(event_execute.tableSelected);
										sm.run(event_execute.selectOCL);
									}
								}
								if (((OCLQuery) structuredSelection
										.getFirstElement()).getOclQuery() != null) {
									displayQueryOCLText
											.setText(((OCLQuery) structuredSelection
													.getFirstElement())
													.getOclQuery());
								}
							}
							queryDeleteButton.setEnabled(true);
						}
						queryTableViewer.refresh();
					}
				});
		queryTableViewer.setContentProvider(new IStructuredContentProvider() {
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof Column) {
					List<Query> result = new LinkedList<Query>();
					Column element = (Column) inputElement;
					// for all stereotypes
					result.addAll(element.getDisplays());
					return result.toArray();
				}
				return null;
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}
		});
		queryTableViewer.setInput(columnSelected);

		createDisplayQueriesButtons(displayQuerySection, displayQuerytable);

		createDisplayQueriesParameters(displayQuerySection);
	}

	protected Query change(Query querySelected, EClass eclass) {
		EObject container = querySelected.eContainer();
		if (container instanceof Column) {
			Column col = (Column) container;
			int index = col.getDisplays().indexOf(querySelected);
			col.getDisplays().remove(index);
			Query q = (Query) Query2tableFactory.eINSTANCE.create(eclass);
			col.getDisplays().add(index, q);
			return q;
		}
		return null;
	}

	private void createDisplayQueriesButtons(Composite displayQuerySection,
			final Table dqt) {
		queryAddButton = toolkit
				.createButton(displayQuerySection, "", SWT.PUSH);
		queryAddButton.setEnabled(false);
		queryAddButton.setImage(imageAdd);
		queryAddButton.addSelectionListener(new EventSelectionListener() {
			public void doWidgetSelected(SelectionEvent arg0) {
				if ("DISPLAY_EDIT__COLUMN__DISPLAY_JAVA".equals(sm
						.getState_Machine())) {
					JavaQuery javaQuery = Query2tableFactory.eINSTANCE
							.createJavaQuery();
					sm.run(event_execute.selectDisplayQuerys);
					sm.state_DISPLAY_EDIT__COLUMN__DISPLAY_JAVA();
					javaQuery.setExtensionId(displayQueryJavaCombo.getText());
					columnSelected.getDisplays().add(javaQuery);
					queryTableViewer.refresh();
					moveEnd();
				} else {
					OCLQuery OCLQuery = Query2tableFactory.eINSTANCE
							.createOCLQuery();
					sm.run(event_execute.selectDisplayQuerys);
					sm.state_DISPLAY_EDIT__COLUMN__DISPLAY_OCL();
					OCLQuery.setOclQuery(displayQueryOCLText.getText());
					columnSelected.getDisplays().add(OCLQuery);
					queryTableViewer.refresh();
					moveEnd();
				}
			}

			public event_execute getEvent() {
				return event_execute.addDisplay;
			}
		});

		queryDeleteButton = toolkit.createButton(displayQuerySection, "",
				SWT.PUSH);
		queryDeleteButton.setEnabled(false);
		queryDeleteButton.setImage(imageRemove);
		queryDeleteButton.addSelectionListener(new EventSelectionListener() {
			public void doWidgetSelected(SelectionEvent arg0) {

				ISelection selection = queryTableViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection select = (IStructuredSelection) selection;
					for (Iterator<?> i = select.iterator(); i.hasNext();) {
						Object o = i.next();
						if (o instanceof Column) {
							Column column = (Column) o;
							getController().getQ2T().getModelExport()
									.getColumns().remove(column);
						}
					}
				}

				// ISelection selection = queryTableViewer.getSelection();
				Query query = null;
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection struc = (IStructuredSelection) selection;
					query = (Query) struc.getFirstElement();
				}
				if (query != null) {
					EList<Query> displays = columnSelected.getDisplays();
					displays.remove(displays.indexOf(query));
				}

				queryTableViewer.refresh();
			}

			public event_execute getEvent() {
				return event_execute.deleteDisplayQuerys;
			}
		});

		queryUpButton = toolkit.createButton(displayQuerySection, "", SWT.PUSH);
		queryUpButton.setEnabled(false);
		queryUpButton.setImage(imageUp);
		queryUpButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				ISelection selection = queryTableViewer.getSelection();
				Query query = null;
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection struc = (IStructuredSelection) selection;
					query = (Query) struc.getFirstElement();
				}
				if (query != null) {
					EList<Query> displays = columnSelected.getDisplays();
					displays.move(displays.indexOf(query) - 1,
							displays.indexOf(query));
					queryTableViewer.refresh();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		queryDownButton = toolkit.createButton(displayQuerySection, "",
				SWT.PUSH);
		queryDownButton.setEnabled(false);
		queryDownButton.setImage(imageDown);
		queryDownButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				ISelection selection = queryTableViewer.getSelection();
				Query query = null;
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection struc = (IStructuredSelection) selection;
					query = (Query) struc.getFirstElement();
				}
				if (query != null) {
					EList<Query> displays = columnSelected.getDisplays();
					displays.move(displays.indexOf(query) + 1,
							displays.indexOf(query));
					queryTableViewer.refresh();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	public void moveEnd() {
		ISelection selection = queryTableViewer.getSelection();
		Query query = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection struc = (IStructuredSelection) selection;
			query = (Query) struc.getFirstElement();
		}
		if (query != null) {
			EList<Query> displays = columnSelected.getDisplays();
			displays.move(displays.size() - 1, displays.indexOf(query));
			queryTableViewer.refresh();
		} else {
			queryTableViewer.refresh();
		}
	}

	private void createDisplayQueriesParameters(Composite displayQuerySection) {
		GridData data = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 2);
		radioButtonDisplayQueryJava = toolkit.createButton(displayQuerySection,
				buttonDisplayQueryJavaText, SWT.RADIO);
		radioButtonDisplayQueryJava
				.addSelectionListener(displayQueryRadioButtonSelectionAdapter);
		radioButtonDisplayQueryJava.setSelection(false);
		radioButtonDisplayQueryJava.setLayoutData(data);
		displayQueryJavaCombo = toolkit.createCombo(displayQuerySection,
				SWT.READ_ONLY | SWT.DROP_DOWN);
		displayQueryJavaCombo.setLayoutData(data);
		displayQueryJavaCombo.setItems(extensionsID);
		displayQueryJavaCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				String t = displayQueryJavaCombo.getText();
				if (t.length() != 0) {
					queryAddButton.setEnabled(true);
				} else {
					queryAddButton.setEnabled(false);
				}
				if (event.getSource() != null
						&& event.getSource() instanceof Combo) {
					Combo combo = ((Combo) event.getSource());
					if (combo.getText() != null) {
						if (displayQuerySelected instanceof JavaQuery) {
							JavaQuery javaQuery = (JavaQuery) displayQuerySelected;
							javaQuery.setExtensionId(combo.getText());
							queryTableViewer.refresh();
						}
					}
				}
			}
		});
		radioButtonDisplayQueryOCL = toolkit.createButton(displayQuerySection,
				buttonDisplayQueryOCLText, SWT.RADIO);
		radioButtonDisplayQueryOCL
				.addSelectionListener(displayQueryRadioButtonSelectionAdapter);
		radioButtonDisplayQueryOCL.setSelection(false);
		radioButtonDisplayQueryOCL.setLayoutData(data);
		displayQueryOCLText = toolkit.createText(displayQuerySection, "",
				SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		displayQueryOCLText.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, true));
		displayQueryOCLText.setLayoutData(data);
		displayQueryOCLText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				String t = displayQueryOCLText.getText();
				if (t.length() != 0) {
					queryAddButton.setEnabled(true);
				} else {
					queryAddButton.setEnabled(false);
				}
				if (event.getSource() != null
						&& event.getSource() instanceof Text) {
					Text text = ((Text) event.getSource());
					if (text.getText() != null) {
						if (displayQuerySelected instanceof OCLQuery) {
							OCLQuery oclQuery = (OCLQuery) displayQuerySelected;
							oclQuery.setOclQuery(text.getText());
							queryTableViewer.refresh();
						}

					}
				}
			}
		});
	}

	public void initPage() {
		switch (getController().getRadioConfig()) {
		case REGISTERED:
			setMessage("In this page you can edit your querys for the configuration. \nRemember you are configurating a registred export.");
			sm.state_COLUMN__COLUMN_UNSELECTED();
			if (getController().getRegisteredExport() != null) {
				Registered registeredSelected = null;
				for (Registered r : RegisteredQuery2TableManager
						.getRegisteredModelExports()) {
					if (r.getName().equals(
							getController().getRegisteredExport())) {
						registeredSelected = r;
					}
				}
				registeredSelected.getModelExportURI();
			}
			break;
		case NEW:
			setMessage("In this page you can edit your querys for your configuration. \nRemember you are creating a new configuration. Save before leaving.");
			sm.state_COLUMN__COLUMN_UNSELECTED();
			break;
		case BROWSE:
			setMessage("In this page you can edit youy querys for the configuration. \nRemember you are configurating an already existing export.");
			sm.state_COLUMN__COLUMN_UNSELECTED();

		}
	}

	public SM getSM() {
		return sm;
	}

	public void unselectDisplay() {
		if ("DISPLAY_EDIT__COLUMN__DISPLAY_EDIT".equals(sm.getState_Machine())) {
			sm.run(event_execute.returnColumns);
		}
		if ("DISPLAY_EDIT__COLUMN__DISPLAY_JAVA".equals(sm.getState_Machine())) {
			sm.run(event_execute.returnColumns);
		}
		if ("DISPLAY_EDIT__COLUMN__DISPLAY_OCL".equals(sm.getState_Machine())) {
			sm.run(event_execute.returnColumns);
		}
	}

	public void upDatePattern() {
		if (columnSelected.getPattern() != null) {
			patternText.setText(columnSelected.getPattern());
		}
		  else{ patternText.setText(""); }
		 
	}

}
