package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.creatures.Creature;
import models.enclosures.Enclosure;
import models.enclosures.biomes.Aquarium;
import models.enclosures.biomes.Aviary;
import models.enclosures.biomes.Terrestrial;

public class BuyEnclosureModalController {

    @FXML
    private ChoiceBox<String> enclosureTypeChoiceBox;

    @FXML
    private TextField nameField;

    private int location;
    private ZooVueController parentController;

    @FXML
    public void initialize() {
        enclosureTypeChoiceBox.setItems(FXCollections.observableArrayList("Aquarium", "Aviary", "Terrestrial"));
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setParentController(ZooVueController parentController) {
        this.parentController = parentController;
    }

    @FXML
    public void buyEnclosure() {
        String selectedType = enclosureTypeChoiceBox.getValue();
        String name = nameField.getText();
        int surface = 10;
        int maxAnimal = 5;
        int cleanliness = 100;
        int aquariumPrice = 1000;
        int aviaryPrice = 1000;
        int terrestrialPrice = 1000;
        int aquariumMaintenancePrice = 200;
        int aviaryMaintenancePrice = 200;
        int terrestrialMaintenancePrice = 200;
        int aviaryHeight = 3;
        int aquariumDepth = 3;
        int aquariumSalinity = 5;

        Enclosure enclosure = null;

        switch (selectedType) {
            case "Aquarium":
                enclosure = new Aquarium(location, name, surface, maxAnimal, new Creature[0], cleanliness, aquariumPrice, aquariumPrice/2, aquariumMaintenancePrice, aquariumDepth, aquariumSalinity);
                break;
            case "Aviary":
                enclosure = new Aviary(location, name, surface, maxAnimal, new Creature[0], cleanliness, aviaryPrice, aviaryPrice/2, aviaryMaintenancePrice, aviaryHeight);
                break;
            case "Terrestrial":
                enclosure = new Terrestrial(location, name, surface, maxAnimal, new Creature[0], cleanliness, terrestrialPrice, terrestrialPrice/2, terrestrialMaintenancePrice);
                break;
        }

        if (enclosure != null) {
            parentController.addEnclosure(location, enclosure);
            Stage stage = (Stage) enclosureTypeChoiceBox.getScene().getWindow();
            stage.close();
        }
    }
}
