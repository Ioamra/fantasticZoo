package controllers.modals;

import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.enclosures.Enclosure;
	
/**
 * Controller class for the modal to sell a creature.
 */
public class SellCreatureModalController {
	@FXML
	private AnchorPane anchorPane;
	
	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;

	@FXML
	private Text ageValue;
	@FXML
	private Text nameValue;

	/**
	 * Initializes the data for the sell creature modal.
	 */
	public void initData() {
		
	}
	
	/**
	 * Handles the process of selling a creature.
	 */
	@FXML
	public void handleSellCreature() {
		
	}
	
	/**
	 * Cancels the process of selling a creature.
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
