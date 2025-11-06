package org.example.adressbook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class OtherLabs {

    @FXML
    private Label text;

    @FXML
    private Button choose;

    @FXML
    private ImageView imageView;


    Image image = new Image(getClass().getResourceAsStream("knight.jpg"));

    @FXML
    public void initialize() {
        imageView.setImage(new Image(getClass().getResourceAsStream("sky.jpg")));
    }

    @FXML
    void changeLabel(ActionEvent event){
        imageView.setImage(image);
        text.setText("Ви успішно змінили картинку!");
        choose.setDisable(true);
    }





}
