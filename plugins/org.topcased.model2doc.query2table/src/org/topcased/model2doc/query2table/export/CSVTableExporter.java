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
package org.topcased.model2doc.query2table.export;

import java.io.IOException;

import org.topcased.model2doc.query2table.DependencyManagement;
import org.topcased.model2doc.query2table.util.TableTree;

public class CSVTableExporter implements TableExporter{

	public String exportToTable(TableTree tree, String outputFilePath, DependencyManagement dependencyManagement)
			throws IOException {
	    //TODO implement CSV export
		throw new NoSuchMethodError("CSV export not implemented yet");
	}

}
