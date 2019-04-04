package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import messages.ShowUpdateMsgPacker;


public class FrontEndController{

	private ShowUpdateMsgPacker showUpdateMsgPacker;
	
	
	private TreeItem<String> showsMainRoot;
	private TreeItem<String> merchMainRoot;


	@FXML
	private Button addShowButton;
	

	public FrontEndController() {
		showUpdateMsgPacker = new ShowUpdateMsgPacker();
	}

	public void initializeData() {

	}
	
	@FXML
	protected void handleButtonActions(ActionEvent event) {
		if (event.getSource().equals(addShowButton)) {
			//TODO: Get this data from the GUI
			String showDate  = "DATE";
			String venueName = "VENUE";
			String location  = "LOCATION";
			showUpdateMsgPacker.sendMsg(showDate, venueName, location);
		}
	}

}
