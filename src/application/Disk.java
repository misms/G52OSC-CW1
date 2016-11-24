package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.lang.reflect.InvocationTargetException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javax.security.auth.login.Configuration;

public class Disk extends Application {

    static int cylinder;
    static int startPos;
    static int numberOfRequest;
    static int[] request;


    public Disk(){

    }

    public Disk(int size, int position,int numOfReq,int[] request_array) {
        cylinder = size;
        startPos = position;
        numberOfRequest = numOfReq;
        request = new int[numOfReq];
        request = request_array;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
            Scene scene = new Scene(root, 450, 550);
            primaryStage.setTitle("Disk Scheduling");
            primaryStage.setScene(scene);
            primaryStage.show();
    }
	
	public static void main(String[] args)
    {
		launch(args);
	}



}
