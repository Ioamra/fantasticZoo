package controllers.modals;

import config.Constants;
import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.enclosures.Enclosure;

/**
 * Controller class for the feed enclosure modal window.
 * Allows users to feed all creatures in the enclosure or cancel the feeding process.
 */
public class FeedEnclosureModalController {
	@FXML
	private AnchorPane anchorPane;
	
	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;


	/**
	 * Feeds all creatures in the enclosure.
	 */
	@FXML
	public void feedAllCreatures() {
		if (Constants.Enclosure.FEED_PRICE > this.enclosureVueController.getZoo().getMaster().getMoney()) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Erreur");
			alert.setHeaderText(null);
			alert.setContentText("Vous n'avez pas assez d'argent.");
			alert.showAndWait();
			return;
		}
		this.enclosureVueController.addInConsole("Les créatures on été nourri pour " + Constants.Enclosure.FEED_PRICE + " $." );
		this.enclosure.feedAll();
		this.enclosureVueController.setEnclosure(this.enclosure);
		this.enclosureVueController.updateData();
		Stage stage = (Stage) anchorPane.getScene().getWindow();
		stage.close();
		
	}
	
	/**
	 * Cancels the feeding process for the enclosure.
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
