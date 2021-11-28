package com.example.cocktail;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.cocktail.DrinkDetailsController;

public class SceneChanger {

    public static void changeScenes(ActionEvent event, String fxmlFile, String drinkId) throws IOException, InterruptedException {

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load());

            InitializeDrink controller = fxmlLoader.getController();

            controller.loadDrinkDetails(drinkId);


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setTitle(drinkId);
            stage.setScene(scene);
            stage.show();

    }

    public static void changeScenes2(ActionEvent event, String fxmlFile) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
