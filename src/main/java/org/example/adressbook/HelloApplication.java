package org.example.adressbook;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Головне вікно
        FXMLLoader mainLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene mainScene = new Scene(mainLoader.load(), 600, 550);
        stage.setTitle("Hello!");
        mainScene.getStylesheets().add(getClass().getResource("my.css").toExternalForm());
        stage.setScene(mainScene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}