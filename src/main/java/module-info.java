module se.se {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens se.se to javafx.fxml;
    opens controllers to javafx.fxml;

    exports controllers;
}