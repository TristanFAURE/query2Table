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

//It keeps the value of the diferents texts, when the pages are refreshed
public class WizardControl {
	
	private String output;
	private String input;
	private String reg;
	private String comboText;
	private String element;
	public boolean checkOutputPath;
	public boolean radioButtonExecute=false;
	public Object firstElement;
	
	
	public void setOutput(String s){
		output=s;
	}
	
	public String getOutput(){
		return output;
	}
	
	public void setInput(String s){
		input=s;
	}
	
	public String getInput(){
		return input;
	}
	
	public void setReg(String s){
		reg=s;
	}
	
	public String getReg(){
		return reg;
	}

	public void setComboText(String s){
		comboText=s;
	}
	
	public String getComboText(){
		return comboText;
	}

	public void setElement(String s){
		element=s;
	}
	
	public String getElement(){
		return element;
	}
}
