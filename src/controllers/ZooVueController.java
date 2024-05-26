package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ZooVueController {
    @FXML
    private Button nextDayButton;

    @FXML
    private Label dayLabel;

    private int dayCounter = 1;

    @FXML
    private void initialize() {
        // Initialize the label with the starting day
        dayLabel.setText("Jour " + dayCounter);
    }

    @FXML
    void handleNextDayButton() {
        // Increment the day counter
        dayCounter++;

        // Update the label text
        dayLabel.setText("Jour " + dayCounter);
    }
}
