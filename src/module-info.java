module fantasticZoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens application to javafx.graphics, javafx.fxml;
    opens controllers.views to javafx.fxml;
    opens controllers.modals to javafx.fxml;
}
