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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.model2doc.query2table.EMFContext;
import org.topcased.model2doc.query2table.Query2tablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMF Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.model2doc.query2table.impl.EMFContextImpl#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMFContextImpl extends ContextImpl implements EMFContext {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getModelElement()
     * @generated
     * @ordered
     */
	protected EObject modelElement;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EMFContextImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Query2tablePackage.Literals.EMF_CONTEXT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EObject getModelElement() {
        if (modelElement != null && modelElement.eIsProxy())
        {
            InternalEObject oldModelElement = (InternalEObject)modelElement;
            modelElement = eResolveProxy(oldModelElement);
            if (modelElement != oldModelElement)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Query2tablePackage.EMF_CONTEXT__MODEL_ELEMENT, oldModelElement, modelElement));
            }
        }
        return modelElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EObject basicGetModelElement() {
        return modelElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setModelElement(EObject newModelElement) {
		EObject oldModelElement = modelElement;
        modelElement = newModelElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Query2tablePackage.EMF_CONTEXT__MODEL_ELEMENT, oldModelElement, modelElement));
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
            case Query2tablePackage.EMF_CONTEXT__MODEL_ELEMENT:
                if (resolve) return getModelElement();
                return basicGetModelElement();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID)
        {
            case Query2tablePackage.EMF_CONTEXT__MODEL_ELEMENT:
                setModelElement((EObject)newValue);
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
            case Query2tablePackage.EMF_CONTEXT__MODEL_ELEMENT:
                setModelElement((EObject)null);
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
            case Query2tablePackage.EMF_CONTEXT__MODEL_ELEMENT:
                return modelElement != null;
        }
        return super.eIsSet(featureID);
    }

} //EMFContextImpl
