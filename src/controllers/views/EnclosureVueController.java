package controllers.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javafx.scene.image.Image;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.creatures.Creature;
import models.creatures.races.*;
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
	private Text consoleText, enclosureName, masterName, masterMoney, surfaceText;
	@FXML
	private ImageView creature1, creature2, creature3, creature4, creature5, creature6, creature7, creature8, creature9, creature10, creature11, creature12, creature13, creature14, creature15, creature16, openBuyCreatureImage, openSellCreatureImage, openMoveCreatureImage, openHealEnclosureImage, openFeedEnclosureImage, openCleanEnclosureImage, openUpgradeEnclosureImage;

    private Enclosure enclosure;
    private Zoo zoo;
    private int dayCounter;
    private String console = "";
    private List<ImageView> creatureImages;
    
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


        creatureImages = Arrays.asList(
                creature1, creature2, creature3, creature4,
                creature5, creature6, creature7, creature8,
                creature9, creature10, creature11, creature12,
                creature13, creature14, creature15, creature16
        );
    }

    public void updateData() {
        int usedSurface = 0;
        List<Creature> creatures = new ArrayList<>(List.of(this.enclosure.getCreatureList()));

        for (int i = 0; i < creatureImages.size(); i++) {
            ImageView imageView = creatureImages.get(i);
            String imagePath = null;
            if (i < creatures.size()) {
                Creature creature = creatures.get(i);
                usedSurface += creature.getSize();
                if (creature instanceof Dragon) {
                    imagePath = "/assets/img/dragon.png";
                } else if (creature instanceof Kraken) {
                    imagePath = "/assets/img/kraken.png";
                } else if (creature instanceof Mermaid) {
                    imagePath = "/assets/img/mermaid.png";
                } else if (creature instanceof Lycanthropes) {
                    imagePath = "/assets/img/lycanthropes.png";
                } else if (creature instanceof Megalodon) {
                    imagePath = "/assets/img/megalodon.png";
                } else if (creature instanceof Nymph) {
                    imagePath = "/assets/img/nymph.png";
                } else if (creature instanceof Unicorn) {
                    imagePath = "/assets/img/unicorn.png";
                } else if (creature instanceof Phoenix) {
                    imagePath = "/assets/img/phoenix.png";
                }
                if (imagePath != null) {
                    try {
                        imageView.setImage(new Image(getClass().getResource(imagePath).toExternalForm()));
                    } catch (NullPointerException e) {
                        System.err.println("Image not found: " + imagePath);
                        imageView.setImage(null);
                    }
                }
            } else {
                imageView.setImage(null);
            }
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
        consoleText.setText(this.console);
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
	        zooController.updateData();

	        Scene scene = btnReturnToZoo.getScene();
	        scene.setRoot(root);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }

    @FXML
    private void HandleViewCreatureInfo(MouseEvent event) {

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


            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void addInConsole(String text) {
    	this.console += "\n"+ text;
    }
    
    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }
    
    public Zoo getZoo() {
    	return this.zoo;
    }
    
    public void setZoo(Zoo zooObject) {
    	this.zoo = zooObject;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }
}