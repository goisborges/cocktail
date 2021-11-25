package com.example.cocktail;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class DrinkDetailsController implements Initializable {

    //transfer the skeleton from the drink-details.fxml file to this class

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //method that will call the API to get the drink details
    public void getDrinkDetails(String drinkName) {
        //DrinkDetails drink = ApiCalls.getDrinkDetails(drinkName);
        //set the drink details to the text fields
        //drinkNameTextField.setText(drink.getDrinkName());
        //drinkInstructionsTextField.setText(drink.getDrinkInstructions());
        //drinkIngredientsTextField.setText(drink.getDrinkIngredients());
        //drinkImageTextField.setText(drink.getDrinkImage());
        //drinkGlassTextField.setText(drink.getDrinkGlass());
        //drinkCategoryTextField.setText(drink.getDrinkCategory());
        //drinkAlcoholicTextField.setText(drink.getDrinkAlcoholic());
        //set image to the image view
//        try {
//            drinkImageView.setImage(new Image(drink.getDrinkImage()));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            //set default image
//            drinkImageView.setImage(new Image("drinks.jpg"));
//        }
    }
}
