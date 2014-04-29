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
package org.topcased.model2doc.query2table.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.ColumnContext;
import org.topcased.model2doc.query2table.DependencyManagement;
import org.topcased.model2doc.query2table.EMFContext;
import org.topcased.model2doc.query2table.ExportExtension;
import org.topcased.model2doc.query2table.ModelExport;
import org.topcased.model2doc.query2table.Query2tablePackage;
import org.topcased.model2doc.query2table.exception.InvalidColumnDefinitionException;
import org.topcased.model2doc.query2table.util.ColumnTreeNode;
import org.topcased.model2doc.query2table.util.TreeNode;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Model Export</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ModelExportImpl#getOutputPath <em>Output Path</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ModelExportImpl#getExportExtension <em>Export Extension</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ModelExportImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ModelExportImpl#getEmfContext <em>Emf Context</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ModelExportImpl#getDependencyManagement <em>Dependency Management</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ModelExportImpl#isCellSpan <em>Cell Span</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelExportImpl extends EObjectImpl implements ModelExport {
	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The default value of the '{@link #getOutputPath() <em>Output Path</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getOutputPath()
     * @generated
     * @ordered
     */
	protected static final String OUTPUT_PATH_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getOutputPath() <em>Output Path</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getOutputPath()
     * @generated
     * @ordered
     */
	protected String outputPath = OUTPUT_PATH_EDEFAULT;

	/**
     * The default value of the '{@link #getExportExtension() <em>Export Extension</em>}' attribute.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @see #getExportExtension()
     * @generated
     * @ordered
     */
	protected static final ExportExtension EXPORT_EXTENSION_EDEFAULT = ExportExtension.XLS;

	/**
     * The cached value of the '{@link #getExportExtension() <em>Export Extension</em>}' attribute.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @see #getExportExtension()
     * @generated
     * @ordered
     */
	protected ExportExtension exportExtension = EXPORT_EXTENSION_EDEFAULT;

	/**
     * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getColumns()
     * @generated
     * @ordered
     */
	protected EList<Column> columns;

	/**
     * The cached value of the '{@link #getEmfContext() <em>Emf Context</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getEmfContext()
     * @generated
     * @ordered
     */
	protected EMFContext emfContext;

	/**
     * The default value of the '{@link #getDependencyManagement() <em>Dependency Management</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDependencyManagement()
     * @generated
     * @ordered
     */
	protected static final DependencyManagement DEPENDENCY_MANAGEMENT_EDEFAULT = DependencyManagement.SUBTABLE;

	/**
     * The cached value of the '{@link #getDependencyManagement() <em>Dependency Management</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDependencyManagement()
     * @generated
     * @ordered
     */
	protected DependencyManagement dependencyManagement = DEPENDENCY_MANAGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isCellSpan() <em>Cell Span</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCellSpan()
	 * @generated not
	 * @ordered
	 */
	protected static final boolean CELL_SPAN_EDEFAULT = true;

	/**
     * The cached value of the '{@link #isCellSpan() <em>Cell Span</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isCellSpan()
     * @generated
     * @ordered
     */
	protected boolean cellSpan = CELL_SPAN_EDEFAULT;

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected ModelExportImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Query2tablePackage.Literals.MODEL_EXPORT;
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public String getOutputPath() {
        return outputPath;
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public void setOutputPath(String newOutputPath) {
        String oldOutputPath = outputPath;
        outputPath = newOutputPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.MODEL_EXPORT__OUTPUT_PATH, oldOutputPath, outputPath));
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public ExportExtension getExportExtension() {
        return exportExtension;
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public void setExportExtension(ExportExtension newExportExtension) {
        ExportExtension oldExportExtension = exportExtension;
        exportExtension = newExportExtension == null ? EXPORT_EXTENSION_EDEFAULT : newExportExtension;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.MODEL_EXPORT__EXPORT_EXTENSION, oldExportExtension, exportExtension));
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public EList<Column> getColumns() {
        if (columns == null)
        {
            columns = new EObjectContainmentEList<Column>(Column.class, this, Query2tablePackage.MODEL_EXPORT__COLUMNS);
        }
        return columns;
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated NOT
     */
	public EMFContext getEmfContext() {
        for (Iterator<EObject> i = eAllContents() ; i.hasNext() ;)
        {
        	EObject next = i.next();
        	if (next instanceof EMFContext) {
				EMFContext context = (EMFContext) next;
				return context ; 
			}
        }
        return null ;
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public EMFContext basicGetEmfContext() {
        return emfContext;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DependencyManagement getDependencyManagement() {
        return dependencyManagement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDependencyManagement(DependencyManagement newDependencyManagement) {
        DependencyManagement oldDependencyManagement = dependencyManagement;
        dependencyManagement = newDependencyManagement == null ? DEPENDENCY_MANAGEMENT_EDEFAULT : newDependencyManagement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.MODEL_EXPORT__DEPENDENCY_MANAGEMENT, oldDependencyManagement, dependencyManagement));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isCellSpan() {
        return cellSpan;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCellSpan(boolean newCellSpan) {
        boolean oldCellSpan = cellSpan;
        cellSpan = newCellSpan;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.MODEL_EXPORT__CELL_SPAN, oldCellSpan, cellSpan));
    }

	/**
	 * <!-- begin-user-doc --> Returns the first column node inside the tree of
	 * columns (organized by dependencies) <!-- end-user-doc -->
	 * 
	 * @throws InvalidColumnDefinitionException
	 * 
	 * @generated NOT
	 */
	public ColumnTreeNode getColumnDependancyTree() {

		TreeNode rootNode = new TreeNode();
		ColumnTreeNode firstColumnNode = null;

		// Check that there is only one initial column
		int count = 0;
		for (Column c : columns) {
			if (c.getExecutes().getExecutionContext() != null
					&& c.getExecutes().getExecutionContext() instanceof EMFContext) {
				count++;
				firstColumnNode = createNode(c, rootNode);
			}
		}
		if (count != 1) {
			if (count == 0) {
				throw new InvalidColumnDefinitionException(
						"A column depending on a EMF execution context must be defined.");
			} else if (count > 1) {
				throw new InvalidColumnDefinitionException(
						"Only one column depending on a EMF execution context must be defined ("
								+ count + " are defined).");
			}
		}
		return firstColumnNode;
	}

	/**
	 * Create a node from a column and as the child of a currentNode
	 * 
	 * @param c
	 *            column (content of the new node)
	 * @param currentNode
	 *            parent of the new node
	 * @return Newly created node
	 */
	private ColumnTreeNode createNode(Column c, TreeNode currentNode) {
		ColumnTreeNode newNode = new ColumnTreeNode(c);
		for (Column child : getColumnsDependingOn(c)) {
			newNode.addChild(createNode(child, newNode));
		}
		return newNode;
	}

	/**
	 * Get the list of columns depending on a given column
	 * 
	 * @param c
	 *            the original column
	 * @return a list of columns
	 */
	private List<Column> getColumnsDependingOn(Column c) {
		List<Column> dependantColumns = new LinkedList<Column>();
		if (c.getExecutes() == null) {
			throw new InvalidColumnDefinitionException("Column " + c.getIndex()
					+ " must have an execution query ");
		}
		if (c.getExecutes().getExecutionContext() == null) {
			throw new InvalidColumnDefinitionException("Column " + c.getIndex()
					+ " must have an execution context for the execution query");
		}

		for (Column aColumn : getColumns()) {
			if (aColumn.getExecutes().getExecutionContext() instanceof ColumnContext) {
				if (c.equals(((ColumnContext) aColumn.getExecutes()
						.getExecutionContext()).getDependsOn())) {
					dependantColumns.add(aColumn);
				}
			}
		}
		return dependantColumns;
	}

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
        switch (featureID)
        {
            case Query2tablePackage.MODEL_EXPORT__COLUMNS:
                return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID)
        {
            case Query2tablePackage.MODEL_EXPORT__OUTPUT_PATH:
                return getOutputPath();
            case Query2tablePackage.MODEL_EXPORT__EXPORT_EXTENSION:
                return getExportExtension();
            case Query2tablePackage.MODEL_EXPORT__COLUMNS:
                return getColumns();
            case Query2tablePackage.MODEL_EXPORT__EMF_CONTEXT:
                if (resolve) return getEmfContext();
                return basicGetEmfContext();
            case Query2tablePackage.MODEL_EXPORT__DEPENDENCY_MANAGEMENT:
                return getDependencyManagement();
            case Query2tablePackage.MODEL_EXPORT__CELL_SPAN:
                return isCellSpan();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID)
        {
            case Query2tablePackage.MODEL_EXPORT__OUTPUT_PATH:
                setOutputPath((String)newValue);
                return;
            case Query2tablePackage.MODEL_EXPORT__EXPORT_EXTENSION:
                setExportExtension((ExportExtension)newValue);
                return;
            case Query2tablePackage.MODEL_EXPORT__COLUMNS:
                getColumns().clear();
                getColumns().addAll((Collection<? extends Column>)newValue);
                return;
            case Query2tablePackage.MODEL_EXPORT__DEPENDENCY_MANAGEMENT:
                setDependencyManagement((DependencyManagement)newValue);
                return;
            case Query2tablePackage.MODEL_EXPORT__CELL_SPAN:
                setCellSpan((Boolean)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID)
        {
            case Query2tablePackage.MODEL_EXPORT__OUTPUT_PATH:
                setOutputPath(OUTPUT_PATH_EDEFAULT);
                return;
            case Query2tablePackage.MODEL_EXPORT__EXPORT_EXTENSION:
                setExportExtension(EXPORT_EXTENSION_EDEFAULT);
                return;
            case Query2tablePackage.MODEL_EXPORT__COLUMNS:
                getColumns().clear();
                return;
            case Query2tablePackage.MODEL_EXPORT__DEPENDENCY_MANAGEMENT:
                setDependencyManagement(DEPENDENCY_MANAGEMENT_EDEFAULT);
                return;
            case Query2tablePackage.MODEL_EXPORT__CELL_SPAN:
                setCellSpan(CELL_SPAN_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID)
        {
            case Query2tablePackage.MODEL_EXPORT__OUTPUT_PATH:
                return OUTPUT_PATH_EDEFAULT == null ? outputPath != null : !OUTPUT_PATH_EDEFAULT.equals(outputPath);
            case Query2tablePackage.MODEL_EXPORT__EXPORT_EXTENSION:
                return exportExtension != EXPORT_EXTENSION_EDEFAULT;
            case Query2tablePackage.MODEL_EXPORT__COLUMNS:
                return columns != null && !columns.isEmpty();
            case Query2tablePackage.MODEL_EXPORT__EMF_CONTEXT:
                return emfContext != null;
            case Query2tablePackage.MODEL_EXPORT__DEPENDENCY_MANAGEMENT:
                return dependencyManagement != DEPENDENCY_MANAGEMENT_EDEFAULT;
            case Query2tablePackage.MODEL_EXPORT__CELL_SPAN:
                return cellSpan != CELL_SPAN_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (outputPath: ");
        result.append(outputPath);
        result.append(", exportExtension: ");
        result.append(exportExtension);
        result.append(", dependencyManagement: ");
        result.append(dependencyManagement);
        result.append(", cellSpan: ");
        result.append(cellSpan);
        result.append(')');
        return result.toString();
    }

} // ModelExportImpl
