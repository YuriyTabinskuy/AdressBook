module org.example.adressbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.adressbook to javafx.fxml;
    exports org.example.adressbook;
}