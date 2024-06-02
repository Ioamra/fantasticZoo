package controllers.modals;

import config.Constants;
import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.enclosures.Enclosure;

/**
 * Controller class for the heal enclosure modal window.
 * Allows users to heal all creatures in the enclosure or cancel the healing process.
 */
public class HealEnclosureModalController {
	@FXML
	private AnchorPane anchorPane;
	
	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;

	/**
	 * Heals all creatures in the enclosure.
	 */
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

	/**
	 * Cancels the healing process for the enclosure.
	 */
	@FXML
	public void cancel() {
		Stage stage = (Stage) anchorPane.getScene().getWindow();
	    stage.close();
	}

	/**
	 * Sets the enclosure for this controller.
	 *
	 * @param enclosure The enclosure to be set.
	 */
	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}

	/**
	 * Sets the enclosure view controller for this controller.
	 *
	 * @param enclosureVueController The enclosure view controller to be set.
	 */
	public void setEnclosureVueController(EnclosureVueController enclosureVueController) {
		this.enclosureVueController = enclosureVueController;
	}
}
