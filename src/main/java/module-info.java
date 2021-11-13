module com.example.cocktail {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.cocktail to javafx.fxml;
    exports com.example.cocktail;
}