package controllers;

import Classes.EventManagementSystem;
import Classes.User;
import controllers.Controller;
import javafx.application.Application;
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
import java.util.ArrayList;


public class RegisterMenu extends Controller {
    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private PasswordField passwordAuthentication;

    @FXML
    private PasswordField passwordAuthentication1;

    @FXML
    private TextField phone;

    @FXML
    private Label status;

    @FXML
    private TextField userNameAuthentication;

    @FXML
    void saveButtonPressed(ActionEvent event) throws Exception {
        checkIfEmpty(email);
        checkIfEmpty(firstName);
        checkIfEmpty(lastName);
        checkIfEmpty(userNameAuthentication);
        checkIfEmpty(passwordAuthentication);
        checkIfEmpty(passwordAuthentication1);
        checkIfEmpty(phone);
        checkIfEmpty(address);

        if (!passwordAuthentication.getText().equals(passwordAuthentication1.getText())) {
            passwordAuthentication.setText("");
            passwordAuthentication.requestFocus();
            passwordAuthentication1.setText("");
        }

        EventManagementSystem eventManagementSystem = EventManagementSystem.getInstance();
        User user = new User(firstName.getText(), lastName.getText(), email.getText(), phone.getText(),
                address.getText(), eventManagementSystem.getNumberOfUsers(), Integer.parseInt(passwordAuthentication.getText()),
                userNameAuthentication.getText(), new ArrayList<>());
        eventManagementSystem.signUp(user);


        FXMLLoader fxmlLoader = new FXMLLoader(controllers.Application.class.getResource("firstMenu.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("AmirKabir Bank");

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));
        stage.setResizable(true);
        stage.setMaximized(false);
        stage.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void cancelButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("firstMenu.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("AmirKabir Bank");

        stage.setScene(scene);

        stage.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));
        stage.setResizable(true);
        stage.setMaximized(false);
        stage.show();


        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }


}
