module com.example.adressbook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media; // Для MediaView

    opens org.example.adressbook to javafx.fxml;
    exports org.example.adressbook;
}