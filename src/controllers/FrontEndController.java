package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
	
	@FXML
	private Button removeShowButton;
	
	@FXML
	private TreeView<String> showsTreeView;
	
	@FXML
	private DatePicker showDatePicker;
	
	@FXML
	private TextField showVenueTextField;
	
	@FXML
	private TextField showLocationTextField;
	

	public FrontEndController() {
		showUpdateMsgPacker = new ShowUpdateMsgPacker();
	}

	public void initializeData() {
		//TODO: Query the Database to get current data
		//TODO: Populate GUI with current data
		createShowsTree();
	}
	
	@FXML
	protected void handleButtonActions(ActionEvent event) {
		if (event.getSource().equals(addShowButton)) {
			//TODO: Get this data from the GUI
			String showDate  = null;
			String venueName = null;
			String location  = null;
			
			showDate  = showDatePicker.getValue().toString();
			venueName = showVenueTextField.getText();
			location  = showLocationTextField.getText();
			
			System.out.println(showDate);
			System.out.println(venueName);
			System.out.println(location);
			
			if ((showDate != null) && (venueName != null) && (location != null)) {
				//showUpdateMsgPacker.sendMsg(showDate, venueName, location);
			}
			
			//TODO: Query database and update the tree
			
		}
		else if (event.getSource().equals(removeShowButton)) {
			showsMainRoot.getChildren().remove(showsTreeView.getSelectionModel().getSelectedItem());	
		}
	}
	
	private void createShowsTree() {
		showsMainRoot = new TreeItem<String>("All Current Shows");
		showsMainRoot.setExpanded(true);
		showsTreeView.setRoot(showsMainRoot);
	}

}
