module com.example.cocktail {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.net.http;
    requires gson;
    requires java.sql;
    requires com.jfoenix;

    opens com.example.cocktail to javafx.fxml, gson;
    exports com.example.cocktail;

}