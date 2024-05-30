package controllers.modals;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class UpgradeEnclosureModalController 
{

	
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

    
    @FXML
    public void initialize() 
    {
        enclosureTypeChoiceBox.getItems().addAll("Terrestre", "Aquarium", "Aviary");
    }

    
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

    @FXML
    private void upgradeSurface() 
    {
        String surface = surfaceField.getText();
        System.out.println("Surface améliorée à : " + surface);
    }

}
