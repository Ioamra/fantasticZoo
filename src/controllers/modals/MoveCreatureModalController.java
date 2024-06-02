package controllers.modals;

import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.enclosures.Enclosure;
	
/**
 * Controller class for the modal to move a creature to another enclosure.
 */
public class MoveCreatureModalController {
	@FXML
	private AnchorPane anchorPane;
	
	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;

	/**
	* Initializes the data for the move creature modal.
	*/
	public void initData() {
		
	}
	
	/**
	 * Moves the selected creature to another enclosure.
	 */
	@FXML
	public void moveCreature() {
		
	}
	
	/**
	 * Cancels the process of moving a creature.
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
