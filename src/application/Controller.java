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
import javax.swing.text.DocumentFilter;


public class Controller extends Algorithms implements Initializable {

    //Combo Box -> Algorithms
	private ObservableList<String> algorithm_list = FXCollections.observableArrayList("FCFS","SSTF","SCAN","CSCAN","LOOK","CLOOK");


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

	/**
     * Set requestARRAY size
     * Get String from request textfield
     * Set token "," and parse Integer into requestARRAY for initialization
     * Call Disk constructor and intialize all variables
     * Select algorithms
     * @throws IOException
     */

	@FXML
	public void simulate() throws IOException {
        int x = 0;

		try {
			int[] requestARRAY = new int[Integer.parseInt(num_request.getText())];
			StringTokenizer str = new StringTokenizer(request.getText(), ",");
			while (str.hasMoreTokens()) {
				requestARRAY[x] = Integer.parseInt(str.nextToken());
				x++;
			}
			Disk disk1 = new Disk(Integer.parseInt(cylinder_size.getText()),
					Integer.parseInt(current_pos.getText()),
					Integer.parseInt(num_request.getText()),
					requestARRAY);
			select_algorithms(disk1);
		}catch(NumberFormatException e){
			Alert.display("Alert","Please use integer and comma specified only!");
		}
	}


	private void select_algorithms(Disk disk){
		int sel = 0;

        if(algobox.getValue() == "FCFS")
		    fcfs(disk);

		if(algobox.getValue() == "SSTF")
			sstf(disk);

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
		//Initialize combo box with algorithms
        algobox.setItems(algorithm_list);
	}
}
