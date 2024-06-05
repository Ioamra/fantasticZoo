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
import models.creatures.Creature;
import models.creatures.Creature.State;
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
import models.enclosures.biomes.UndefinedEnclosure;
import models.master.Master;
import models.zoo.Zoo;
import java.util.Random;

import config.Constants;


/**
 * Controller class for the zoo view.
 */
public class ZooVueController {
	@FXML
	private Label dayLabel;
	@FXML
	private Pane enclosure1, enclosure2, enclosure3, enclosure4, enclosure5, enclosure6, enclosure7, enclosure8, enclosure9;
	@FXML
	private Text consoleText, zooNameText, masterName, masterMoney;
	@FXML
	private Button nextDayButton, enclosureSellOrBuyButton1, enclosureSellOrBuyButton2, enclosureSellOrBuyButton3, enclosureSellOrBuyButton4, enclosureSellOrBuyButton5, enclosureSellOrBuyButton6, enclosureSellOrBuyButton7, enclosureSellOrBuyButton8, enclosureSellOrBuyButton9;

    private int nbEnclosure = 9;
    private int dayCounter;
    private Zoo zoo;
    private String console = "";

    /**
     * Initializes the controller.
     */
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

    /**
     * Updates the displayed data.
     */
    public void updateData() {
        dayLabel.setText("Jour " + dayCounter);
        zooNameText.setText(this.zoo.getName());
        masterName.setText(this.zoo.getMaster().getName());
        masterMoney.setText(String.valueOf(this.zoo.getMaster().getMoney()) + " $");
        consoleText.setText(this.console);
    }

    /**
     * Handles the click event on the "Next Day" button.
     */
    @FXML
    void handleNextDayButton() {
        dayCounter++;
        dayLabel.setText("Jour " + dayCounter);
        int moneyEarn = 0;
        for (Enclosure enclosure: this.zoo.getEnclosureList()) {
        	int cleanlinessLost = 0;
        	for (Creature creature: enclosure.getCreatureList()) {
        		if (creature.getState() != State.DEAD) {
        			creature.incrementAge();
        			Random random = new Random();
        			int rngSick = random.nextInt(101);
        			if (creature.getState() == State.HEALTHY && rngSick > Constants.Creature.ILLNESS_PROBABILITY + Constants.Creature.ILLNESS_PROBABILITY * (100 - enclosure.getCleanliness())) {
        				creature.fallIll();
        			}
        			if (creature.getState() == State.SICK) {
        				int tmpRngHp = Constants.Creature.MAX_SICKNESS_HP_LOSS - Constants.Creature.MIN_SICKNESS_HP_LOSS;
        				int rngHp = random.nextInt(tmpRngHp) + Constants.Creature.MIN_SICKNESS_HP_LOSS;
        				creature.setHp(creature.getHp() - rngHp);
        			}        			
        			cleanlinessLost += Constants.Creature.DAILY_ENCLOSURE_CLEANLINESS_LOSS;     
        			creature.setHunger(creature.getHunger() - Constants.Creature.DAILY_HUNGER_INCREASE);
        			creature.checkHunger();
        		} else {
        			cleanlinessLost += Constants.Creature.DAILY_ENCLOSURE_CLEANLINESS_LOSS * Constants.Creature.RATIO_DAILY_ENCLOSURE_CLEANLINESS_LOSS_IF_DEAD;        			
        		}
        		if (creature.getHp() <= 0) {
        			creature.setHp(0);
        			creature.setState(State.DEAD);
        		}
        		if (creature.getState() == State.SICK) {
        			this.addInConsole("La créature " + creature.getName() + " est malade dans l'enclos " + enclosure.getName());
        		}
        		if (creature.getState() == State.DEAD) {
        			this.addInConsole("La créature " + creature.getName() + " est morte dans l'enclos " + enclosure.getName());
        		} else {
        			if (creature instanceof Dragon) {
        				moneyEarn += Constants.Creature.Dragon.MONEY_GAIN;
        			}
        			if (creature instanceof Kraken) {
        				moneyEarn += Constants.Creature.Kraken.MONEY_GAIN;
        			}
        			if (creature instanceof Lycanthropes) {
        				moneyEarn += Constants.Creature.Lycanthropes.MONEY_GAIN;
        			}
        			if (creature instanceof Megalodon) {
        				moneyEarn += Constants.Creature.Megalodon.MONEY_GAIN;
        			}
        			if (creature instanceof Mermaid) {
        				moneyEarn += Constants.Creature.Mermaid.MONEY_GAIN;
        			}
        			if (creature instanceof Nymph) {
        				moneyEarn += Constants.Creature.Nymph.MONEY_GAIN;
        			}
        			if (creature instanceof Phoenix) {
        				moneyEarn += Constants.Creature.Phoenix.MONEY_GAIN;
        			}
        			if (creature instanceof Unicorn) {
        				moneyEarn += Constants.Creature.Unicorn.MONEY_GAIN;
        			}
        			
        		}
        	}
        	int newCleanliness = enclosure.getCleanliness() - cleanlinessLost > 0 ? enclosure.getCleanliness() - cleanlinessLost : 0;
        	enclosure.setCleanliness(newCleanliness);
        }
        this.addInConsole("Vos créatures vous ont rapporté au total " + moneyEarn + " $.");
        this.zoo.getMaster().setMoney(this.zoo.getMaster().getMoney() + moneyEarn);
        consoleText.setText(this.console);
        this.updateData();
    }
    
    /**
     * Handles the click event on an enclosure.
     *
     * @param event The MouseEvent object representing the click event.
     */
    @FXML
    private void handleEnclosureClick(MouseEvent event) {
    	Pane clickedEnclosure= (Pane) event.getSource();
    	int location = Integer.parseInt(clickedEnclosure.getId().replace("enclosure", "")) - 1;
    	Enclosure enclosure = zoo.getEnclosureList()[location];
    	if (!(enclosure instanceof UndefinedEnclosure))  {
    		openEnclosureView(enclosure);
    	}
    }
    
    /**
     * Opens the enclosure view.
     *
     * @param enclosure The enclosure object to display.
     */
    private void openEnclosureView(Enclosure enclosure) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/views/EnclosureVue.fxml"));
            Parent root = loader.load();

            EnclosureVueController enclosureController = loader.getController();
            enclosureController.setEnclosure(enclosure);
            enclosureController.setDayCounter(dayCounter);
            enclosureController.setZoo(zoo);
            enclosureController.initData();
            enclosureController.updateData();

            Stage stage = (Stage) nextDayButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Handles the click event on an enclosure's sell or buy button.
     *
     * @param event The ActionEvent object representing the click event.
     */
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

    /**
     * Initializes the master and zoo.
     *
     * @param zooName The name of the zoo.
     * @param master  The master object.
     */
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
    
    /**
     * Opens the buy enclosure modal.
     *
     * @param location The location of the enclosure.
     */
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
    
    /**
     * Opens the sell enclosure modal.
     *
     * @param enclosure The enclosure object to sell.
     */
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

    /**
     * Updates the enclosure.
     *
     * @param enclosure The updated enclosure object.
     */
    public void updateEnclosure(Enclosure enclosure) {
    	zoo.getEnclosureList()[enclosure.getPosition()] = enclosure;
    	this.updateData();
    }

    /**
     * Updates the enclosure status.
     */
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

    /**
     * Updates the text and button of the enclosure based on its type.
     *
     * @param enclosurePane The pane representing the enclosure.
     * @param location      The index of the enclosure.
     */
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

    /**
     * Adds text to the console.
     *
     * @param text The text to add to the console.
     */
    public void addInConsole(String text) {
    	this.console += "\n"+ text;
    }

    /**
     * Gets the zoo object.
     *
     * @return The zoo object.
     */
    public Zoo getZoo() {
        return zoo;
    }

    /**
     * Sets the zoo object.
     *
     * @param zoo The zoo object to set.
     */
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    /**
     * Sets the day counter.
     *
     * @param dayCounter The day counter to set.
     */
    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }
}
