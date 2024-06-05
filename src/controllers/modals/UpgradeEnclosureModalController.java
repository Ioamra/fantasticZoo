package controllers.modals;

import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.enclosures.Enclosure;
import models.enclosures.biomes.Aquarium;
import models.enclosures.biomes.Aviary;
import models.enclosures.biomes.Terrestrial;
import config.Constants;

/**
 * Controller class for the modal to upgrade an enclosure.
 */
public class UpgradeEnclosureModalController {
	@FXML
	private AnchorPane anchorPane;
    @FXML
    private Label depthLabel;
    @FXML
    private Text depthField;
    @FXML
    private Label heightLabel;
    @FXML
    private Text heightField;
    @FXML
    private Text surfaceField;
    @FXML
    private Label surfaceLevelLabel;
    @FXML
    private Label depthLevelLabel;
    @FXML
    private Label heightLevelLabel;
    @FXML
    private Button surfaceBtn, depthBtn, heightBtn;
	
	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;

	
	private int currentSurface;
	private int currentDepth;
	private int currentHeight;
	
 
    /**
     * Initializes the data for the upgrade enclosure modal.
     */
    public void initData() {
		if (this.enclosure instanceof Terrestrial) {
			currentSurface = this.enclosure.getSurface();
			if (currentSurface == Constants.Enclosure.Terrestrial.SURFACE_LVL_3) {
				surfaceBtn.setDisable(true);
			}
            surfaceField.setVisible(true);
            surfaceLevelLabel.setVisible(true);
            depthLabel.setVisible(false);
            depthField.setVisible(false);
            depthLevelLabel.setVisible(false);
            heightLabel.setVisible(false);
            heightField.setVisible(false);
            heightLevelLabel.setVisible(false);
            depthBtn.setVisible(false);
            heightBtn.setVisible(false);
            surfaceField.setText(String.valueOf(currentSurface));
            updateSurfaceLevelLabel();
        } else if (this.enclosure instanceof Aquarium) {
        	currentSurface = this.enclosure.getSurface();
			if (currentSurface == Constants.Enclosure.Aquarium.SURFACE_LVL_3) {
				surfaceBtn.setDisable(true);
			}
			currentDepth = ((Aquarium) this.enclosure).getDepth();
			if (currentDepth == Constants.Enclosure.Aquarium.DEPTH_LVL_3) {
				depthBtn.setDisable(true);
			}
            surfaceField.setVisible(true);
            surfaceLevelLabel.setVisible(true);
            depthLabel.setVisible(true);
            depthField.setVisible(true);
            depthLevelLabel.setVisible(true);
            heightLabel.setVisible(false);
            heightField.setVisible(false);
            heightLevelLabel.setVisible(false);
            depthBtn.setVisible(true);
            heightBtn.setVisible(false);
            surfaceField.setText(String.valueOf(currentSurface));
            depthField.setText(String.valueOf(currentDepth));
            updateSurfaceLevelLabel();
            updateDepthLevelLabel();
        } else if (this.enclosure instanceof Aviary) {
        	currentSurface = this.enclosure.getSurface();
        	if (currentSurface == Constants.Enclosure.Aviary.SURFACE_LVL_3) {
				surfaceBtn.setDisable(true);
			}
    		currentHeight= ((Aviary) this.enclosure).getHeight();
    		if (currentHeight == Constants.Enclosure.Aviary.HEIGHT_LVL_3) {
				heightBtn.setDisable(true);
			}
            surfaceField.setVisible(true);
            surfaceLevelLabel.setVisible(true);
            depthLabel.setVisible(false);
            depthField.setVisible(false);
            depthLevelLabel.setVisible(false);
            heightLabel.setVisible(true);
            heightField.setVisible(true);
            heightLevelLabel.setVisible(true);
            depthBtn.setVisible(false);
            heightBtn.setVisible(true);
            surfaceField.setText(String.valueOf(currentSurface));
            heightField.setText(String.valueOf(currentHeight));
            updateSurfaceLevelLabel();
            updateHeightLevelLabel();
        }
	}
	
    /**
     * Closes the upgrade enclosure modal.
     */
	@FXML
	private void close() {
		Stage stage = (Stage) anchorPane.getScene().getWindow();
	    stage.close();
	}

    private void updateSurfaceLevelLabel() {
        int surfaceLevel = currentSurface < Constants.Enclosure.Aviary.SURFACE_LVL_2 ? 1 :
                           currentSurface < Constants.Enclosure.Aviary.SURFACE_LVL_3 ? 2 : 3;
        surfaceLevelLabel.setText("Niveau actuel : " + surfaceLevel);
    }

    private void updateDepthLevelLabel() {
        int depthLevel = currentDepth < Constants.Enclosure.Aquarium.DEPTH_LVL_2 ? 1 :
                         currentDepth < Constants.Enclosure.Aquarium.DEPTH_LVL_3 ? 2 : 3;
        depthLevelLabel.setText("Niveau actuel : " + depthLevel);
    }

    private void updateHeightLevelLabel() {
        int heightLevel = currentHeight < Constants.Enclosure.Aviary.HEIGHT_LVL_2 ? 1 :
                          currentHeight < Constants.Enclosure.Aviary.HEIGHT_LVL_3 ? 2 : 3;
        heightLevelLabel.setText("Niveau actuel : " + heightLevel);
    }

    @FXML
    private void upgradeSurface() {
    	if (this.enclosure instanceof Terrestrial) {
    		 if (currentSurface == Constants.Enclosure.Terrestrial.SURFACE_LVL_1) {
    	        	currentSurface = Constants.Enclosure.Terrestrial.SURFACE_LVL_2;
    	        	enclosure.setSurface(currentSurface);
    	        } else if (currentSurface == Constants.Enclosure.Terrestrial.SURFACE_LVL_2) {
    	        	currentSurface = Constants.Enclosure.Terrestrial.SURFACE_LVL_3;
    	        	surfaceBtn.setDisable(true);
    	        	enclosure.setSurface(currentSurface);
    	        }
    	} else if (this.enclosure instanceof Aquarium) {
    		 if (currentSurface == Constants.Enclosure.Aquarium.SURFACE_LVL_1) {
    	        	currentSurface = Constants.Enclosure.Aquarium.SURFACE_LVL_2;
    	        	enclosure.setSurface(currentSurface);
    	        } else if (currentSurface == Constants.Enclosure.Aquarium.SURFACE_LVL_2) {
    	        	currentSurface = Constants.Enclosure.Aquarium.SURFACE_LVL_3;
    	        	surfaceBtn.setDisable(true);
    	        	enclosure.setSurface(currentSurface);
    	        }
    	} else if (this.enclosure instanceof Aviary) {
    		 if (currentSurface == Constants.Enclosure.Aviary.SURFACE_LVL_1) {
    	        	currentSurface = Constants.Enclosure.Aviary.SURFACE_LVL_2;
    	        	enclosure.setSurface(currentSurface);
    	        } else if (currentSurface == Constants.Enclosure.Aviary.SURFACE_LVL_2) {
    	        	currentSurface = Constants.Enclosure.Aviary.SURFACE_LVL_3;
    	        	surfaceBtn.setDisable(true);
    	        	enclosure.setSurface(currentSurface);
    	        }
    	}
        surfaceField.setText(String.valueOf(currentSurface));
        updateSurfaceLevelLabel();
        this.enclosureVueController.getZoo().getMaster().spendMoney(500);
        this.enclosureVueController.addInConsole("La surface de l'enclos est passé à " + currentSurface + " pour 500 $.");
        this.enclosureVueController.updateData();
    }

    @FXML
    private void upgradeDepth() {
   		 if (currentDepth == Constants.Enclosure.Aquarium.DEPTH_LVL_1) {
   			currentDepth = Constants.Enclosure.Aquarium.DEPTH_LVL_2;
   	        	((Aquarium)this.enclosure).setDepth(currentDepth);
   	        } else if (currentDepth == Constants.Enclosure.Aquarium.DEPTH_LVL_2) {
   	        	currentDepth = Constants.Enclosure.Aquarium.DEPTH_LVL_3;
   	        	depthBtn.setDisable(true);
   	        	((Aquarium)this.enclosure).setDepth(currentDepth);
   	        }
    	depthField.setText(String.valueOf(currentDepth));
    	updateDepthLevelLabel();
       this.enclosureVueController.getZoo().getMaster().spendMoney(500);
       this.enclosureVueController.addInConsole("La profondeur de l'enclos est passé à " + currentDepth + " pour 500 $.");
       this.enclosureVueController.updateData();
    }

    @FXML
    private void upgradeHeight() {
    	if (currentHeight == Constants.Enclosure.Aviary.HEIGHT_LVL_1) {
    		currentHeight = Constants.Enclosure.Aviary.HEIGHT_LVL_2;
        	((Aviary)this.enclosure).setHeight(currentHeight);
        } else if (currentHeight == Constants.Enclosure.Aviary.HEIGHT_LVL_2) {
        	currentHeight = Constants.Enclosure.Aviary.HEIGHT_LVL_3;
        	heightBtn.setDisable(true);
        	((Aviary)this.enclosure).setHeight(currentHeight);
        }
    	heightField.setText(String.valueOf(currentHeight));
    	updateHeightLevelLabel();
        this.enclosureVueController.getZoo().getMaster().spendMoney(500);
        this.enclosureVueController.addInConsole("La surface de l'enclos est passé à " + currentHeight + " pour 500 $.");
        this.enclosureVueController.updateData();
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
