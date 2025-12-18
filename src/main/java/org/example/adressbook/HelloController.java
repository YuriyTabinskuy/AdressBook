package org.example.adressbook;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    @FXML private Button btnAdd;
    @FXML private Button btnDelete;
    @FXML private Button btnEdit;
    @FXML private Button btnSearch;
    @FXML private TextField txtSearch;
    @FXML private Button btnOth;
    @FXML private Button btnLab6;
    @FXML private TableView<Person> tableAddressBook;
    @FXML private TableColumn<Person, String> columnPip;
    @FXML private TableColumn<Person, String> columnPhone;
    @FXML private Label labelCount;

    private Stage dialogStage;
    private EditController editController;
    private Parent editRoot;


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
        // Логіка пошуку тут
    }

    @FXML
    void openNewWindowOtherLabs() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/adressbook/other.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Other Labs (Практична №4)");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnSearch.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openLab6Window(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/adressbook/lab6-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            stage.setTitle("Практична робота №6: Контроли та Квіз");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void updateCountLabel(){
        labelCount.setText("Кількість записів: " + addressBookImpl.getPersonList().size());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnPip.setCellValueFactory(new PropertyValueFactory<Person, String>("pip"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        addressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {
                updateCountLabel();
            }
        });

        addressBookImpl.fillTestData();
        tableAddressBook.setItems(addressBookImpl.getPersonList());

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/adressbook/edit.fxml"));
            editRoot = loader.load();
            editController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDialog() {
        if (dialogStage == null) {
            dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(tableAddressBook.getScene().getWindow());
            dialogStage.setScene(new Scene(editRoot));
        }
        dialogStage.showAndWait();
    }

    @FXML
    void openWindow(ActionEvent event) {
        Button btn = (Button) event.getSource();
        Person selected = tableAddressBook.getSelectionModel().getSelectedItem();

        switch (btn.getId()) {
            case "btnAdd":
                editController.setPerson(new Person("", ""));
                showDialog();
                addressBookImpl.add(editController.getPerson());
                break;

            case "btnEdit":
                if (selected != null) {
                    editController.setPerson(selected);
                    showDialog();
                }
                break;

            case "btnDelete":
                if (selected != null) {
                    addressBookImpl.delete(selected);
                }
                break;
        }
    }
}