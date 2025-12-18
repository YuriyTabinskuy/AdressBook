package org.example.adressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Lab7Controller implements Initializable {

    @FXML private DatePicker datePicker;
    @FXML private Label lblDateResult;

    @FXML private ColorPicker colorPicker;
    @FXML private VBox colorBackground;
    @FXML private Label lblColorResult;

    @FXML private Slider volumeSlider;
    @FXML private Label lblSliderResult;

    @FXML private MediaView mediaView;
    @FXML private Button btnPlay;
    @FXML private Button btnStop;
    @FXML private Button btnOpenMedia;

    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setValue(50);

        volumeSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblSliderResult.setText("Гучність: " + String.format("%.0f", newVal) + "%");
            if (mediaPlayer != null) {

                mediaPlayer.setVolume(newVal.doubleValue() / 100.0);
            }
        });
        lblSliderResult.setText("Гучність: 50%");


        btnPlay.setDisable(true);
        btnStop.setDisable(true);
    }


    @FXML
    void handleDatePicker(ActionEvent event) {
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate != null) {
            lblDateResult.setText("Обрана дата: " + selectedDate.toString());
        } else {
            lblDateResult.setText("Дата не обрана.");
        }
    }


    @FXML
    void handleColorPicker(ActionEvent event) {
        Color selectedColor = colorPicker.getValue();


        String hexColor = String.format("#%02X%02X%02X",
                (int) (selectedColor.getRed() * 255),
                (int) (selectedColor.getGreen() * 255),
                (int) (selectedColor.getBlue() * 255));

        colorBackground.setStyle("-fx-background-color: " + hexColor + ";");
        lblColorResult.setText("Обраний колір: " + hexColor);
        lblColorResult.setTextFill(selectedColor.invert());
    }


    @FXML
    void openMediaFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Оберіть медіафайл (mp3, mp4, wav)");

        FileChooser.ExtensionFilter mediaFilter = new FileChooser.ExtensionFilter(
                "Медіафайли", "*.mp4", "*.mp3", "*.wav");
        fileChooser.getExtensionFilters().add(mediaFilter);

        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.dispose();
            }

            try {
                Media media = new Media(file.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);

                mediaPlayer.setVolume(volumeSlider.getValue() / 100.0);

                btnPlay.setDisable(false);
                btnStop.setDisable(false);

                mediaPlayer.play();

            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Помилка завантаження медіа");
                alert.setHeaderText("Не вдалося завантажити медіафайл.");
                alert.setContentText("Перевірте шлях до файлу, його формат та наявність необхідних кодеків.");
                alert.showAndWait();
            }
        }
    }


    @FXML
    void playMedia(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    @FXML
    void stopMedia(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}