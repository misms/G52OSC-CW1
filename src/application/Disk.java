package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Disk extends Application {

    int cylinder;
    int startPos;
    int numberOfRequest;
    int[] request;

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
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
            Scene scene = new Scene(root, 1000, 600);
            scene.getStylesheets().add("/application/application.css");
            primaryStage.setTitle("Disk Scheduling");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	public static void main(String[] args)
    {
        launch(args);
	}



}
