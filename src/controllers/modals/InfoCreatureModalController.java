package controllers.modals;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.creatures.Creature;
import models.creatures.races.*;

/**
 * Controller class for the information modal of a creature.
 */
public class InfoCreatureModalController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Text name, type, gender, weight, size, age, sleep, hunger, stamina, state, hp;

    /**
     * Initializes the data of the creature in the modal.
     *
     * @param creature The creature whose information is to be displayed.
     */
    public void initData(Creature creature) {
        name.setText(creature.getName());
        if (creature instanceof Dragon) {
            type.setText("Dragon");
        } else if (creature instanceof Kraken) {
            type.setText("Kraken");
        } else if (creature instanceof Mermaid) {
            type.setText("Mermaid");
        } else if (creature instanceof Lycanthropes) {
            type.setText("Lycanthropes");
        } else if (creature instanceof Megalodon) {
            type.setText("Megalodon");
        } else if (creature instanceof Nymph) {
            type.setText("Nymph");
        } else if (creature instanceof Unicorn) {
            type.setText("Unicorn");
        } else if (creature instanceof Phoenix) {
            type.setText("Phoenix");
        }
        gender.setText(creature.getGender().toString());
        weight.setText(String.valueOf(creature.getWeight()));
        size.setText(String.valueOf(creature.getSize()));
        age.setText(String.valueOf(creature.getAge()));

        if (creature.isSleep()) {
            sleep.setText("true");
        } else {
            sleep.setText("false");
        }

        hunger.setText(String.valueOf(creature.getHunger()));
        stamina.setText(String.valueOf(creature.getStamina()));
        state.setText(String.valueOf(creature.getState()));
        hp.setText(String.valueOf(creature.getHp()));
    }
    
    /**
     * Closes the creature information modal.
     */
    @FXML
    private void close() {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

}