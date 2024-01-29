package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class CreateEvent extends Controller implements Initializable {
    private String doctorName;
    private String patientSex;
    private String ageUnit;
    private LocalDateTime dateTime;
    private ArrayList<String> selectedTests = new ArrayList<>();
    private double totalCostDouble = 0;
    private int fontSizeInteger;

    @FXML
    private ComboBox<String> doctorsChoiceBox;

    @FXML
    private TextField totalCost;

    @FXML
    private TextField removeTest;

    @FXML
    private Label patientID;

    @FXML
    private ToggleGroup a;

    @FXML
    private TextField address;

    @FXML
    private TextField age;

    @FXML
    private TextField contactNo;

    @FXML
    private TextField email;

    @FXML
    private TextField sexTextField;

    @FXML
    private TextField fatherName;

    @FXML
    private Label data;

    @FXML
    private TextField name;

    @FXML
    private TextField processTime;

    @FXML
    private TextField testsTextField;

    @FXML
    private RadioButton month;

    @FXML
    private RadioButton day;

    @FXML
    private RadioButton year;

    @FXML
    private Button print;

    @FXML
    private Button maleButton;

    @FXML
    private Button femaleButton;

    @FXML
    private Button childButton;

    @FXML
    private Button save;

    @FXML
    private TextField fontSize;

    @FXML
    private Label printStatus;

    private AutoCompletionBinding autoCompletionBinding;
    private AutoCompletionBinding autoCompletionBinding2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initializingRegisterData();

    }


    private void createAppointment() {
        String nameString = name.getText();
        String fatherNameString = fatherName.getText();
        String contactString = contactNo.getText();
        String addressString = address.getText();
        String processTimeString = processTime.getText();
        String emailString = email.getText();

        if (name.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Essential information");
            alert.setHeaderText("Patient name required!");
            alert.showAndWait();

            name.requestFocus();
            return;
        }

        if (fatherName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Essential information");
            alert.setHeaderText("Patient father name required!");
            alert.showAndWait();

            fatherName.requestFocus();
            return;
        }
        if (age.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Essential information");
            alert.setHeaderText("Age required!");
            alert.showAndWait();

            age.requestFocus();
            return;
        }

        if (address.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Essential information");
            alert.setHeaderText("Address required!");
            alert.showAndWait();

            address.requestFocus();
            return;
        }

        int intAge = 0;
        int intContact;

        try {
            intAge = Integer.parseInt(age.getText());
        } catch (Exception e) {
            age.requestFocus();
            return;
        }

        try {
            intContact = Integer.parseInt(contactNo.getText());
        } catch (Exception e) {
            intContact = 0;
        }

    }

    @FXML
    void saveButtonPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        //alert.setContentText("Are you sure want to save?!");// line 4

        ButtonType saveAndPrintButtonType = new ButtonType("Save and print", ButtonBar.ButtonData.OK_DONE);
        ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);

        alert.getButtonTypes().setAll(saveAndPrintButtonType, saveButtonType, ButtonType.CANCEL);

        Optional<ButtonType> result = alert.showAndWait();


    }
    private void initializingRegisterData() {
        dateTime = LocalDateTime.now();

        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(
                "yyyy-MM-dd | h:mm a");

        String loginTime = dateTime.format(formatter);

        data.setText(loginTime);
    }


    @FXML
    void cancelButtonPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Data well be deleted!");
        //alert.setContentText("Are you sure want to close?!");// line 4
        ButtonType continueToAddPatient = new ButtonType("Continue to add patient", ButtonBar.ButtonData.OK_DONE);
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


    @FXML
    private void maleButtonAction(ActionEvent event) {
        sexTextField.setText("Male");
        patientSex = "Male";
        age.requestFocus();
    }

    @FXML
    private void femaleButtonAction(ActionEvent event) {
        sexTextField.setText("Female");
        patientSex = "Female";
        age.requestFocus();
    }

    @FXML
    private void childButtonAction(ActionEvent event) {
        sexTextField.setText("Child");
        patientSex = "Child";
        age.requestFocus();
    }

    @FXML
    void ageTextFieldAction(ActionEvent event) {
        testsTextField.requestFocus();
    }

    @FXML
    void fatherNameTextFieldAction(ActionEvent event) {
        address.requestFocus();
    }

    @FXML
    void nameTextFieldAction(ActionEvent event) {
        fatherName.requestFocus();
    }


    @FXML
    void addressAction(ActionEvent event) {
        maleButton.requestFocus();
    }

    public void printButtonPressed(ActionEvent event) {

    }

    public void testsTextFieldAction(ActionEvent event) {

    }

}
