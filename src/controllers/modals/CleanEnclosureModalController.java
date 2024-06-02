package controllers.modals;

import config.Constants;
import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.enclosures.Enclosure;

/**
 * Controller class for the clean enclosure modal window.
 * Allows users to confirm or cancel the cleaning process for an enclosure.
 */
public class CleanEnclosureModalController {
	@FXML
	private AnchorPane anchorPane;
	
	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;

	/**
	 * Confirms the cleaning process for the enclosure.
	 */
	@FXML
	public void confirmCleaning() {
		if (Constants.Enclosure.CLEAN_PRICE > this.enclosureVueController.getZoo().getMaster().getMoney()) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Erreur");
			alert.setHeaderText(null);
			alert.setContentText("Vous n'avez pas assez d'argent.");
			alert.showAndWait();
			return;
		}
		this.enclosureVueController.addInConsole("L'enclos à été nettoyé pour " + Constants.Enclosure.CLEAN_PRICE + " $." );
		this.enclosure.clean();
		this.enclosureVueController.setEnclosure(this.enclosure);
		this.enclosureVueController.updateData();
		Stage stage = (Stage) anchorPane.getScene().getWindow();
		stage.close();
	}

	/**
	 * Cancels the cleaning process for the enclosure.
	 */
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
