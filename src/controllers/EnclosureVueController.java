package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.enclosures.Enclosure;

public class EnclosureVueController {
    @FXML
    private Label enclosureLabel;

    private Enclosure enclosure;

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
        updateEnclosureDetails();
    }

    private void updateEnclosureDetails() {
        if (enclosure != null) {
            enclosureLabel.setText(enclosure.getName());
            // Mettez à jour d'autres éléments de la vue en fonction des détails de l'enclosure
        }
    }
}
