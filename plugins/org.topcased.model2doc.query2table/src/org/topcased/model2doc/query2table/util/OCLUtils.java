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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.options.ProblemOption;
import org.topcased.model2doc.query2table.exception.QueryExecutionException;

/**
 * @author ahaugomm
 * 
 */
public class OCLUtils {

	private static OCL<EPackage, EClassifier, EOperation, EStructuralFeature, ?, ?, ?, ?, ?, Constraint, EClass, EObject> ocl;
	private static OCLHelper<EClassifier, ?, ?, Constraint> oclHelper;
	private static Map<String, OCLExpression<EClassifier>> queries = new HashMap<String, OCLExpression<EClassifier>>();

	static {
		// force loading of all the epackages of the platform
		Collection<String> keys = new ArrayList<String>(EPackage.Registry.INSTANCE.keySet());
		for (String s : keys) {
			EPackage.Registry.INSTANCE.getEPackage(s);
		}
	}
	
	public static OCL<EPackage, EClassifier, EOperation, EStructuralFeature, ?, ?, ?, ?, ?, Constraint, EClass, EObject> getOCL() {
		if (ocl == null) {

			// From factory
			ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
			ParsingOptions.setOption(ocl.getEnvironment(),
					ParsingOptions.implicitRootClass(ocl.getEnvironment()),
					EcorePackage.Literals.EOBJECT);
			ParsingOptions.setOption(ocl.getEnvironment(),
					ProblemOption.CLOSURE_ITERATOR,
					ProblemHandler.Severity.OK);
			oclHelper = ocl.createOCLHelper();
			// TODO if ocl factory mechanism is updated clear the cache map and reinit the ocl helper

		}

		return ocl;
	}
	public static Object processOCLConstraint(Object context,
			String oclExpression) throws QueryExecutionException,
			ParserException {
		return processOCLConstraint(context, oclExpression, null);
	}
	public static Object processOCLConstraint(Object context,
			String oclExpression, Map<EClass, Set<EObject>> extents) throws QueryExecutionException,
			ParserException {

		if (context instanceof EObject) {
			try {
				getOCL().setExtentMap(extents);
				oclHelper.setContext(((EObject) context).eClass());
				// Query<EClassifier, EClass, EObject> query = ocl
				// .createQuery(oclHelper.createQuery(oclExpression));
				OCLExpression<EClassifier> createQuery = queries
						.get(oclExpression);
				if (createQuery == null) {
					createQuery = oclHelper.createQuery(oclExpression);
					queries.put(oclExpression, createQuery);
				}
				Object result = getOCL().evaluate(context, createQuery);
				getOCL().setExtentMap(null);
				return result;
			} catch (Throwable t) {
				throw new QueryExecutionException(
						"Unexpected error during query processing :"
								+ t.getMessage(), t);
			}
		} else {
			throw new QueryExecutionException(
					"Query impossible to handle. Context is not a EClassifier");
		}
	}

}
