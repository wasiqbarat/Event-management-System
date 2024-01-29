package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AuthenticationDialog extends Controller{

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label status;

    private boolean authentication = false;

    @FXML
    void okButtonPressed(ActionEvent event) {

    }


    public boolean isAuthentication() {
        return authentication;
    }

    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    @FXML
    void cancelButtonPressed(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void passwordAction(ActionEvent event) {
        okButtonPressed(event);
    }

    @FXML
    void usernameAction(ActionEvent event) {
        if (username.getText().isEmpty()) {
            username.requestFocus();
            return;
        }
        password.requestFocus();
    }

}
