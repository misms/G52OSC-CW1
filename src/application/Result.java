package application;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public abstract class Result {

    @FXML
    Text request_result = new Text();
    @FXML
    Text movement_result = new Text();

    void set(int[] request, int movement){
        request_result.setText(Arrays.toString(request));
        movement_result.setText(String.valueOf(movement));
    }
}
