package controllers.views;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.master.Master;

import java.net.URL;
import java.util.ResourceBundle;

import config.Constants;

public class InitMasterVueController implements Initializable {

    @FXML
    private TextField playerNameField;
    @FXML
    private TextField ageField;
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    @FXML
    private TextField zooNameField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderChoiceBox.getItems().addAll("Homme", "Femme");
        genderChoiceBox.setValue("Homme");
    }

    @FXML
    private void initializeMaster() {
        try {
            String playerName = playerNameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String zooName = zooNameField.getText();
            
            if (playerName == null || playerName.trim().isEmpty()) {
            	Alert alert = new Alert(AlertType.WARNING);
    	        alert.setTitle("Erreur");
    			alert.setHeaderText(null);
    	        alert.setContentText("Veuillez entrer un nom valide.");
    	        alert.showAndWait();
    	        return;
            }
            if (zooName == null || zooName.trim().isEmpty()) {
            	Alert alert = new Alert(AlertType.WARNING);
    	        alert.setTitle("Erreur");
    			alert.setHeaderText(null);
    	        alert.setContentText("Veuillez entrer un nom de zoo valide.");
    	        alert.showAndWait();
    	        return;
            }
            
            Master.Gender gender;
            if (genderChoiceBox.getValue() == "Homme") {
            	gender = Master.Gender.valueOf("M");
            } else {
            	gender = Master.Gender.valueOf("F");
            }

            Master master = new Master(playerName, age, gender, Constants.Master.INITIAL_MONEY);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/views/ZooVue.fxml"));
            Parent root = loader.load();

            ZooVueController zooController = loader.getController();
            zooController.initMasterAndZoo(zooName, master);

            Stage stage = (Stage) playerNameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
        	Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Erreur");
			alert.setHeaderText(null);
	        alert.setContentText("Veuillez entrer un âge valide.");
	        alert.showAndWait();
        }
    }
}
