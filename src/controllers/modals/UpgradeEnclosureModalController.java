package controllers.modals;

import controllers.views.EnclosureVueController;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.enclosures.Enclosure;

/**
 * Controller class for the modal to upgrade an enclosure.
 */
public class UpgradeEnclosureModalController {
	@FXML
	private AnchorPane anchorPane;
    @FXML
    private ChoiceBox<String> enclosureTypeChoiceBox;
    @FXML
    private Label depthLabel;
    @FXML
    private TextField depthField;
    @FXML
    private Label heightLabel;
    @FXML
    private TextField heightField;
    @FXML
    private TextField surfaceField;
	
	private Enclosure enclosure;
	private EnclosureVueController enclosureVueController;

    /**
     * Initializes the choice box with enclosure types.
     */
    @FXML
    public void initialize() 
    {
        enclosureTypeChoiceBox.getItems().addAll("Terrestre", "Aquarium", "Aviary");
    }

    /**
     * Initializes the data for the upgrade enclosure modal.
     */
	public void initData() {
		
	}
	
    /**
     * Closes the upgrade enclosure modal.
     */
	@FXML
	private void close() {
		Stage stage = (Stage) anchorPane.getScene().getWindow();
	    stage.close();
	}

    /**
     * Handles the selection of enclosure type and adjusts the visibility of input fields accordingly.
     */
    @FXML
    private void handleEnclosureTypeSelection() 
    {
        String selectedType = enclosureTypeChoiceBox.getValue();
        if (selectedType != null) 
        {
            switch (selectedType) 
            {
                case "Terrestre":
                    surfaceField.setVisible(true);
                    depthLabel.setVisible(false);
                    depthField.setVisible(false);
                    heightLabel.setVisible(false);
                    heightField.setVisible(false);
                    break;
                case "Aquarium":
                    surfaceField.setVisible(true);
                    depthLabel.setVisible(true);
                    depthField.setVisible(true);
                    heightLabel.setVisible(false);
                    heightField.setVisible(false);
                    break;
                case "Aviary":
                    surfaceField.setVisible(true);
                    depthLabel.setVisible(false);
                    depthField.setVisible(false);
                    heightLabel.setVisible(true);
                    heightField.setVisible(true);
                    break;
            }
        }
    }
    
    /**
     * Handles the upgrade of enclosure surface.
     */
    @FXML
    private void upgradeSurface() 
    {
        String surface = surfaceField.getText();
        System.out.println("Surface améliorée à : " + surface);
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
