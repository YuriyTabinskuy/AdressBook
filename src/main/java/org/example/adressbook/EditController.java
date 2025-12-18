package org.example.adressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {

    @FXML
    private TextField txtPip;

    @FXML
    private TextField txtPhone;

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
        txtPip.setText(person.getPip());
        txtPhone.setText(person.getPhone());
    }

    public Person getPerson() {
        return person;
    }

    @FXML
    void actionSave(ActionEvent event) {
        person.setPip(txtPip.getText());
        person.setPhone(txtPhone.getText());
        actionClose(event);
    }

    @FXML
    void actionClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}