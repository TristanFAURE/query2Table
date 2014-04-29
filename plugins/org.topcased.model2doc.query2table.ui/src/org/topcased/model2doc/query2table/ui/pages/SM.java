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

public class SM {

	public enum states_execute {
		 COLUMN__PSEUDORADIO,
		 COLUMN__INITIALNODE,
		 PSEUDOSTATE2,
		 NO_SELECTION,
		 DISPLAY_EDIT__COLUMN__DISPLAY_OCL,
		 DISPLAY_EDIT__COLUMN__DISPLAY_EDIT,
		 DISPLAY_EDIT__COLUMN__INITIALNODE,
		 INITIALNODE,
		 COLUMN__COLUMN_SELECTED,
		 PSEUDOSTATE1,
		 COLUMN__EXECUTE_OCL,
		 DISPLAY_EDIT__COLUMN__DISPLAY_JAVA,
		 COLUMN__COLUMN_UNSELECTED,
		 DISPLAY_EDIT__COLUMN__COLUMN_SELECTED,
		 COLUMN__EXECUTE_JAVA,
		 COLUMN,
		 COLUMN__DISPLAY_EDIT,
		 FINISH,
	}


	public enum event_execute {

buttonMoin, 
buttonPlus, 
finishButton, 
radioButtonExecuteJava, 
changeToJava, 
isColumnZero, 
tableSelected, 
radioButtonExecuteOCL, 
isNotColumnZero, 
radioButtonDisplayOCL, 
changeToOCL, 
selectJava, 
selectDisplayQuerys, 
selectOCL, 
radioButtonDisplayJava, 
tableChanged, 
returnColumns, 
deleteDisplayQuerys, 
addDisplay
	
	}

	/**
	 * 
	 */
	private final ConfigurationWizardPage sm;
	private states_execute currentStateExecute;
	

	public SM(ConfigurationWizardPage configurationWizardPage) {
		sm = configurationWizardPage;
		currentStateExecute = states_execute.NO_SELECTION;
		state_NO_SELECTION();
	}
	
	public String getState_Machine(){
		return currentStateExecute.toString();
	}

	
	
	public void run(event_execute event) {
		switch (currentStateExecute) {
		// current state
		case NO_SELECTION : 
				// event triggered
				switch (event) {
					case  buttonPlus :
						state_PSEUDOSTATE2 () ;
						
					break ;
					default :
						// nothing to do 
					break ;
			}
		break;
		// current state
		case DISPLAY_EDIT__COLUMN__DISPLAY_OCL : 
				// event triggered
				switch (event) {
					case  buttonMoin :
						state_PSEUDOSTATE1 () ;
						
					break ;
					case  returnColumns :
						state_COLUMN__COLUMN_UNSELECTED () ;
						
					break ;
					case  addDisplay :
						state_DISPLAY_EDIT__COLUMN__DISPLAY_EDIT () ;
						
					break ;
					case  buttonPlus :
						state_PSEUDOSTATE2 () ;
						
					break ;
					case  changeToJava :
						state_DISPLAY_EDIT__COLUMN__DISPLAY_JAVA () ;
						
					break ;
					case  deleteDisplayQuerys :
						state_COLUMN__DISPLAY_EDIT () ;
						
					break ;
					case  finishButton :
						state_FINISH () ;
						
					break ;
					default :
						// nothing to do 
					break ;
			}
		break;
		// current state
		case DISPLAY_EDIT__COLUMN__DISPLAY_EDIT : 
				// event triggered
				switch (event) {
					case  buttonMoin :
						state_PSEUDOSTATE1 () ;
						
					break ;
					case  returnColumns :
						state_COLUMN__COLUMN_UNSELECTED () ;
						
					break ;
					case  tableSelected :
						state_DISPLAY_EDIT__COLUMN__COLUMN_SELECTED () ;
						
					break ;
					case  radioButtonDisplayOCL :
						state_DISPLAY_EDIT__COLUMN__DISPLAY_OCL () ;
						
					break ;
					case  buttonPlus :
						state_PSEUDOSTATE2 () ;
						
					break ;
					case  deleteDisplayQuerys :
						state_COLUMN__DISPLAY_EDIT () ;
						
					break ;
					case  radioButtonDisplayJava :
						state_DISPLAY_EDIT__COLUMN__DISPLAY_JAVA () ;
						
					break ;
					case  finishButton :
						state_FINISH () ;
						
					break ;
					default :
						// nothing to do 
					break ;
			}
		break;
		// current state
		case COLUMN__COLUMN_SELECTED : 
				// event triggered
				switch (event) {
					case  buttonMoin :
						state_PSEUDOSTATE1 () ;
						
					break ;
					case  radioButtonExecuteJava :
						state_COLUMN__EXECUTE_JAVA () ;
						
					break ;
					case  buttonPlus :
						state_PSEUDOSTATE2 () ;
						
					break ;
					case  radioButtonExecuteOCL :
						state_COLUMN__EXECUTE_OCL () ;
						
					break ;
					default :
						// nothing to do 
					break ;
			}
		break;
		// current state
		case COLUMN__EXECUTE_OCL : 
				// event triggered
				switch (event) {
					case  buttonMoin :
						state_PSEUDOSTATE1 () ;
						
					break ;
					case  selectDisplayQuerys :
						state_COLUMN__DISPLAY_EDIT () ;
						
					break ;
					case  buttonPlus :
						state_PSEUDOSTATE2 () ;
						
					break ;
					case  changeToJava :
						state_COLUMN__EXECUTE_JAVA () ;
						
					break ;
					default :
						// nothing to do 
					break ;
			}
		break;
		// current state
		case DISPLAY_EDIT__COLUMN__DISPLAY_JAVA : 
				// event triggered
				switch (event) {
					case  buttonMoin :
						state_PSEUDOSTATE1 () ;
						
					break ;
					case  returnColumns :
						state_COLUMN__COLUMN_UNSELECTED () ;
						
					break ;
					case  changeToOCL :
						state_DISPLAY_EDIT__COLUMN__DISPLAY_OCL () ;
						
					break ;
					case  buttonPlus :
						state_PSEUDOSTATE2 () ;
						
					break ;
					case  deleteDisplayQuerys :
						state_COLUMN__DISPLAY_EDIT () ;
						
					break ;
					case  addDisplay :
						state_DISPLAY_EDIT__COLUMN__DISPLAY_EDIT () ;
						
					break ;
					case  finishButton :
						state_FINISH () ;
						
					break ;
					default :
						// nothing to do 
					break ;
			}
		break;
		// current state
		case DISPLAY_EDIT__COLUMN__COLUMN_SELECTED : 
				// event triggered
				switch (event) {
					case  buttonMoin :
						state_PSEUDOSTATE1 () ;
						
					break ;
					case  returnColumns :
						state_COLUMN__COLUMN_UNSELECTED () ;
						
					break ;
					case  selectOCL :
						state_DISPLAY_EDIT__COLUMN__DISPLAY_OCL () ;
						
					break ;
					case  buttonPlus :
						state_PSEUDOSTATE2 () ;
						
					break ;
					case  deleteDisplayQuerys :
						state_COLUMN__DISPLAY_EDIT () ;
						
					break ;
					case  finishButton :
						state_FINISH () ;
						
					break ;
					case  selectJava :
						state_DISPLAY_EDIT__COLUMN__DISPLAY_JAVA () ;
						
					break ;
					default :
						// nothing to do 
					break ;
			}
		break;
		// current state
		case COLUMN__COLUMN_UNSELECTED : 
				// event triggered
				switch (event) {
					case  buttonMoin :
						state_PSEUDOSTATE1 () ;
						
					break ;
					case  tableSelected :
						state_COLUMN__COLUMN_SELECTED () ;
						
					break ;
					case  selectJava :
						state_COLUMN__EXECUTE_JAVA () ;
						
					break ;
					case  buttonPlus :
						state_PSEUDOSTATE2 () ;
						
					break ;
					case  selectOCL :
						state_COLUMN__EXECUTE_OCL () ;
						
					break ;
					default :
						// nothing to do 
					break ;
			}
		break;
		// current state
		case COLUMN__EXECUTE_JAVA : 
				// event triggered
				switch (event) {
					case  buttonMoin :
						state_PSEUDOSTATE1 () ;
						
					break ;
					case  changeToOCL :
						state_COLUMN__EXECUTE_OCL () ;
						
					break ;
					case  buttonPlus :
						state_PSEUDOSTATE2 () ;
						
					break ;
					case  selectDisplayQuerys :
						state_COLUMN__DISPLAY_EDIT () ;
						
					break ;
					default :
						// nothing to do 
					break ;
			}
		break;
		// current state
		case FINISH : 
				// event triggered
				switch (event) {
					default :
						// nothing to do 
					break ;
			}
		break;
		default :
			// nothing to do 
		break ;
		}

	}


	public void state_COLUMN__PSEUDORADIO(){
		currentStateExecute = states_execute.COLUMN__PSEUDORADIO;
		
	}
	public void state_COLUMN__INITIALNODE(){
		currentStateExecute = states_execute.COLUMN__INITIALNODE;
		state_COLUMN__COLUMN_UNSELECTED();
	}
	public void state_PSEUDOSTATE2(){
		currentStateExecute = states_execute.PSEUDOSTATE2;
		state_COLUMN () ;
	}
	public void state_NO_SELECTION(){
		currentStateExecute = states_execute.NO_SELECTION;
		sm.buttonAddColumn.setEnabled(true);
		sm.buttonRemoveColumn.setEnabled(false);
		sm.executeQueryJavaCombo.setEnabled(false);
		sm.executeQueryOCLText.setEnabled(false);
		sm.contextCombo.setEnabled(false);
		sm.queryAddButton.setEnabled(false);
		sm.queryDeleteButton.setEnabled(false);
		sm.displayQueryJavaCombo.setEnabled(false);
		sm.displayQueryOCLText.setEnabled(false);
		sm.patternText.setEnabled(false);
		sm.radioButtonDisplayQueryJava.setEnabled(false);
		sm.radioButtonDisplayQueryOCL.setEnabled(false);
		sm.radioButtonExecuteQueryJava.setEnabled(false);
		sm.radioButtonExecuteQueryOCL.setEnabled(false);
		sm.radioButtonExecuteQueryJava.setSelection(false);
		sm.radioButtonExecuteQueryOCL.setSelection(false);
		//sm.stateMachineText.setText(currentStateExecute.toString());
		
	}
	public void state_DISPLAY_EDIT__COLUMN__DISPLAY_OCL(){
		currentStateExecute = states_execute.DISPLAY_EDIT__COLUMN__DISPLAY_OCL;
		sm.buttonAddColumn.setEnabled(true);
		sm.buttonRemoveColumn.setEnabled(true);
		sm.contextCombo.setEnabled(true);
		sm.queryAddButton.setEnabled(true);
		sm.queryDeleteButton.setEnabled(true);
		sm.displayQueryJavaCombo.setEnabled(false);
		sm.displayQueryOCLText.setEnabled(true);
		sm.patternText.setEnabled(true);
		sm.displayQueryJavaCombo.deselectAll();
		sm.radioButtonDisplayQueryJava.setEnabled(true);
		sm.radioButtonDisplayQueryOCL.setEnabled(true);
		sm.radioButtonDisplayQueryJava.setSelection(false);
		sm.radioButtonDisplayQueryOCL.setSelection(true);
		sm.radioButtonExecuteQueryJava.setEnabled(false);
		sm.radioButtonExecuteQueryOCL.setEnabled(false);
		sm.executeQueryJavaCombo.setEnabled(false);
		sm.executeQueryOCLText.setEnabled(false);
		sm.contextCombo.setEnabled(false);
		sm.queryUpButton.setEnabled(true);
		sm.queryDownButton.setEnabled(true);
		//sm.stateMachineText.setText(currentStateExecute.toString());
		
	}
	public void state_DISPLAY_EDIT__COLUMN__DISPLAY_EDIT(){
		currentStateExecute = states_execute.DISPLAY_EDIT__COLUMN__DISPLAY_EDIT;
		sm.buttonAddColumn.setEnabled(true);
		sm.buttonRemoveColumn.setEnabled(true);
		sm.executeQueryJavaCombo.setEnabled(false);
		sm.executeQueryOCLText.setEnabled(false);
		sm.contextCombo.setEnabled(false);
		sm.queryAddButton.setEnabled(false);
		sm.queryDeleteButton.setEnabled(false);
		sm.displayQueryJavaCombo.setEnabled(false);
		sm.displayQueryJavaCombo.deselectAll();
		sm.displayQueryOCLText.setEnabled(false);
		sm.displayQueryOCLText.setText("");
		sm.radioButtonDisplayQueryJava.setSelection(false);
		sm.radioButtonDisplayQueryOCL.setSelection(false);
		sm.radioButtonDisplayQueryJava.setEnabled(true);
		sm.radioButtonDisplayQueryOCL.setEnabled(true);
		sm.patternText.setEnabled(true);
		sm.queryUpButton.setEnabled(true);
		sm.queryDownButton.setEnabled(true);
		//sm.stateMachineText.setText(currentStateExecute.toString());
		
	}
	public void state_DISPLAY_EDIT__COLUMN__INITIALNODE(){
		currentStateExecute = states_execute.DISPLAY_EDIT__COLUMN__INITIALNODE;
		state_DISPLAY_EDIT__COLUMN__DISPLAY_EDIT();
	}
	public void state_INITIALNODE(){
		currentStateExecute = states_execute.INITIALNODE;
		state_NO_SELECTION();
	}
	public void state_COLUMN__COLUMN_SELECTED(){
		currentStateExecute = states_execute.COLUMN__COLUMN_SELECTED;
		sm.buttonAddColumn.setEnabled(true);
		sm.buttonRemoveColumn.setEnabled(true);
		sm.executeQueryJavaCombo.setEnabled(false);
		sm.executeQueryOCLText.setEnabled(false);
		sm.contextCombo.setEnabled(false);
		sm.queryAddButton.setEnabled(false);
		sm.queryDeleteButton.setEnabled(false);
		sm.displayQueryJavaCombo.setEnabled(false);
		sm.displayQueryOCLText.setEnabled(false);
		sm.patternText.setEnabled(false);
		sm.radioButtonExecuteQueryJava.setEnabled(true);
		sm.radioButtonExecuteQueryOCL.setEnabled(true);
		sm.radioButtonExecuteQueryJava.setSelection(false);
		sm.radioButtonExecuteQueryOCL.setSelection(false);
		sm.radioButtonDisplayQueryJava.setEnabled(false);
		sm.radioButtonDisplayQueryOCL.setEnabled(false);
		//sm.stateMachineText.setText(currentStateExecute.toString());
		
	}
	public void state_PSEUDOSTATE1(){
		currentStateExecute = states_execute.PSEUDOSTATE1;
		// isNotColumnZero
			if (isNotColumnZero ()) {
				state_PSEUDOSTATE2 () ;
			}
			// isColumnZero
			if (isColumnZero ()) {
				state_NO_SELECTION () ;
			}
	}
	public void state_COLUMN__EXECUTE_OCL(){
		currentStateExecute = states_execute.COLUMN__EXECUTE_OCL;
		sm.radioButtonExecuteQueryJava.setSelection(false);
		sm.radioButtonExecuteQueryJava.setEnabled(true);
		sm.radioButtonExecuteQueryOCL.setSelection(true);
		sm.radioButtonExecuteQueryOCL.setEnabled(true);
		sm.radioButtonDisplayQueryJava.setEnabled(false);
		sm.radioButtonDisplayQueryOCL.setEnabled(false);
		sm.radioButtonDisplayQueryJava.setSelection(false);
		sm.radioButtonDisplayQueryOCL.setSelection(false);
		sm.buttonAddColumn.setEnabled(true);
		sm.buttonRemoveColumn.setEnabled(true);
		sm.executeQueryJavaCombo.setEnabled(false);
		sm.executeQueryJavaCombo.deselectAll();
		sm.executeQueryOCLText.setEnabled(true);
		sm.contextCombo.setEnabled(true);
		sm.queryAddButton.setEnabled(true);
		sm.queryDeleteButton.setEnabled(false);
		sm.displayQueryJavaCombo.setEnabled(false);
		sm.displayQueryOCLText.setEnabled(false);
		sm.patternText.setEnabled(true);
		//sm.stateMachineText.setText(currentStateExecute.toString());
		
	}
	public void state_DISPLAY_EDIT__COLUMN__DISPLAY_JAVA(){
		currentStateExecute = states_execute.DISPLAY_EDIT__COLUMN__DISPLAY_JAVA;
		sm.buttonAddColumn.setEnabled(true);
		sm.buttonRemoveColumn.setEnabled(true);
		sm.contextCombo.setEnabled(true);
		sm.queryAddButton.setEnabled(true);
		sm.queryDeleteButton.setEnabled(true);
		sm.displayQueryJavaCombo.setEnabled(true);
		sm.displayQueryOCLText.setEnabled(false);
		sm.displayQueryOCLText.setText("");
		sm.patternText.setEnabled(true);
		sm.radioButtonDisplayQueryJava.setSelection(true);
		sm.radioButtonDisplayQueryOCL.setSelection(false);
		sm.radioButtonExecuteQueryJava.setEnabled(false);
		sm.radioButtonExecuteQueryOCL.setEnabled(false);
		sm.executeQueryJavaCombo.setEnabled(false);
		sm.executeQueryOCLText.setEnabled(false);
		sm.contextCombo.setEnabled(false);
		sm.queryUpButton.setEnabled(true);
		sm.queryDownButton.setEnabled(true);
		//sm.stateMachineText.setText(currentStateExecute.toString());
		
	}
	public void state_COLUMN__COLUMN_UNSELECTED(){
		currentStateExecute = states_execute.COLUMN__COLUMN_UNSELECTED;
		sm.buttonAddColumn.setEnabled(true);
		sm.buttonRemoveColumn.setEnabled(false);
		sm.executeQueryJavaCombo.setEnabled(false);
		sm.executeQueryOCLText.setEnabled(false);
		sm.contextCombo.setEnabled(false);
		sm.contextCombo.deselectAll();
		sm.queryAddButton.setEnabled(false);
		sm.queryDeleteButton.setEnabled(false);
		sm.displayQueryJavaCombo.setEnabled(false);
		sm.displayQueryOCLText.setEnabled(false);
		sm.patternText.setEnabled(false);
		sm.radioButtonExecuteQueryJava.setEnabled(false);
		sm.radioButtonExecuteQueryOCL.setEnabled(false);
		sm.radioButtonExecuteQueryJava.setSelection(false);
		sm.radioButtonExecuteQueryOCL.setSelection(false);
		//sm.stateMachineText.setText(currentStateExecute.toString());
		
	}
	public void state_DISPLAY_EDIT__COLUMN__COLUMN_SELECTED(){
		currentStateExecute = states_execute.DISPLAY_EDIT__COLUMN__COLUMN_SELECTED;
		
		
	}
	public void state_COLUMN__EXECUTE_JAVA(){
		currentStateExecute = states_execute.COLUMN__EXECUTE_JAVA;
		sm.radioButtonExecuteQueryOCL.setSelection(false);
		sm.radioButtonExecuteQueryJava.setSelection(true);
		sm.radioButtonExecuteQueryOCL.setEnabled(true);
		sm.radioButtonExecuteQueryJava.setEnabled(true);
		sm.radioButtonDisplayQueryJava.setEnabled(false);
		sm.radioButtonDisplayQueryOCL.setEnabled(true);
		sm.radioButtonDisplayQueryJava.setSelection(false);
		sm.radioButtonDisplayQueryOCL.setSelection(false);
		sm.buttonAddColumn.setEnabled(true);
		sm.buttonRemoveColumn.setEnabled(true);
		sm.executeQueryJavaCombo.setEnabled(true);
		sm.executeQueryOCLText.setEnabled(false);
		sm.executeQueryOCLText.setText("");
		sm.contextCombo.setEnabled(true);
		sm.queryAddButton.setEnabled(true);
		sm.queryDeleteButton.setEnabled(false);
		sm.displayQueryJavaCombo.setEnabled(false);
		sm.displayQueryOCLText.setEnabled(false);
		sm.patternText.setEnabled(true);
		//sm.stateMachineText.setText(currentStateExecute.toString());
		
	}
	public void state_COLUMN(){
		currentStateExecute = states_execute.COLUMN;
		//sm.stateMachineText.setText(currentStateExecute.toString());
			state_COLUMN__INITIALNODE () ;
		
	}
	public void state_COLUMN__DISPLAY_EDIT(){
		currentStateExecute = states_execute.COLUMN__DISPLAY_EDIT;
		sm.buttonAddColumn.setEnabled(true);
		sm.buttonRemoveColumn.setEnabled(false);
		sm.executeQueryJavaCombo.setEnabled(true);
		sm.executeQueryOCLText.setEnabled(true);
		sm.contextCombo.setEnabled(true);
		sm.queryAddButton.setEnabled(true);
		sm.queryDeleteButton.setEnabled(true);
		sm.displayQueryJavaCombo.setEnabled(true);
		sm.displayQueryOCLText.setEnabled(true);
		sm.patternText.setEnabled(true);
		//sm.stateMachineText.setText(currentStateExecute.toString());
			state_DISPLAY_EDIT__COLUMN__INITIALNODE () ;
		
	}
	public void state_FINISH(){
		currentStateExecute = states_execute.FINISH;
		
		
	}

	public boolean isColumnZero(){
		int indexC=sm.table.getItemCount();
		sm.executeQueryOCLText.setText("");
		sm.executeQueryJavaCombo.deselectAll();
		return(indexC==0);
	}
	public boolean isNotColumnZero(){
		int indexC=sm.table.getItemCount();
		sm.executeQueryOCLText.setText("");
		sm.executeQueryJavaCombo.deselectAll();
		return(indexC!=0);
	}
	public boolean addDisplayQuerys(){
		int indexC=sm.table.getItemCount();
				return(indexC==0);
	}
	public boolean radioButtonExecuteJava(){
		int indexC=sm.table.getItemCount();
				return(indexC==0);
	}
	public boolean radioButtonExecuteOCL(){
		int indexC=sm.table.getItemCount();
				return(indexC==0);
	}
	public boolean radioButtonDisplayOCL(){
		int indexC=sm.table.getItemCount();
				return(indexC==0);
	}
	public boolean radioButtonDisplayJava(){
		int indexC=sm.table.getItemCount();
				return(indexC==0);
	}



}	