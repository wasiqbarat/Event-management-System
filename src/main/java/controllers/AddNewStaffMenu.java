package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddNewStaffMenu extends Controller implements Initializable {

    @FXML
    private TextField staffUsernameToRemove;

    @FXML
    private PasswordField staffPassword;

    @FXML
    private TextField staffUsername;

    @FXML
    private TextField address;

    @FXML
    private TextField age;

    @FXML
    private TextField contactNo;

    @FXML
    private TextField fatherName;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private PasswordField passwordAuthentication;

    @FXML
    private TextField userNameAuthentication;

    @FXML
    private PasswordField passwordAuthentication1;

    @FXML
    private TextField userNameAuthentication1;

    @FXML
    private TextField nationalID;

    @FXML
    private TextField job;

    @FXML
    private TextField salary;
    @FXML
    private ComboBox<String> removeStaffChoiceBox;

    @FXML
    void cancelButtonPressed(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveButtonPressed(ActionEvent event) {
        String firstNameString = firstName.getText();
        String lastNameString = lastName.getText();
        String fatherNameString = fatherName.getText();
        String addressString = address.getText();
        String contactNoString = contactNo.getText();
        String ageString = age.getText();
        String nationalIDString = nationalID.getText();
        String jobString = job.getText();
        String salaryString = salary.getText();

        String staffPasswordString = staffPassword.getText();
        String staffUsernameString = staffUsername.getText();


        try {
            checkIfEmpty(salary);
            checkIfEmpty(job);
            checkIfEmpty(nationalID);
            checkIfEmpty(staffUsername);
            checkIfEmpty(staffPassword);
            checkIfEmpty(age);
            checkIfEmpty(address);
            checkIfEmpty(contactNo);
            checkIfEmpty(fatherName);
            checkIfEmpty(lastName);
            checkIfEmpty(firstName);
        } catch (Exception e) {
            return;
        }



        int age = 0;
        int contact = 0;
        try {
            contact = Integer.parseInt(contactNoString);
            age = Integer.parseInt(ageString);
        } catch (NumberFormatException ignored) {

        }


    }

    public void checkIfEmpty(TextField textField) throws Exception {
        if (textField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information missed");
            alert.setHeaderText("Please fill the required text field.");

            ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> result = alert.showAndWait();
            textField.requestFocus();
            Exception IOException = new Exception("Filed is empty!");
            throw IOException;
        }

    }

    void checkIfEmpty(PasswordField passwordField) throws Exception {
        if (passwordField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information missed");
            alert.setHeaderText("Please fill the required text field.");

            ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            Optional<ButtonType> result = alert.showAndWait();
            passwordField.requestFocus();
            Exception IOException = new Exception("Filed is empty!");
            throw IOException;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeStaffComboBox();
    }

    private void initializeStaffComboBox() {

    }

    @FXML
    void saveRemoveButtonPressed(ActionEvent event) {
        if (removeStaffChoiceBox.getValue() == null) {
            removeStaffChoiceBox.requestFocus();
            return;
        }

        try {
            checkIfEmpty(staffUsernameToRemove);
        } catch (Exception e) {
            return;
        }


        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("Do you want to remove staff?");

        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(no, yes);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == yes) {



            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }

    }

    private boolean validUsername(String username) {
        return false;
    }

}
