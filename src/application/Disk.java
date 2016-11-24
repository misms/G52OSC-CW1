package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.lang.reflect.InvocationTargetException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javax.security.auth.login.Configuration;

public class Disk extends Application {

    int cylinder;
    int startPos;
    int numberOfRequest;
    int[] request;

    @FXML
    Button simulate_button = new Button();

    public Disk(){
    }

    /**
     * Initialize all variables
     * @param size Cylinder size
     * @param position Current header position
     * @param numOfReq Number of requests
     * @param request_array All requests
     */
    public Disk(int size, int position,int numOfReq,int[] request_array) {
        cylinder = size;
        startPos = position;
        numberOfRequest = numOfReq;
        request = new int[numOfReq];
        request = request_array;
    }

    //Set scene size and title
    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
            Scene scene = new Scene(root, 470, 700);
            scene.getStylesheets().add("/application/application.css");
            primaryStage.setTitle("Disk Scheduling");
            primaryStage.setScene(scene);
            primaryStage.show();
    }


	
	public static void main(String[] args)
    {
		launch(args);
	}



}
