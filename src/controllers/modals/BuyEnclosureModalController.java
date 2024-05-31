package controllers.modals;

import config.Constants;
import controllers.views.ZooVueController;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.enclosures.Enclosure;
import models.enclosures.biomes.Aquarium;
import models.enclosures.biomes.Aviary;
import models.enclosures.biomes.Terrestrial;

public class BuyEnclosureModalController {
	@FXML
	private AnchorPane anchorPane;
    @FXML
    private ChoiceBox<String> enclosureTypeChoiceBox;
    @FXML
    private TextField nameField;

    private int location;
    private ZooVueController zooVueController;

    @FXML
    public void initialize() {
    	enclosureTypeChoiceBox.getItems().addAll("Aquarium", "Aviary", "Terrestrial");
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setZooVueController(ZooVueController zooVueController) {
        this.zooVueController = zooVueController;
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
            		Constants.Enclosure.Aquarium.DEPTH_LVL_1, 
            		Constants.Enclosure.Aquarium.INITIAL_SALINITY
                );
                break;
            case "Aviary":
                enclosure = new Aviary(
            		location, 
            		name, 
            		Constants.Enclosure.Aviary.SURFACE_LVL_1, 
            		Constants.Enclosure.MAX_CLEANLINESS, 
            		Constants.Enclosure.Aviary.HEIGHT_LVL_1
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
        	this.zooVueController.updateEnclosure(enclosure);
            Stage stage = (Stage) enclosureTypeChoiceBox.getScene().getWindow();
            stage.close();
        }
    }

	@FXML
	public void cancel() {
		Stage stage = (Stage) anchorPane.getScene().getWindow();
	    stage.close();
	}
}
