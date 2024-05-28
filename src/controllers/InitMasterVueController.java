package controllers;

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

public class InitMasterVueController implements Initializable {

    @FXML
    private TextField playerNameField;
    
    @FXML
    private TextField ageField;
    
    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the ChoiceBox with gender options
        ObservableList<String> genderOptions = FXCollections.observableArrayList("M", "F");
        genderChoiceBox.setItems(genderOptions);
    }

    @FXML
    private void initializeMaster() {
        try {
            String playerName = playerNameField.getText();
            int age = Integer.parseInt(ageField.getText());
            Master.Gender gender = Master.Gender.valueOf(genderChoiceBox.getValue());
            int money = 10000;

            Master master = new Master(playerName, age, gender, money);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ZooVue.fxml"));
            Parent root = loader.load();

            ZooVueController zooController = loader.getController();
            zooController.initMasterAndZoo(master);

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
