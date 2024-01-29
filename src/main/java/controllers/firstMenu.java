package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class firstMenu extends Controller{
    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label status;


    @FXML
    void loginButtonPressed(ActionEvent event){
        String usernameString = username.getText();
        String passwordString = password.getText();
        if (usernameString.isEmpty()) {
            username.requestFocus();
            return;
        }
        if (passwordString.isEmpty()) {
            password.requestFocus();
            return;
        }




        try {
            gotoMainMenu(event);
        }catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    @FXML
    void signUPButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("RegisterMenu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(appName);

        stage.setScene(scene);

        stage.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));
        stage.setResizable(true);
        stage.setMaximized(false);
        stage.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void usernameAction(ActionEvent event) {
        password.requestFocus();
    }

}
