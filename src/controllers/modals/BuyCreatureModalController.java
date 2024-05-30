package controllers.modals;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class BuyCreatureModalController 
{
	
	
	private TextField nameField;
	private ChoiceBox<String> creatureTypeChoiceBox;
	
	
	public void initialize() 
	{
		creatureTypeChoiceBox.getItems().addAll("Dragon", "Kraken", "Lycanthropes", "Megalodon", "Mermaid", "Nymph", "Phoenix", "Unicorn" );
		creatureTypeChoiceBox.setValue(null);
	}
	
	
	@FXML
	private void buyCreature() 
	{
		String name = nameField.getText();
		String type = creatureTypeChoiceBox.getValue();
		
		processPurchase(name, type);
	}
	
	
	private void processPurchase(String name, String type) 
	{
		if (name != null && type != null)
		{
			System.out.println("Traitement de l'achat de la créature : " + type + " nommée" + name);
		}
	}
}
