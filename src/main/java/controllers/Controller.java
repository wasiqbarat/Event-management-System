package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public String appName = "Event Management System";

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


}

