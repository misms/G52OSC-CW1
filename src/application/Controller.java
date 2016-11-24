package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import java.util.StringTokenizer;


public class Controller extends Algorithms implements Initializable {

	ObservableList<String> algorithm_list = FXCollections.observableArrayList("FCFS","SSTF","SCAN","CSCAN","LOOK","CLOOK");

    public String requestString;
	@FXML
	private Button simulate_button = new Button();
    @FXML
    TextField current_pos = new TextField();
    @FXML
    TextField cylinder_size = new TextField();
    @FXML
    TextField num_request = new TextField();
    @FXML
    TextField request = new TextField();
	@FXML
	private ComboBox algobox = new ComboBox();


    private int cylinderSIZE;
    private int currentPOS;
    private int numREQUEST;
    private int[] requestARRAY;
    private int selALGORITHM;

	@FXML
	public void simulate() throws IOException {
        int x = 0;
        int[] requestARRAY = new int[Integer.parseInt(num_request.getText())];
        requestString = request.getText().toString();
        StringTokenizer str = new StringTokenizer(requestString,",");
        while(str.hasMoreTokens()) {
            requestARRAY[x] = Integer.parseInt(str.nextToken());
            x++;
        }

        Disk disk1 = new Disk(Integer.parseInt(cylinder_size.getText()),
                Integer.parseInt(current_pos.getText()),
                Integer.parseInt(num_request.getText()),
                requestARRAY);
	    select_algorithms(disk1);
	}

	public void select_algorithms(Disk disk){
		int sel = 0;

        if(algobox.getValue() == "FCFS")
		    fcfs(disk);

		if(algobox.getValue() == "SSTF")
			sel = 2;

		if(algobox.getValue() == "SCAN")
			sel = 3;

		if(algobox.getValue() == "CSCAN")
			sel = 4;

		if(algobox.getValue() == "LOOK")
			sel = 5;

		if(algobox.getValue() == "CLOOK")
			sel = 6;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		algobox.setItems(algorithm_list);
	}
}
