

package ua.budenkov.learnWorldEasy;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class learnWorldEasy extends Application {

	public static void main(String[] args) {
			
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		primaryStage.setTitle("Learn word easy");
	    primaryStage.setWidth(500);
	    primaryStage.setHeight(600);
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(getClass().getResource("/mainMaket.fxml"));
	    Scene scene= new Scene(loader.load());
	    scene.getStylesheets().add(getClass().getResource("/mainMaket.css").toExternalForm());
	    primaryStage.setScene(scene);
	    
	    //Label helloWorldLabel = new Label("Hello world!");
	    //helloWorldLabel.setAlignment(Pos.CENTER);
	    //Scene primaryScene = new Scene(helloWorldLabel);
	    //primaryStage.setScene(primaryScene);	    
//		
	    
	    primaryStage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
