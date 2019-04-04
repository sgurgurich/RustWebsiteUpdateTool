package application;

import controllers.FrontEndController;
import data.InternalDataManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	FrontEndController myController;
	
	@Override
	public void start(Stage primaryStage) {
		try {
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("siteEditor.fxml"));
		    Parent root = loader.load();

		    myController = loader.getController();
		    
		    //Set Data to FXML through controller
		    myController.initializeData();
		  
		    InternalDataManager.getInstance();
		    
		    Scene scene = new Scene(root);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("Rust N' Stardust Site Update Tool");
		    primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
