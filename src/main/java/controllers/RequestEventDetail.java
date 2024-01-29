package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.*;


public class RequestEventDetail extends Controller implements Initializable {
    @FXML
    private TextField address;
    @FXML
    private CheckBox addressCheckBox;
    @FXML
    private TextField fatherName;
    @FXML
    private CheckBox fatherNameCheckBox;
    ///
    @FXML
    private TableColumn resultColumn;
    ///
    @FXML
    private TextField id;
    @FXML
    private CheckBox idCheckBox;
    @FXML
    private TextField name;
    @FXML
    private CheckBox nameCheckBox;

    private void initializeNames() {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> fatherNames = new ArrayList<>();
        ArrayList<String> addresses = new ArrayList<>();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void SearchButtonPressed(ActionEvent event) {
        int id1 = 0;
        if (!id.getText().isEmpty()) {
            try {
                id1 = Integer.parseInt(id.getText());
            }catch (Exception e) {
                id.requestFocus();
                return;
            }
        }


    }


    private void addressCheckBoxStatus() {
        addressCheckBox.setOnAction(event -> {
            if (!addressCheckBox.isSelected()) {
                address.setVisible(false);
            }else {
                address.setVisible(true);
            }
        });
    }

    private void nameCheckBoxStatus() {
        nameCheckBox.setOnAction(event ->  {
            if (!nameCheckBox.isSelected()) {
                name.setVisible(false);
            }else {
                name.setVisible(true);
            }
        });
    }


    @FXML
    void cancelButtonPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure?");

        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);

        alert.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == yes) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    public void nameAction(ActionEvent event) {


    }

    public void fatherNameAction(ActionEvent event) {

    }

    public void addressAction(ActionEvent event) {


    }

    public void idAction(ActionEvent event) {

    }
}
