package application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 400, 550);
        primaryStage.setTitle("Disk Scheduling");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
}
