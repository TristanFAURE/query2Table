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
package org.topcased.model2doc.query2table.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.topcased.model2doc.query2table.util.Query2tableResourceFactoryImpl
 * @generated
 */
public class Query2tableResourceImpl extends XMIResourceImpl {
	
	private boolean flag = false ;
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "Copyright (c) 2010 Atos Origin.\r\n \r\n    \r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n Anne Haugommard(Atos Origin) anne.haugommard@atosorigin.com - Initial API\r\n ";

	/**
     * Creates an instance of the resource.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param uri the URI of the new resource.
     * @generated
     */
	public Query2tableResourceImpl(URI uri) {
        super(uri);
    }

	@Override
	public void doLoad(InputSource inputSource, Map<?, ?> options)
			throws IOException {
		super.doLoad(inputSource, options);
		initOCL();
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		super.doLoad(inputStream, options);
		initOCL();
	}

	@Override
	public void doLoad(Node node, Map<?, ?> options) throws IOException {
		super.doLoad(node, options);
		initOCL();
	}
	
	public void initOCL ()
	{
		if (!flag)
		{
			EcoreUtil.resolveAll(this.getResourceSet());

//			//Find all metamodel packages
//			TreeIterator<EObject> allModelObjects = EcoreUtil.getAllContents(this,true);
//			EObject currentObject;
//			Set<EPackage> packages = new HashSet<EPackage>();
//			while (allModelObjects.hasNext())
//			{
//				currentObject = allModelObjects.next();
//				EPackage epackage = currentObject.eClass().getEPackage();
//				if(!packages.contains(epackage)){
//					packages.add(epackage);
//					
//				}
//				// Add ePackages for all EMF model objects 
//				if(currentObject instanceof EMFContext){
//					packages.addAll(getAllEPackages(((EMFContext)currentObject).getModelElement().eResource()));
//				}
//			}
//			
//			//Initialize Ocl environment from these metamodels
			
			//Initialize Ocl environment
			OCLUtils.getOCL();
			flag = true ;
		}
	}
	
//	private Set<EPackage> getAllEPackages(Resource resource) {
//		// Find all meta-model packages
//		TreeIterator<EObject> allModelObjects = EcoreUtil.getAllContents(
//				resource, true);
//		EObject currentObject;
//		Set<EPackage> packages = new HashSet<EPackage>();
//		while (allModelObjects.hasNext()) {
//			currentObject = allModelObjects.next();
//			EPackage epackage = currentObject.eClass().getEPackage();
//			if (!packages.contains(epackage)) {
//				packages.add(epackage);
//			}
//		}
//		return packages;
//	}

	@Override
	protected boolean useUUIDs() {
		return true;
	}

	/**
	 * @generated NOT 
	 */
	@Override
	protected Notification setLoaded(boolean isLoaded) {
		return super.setLoaded(isLoaded);
	}

	@Override
	protected XMLHelper createXMLHelper() {
		// TODO Auto-generated method stub
		return super.createXMLHelper();
	}
	
} //Query2tableResourceImpl
