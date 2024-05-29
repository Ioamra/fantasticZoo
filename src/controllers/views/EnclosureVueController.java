package controllers.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.enclosures.Enclosure;

public class EnclosureVueController {
    @FXML
    private Label enclosureLabel;
    
    @FXML
    private Button btnReturnToZoo;

    private Enclosure enclosure;
    private ZooVueController zooVueController;
    
    @FXML
    private void returnToZooVue(ActionEvent event) {
    	try {
	        
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/views/ZooVue.fxml"));
	        Parent root = loader.load();

	        ZooVueController zooController = loader.getController();
	        zooController.setZoo(this.zooVueController.getZoo());
	        zooController.updateEnclosureStatus();

	        Scene scene = btnReturnToZoo.getScene();
	        scene.setRoot(root);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }
    
    public void setZooVueController(ZooVueController zooVueController) {
        this.zooVueController = zooVueController;
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
}