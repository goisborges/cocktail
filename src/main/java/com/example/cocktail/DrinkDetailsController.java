package com.example.cocktail;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrinkDetailsController implements Initializable {

    @FXML
    private JFXButton backBtn;

    @FXML
    private Label drinkAlcoholicTextField;

    @FXML
    private Label drinkCategoryTextField;

    @FXML
    private Label drinkGlassTextField;

    @FXML
    private Label drinkIdTextField;

    @FXML
    private ImageView drinkImageView;

    @FXML
    private Label drinkInstructionsTextField;

    @FXML
    private Label drinkNameTextField;

    @FXML
    private Label ingredient10Label;

    @FXML
    private Label ingredient1Label;

    @FXML
    private Label ingredient2Label;

    @FXML
    private Label ingredient3Label;

    @FXML
    private Label ingredient4Label;

    @FXML
    private Label ingredient5Label;

    @FXML
    private Label ingredient6Label;

    @FXML
    private Label ingredient7Label;

    @FXML
    private Label ingredient8Label;

    @FXML
    private Label ingredient9Label;

    @FXML
    private Label measure10Label;

    @FXML
    private Label measure1Label;

    @FXML
    private Label measure2Label;

    @FXML
    private Label measure3Label;

    @FXML
    private Label measure4Label;

    @FXML
    private Label measure5Label;

    @FXML
    private Label measure6Label;

    @FXML
    private Label measure7Label;

    @FXML
    private Label measure8Label;

    @FXML
    private Label measure9Label;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //method that will call the API to get the drink details
    public void loadDrinkDetails(String drinkId) {
        DrinkDetails drink = null;
        try {
            drink = ApiCalls.getDrinkDetails(drinkId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //set the drink details to the text fields
        drinkIdTextField.setText(drink.getIdDrink());
        drinkNameTextField.setText(drink.getStrDrink());
        drinkInstructionsTextField.setText(drink.getStrInstructions());
        drinkGlassTextField.setText(drink.getStrGlass());
        drinkCategoryTextField.setText(drink.getStrCategory());
        drinkAlcoholicTextField.setText(drink.getStrAlcoholic());
        //set ingredients and measures to the labels
        ingredient1Label.setText(drink.getStrIngredient1());
        measure1Label.setText(drink.getStrMeasure1());
        ingredient2Label.setText(drink.getStrIngredient2());
        measure2Label.setText(drink.getStrMeasure2());
        ingredient3Label.setText(drink.getStrIngredient3());
        measure3Label.setText(drink.getStrMeasure3());
        ingredient4Label.setText(drink.getStrIngredient4());
        measure4Label.setText(drink.getStrMeasure4());
        ingredient5Label.setText(drink.getStrIngredient5());
        measure5Label.setText(drink.getStrMeasure5());
        ingredient6Label.setText(drink.getStrIngredient6());
        measure6Label.setText(drink.getStrMeasure6());
        ingredient7Label.setText(drink.getStrIngredient7());
        measure7Label.setText(drink.getStrMeasure7());
        ingredient8Label.setText(drink.getStrIngredient8());
        measure8Label.setText(drink.getStrMeasure8());
        ingredient9Label.setText(drink.getStrIngredient9());
        measure9Label.setText(drink.getStrMeasure9());
        ingredient10Label.setText(drink.getStrIngredient10());
        measure10Label.setText(drink.getStrMeasure10());


        //set image to the image view
        try {
            drinkImageView.setImage(new Image(drink.getStrDrinkThumb()));
        }
        catch (Exception e) {
            e.printStackTrace();
            //set default image
            drinkImageView.setImage(new Image("src/main/resources/com/example/cocktail/drinks.jpg"));
        }
    }

    @FXML
    private void returnToSearch(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes(event,"cocktails-view.fxml");
    }
}
