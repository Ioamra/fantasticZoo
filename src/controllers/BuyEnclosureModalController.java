package controllers;

import config.Constants;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    	enclosureTypeChoiceBox.getItems().addAll("Aquarium", "Aviary", "Terrestrial");
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

        Enclosure enclosure = null;

        switch (selectedType) {
            case "Aquarium":
                enclosure = new Aquarium(
            		location, 
            		name, 
            		Constants.Enclosure.Aquarium.SURFACE_LVL_1, 
            		Constants.Enclosure.MAX_CLEANLINESS, 
            		Constants.Enclosure.Aquarium.INITIAL_DEPTH, 
            		Constants.Enclosure.Aquarium.INITIAL_SALINITY
                );
                break;
            case "Aviary":
                enclosure = new Aviary(
            		location, 
            		name, 
            		Constants.Enclosure.Aviary.SURFACE_LVL_1, 
            		Constants.Enclosure.MAX_CLEANLINESS, 
            		Constants.Enclosure.Aviary.INITIAL_HEIGHT
                );
                break;
            case "Terrestrial":
                enclosure = new Terrestrial(
                	location, 
                	name, 
                	Constants.Enclosure.Terrestrial.SURFACE_LVL_1, 
                	Constants.Enclosure.MAX_CLEANLINESS
                );
                break;
        }

        if (enclosure != null) {
            parentController.addEnclosure(location, enclosure);
            Stage stage = (Stage) enclosureTypeChoiceBox.getScene().getWindow();
            stage.close();
        }
    }
}
