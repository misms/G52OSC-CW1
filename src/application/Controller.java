package application;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.StringTokenizer;


public class Controller extends FCFS implements Initializable {

	final String[] algorithms = {"FCFS","SSTF","SCAN","CSCAN","LOOK","CLOOK"};
    //Combo Box -> Algorithms
	private ObservableList<String> algorithm_list = FXCollections.observableArrayList("FCFS","SSTF","SCAN","CSCAN","LOOK","CLOOK");
	int sel = 0;

    @FXML
    TextField current_pos = new TextField();
    @FXML
    TextField cylinder_size = new TextField();
    @FXML
    TextField num_request = new TextField();
    @FXML
    TextField request = new TextField();
	@FXML
	ComboBox algobox = new ComboBox();
	@FXML
	LineChart<String,Number> lineChart;

	/**
     * Set requestARRAY size
     * Get String from request textfield
     * Set token "," and parse Integer into requestARRAY for initialization
     * Call Disk constructor and intialize all variables
     * Select algorithms
     * @throws IOException
     */

	@FXML
	public void simulate() throws IOException, NumberFormatException {
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
			graphing(disk1);
		}catch(NumberFormatException e){
			Alert.display("Alert","Please use integer and comma specified only!");
		}catch(ArrayIndexOutOfBoundsException e){
			Alert.display("Alert","Please increase number of request !\nIt does not match request list");
		}
	}

	private void select_algorithms(Disk disk) {

        if(algobox.getValue() == "FCFS"){
			sel = 1;
			fcfs(disk);
		}
		if(algobox.getValue() == "SSTF"){
			sel = 2;
			sstf(disk);
		}
		if(algobox.getValue() == "SCAN"){
			sel = 3;
			scan(disk);
		}
		if(algobox.getValue() == "CSCAN"){
			sel = 4;
			cscan(disk);
		}
		if(algobox.getValue() == "LOOK"){
			sel = 5;
			look(disk);
		}
		if(algobox.getValue() == "CLOOK"){
			sel = 6;
			clook(disk);

		}
        for (int i = 0; i < 6; i++) {
            if (algobox.getValue() == algorithms[i]) {
                sel = i + 1;
            }
        }

        switch (sel) {
            case 1:
                fcfs(disk);
                break;

            case 2:
                sstf(disk);
                break;

            case 3:
                scan(disk);
                break;

            case 4:
                cscan(disk);
                break;

            case 5:
                look(disk);
                break;

            case 6:
                clook(disk);
                break;
        }
    }

	private void graphing(Disk disk){
		lineChart.getData().clear();
		XYChart.Series<String,Number> series = new XYChart.Series <String,Number>();
		for(int i = 0 ; i < disk.request.length ; i++){
			series.getData().add(new XYChart.Data<String,Number>(Integer.toString(i),disk.request[i]));
		}
		for(int i = 0 ; i < algorithms.length ; i++){
			if(algobox.getValue() == algorithms[i])
				series.setName(algorithms[i]);
		}
		lineChart.getData().add(series);

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Initialize combo box with algorithms
           algobox.setItems(algorithm_list);
	}
}
