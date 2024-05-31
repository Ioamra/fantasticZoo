package controllers.views;

import java.io.IOException;

import controllers.modals.BuyEnclosureModalController;
import controllers.modals.SellEnclosureModalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.enclosures.Enclosure;
import models.enclosures.biomes.Aquarium;
import models.enclosures.biomes.Aviary;
import models.enclosures.biomes.Terrestrial;
import models.enclosures.biomes.UndefinedEnclosure;
import models.master.Master;
import models.zoo.Zoo;

public class ZooVueController {
    @FXML
    private Button nextDayButton;
    @FXML
    private Label dayLabel;
    @FXML
    private Pane enclosure1;
    @FXML
    private Pane enclosure2;
    @FXML
    private Pane enclosure3;
    @FXML
    private Pane enclosure4;
    @FXML
    private Pane enclosure5;
    @FXML
    private Pane enclosure6;
    @FXML
    private Pane enclosure7;
    @FXML
    private Pane enclosure8;
    @FXML
    private Pane enclosure9;
    @FXML
    private Text consoleText;
    @FXML
    private Text zooNameText;
    @FXML
    private Text masterName;
    @FXML
    private Text masterMoney;
    @FXML
    private Button enclosureSellOrBuyButton1;
    @FXML
    private Button enclosureSellOrBuyButton2;
    @FXML
    private Button enclosureSellOrBuyButton3;
    @FXML
    private Button enclosureSellOrBuyButton4;
    @FXML
    private Button enclosureSellOrBuyButton5;
    @FXML
    private Button enclosureSellOrBuyButton6;
    @FXML
    private Button enclosureSellOrBuyButton7;
    @FXML
    private Button enclosureSellOrBuyButton8;
    @FXML
    private Button enclosureSellOrBuyButton9;

    private int nbEnclosure = 9;
    private int dayCounter;
    private Zoo zoo;
    private String console = "";

    @FXML
    public void initialize() {
        enclosureSellOrBuyButton1.setCursor(Cursor.HAND);
        enclosureSellOrBuyButton2.setCursor(Cursor.HAND);
        enclosureSellOrBuyButton3.setCursor(Cursor.HAND);
        enclosureSellOrBuyButton4.setCursor(Cursor.HAND);
        enclosureSellOrBuyButton5.setCursor(Cursor.HAND);
        enclosureSellOrBuyButton6.setCursor(Cursor.HAND);
        enclosureSellOrBuyButton7.setCursor(Cursor.HAND);
        enclosureSellOrBuyButton8.setCursor(Cursor.HAND);
        enclosureSellOrBuyButton9.setCursor(Cursor.HAND);
        nextDayButton.setCursor(Cursor.HAND);
    }
    
    public void updateData() {
        dayLabel.setText("Jour " + dayCounter);
        zooNameText.setText(this.zoo.getName());
        masterName.setText(this.zoo.getMaster().getName());
        masterMoney.setText(String.valueOf(this.zoo.getMaster().getMoney()) + " $");
        consoleText.setText(this.console);
    }
    
    @FXML
    void handleNextDayButton() {
        dayCounter++;
        dayLabel.setText("Jour " + dayCounter);
    }
    
    @FXML
    private void handleEnclosureClick(MouseEvent event) {
    	Pane clickedEnclosure= (Pane) event.getSource();
    	int location = Integer.parseInt(clickedEnclosure.getId().replace("enclosure", "")) - 1;
    	Enclosure enclosure = zoo.getEnclosureList()[location];
    	if (!(enclosure instanceof UndefinedEnclosure))  {
    		openEnclosureView(enclosure);
    	}
    }
    
    private void openEnclosureView(Enclosure enclosure) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/views/EnclosureVue.fxml"));
            Parent root = loader.load();

            EnclosureVueController enclosureController = loader.getController();
            enclosureController.setEnclosure(enclosure);
            enclosureController.setDayCounter(dayCounter);
            enclosureController.setZoo(zoo);
            enclosureController.updateData();

            Stage stage = (Stage) nextDayButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleEnclosureSellOrBuy(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        Pane parentPane = (Pane) clickedButton.getParent();
        int location = Integer.parseInt(parentPane.getId().replace("enclosure", "")) - 1;
        Enclosure enclosure = zoo.getEnclosureList()[location];
        if (enclosure instanceof UndefinedEnclosure) {
            openBuyEnclosureModal(location);
        } else {
            openSellEnclosureModal(enclosure);
        }
    }
    
    public void initMasterAndZoo(String zooName, Master master) {
        Enclosure[] enclosures = new Enclosure[nbEnclosure];
        for (int i = 0; i < nbEnclosure; i++) {
            enclosures[i] = new UndefinedEnclosure(i + 1);
        }
        this.zoo = new Zoo(zooName, master, nbEnclosure, enclosures);
        updateEnclosureStatus();
        this.setDayCounter(1);
        this.updateData();
    }
    
    private void openBuyEnclosureModal(int location) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/modals/BuyEnclosureModal.fxml"));
            Parent root = loader.load();

            BuyEnclosureModalController buyEnclosureModalController = loader.getController();
            buyEnclosureModalController.setLocation(location);
            buyEnclosureModalController.setZooVueController(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            updateEnclosureStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void openSellEnclosureModal(Enclosure enclosure) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/modals/SellEnclosureModal.fxml"));
            Parent root = loader.load();

            SellEnclosureModalController sellEnclosureModalController = loader.getController();
            sellEnclosureModalController.setEnclosure(enclosure);
            sellEnclosureModalController.setZooVueController(this);
            sellEnclosureModalController.initData();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            updateEnclosureStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void updateEnclosure(Enclosure enclosure) {
    	zoo.getEnclosureList()[enclosure.getPosition()] = enclosure;
    	this.updateData();
    }

    public void updateEnclosureStatus() {
        updateEnclosureText(enclosure1, 0);
        updateEnclosureText(enclosure2, 1);
        updateEnclosureText(enclosure3, 2);
        updateEnclosureText(enclosure4, 3);
        updateEnclosureText(enclosure5, 4);
        updateEnclosureText(enclosure6, 5);
        updateEnclosureText(enclosure7, 6);
        updateEnclosureText(enclosure8, 7);
        updateEnclosureText(enclosure9, 8);
    }

    private void updateEnclosureText(Pane enclosurePane, int location) {
        Text text = (Text) enclosurePane.getChildren().get(0);
        Button button = (Button) enclosurePane.getChildren().get(1);
        if (zoo.getEnclosureList()[location] instanceof UndefinedEnclosure) {
            text.setText("Emplacement d'enclos");
            button.setText("+");
        } else if (zoo.getEnclosureList()[location] instanceof Aviary) {
            text.setText("Aviary " + zoo.getEnclosureList()[location].getName());
            button.setText("-");
        } else if (zoo.getEnclosureList()[location] instanceof Terrestrial) {
        	text.setText("Terrestrial " + zoo.getEnclosureList()[location].getName());
            button.setText("-");
        } else if (zoo.getEnclosureList()[location] instanceof Aquarium) {
        	text.setText("Aquarium " + zoo.getEnclosureList()[location].getName());
            button.setText("-");
        }
    }
    
    public void addInConsole(String text) {
    	this.console += "\n"+ text;
    }
    
    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
    
    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }
}
