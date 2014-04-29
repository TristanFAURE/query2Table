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

import org.topcased.model2doc.query2table.Column;
import org.topcased.model2doc.query2table.EMFContext;
import org.topcased.model2doc.query2table.JavaQuery;
import org.topcased.model2doc.query2table.OCLQuery;
import org.topcased.model2doc.query2table.exception.InvalidColumnDefinitionException;
import org.topcased.model2doc.query2table.exception.QueryExecutionException;

public class ColumnTreeNode extends TreeNode {

	
	public ColumnTreeNode(Column c){
		super(c);
	}
	
	public Column getColumn(){
		if( this.getContent() instanceof Column){
			return (Column)this.getContent();
		}
		else{
			throw new InvalidColumnDefinitionException("The content is not a column : "+this.getContent());
		}
	}
	
	
	
	/**
	 * Returns true if the column execution query is defined on a EMF content (root column) 
	 * @return
	 */
	public boolean isPrincipalColumn(){
		Column c = getColumn();
		checkColumn(c);
		return (c.getExecutes().getExecutionContext() instanceof EMFContext);
	}
	
	/**
	 * Returns true if the column execution query is an OCL Query 
	 * @return
	 */
	public boolean hasOCLExecutionQuery(){
		Column c = getColumn();
		checkColumn(c);
		return (c.getExecutes() instanceof OCLQuery);
	}
	
	/**
	 * Returns true if the column execution query is a Java Query 
	 * @return
	 */
	public boolean hasJavaExecutionQuery(){
		Column c = getColumn();
		checkColumn(c);
		return (c.getExecutes() instanceof JavaQuery);
	}
	
	
	public Object executeEMFQuery(){
		if (isPrincipalColumn()){
			return getColumn().getExecutes().executeQuery(((EMFContext) getColumn().getExecutes().getExecutionContext())
						.getModelElement());
		}
		throw new QueryExecutionException("This column does not have a query with an EMF Context");
	}
	
	/**
	 * Check integrity of the column content
	 */
	private void checkColumn(Column c){
		if (c.getExecutes() == null) {
			throw new InvalidColumnDefinitionException("Column " + c.getIndex()
					+ " must have an execution query ");
		}
		if ( c.getExecutes().getExecutionContext() == null) {
			throw new InvalidColumnDefinitionException("Column " + c.getIndex()
					+ " must have an execution context for the execution query");
		}
	}
	
}
