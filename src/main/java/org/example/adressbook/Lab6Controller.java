package org.example.adressbook;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Lab6Controller implements Initializable {

    // CheckBox
    @FXML private CheckBox chkПогодженість;
    @FXML private CheckBox chkДружність;
    @FXML private CheckBox chkГнучкість;
    @FXML private CheckBox chkСкладність;
    @FXML private Label lblCheckBoxResult;

    // ChoiceBox
    @FXML private ChoiceBox<String> choiceBox;
    @FXML private Label lblChoiceBoxResult;
    private final String[] choiceOptions = {"Правильно", "Неправильно"};

    // ComboBox
    @FXML private ComboBox<String> comboBox;
    @FXML private Label lblComboBoxResult;
    private final String[] comboOptions = {"Control", "Menu", "Palette", "Content", "Properties"};


    @FXML private RadioButton rbProperties;
    @FXML private RadioButton rbLayout;
    @FXML private RadioButton rbCode;
    @FXML private RadioButton rbControls;
    @FXML private Label lblRadioButtonResult;


    @FXML private Label lblTotalResult;
    @FXML private Button btnOpenLab7;

    private int correctAnswers = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(FXCollections.observableArrayList(choiceOptions));
        choiceBox.setValue("Правильно");

        comboBox.setItems(FXCollections.observableArrayList(comboOptions));
        comboBox.setValue("Control");

        ToggleGroup rbGroup = new ToggleGroup();
        rbProperties.setToggleGroup(rbGroup);
        rbLayout.setToggleGroup(rbGroup);
        rbCode.setToggleGroup(rbGroup);
        rbControls.setToggleGroup(rbGroup);
    }

    @FXML
    void openLab7Window(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/adressbook/lab7-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Практична робота №7: Компоненти Media, Color, Date");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка завантаження");
            alert.setHeaderText("Не вдалося завантажити Lab 7");
            alert.setContentText("Перевірте, чи існують файли lab7-view.fxml та Lab7Controller.java.");
            alert.showAndWait();
        }
    }


    @FXML
    private void checkCheckBox(ActionEvent event) {
        boolean isCorrect = chkПогодженість.isSelected() && chkДружність.isSelected() && chkГнучкість.isSelected() && !chkСкладність.isSelected();
        if (isCorrect) {
            lblCheckBoxResult.setText("Вітаємо! Ваша відповідь правильна!");
            lblCheckBoxResult.setTextFill(Color.GREEN);
        } else {
            lblCheckBoxResult.setText("Подумайте ще раз!");
            lblCheckBoxResult.setTextFill(Color.RED);
        }
        updateTotalResult();
    }

    @FXML
    private void checkChoiceBox(ActionEvent event) {
        if ("Неправильно".equals(choiceBox.getValue())) {
            lblChoiceBoxResult.setText("Вітаємо! Ваша відповідь правильна!");
            lblChoiceBoxResult.setTextFill(Color.GREEN);
        } else {
            lblChoiceBoxResult.setText("Подумайте ще раз!");
            lblChoiceBoxResult.setTextFill(Color.RED);
        }
        updateTotalResult();
    }

    @FXML
    private void checkComboBox(ActionEvent event) {
        if ("Palette".equals(comboBox.getValue())) {
            lblComboBoxResult.setText("Вітаємо! Ваша відповідь правильна!");
            lblComboBoxResult.setTextFill(Color.GREEN);
        } else {
            lblComboBoxResult.setText("Подумайте ще раз!");
            lblComboBoxResult.setTextFill(Color.RED);
        }
        updateTotalResult();
    }

    @FXML
    private void checkRadioButton(ActionEvent event) {
        if (rbProperties.isSelected()) {
            lblRadioButtonResult.setText("Вітаємо! Ваша відповідь правильна!");
            lblRadioButtonResult.setTextFill(Color.GREEN);
        } else {
            lblRadioButtonResult.setText("Подумайте ще раз!");
            lblRadioButtonResult.setTextFill(Color.RED);
        }
        updateTotalResult();
    }

    private void updateTotalResult() {
        boolean q1Correct = chkПогодженість.isSelected() && chkДружність.isSelected() && chkГнучкість.isSelected() && !chkСкладність.isSelected();
        boolean q2Correct = "Неправильно".equals(choiceBox.getValue());
        boolean q3Correct = "Palette".equals(comboBox.getValue());
        boolean q4Correct = rbProperties.isSelected();

        correctAnswers = 0;
        if (q1Correct) correctAnswers++;
        if (q2Correct) correctAnswers++;
        if (q3Correct) correctAnswers++;
        if (q4Correct) correctAnswers++;

        lblTotalResult.setText("Всього правильних відповідей: " + correctAnswers + "/4");
    }
}