package controllers.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import models.enclosures.Enclosure;
import models.enclosures.biomes.Aquarium;
import models.enclosures.biomes.Aviary;
import models.enclosures.biomes.Terrestrial;
import models.enclosures.biomes.UndefinedEnclosure;
import models.zoo.Zoo;

public class EnclosureVueController {
    @FXML
    private Label enclosureLabel;
    @FXML
    private Button btnReturnToZoo;
    @FXML
    private Text consoleText;
    @FXML
    private Text enclosureName;
    @FXML
    private Text masterName;
    @FXML
    private Text masterMoney;

    private Enclosure enclosure;
    private Zoo zoo;
    private int dayCounter;
    
    @FXML
    private void returnToZooVue(ActionEvent event) {
    	try {
	        
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/views/ZooVue.fxml"));
	        Parent root = loader.load();

	        ZooVueController zooController = loader.getController();
	        zooController.setZoo(this.zoo);
	        zooController.updateEnclosureStatus();
	        zooController.setDayCounter(dayCounter);
	        zooController.showSideInfos();

	        Scene scene = btnReturnToZoo.getScene();
	        scene.setRoot(root);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }
    
    @FXML
    private void openBuyCreatureModal() {
    	
    }

    @FXML
    private void openSellCreatureModal() {
    	
    }   
    
    @FXML
    private void openMoveCreatureModal() {
    	
    }
    
    @FXML
    private void openCleanEnclosureModal() {
    	
    }
    
    @FXML
    private void openHealEnclosureModal() {
    	
    }
    
    @FXML
    private void openUpgradeEnclosureModal() {
    	
    }
    
    @FXML
    private void openFeedEnclosureModal() {
    	
    }
    
    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }
    
    public void setZoo(Zoo zooObject) {
    	this.zoo = zooObject;
    }
    

    public void showSideInfos() {
    	 if (this.enclosure instanceof UndefinedEnclosure) {
    		 enclosureName.setText("Emplacement d'enclos");
         } else if (this.enclosure instanceof Aviary) {
        	 enclosureName.setText("Aviary " + this.enclosure.getName());
         } else if (this.enclosure instanceof Terrestrial) {
        	 enclosureName.setText("Terrestrial " + this.enclosure.getName());
         } else if (this.enclosure instanceof Aquarium) {
        	 enclosureName.setText("Aquarium " + this.enclosure.getName());
         }
        masterName.setText(this.zoo.getMaster().getName());
        masterMoney.setText(String.valueOf(this.zoo.getMaster().getMoney()) + " $");
    }
}