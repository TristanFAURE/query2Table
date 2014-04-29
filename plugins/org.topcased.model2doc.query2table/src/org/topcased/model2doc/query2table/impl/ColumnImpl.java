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
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.Query;
import org.topcased.model2doc.query2table.Query2tablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ColumnImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ColumnImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ColumnImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ColumnImpl#getDisplays <em>Displays</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ColumnImpl#getExecutes <em>Executes</em>}</li>
 *   <li>{@link org.topcased.model2doc.query2table.impl.ColumnImpl#getDefaultValueToDisplay <em>Default Value To Display</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnImpl extends EObjectImpl implements Column {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIndex()
     * @generated
     * @ordered
     */
	protected static final int INDEX_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIndex()
     * @generated
     * @ordered
     */
	protected int index = INDEX_EDEFAULT;

	/**
     * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTitle()
     * @generated
     * @ordered
     */
	protected static final String TITLE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTitle()
     * @generated
     * @ordered
     */
	protected String title = TITLE_EDEFAULT;

	/**
     * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
	protected static final String PATTERN_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
	protected String pattern = PATTERN_EDEFAULT;

	/**
     * The cached value of the '{@link #getDisplays() <em>Displays</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDisplays()
     * @generated
     * @ordered
     */
	protected EList<Query> displays;

	/**
     * The cached value of the '{@link #getExecutes() <em>Executes</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExecutes()
     * @generated
     * @ordered
     */
	protected Query executes;

	/**
     * The default value of the '{@link #getDefaultValueToDisplay() <em>Default Value To Display</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValueToDisplay()
     * @generated
     * @ordered
     */
    protected static final String DEFAULT_VALUE_TO_DISPLAY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultValueToDisplay() <em>Default Value To Display</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValueToDisplay()
     * @generated
     * @ordered
     */
    protected String defaultValueToDisplay = DEFAULT_VALUE_TO_DISPLAY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ColumnImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Query2tablePackage.Literals.COLUMN;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getIndex() {
        return index;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIndex(int newIndex) {
        int oldIndex = index;
        index = newIndex;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.COLUMN__INDEX, oldIndex, index));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTitle() {
        return title;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTitle(String newTitle) {
        String oldTitle = title;
        title = newTitle;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.COLUMN__TITLE, oldTitle, title));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getPattern() {
        return pattern;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPattern(String newPattern) {
        String oldPattern = pattern;
        pattern = newPattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.COLUMN__PATTERN, oldPattern, pattern));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Query> getDisplays() {
        if (displays == null)
        {
            displays = new EObjectContainmentEList<Query>(Query.class, this, Query2tablePackage.COLUMN__DISPLAYS);
        }
        return displays;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Query getExecutes() {
        return executes;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetExecutes(Query newExecutes, NotificationChain msgs) {
        Query oldExecutes = executes;
        executes = newExecutes;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Query2tablePackage.COLUMN__EXECUTES, oldExecutes, newExecutes);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExecutes(Query newExecutes) {
        if (newExecutes != executes)
        {
            NotificationChain msgs = null;
            if (executes != null)
                msgs = ((InternalEObject)executes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Query2tablePackage.COLUMN__EXECUTES, null, msgs);
            if (newExecutes != null)
                msgs = ((InternalEObject)newExecutes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Query2tablePackage.COLUMN__EXECUTES, null, msgs);
            msgs = basicSetExecutes(newExecutes, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.COLUMN__EXECUTES, newExecutes, newExecutes));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDefaultValueToDisplay()
    {
        return defaultValueToDisplay;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultValueToDisplay(String newDefaultValueToDisplay)
    {
        String oldDefaultValueToDisplay = defaultValueToDisplay;
        defaultValueToDisplay = newDefaultValueToDisplay;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.COLUMN__DEFAULT_VALUE_TO_DISPLAY, oldDefaultValueToDisplay, defaultValueToDisplay));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addDisplayQuery(Query displayQuery)
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID)
        {
            case Query2tablePackage.COLUMN__DISPLAYS:
                return ((InternalEList<?>)getDisplays()).basicRemove(otherEnd, msgs);
            case Query2tablePackage.COLUMN__EXECUTES:
                return basicSetExecutes(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID)
        {
            case Query2tablePackage.COLUMN__INDEX:
                return getIndex();
            case Query2tablePackage.COLUMN__TITLE:
                return getTitle();
            case Query2tablePackage.COLUMN__PATTERN:
                return getPattern();
            case Query2tablePackage.COLUMN__DISPLAYS:
                return getDisplays();
            case Query2tablePackage.COLUMN__EXECUTES:
                return getExecutes();
            case Query2tablePackage.COLUMN__DEFAULT_VALUE_TO_DISPLAY:
                return getDefaultValueToDisplay();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID)
        {
            case Query2tablePackage.COLUMN__INDEX:
                setIndex((Integer)newValue);
                return;
            case Query2tablePackage.COLUMN__TITLE:
                setTitle((String)newValue);
                return;
            case Query2tablePackage.COLUMN__PATTERN:
                setPattern((String)newValue);
                return;
            case Query2tablePackage.COLUMN__DISPLAYS:
                getDisplays().clear();
                getDisplays().addAll((Collection<? extends Query>)newValue);
                return;
            case Query2tablePackage.COLUMN__EXECUTES:
                setExecutes((Query)newValue);
                return;
            case Query2tablePackage.COLUMN__DEFAULT_VALUE_TO_DISPLAY:
                setDefaultValueToDisplay((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID)
        {
            case Query2tablePackage.COLUMN__INDEX:
                setIndex(INDEX_EDEFAULT);
                return;
            case Query2tablePackage.COLUMN__TITLE:
                setTitle(TITLE_EDEFAULT);
                return;
            case Query2tablePackage.COLUMN__PATTERN:
                setPattern(PATTERN_EDEFAULT);
                return;
            case Query2tablePackage.COLUMN__DISPLAYS:
                getDisplays().clear();
                return;
            case Query2tablePackage.COLUMN__EXECUTES:
                setExecutes((Query)null);
                return;
            case Query2tablePackage.COLUMN__DEFAULT_VALUE_TO_DISPLAY:
                setDefaultValueToDisplay(DEFAULT_VALUE_TO_DISPLAY_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID)
        {
            case Query2tablePackage.COLUMN__INDEX:
                return index != INDEX_EDEFAULT;
            case Query2tablePackage.COLUMN__TITLE:
                return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
            case Query2tablePackage.COLUMN__PATTERN:
                return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
            case Query2tablePackage.COLUMN__DISPLAYS:
                return displays != null && !displays.isEmpty();
            case Query2tablePackage.COLUMN__EXECUTES:
                return executes != null;
            case Query2tablePackage.COLUMN__DEFAULT_VALUE_TO_DISPLAY:
                return DEFAULT_VALUE_TO_DISPLAY_EDEFAULT == null ? defaultValueToDisplay != null : !DEFAULT_VALUE_TO_DISPLAY_EDEFAULT.equals(defaultValueToDisplay);
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (index: ");
        result.append(index);
        result.append(", title: ");
        result.append(title);
        result.append(", pattern: ");
        result.append(pattern);
        result.append(", defaultValueToDisplay: ");
        result.append(defaultValueToDisplay);
        result.append(')');
        return result.toString();
    }

} //ColumnImpl
