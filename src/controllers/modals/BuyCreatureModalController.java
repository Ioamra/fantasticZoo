package controllers.modals;

import config.Constants;
import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.creatures.Creature;
import models.creatures.Creature.Gender;
import models.creatures.races.Dragon;
import models.creatures.races.Kraken;
import models.creatures.races.Lycanthropes;
import models.creatures.races.Megalodon;
import models.creatures.races.Mermaid;
import models.creatures.races.Nymph;
import models.creatures.races.Phoenix;
import models.creatures.races.Unicorn;
import models.enclosures.Enclosure;
import models.enclosures.biomes.Aquarium;
import models.enclosures.biomes.Aviary;
import models.enclosures.biomes.Terrestrial;

public class BuyCreatureModalController {
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private ChoiceBox<String> creatureTypeChoiceBox;
	@FXML
	private ChoiceBox<String> creatureGenderChoiceBox;
	@FXML
	private TextField nameField;

	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;
	
	
	public void initialize() {
		creatureGenderChoiceBox.getItems().addAll("Male", "Femelle" );
		creatureGenderChoiceBox.setValue("Male");
	}
	
	public void initData() {
		if (enclosure instanceof Aquarium) {
			creatureTypeChoiceBox.getItems().addAll("Dragon", "Kraken", "Megalodon", "Sirène", "Nymph" );
		} else if (enclosure instanceof Aviary) {
			creatureTypeChoiceBox.getItems().addAll("Dragon", "Phénix" );
		} else if (enclosure instanceof Terrestrial) {
			creatureTypeChoiceBox.getItems().addAll("Dragon", "Loup-garou", "Nymph", "Licorne" );
		}
	}
	
	
	@FXML
	private void handleBuyCreature() {
		String name = nameField.getText();
		if (name == null || name.trim().isEmpty()) {
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
	        alert.setHeaderText("Nom requis");
	        alert.setContentText("Veuillez remplir un nom pour la créature.");
	        alert.showAndWait();
	        return;
	    }
		String selectedType = creatureTypeChoiceBox.getValue();
		if (selectedType == null || selectedType.trim().isEmpty()) {
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
	        alert.setHeaderText("Type de créature requis");
	        alert.setContentText("Veuillez choisir un type de créature.");
	        alert.showAndWait();
	        return;
	    }
		int usedSurface = 0;
		for (Creature creature: this.enclosure.getCreatureList()) {
			usedSurface += creature.getSize();
		}
		
        Gender gender;
        if (creatureGenderChoiceBox.getValue() == "Male") {
        	gender = Gender.valueOf("M");
        } else {
        	gender = Gender.valueOf("F");
        }

		switch (selectedType) {
			case "Dragon":
				if (this.enclosure.getSurface() - usedSurface < Constants.Creature.Dragon.SIZE) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("Vous n'avez pas assez de place pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				if (this.enclosure instanceof Aquarium && ((Aquarium) this.enclosure).getDepth() < Constants.Creature.Dragon.HEIGHT) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("La profondeur de l'aquarium n'est pas suffisante pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				if (this.enclosure instanceof Aviary && ((Aviary) this.enclosure).getHeight() < Constants.Creature.Dragon.HEIGHT) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("La hauteur de la volière n'est pas suffisante pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				this.enclosure.addCreature(
					new Dragon(
							name,
							gender,
							Constants.Creature.Dragon.INITIAL_WEIGHT,
							0
						)
					);
				break;
			case "Kraken":
				if (this.enclosure.getSurface() - usedSurface < Constants.Creature.Kraken.SIZE) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("Vous n'avez pas assez de place pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				if (this.enclosure instanceof Aquarium && ((Aquarium) this.enclosure).getDepth() < Constants.Creature.Kraken.HEIGHT) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("La profondeur de l'aquarium n'est pas suffisante pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				this.enclosure.addCreature(
						new Kraken(
								name,
								gender,
								Constants.Creature.Kraken.INITIAL_WEIGHT,
								0
						)
					);
				break;
			case "Loup-garou":
				if (this.enclosure.getSurface() - usedSurface < Constants.Creature.Lycanthropes.SIZE) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("Vous n'avez pas assez de place pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				this.enclosure.addCreature(
						new Lycanthropes(
								name,
								gender,
								Constants.Creature.Lycanthropes.INITIAL_WEIGHT,
								0
						)
					);
				break;
			case "Megalodon":
				if (this.enclosure.getSurface() - usedSurface < Constants.Creature.Megalodon.SIZE) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("Vous n'avez pas assez de place pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				if (this.enclosure instanceof Aquarium && ((Aquarium) this.enclosure).getDepth() < Constants.Creature.Megalodon.HEIGHT) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("La profondeur de l'aquarium n'est pas suffisante pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				this.enclosure.addCreature(
						new Megalodon(
								name,
								gender,
								Constants.Creature.Megalodon.INITIAL_WEIGHT,
								0
						)
					);
				break;
			case "Sirène":
				if (this.enclosure.getSurface() - usedSurface < Constants.Creature.Mermaid.SIZE) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("Vous n'avez pas assez de place pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				if (this.enclosure instanceof Aquarium && ((Aquarium) this.enclosure).getDepth() < Constants.Creature.Mermaid.HEIGHT) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("La profondeur de l'aquarium n'est pas suffisante pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				this.enclosure.addCreature(
						new Mermaid(
								name,
								gender,
								Constants.Creature.Mermaid.INITIAL_WEIGHT,
								0
						)
					);
				break;
			case "Nymph":
				if (this.enclosure.getSurface() - usedSurface < Constants.Creature.Nymph.SIZE) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("Vous n'avez pas assez de place pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				if (this.enclosure instanceof Aquarium && ((Aquarium) this.enclosure).getDepth() < Constants.Creature.Nymph.HEIGHT) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("La profondeur de l'aquarium n'est pas suffisante pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				this.enclosure.addCreature(
						new Nymph(
								name,
								gender,
								Constants.Creature.Nymph.INITIAL_WEIGHT,
								0
						)
					);
				break;
			case "Phénix":
				if (this.enclosure.getSurface() - usedSurface < Constants.Creature.Phoenix.SIZE) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("Vous n'avez pas assez de place pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				if (this.enclosure instanceof Aviary && ((Aviary) this.enclosure).getHeight() < Constants.Creature.Phoenix.HEIGHT) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("La hauteur de la volière n'est pas suffisante pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				this.enclosure.addCreature(
						new Phoenix(
								name,
								gender,
								Constants.Creature.Phoenix.INITIAL_WEIGHT,
								0
						)
					);
				break;
			case "Licorne":
				if (this.enclosure.getSurface() - usedSurface < Constants.Creature.Unicorn.SIZE) {
					Alert alert = new Alert(AlertType.WARNING);
			        alert.setTitle("Erreur");
        			alert.setHeaderText(null);
			        alert.setContentText("Vous n'avez pas assez de place pour cette créature.");
			        alert.showAndWait();
			        return;
				}
				this.enclosure.addCreature(
						new Unicorn(
								name,
								gender,
								Constants.Creature.Unicorn.INITIAL_WEIGHT,
								0
						)
					);
				break;
			}
		this.enclosureVueController.setEnclosure(this.enclosure);
		this.enclosureVueController.initData();
		Stage stage = (Stage) anchorPane.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void cancel() {
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
