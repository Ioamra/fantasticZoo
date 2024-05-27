package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.enclosures.Enclosure;
import models.master.Master;
import models.zoo.Zoo;

public class ZooVueController {
    @FXML
    private Button nextDayButton;
    @FXML
    private Label dayLabel;
    @FXML
    private Pane enclosure1;
    @FXML
    private Pane enclosure2;
    @FXML
    private Pane enclosure3;
    @FXML
    private Pane enclosure4;
    @FXML
    private Pane enclosure5;
    @FXML
    private Pane enclosure6;
    @FXML
    private Pane enclosure7;
    @FXML
    private Pane enclosure8;
    @FXML
    private Pane enclosure9;

    private int dayCounter = 1;
    private Master master;
    private Zoo zoo;

    @FXML
    private void initialize() {
        // Initialize the label with the starting day
        dayLabel.setText("Jour " + dayCounter);
    }

    @FXML
    void handleNextDayButton() {
        // Increment the day counter
        dayCounter++;

        // Update the label text
        dayLabel.setText("Jour " + dayCounter);
    }
    
    @FXML
    private void handleEnclosureClick(javafx.scene.input.MouseEvent event) {
        Pane clickedEnclosure = (Pane) event.getSource();
        int location = Integer.parseInt(clickedEnclosure.getId().replace("enclosure", "")) - 1;

        if (zoo.getEnclosureList()[location] == null) {
            openBuyEnclosureModal(location);
        } else {
            // Logic for existing enclosure, if needed
        }
    }
    
    public void setMaster(Master master) {
        this.master = master;
    }
    
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
        updateEnclosureStatus();
    }
    
    private void openBuyEnclosureModal(int location) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/BuyEnclosureModal.fxml"));
            Parent root = loader.load();

            BuyEnclosureModalController controller = loader.getController();
            controller.setLocation(location);
            controller.setParentController(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            updateEnclosureStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEnclosure(int location, Enclosure enclosure) {
        zoo.getEnclosureList()[location] = enclosure;
    }

    private void updateEnclosureStatus() {
        updateEnclosureText(enclosure1, 0);
        updateEnclosureText(enclosure2, 1);
        updateEnclosureText(enclosure3, 2);
        updateEnclosureText(enclosure4, 3);
        updateEnclosureText(enclosure5, 4);
        updateEnclosureText(enclosure6, 5);
        updateEnclosureText(enclosure7, 6);
        updateEnclosureText(enclosure8, 7);
        updateEnclosureText(enclosure9, 8);
    }

    private void updateEnclosureText(Pane enclosurePane, int location) {
        Text text = (Text) enclosurePane.getChildren().get(0); // Assuming the Text is the first child of the Pane
        if (zoo.getEnclosureList()[location] != null) {
            text.setText("Enclos existant");
        } else {
            text.setText("Emplacement d'enclos");
        }
    }
}
