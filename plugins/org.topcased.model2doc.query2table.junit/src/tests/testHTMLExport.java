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
package tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class testHTMLExport {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		exportToFile(exportToTable(), "D:/test.html");
	}

	protected static void exportToFile(StringBuffer stringBuffer,
			String outputFilePath) throws IOException {

		// Write content into result file
		File f = new File(outputFilePath);
		FileWriter fWriter = new FileWriter(f);
		fWriter.write(stringBuffer.toString());
		fWriter.close();

	}

	protected static StringBuffer exportToTable() {

		// Test data
		List<String> columnTitles = Arrays.asList(new String[] { "TITRE1",
				"TITRE2", "TITRE3" });

		List<List<String>> lines = null; //TODO try

		// Code
		StringBuffer htmlContent = new StringBuffer();

		htmlContent.append("<html>");
		htmlContent.append("<body><table border='1'>");

		// Table header (all column titles)
		htmlContent.append("<thead style=\"font-weight: bold\">");
		htmlContent.append("<tr>");
		for (String columnTitle : columnTitles) {
			htmlContent.append("<td>");
			htmlContent.append(columnTitle);
			htmlContent.append("</td>");
		}
		htmlContent.append("</tr>");
		htmlContent.append("</thead>");

		htmlContent.append("<tbody>");

		for (List<String> line : lines) {
			// start line
			htmlContent.append("<tr>");

			for (String cellContent : line) {
				htmlContent.append("<td>");
				htmlContent.append(cellContent);
				htmlContent.append("</td>");
			}
			htmlContent.append("</tr>");
		}

		// htmlContent.append("<tr>");
		// htmlContent.append("<td>");
		// htmlContent.append("value4");
		// htmlContent.append("</td>");
		// htmlContent.append("<td rowspan=\"2\" >");
		// htmlContent.append("value5\n&value8");
		// htmlContent.append("</td>");
		// htmlContent.append("<td>");
		// htmlContent.append("value6");
		// htmlContent.append("</td>");
		// htmlContent.append("</tr>");
		//
		// htmlContent.append("<tr>");
		// htmlContent.append("<td>");
		// htmlContent.append("value7");
		// htmlContent.append("</td>");
		// htmlContent.append("<td>");
		// htmlContent.append("value9");
		// htmlContent.append("</td>");
		// htmlContent.append("</tr>");
		//
		// htmlContent.append("<tr>");
		// htmlContent.append("<td>");
		// htmlContent.append("value11");
		// htmlContent.append("</td>");
		// htmlContent.append("<td colspan=\"2\" >");
		// htmlContent.append("value12");
		// htmlContent.append("</td>");
		// htmlContent.append("</tr>");

		htmlContent.append("</tbody>");

		htmlContent.append("</table></body></html>");

		return htmlContent;
	}

}
