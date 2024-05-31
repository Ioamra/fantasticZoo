package controllers.modals;

import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.enclosures.Enclosure;


public class BuyCreatureModalController {
	@FXML
	private AnchorPane anchorPane;
	
	private TextField nameField;
	private ChoiceBox<String> creatureTypeChoiceBox;
	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;
	
	
	public void initialize() {
		// creatureTypeChoiceBox.getItems().addAll("Dragon", "Kraken", "Lycanthropes", "Megalodon", "Mermaid", "Nymph", "Phoenix", "Unicorn" );
		// creatureTypeChoiceBox.setValue(null);
	}
	
	public void initData() {
		
	}
	
	
	@FXML
	private void handleBuyCreature() {
		String name = nameField.getText();
		String type = creatureTypeChoiceBox.getValue();
		
		processPurchase(name, type);
	}
	
	@FXML
	private void cancel() {
		Stage stage = (Stage) anchorPane.getScene().getWindow();
	    stage.close();
	}
	
	
	private void processPurchase(String name, String type) {
		if (name != null && type != null)
		{
			System.out.println("Traitement de l'achat de la créature : " + type + " nommée" + name);
		}
	}
	
	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}
	
	public void setEnclosureVueController(EnclosureVueController enclosureVueController) {
		this.enclosureVueController = enclosureVueController;
	}
}
