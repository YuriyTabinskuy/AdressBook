package org.example.adressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class OtherLabs implements Initializable {

    @FXML private Button choose;
    @FXML private Label text;
    @FXML private ImageView imageView;

    private boolean isImageOne = true;
    private static final String IMAGE_PATH_ONE = "2222.jpg";
    private static final String IMAGE_PATH_TWO = "hall.jpg";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void changeLabel(ActionEvent event) {
        isImageOne = !isImageOne;

        try {
            String imagePath = isImageOne ? IMAGE_PATH_ONE : IMAGE_PATH_TWO;
            String textLabel = isImageOne ? "Картинка 1 (2222.jpg)" : "Картинка 2 (hall.jpg)";

            Image image = new Image(getClass().getResourceAsStream(imagePath));
            imageView.setImage(image);
            text.setText(textLabel);

        } catch (Exception e) {
            System.err.println("Помилка завантаження зображення: " + e.getMessage());
            text.setText("Помилка! Файл зображення відсутній або шлях неправильний.");
            e.printStackTrace();
        }
    }
}