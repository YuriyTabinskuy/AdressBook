package org.example.adressbook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnOth;

    @FXML
    void openNewWindow(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader mainLoader = new FXMLLoader(HelloApplication.class.getResource("edit.fxml"));
        Scene mainScene = null;
        try {
            mainScene = new Scene(mainLoader.load(), 600, 200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Edit!");
        stage.setScene(mainScene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnAdd.getScene().getWindow());
        stage.show();
    }

    @FXML
    void new_Alert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");

        alert.setHeaderText("Confirmation:");
        alert.setContentText("Deleting may change the order of people in your Address Book! ");
        alert.showAndWait();

    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void openNewWindowOtherLabs() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/demo/other.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Other Labs");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnSearch.getScene().getWindow());

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





