package controllers.modals;

import java.util.Optional;

import config.Constants;
import controllers.views.ZooVueController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.enclosures.Enclosure;
import models.enclosures.biomes.Aquarium;
import models.enclosures.biomes.Aviary;
import models.enclosures.biomes.Terrestrial;
import models.enclosures.biomes.UndefinedEnclosure;

public class SellEnclosureModalController {
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Text depthOrHeightLabel;
	@FXML
	private Text nameValue;
	@FXML
	private Text surfaceValue;
	@FXML
	private Text depthOrHeightValue;

    private Enclosure enclosure;
	private ZooVueController zooVueController;
	
    public void initData() {
		if (this.enclosure instanceof Aquarium) {
			depthOrHeightLabel.setText("Profondeur :");
			depthOrHeightValue.setText(String.valueOf(((Aquarium) this.enclosure).getDepth()));
		} else if (this.enclosure instanceof Aviary) {
			depthOrHeightLabel.setText("Hauteur :");
			depthOrHeightValue.setText(String.valueOf(((Aviary) this.enclosure).getHeight()));
		}
		nameValue.setText(this.enclosure.getName());
		surfaceValue.setText(String.valueOf(this.enclosure.getSurface()));
    }

	@FXML
	private void handleSellEnclosure() {
		if (this.enclosure.getCreatureList().length > 0) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Confirmation de vente");
	        alert.setHeaderText(null);
	        alert.setContentText("Il vous reste des créatures dans cet enclos, si vous continuez vous les perdrez. Êtes-vous sûr de vouloir continuer ?");
	        Optional<ButtonType> result = alert.showAndWait();
	        if (result.isPresent() && result.get() == ButtonType.OK) {
	        	this.sellEnclosure();
	        }
		} else {
			this.sellEnclosure();
		}
	}
	
	private void sellEnclosure() {
		if (this.enclosure instanceof Aquarium) {
			this.zooVueController.addInConsole("L'aquarium " + this.enclosure.getName() + " à été vendu pour " + Constants.Enclosure.Aquarium.SELL_PRICE + " $.");
			this.zooVueController.getZoo().getMaster().earnMoney(Constants.Enclosure.Aquarium.SELL_PRICE);
		} else if (this.enclosure instanceof Aviary) {
			this.zooVueController.addInConsole("La volière " + this.enclosure.getName() + " à été vendu pour " + Constants.Enclosure.Aviary.SELL_PRICE + " $.");
			this.zooVueController.getZoo().getMaster().earnMoney(Constants.Enclosure.Aviary.SELL_PRICE);
		} else if (this.enclosure instanceof Terrestrial) {
			this.zooVueController.addInConsole("L'enclos terrestre " + this.enclosure.getName() + " à été vendu pour " + Constants.Enclosure.Terrestrial.SELL_PRICE + " $.");
			this.zooVueController.getZoo().getMaster().earnMoney(Constants.Enclosure.Terrestrial.SELL_PRICE);
		}
		this.zooVueController.updateEnclosure(new UndefinedEnclosure(this.enclosure.getPosition()));
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
    
    public void setZooVueController(ZooVueController zooVueController) {
        this.zooVueController = zooVueController;
    }
}
