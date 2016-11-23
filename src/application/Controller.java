package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class Controller implements Initializable {

	@FXML
	private Button simulate_button;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert simulate_button != null :"fx:id=\"simulate_button\" was not injected: check your FXML file 'sample.fxml'.";
	}
}
