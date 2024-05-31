package controllers.views;

import java.io.IOException;

import controllers.modals.BuyCreatureModalController;
import controllers.modals.CleanEnclosureModalController;
import controllers.modals.FeedEnclosureModalController;
import controllers.modals.HealEnclosureModalController;
import controllers.modals.MoveCreatureModalController;
import controllers.modals.SellCreatureModalController;
import controllers.modals.SellEnclosureModalController;
import controllers.modals.UpgradeEnclosureModalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.creatures.Creature;
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
    @FXML
    private ImageView openBuyCreatureImage;
    @FXML
    private ImageView openSellCreatureImage;
    @FXML
    private ImageView openMoveCreatureImage;
    @FXML
    private ImageView openHealEnclosureImage;
    @FXML
    private ImageView openFeedEnclosureImage;
    @FXML
    private ImageView openCleanEnclosureImage;
    @FXML
    private ImageView openUpgradeEnclosureImage;
    @FXML
    private Text surfaceText;

    private Enclosure enclosure;
    private Zoo zoo;
    private int dayCounter;
    
    @FXML
    public void initialize() {
    	btnReturnToZoo.setCursor(Cursor.HAND);
    	openBuyCreatureImage.setCursor(Cursor.HAND);
    	openSellCreatureImage.setCursor(Cursor.HAND);
    	openMoveCreatureImage.setCursor(Cursor.HAND);
    	openHealEnclosureImage.setCursor(Cursor.HAND);
    	openFeedEnclosureImage.setCursor(Cursor.HAND);
    	openCleanEnclosureImage.setCursor(Cursor.HAND);
    	openUpgradeEnclosureImage.setCursor(Cursor.HAND);
    }
    
    public void initData() {
    	int usedSurface = 0;
		for (Creature creature: this.enclosure.getCreatureList()) {
			usedSurface += creature.getSize();
		}
		surfaceText.setText("Surface utilisé: " + usedSurface + "/" + this.enclosure.getSurface());
    	
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
        
        System.out.println("Liste des créatures dans l'enclos:");
        for (Creature creature : enclosure.getCreatureList()) {
            System.out.println(creature);
        }
    }
    
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
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/modals/BuyCreatureModal.fxml"));
            Parent root = loader.load();

            BuyCreatureModalController buyCreatureModalController = loader.getController();
            buyCreatureModalController.setEnclosure(this.enclosure);
            buyCreatureModalController.setEnclosureVueController(this);
            buyCreatureModalController.initData();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openSellCreatureModal() {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/modals/SellCreatureModal.fxml"));
            Parent root = loader.load();

            SellCreatureModalController sellCreatureModalController = loader.getController();
            sellCreatureModalController.setEnclosure(enclosure);
            sellCreatureModalController.setEnclosureVueController(this);
            sellCreatureModalController.initData();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    
    @FXML
    private void openMoveCreatureModal() {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/modals/MoveCreatureModal.fxml"));
            Parent root = loader.load();

            MoveCreatureModalController moveCreatureModalController = loader.getController();
            moveCreatureModalController.setEnclosure(enclosure);
            moveCreatureModalController.setEnclosureVueController(this);
            moveCreatureModalController.initData();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void openCleanEnclosureModal() {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/modals/CleanEnclosureModal.fxml"));
            Parent root = loader.load();

            CleanEnclosureModalController cleanEnclosureModalController = loader.getController();
            cleanEnclosureModalController.setEnclosure(enclosure);
            cleanEnclosureModalController.setEnclosureVueController(this);
            cleanEnclosureModalController.initData();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void openHealEnclosureModal() {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/modals/HealEnclosureModal.fxml"));
            Parent root = loader.load();

            HealEnclosureModalController healEnclosureModalController = loader.getController();
            healEnclosureModalController.setEnclosure(enclosure);
            healEnclosureModalController.setEnclosureVueController(this);
            healEnclosureModalController.initData();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void openUpgradeEnclosureModal() {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/modals/UpgradeEnclosureModal.fxml"));
            Parent root = loader.load();

            UpgradeEnclosureModalController upgradeEnclosureModalController = loader.getController();
            upgradeEnclosureModalController.setEnclosure(enclosure);
            upgradeEnclosureModalController.setEnclosureVueController(this);
            upgradeEnclosureModalController.initData();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void openFeedEnclosureModal() {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/modals/FeedEnclosureModal.fxml"));
            Parent root = loader.load();

            FeedEnclosureModalController feedEnclosureModalController = loader.getController();
            feedEnclosureModalController.setEnclosure(enclosure);
            feedEnclosureModalController.setEnclosureVueController(this);
            feedEnclosureModalController.initData();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }
    
    public void setZoo(Zoo zooObject) {
    	this.zoo = zooObject;
    }
}