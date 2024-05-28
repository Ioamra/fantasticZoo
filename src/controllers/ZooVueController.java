package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
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
import models.enclosures.biomes.Aquarium;
import models.enclosures.biomes.Aviary;
import models.enclosures.biomes.Terrestrial;
import models.enclosures.biomes.UndefinedEnclosure;
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

    private int nbEnclosure = 9;
    private int dayCounter = 1;
    private Zoo zoo;

    @FXML
    private void initialize() {
        dayLabel.setText("Jour " + dayCounter);
    }

    @FXML
    void handleNextDayButton() {
        dayCounter++;
        dayLabel.setText("Jour " + dayCounter);
    }
    
    @FXML
    private void handleEnclosureClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        Pane parentPane = (Pane) clickedButton.getParent();
        int location = Integer.parseInt(parentPane.getId().replace("enclosure", "")) - 1;
        Enclosure enclosure = zoo.getEnclosureList()[location];
        if (enclosure instanceof UndefinedEnclosure) {
            openBuyEnclosureModal(location);
        } else {
            // Logique pour l'enclos existant, si nécessaire
        }
    }
    
    public void initMasterAndZoo(Master master) {
        Enclosure[] enclosures = new Enclosure[nbEnclosure];
        for (int i = 0; i < nbEnclosure; i++) {
            enclosures[i] = new UndefinedEnclosure(i + 1);
        }
        this.zoo = new Zoo("Fantastic Zoo", master, nbEnclosure, enclosures);
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
        Text text = (Text) enclosurePane.getChildren().get(0);
        if (zoo.getEnclosureList()[location] instanceof UndefinedEnclosure) {
            text.setText("Emplacement d'enclos");
        } else if (zoo.getEnclosureList()[location] instanceof Aviary) {
            text.setText("Aviary "+zoo.getEnclosureList()[location].getName());
        } else if (zoo.getEnclosureList()[location] instanceof Terrestrial) {
        	text.setText("Terrestrial "+zoo.getEnclosureList()[location].getName());
        } else if (zoo.getEnclosureList()[location] instanceof Aquarium) {
        	text.setText("Aquarium "+zoo.getEnclosureList()[location].getName());
        }
    }
}
