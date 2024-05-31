package controllers.views;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
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
    private TextField zooName;

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
            zooController.initMasterAndZoo(zooName.getText(), master);

            Stage stage = (Stage) playerNameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un âge valide.");
        }
    }
}
