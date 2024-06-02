package controllers.modals;

import config.Constants;
import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.enclosures.Enclosure;

public class HealEnclosureModalController {
	@FXML
	private AnchorPane anchorPane;
	
	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;
	


	@FXML
	public void healAllCreatures() {
		if (Constants.Enclosure.HEAL_PRICE > this.enclosureVueController.getZoo().getMaster().getMoney()) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Erreur");
			alert.setHeaderText(null);
			alert.setContentText("Vous n'avez pas assez d'argent.");
			alert.showAndWait();
			return;
		}
		this.enclosureVueController.addInConsole("Les créatures on été soigné pour " + Constants.Enclosure.HEAL_PRICE + " $." );
		this.enclosure.healAll();
		this.enclosureVueController.setEnclosure(this.enclosure);
		this.enclosureVueController.updateData();
		Stage stage = (Stage) anchorPane.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) anchorPane.getScene().getWindow();
	    stage.close();
	}

	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}
	
	public void setEnclosureVueController(EnclosureVueController enclosureVueController) {
		this.enclosureVueController = enclosureVueController;
	}
}
