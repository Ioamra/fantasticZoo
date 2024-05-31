package controllers.modals;

import config.Constants;
import controllers.views.ZooVueController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    	enclosureTypeChoiceBox.getItems().addAll("Aquarium", "Volière", "Terrestre");
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
            	if (Constants.Enclosure.Aquarium.PRICE > this.zooVueController.getZoo().getMaster().getMoney()) {
            		Alert alert = new Alert(AlertType.WARNING);
        	        alert.setTitle("Erreur");
                	alert.setHeaderText(null);
        	        alert.setContentText("Vous n'avez pas assez d'argent.");
        	        alert.showAndWait();
        	        return;
            	}
                enclosure = new Aquarium(
            		location, 
            		name, 
            		Constants.Enclosure.Aquarium.SURFACE_LVL_1, 
            		Constants.Enclosure.MAX_CLEANLINESS, 
            		Constants.Enclosure.Aquarium.DEPTH_LVL_1, 
            		Constants.Enclosure.Aquarium.INITIAL_SALINITY
                );
                this.zooVueController.addInConsole("L'aquarium " + name + " à été acheté pour " + Constants.Enclosure.Aquarium.PRICE + " $.");
                this.zooVueController.getZoo().getMaster().spendMoney(Constants.Enclosure.Aquarium.PRICE);
                break;
            case "Volière":
            	if (Constants.Enclosure.Aviary.PRICE > this.zooVueController.getZoo().getMaster().getMoney()) {
            		Alert alert = new Alert(AlertType.WARNING);
        	        alert.setTitle("Erreur");
                	alert.setHeaderText(null);
        	        alert.setContentText("Vous n'avez pas assez d'argent.");
        	        alert.showAndWait();
        	        return;
            	}
                enclosure = new Aviary(
            		location, 
            		name, 
            		Constants.Enclosure.Aviary.SURFACE_LVL_1, 
            		Constants.Enclosure.MAX_CLEANLINESS, 
            		Constants.Enclosure.Aviary.HEIGHT_LVL_1
                );
                this.zooVueController.addInConsole("La volière " + name + " à été acheté pour " + Constants.Enclosure.Aviary.PRICE + " $.");
                this.zooVueController.getZoo().getMaster().spendMoney(Constants.Enclosure.Aviary.PRICE);
                break;
            case "Terrestre":
            	if (Constants.Enclosure.Terrestrial.PRICE > this.zooVueController.getZoo().getMaster().getMoney()) {
            		Alert alert = new Alert(AlertType.WARNING);
        	        alert.setTitle("Erreur");
                	alert.setHeaderText(null);
        	        alert.setContentText("Vous n'avez pas assez d'argent.");
        	        alert.showAndWait();
        	        return;
            	}
                enclosure = new Terrestrial(
                	location, 
                	name, 
                	Constants.Enclosure.Terrestrial.SURFACE_LVL_1, 
                	Constants.Enclosure.MAX_CLEANLINESS
                );
                this.zooVueController.addInConsole("L'enclos terrestre " + name + " à été acheté pour " + Constants.Enclosure.Terrestrial.PRICE + " $.");
                this.zooVueController.getZoo().getMaster().spendMoney(Constants.Enclosure.Terrestrial.PRICE);
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
