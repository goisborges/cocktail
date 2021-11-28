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

public class DrinkDetailsController implements Initializable, InitializeDrink {

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
        ApiResponse drink = null;
        try {
            drink = ApiCalls.getDrinkDetails(drinkId);
            System.out.println("Drink Details Loaded");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //console log the drink details
        System.out.println(drink.getDrinks()[0].getStrDrink());

        //set the drink details to the text fields
        drinkIdTextField.setText(drink.getDrinks()[0].getIdDrink());
        drinkNameTextField.setText(drink.getDrinks()[0].getStrDrink());
        drinkInstructionsTextField.setText(drink.getDrinks()[0].getStrInstructions());
        drinkGlassTextField.setText(drink.getDrinks()[0].getStrGlass());
        drinkCategoryTextField.setText(drink.getDrinks()[0].getStrCategory());
        drinkAlcoholicTextField.setText(drink.getDrinks()[0].getStrAlcoholic());
        //set ingredients and measures to the labels
        ingredient1Label.setText(drink.getDrinks()[0].getStrIngredient1());
        measure1Label.setText(drink.getDrinks()[0].getStrMeasure1());
        if(drink.getDrinks()[0].getStrIngredient2() != null) {
        ingredient2Label.setText(drink.getDrinks()[0].getStrIngredient2());
        measure2Label.setText(drink.getDrinks()[0].getStrMeasure2());
        }
        if(drink.getDrinks()[0].getStrIngredient3() != null) {
        ingredient3Label.setText(drink.getDrinks()[0].getStrIngredient3());
        measure3Label.setText(drink.getDrinks()[0].getStrMeasure3());
        }
        if(drink.getDrinks()[0].getStrIngredient4() != null) {
        ingredient4Label.setText(drink.getDrinks()[0].getStrIngredient4());
        measure4Label.setText(drink.getDrinks()[0].getStrMeasure4());
        }
        if(drink.getDrinks()[0].getStrIngredient5() != null) {
        ingredient5Label.setText(drink.getDrinks()[0].getStrIngredient5());
        measure5Label.setText(drink.getDrinks()[0].getStrMeasure5());
        }
        if(drink.getDrinks()[0].getStrIngredient6() != null) {
        ingredient6Label.setText(drink.getDrinks()[0].getStrIngredient6());
        measure6Label.setText(drink.getDrinks()[0].getStrMeasure6());
        }
        if(drink.getDrinks()[0].getStrIngredient7() != null) {
        ingredient7Label.setText(drink.getDrinks()[0].getStrIngredient7());
        measure7Label.setText(drink.getDrinks()[0].getStrMeasure7());
        }
        if(drink.getDrinks()[0].getStrIngredient8() != null) {
        ingredient8Label.setText(drink.getDrinks()[0].getStrIngredient8());
        measure8Label.setText(drink.getDrinks()[0].getStrMeasure8());
        }
        if(drink.getDrinks()[0].getStrIngredient9() != null) {
        ingredient9Label.setText(drink.getDrinks()[0].getStrIngredient9());
        measure9Label.setText(drink.getDrinks()[0].getStrMeasure9());
        }
        if(drink.getDrinks()[0].getStrIngredient10() != null) {
        ingredient10Label.setText(drink.getDrinks()[0].getStrIngredient10());
        measure10Label.setText(drink.getDrinks()[0].getStrMeasure10());
        }


        //set image to the image view
        try {
            drinkImageView.setImage(new Image(drink.getDrinks()[0].getStrDrinkThumb()));
            System.out.println("drink image set" + drink.getDrinks()[0].getStrDrinkThumb());
        }
        catch (Exception e) {
            e.printStackTrace();
            //set default image
            drinkImageView.setImage(new Image("src/main/resources/com/example/cocktail/drinks.jpg"));
        }
    }

    @FXML
    private void returnToSearch(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes2(event,"cocktails-view.fxml");
    }
}
