package controllers;

import javafx.application.Platform;
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
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainMenu extends Controller implements Initializable {

    @FXML
    private Button exit;

    @FXML
    private Button newPatient;

    @FXML
    private Button profile;

    @FXML
    private TextField footer;

    @FXML
    private Button searchPatient;

    @FXML
    void ProfileButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ProfileMenu.fxml"));
        Parent root = fxmlLoader.load();
        Stage lastStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        lastStage.close();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(appName);
        stage.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));

        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();
    }

    @FXML
    void exitButtonPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("Do you want to exit application?");

        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == yes) {
            Platform.exit();
        }
    }


    @FXML
    void createEvent(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("CreateEvent.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();

        Scene scene = new Scene(root);

        stage.setTitle(appName);

        stage.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void requestEventDetail(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("RequestEventDetail.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();

        Scene scene = new Scene(root);
        stage.setTitle(appName);
        stage.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));

        stage.setScene(scene);
        stage.show();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeFooter(footer);
    }

    private void initializeFooter(TextField textField) {
        String log;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | h:mm a");
        String loginTime = LocalDateTime.now().format(formatter);

        String identity = "         You are logged in as ( " + getCurrentUserName() + " )";

        log = identity + "        login time(زمان ورود): ".concat(loginTime);

        footer.setText(log);
    }

    @FXML
    void LogOutButtonPressed(ActionEvent event) throws IOException {
        setCurrentPassword(null);
        setCurrentUserName(null);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("firstMenu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(appName);
        stage.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));
        stage.setScene(scene);
        stage.setHeight(450);
        stage.setWidth(600);
        stage.setResizable(false);
        stage.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }


    @FXML
    void addNewStaffButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Application.class.getResource("AuthenticationDialog.fxml"));
        Parent root1 = loader.load();
        Stage stage1 = new Stage();

        Scene scene1 = new Scene(root1);
        stage1.setTitle("Authentication");
        stage1.getIcons().add(new Image("file:src\\main\\resources\\assets\\icon2.png"));

        stage1.setResizable(false);
        stage1.setScene(scene1);
        AuthenticationDialog authenticationDialog = loader.getController();
        stage1.showAndWait();
    }


}