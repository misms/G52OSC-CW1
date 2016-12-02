package application;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;

public abstract class Result {

    @FXML
    Text request_result = new Text();
    @FXML
    Text movement_result = new Text();
    @FXML
    ProgressBar progress_bar = new ProgressBar();
    @FXML
    Text progress_percentage = new Text();

    void set(Disk disk,int[] request, int movement){
        request_result.setText(Arrays.toString(request));
        movement_result.setText(String.valueOf(movement));
        progress_bar.setProgress(calculate(disk,request,movement));
    }

    double calculate(Disk disk,int[] request ,int movement){
        float avg = (float) movement/request.length;
        float percent = (avg/(disk.cylinder-1));
        progress_percentage.setText(String.valueOf(percent*100 + "%"));

        for(int i = 0; i < request.length ; i++)
            System.out.print(request[i] + " ");
        System.out.println("");
        System.out.println("Average: " + avg);
        System.out.println("Disk Load: "+percent*100+"%");
        return percent;
    }

}
