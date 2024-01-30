package controllers;

import Classes.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class CreateEvent extends Controller {
    @FXML
    private TextField address;

    @FXML
    private TextField date;

    @FXML
    private TextField max;

    @FXML
    private TextField min;

    @FXML
    private TextField name;

    @FXML
    private Label printStatus;

    @FXML
    private Button save;

    @FXML
    private TextField totalCost;


    @FXML
    void saveButtonPressed(ActionEvent ActionEvent) {
        Event event = new Event(name.getText(), address.getText(), date.getText(), Integer.parseInt(max.getText()),
                Integer.parseInt(min.getText()), Double.parseDouble(totalCost.getText() ) );

        eventManagementSystem.addEvent(getCurrentUserName(), event);

    }


    @FXML
    void cancelButtonPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Data well be deleted!");
        ButtonType continueToAddPatient = new ButtonType("Do not close", ButtonBar.ButtonData.OK_DONE);
        ButtonType close = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(continueToAddPatient, close);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == close) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void newButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("CreateEvent.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();

        Scene scene = new Scene(root);
        stage.setTitle(appName + " (Add new patient)");

        stage.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));

        stage.setScene(scene);
        stage.show();
    }

}
