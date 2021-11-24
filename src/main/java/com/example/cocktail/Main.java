package com.example.cocktail;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cocktails-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cocktail Spirit");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)  {
        launch();
    }

//        ApiResponse resultAPI = ApiCalls.getAllCocktailsAPI("margarita");
//        System.out.println(resultAPI);

//        ApiResponse resultAPI = ApiCalls.searchCocktailByIngredient("rum");
//        System.out.println(resultAPI);




}
