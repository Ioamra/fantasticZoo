package controllers.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class TutoVueController {
	@FXML
	private Button button;
	
	@FXML
	void GoToZooVue(ActionEvent event) {
	    try {
	        Parent root = FXMLLoader.load(getClass().getResource("/layouts/views/InitMasterVue.fxml"));
	        Scene scene = button.getScene();
	        scene.setRoot(root);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
