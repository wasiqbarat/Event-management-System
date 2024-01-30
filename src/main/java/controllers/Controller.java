package controllers;

import Classes.Event;
import Classes.EventManagementSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    public String appName = "Event Management System";
    public EventManagementSystem eventManagementSystem = EventManagementSystem.getInstance();

    private static String currentUserName = "";
    private static String currentPassword = "";

    public static String getCurrentUserName() {
        return currentUserName;
    }

    public static void setCurrentUserName(String currentUserName) {
        Controller.currentUserName = currentUserName;
    }

    public static String getCurrentPassword() {
        return currentPassword;
    }

    public static void setCurrentPassword(String currentPassword) {
        Controller.currentPassword = currentPassword;
    }
    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void gotoMainMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainMenu.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(appName);

        stage.setScene(scene);
        //stage.setWidth(950);
        //stage.setHeight(640);

        stage.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));
        stage.setResizable(true);
        stage.setMaximized(false);
        stage.show();
    }
    protected void checkIfEmpty(TextField textField) throws Exception {
        if (textField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information missed");
            alert.setHeaderText("Please fill the required text field.");

            ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> result = alert.showAndWait();
            textField.requestFocus();
            Exception IOException = new Exception("Field is empty!");
            throw IOException;
        }

    }

}

