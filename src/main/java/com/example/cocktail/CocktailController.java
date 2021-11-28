package com.example.cocktail;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CocktailController implements Initializable {

    @FXML
    private JFXListView<Cocktail> ListView;

    @FXML
    private ToggleGroup alcoholGroup;

    @FXML
    private JFXRadioButton alcoholicRadioBtn;

    @FXML
    private JFXComboBox<String> categoryComboBox;

    @FXML
    private Label drinkNameLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private JFXRadioButton nonalcoholicRadioBtn;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchIngredientTextField;

    @FXML
    private TextField searchNameTextField;

    @FXML
    private JFXButton showDrinkBtn;

    @FXML
    private Button searchIngredientBtn;


    @FXML
    private void getSearchResults() throws IOException, InterruptedException {
        //clear the listview
        ListView.getItems().clear();

        //when user search for a drink, set the image to a general drink image and ask user to choose a drink
        File file = new File("src/main/resources/com/example/cocktail/drinks-background.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        drinkNameLabel.setText("Choose a Drink");


        ApiResponse apiResponse = ApiCalls.getAllCocktailsAPI(searchNameTextField.getText());
        if (apiResponse.getDrinks() != null) {
            ListView.getItems().addAll(apiResponse.getDrinks());
        }
        else{
            drinkNameLabel.setText("No results found");
        }
    }

    @FXML
    private void getSearchIngredient() throws IOException, InterruptedException {
        ListView.getItems().clear();

        //when user search for a drink, set the image to a general drink image and ask user to choose a drink
        File file = new File("src/main/resources/com/example/cocktail/drinks-background.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        drinkNameLabel.setText("Choose a Drink");

        ApiResponse apiResponse = ApiCalls.searchCocktailByIngredient(searchIngredientTextField.getText());

        if (apiResponse.getDrinks() != null) {
            ListView.getItems().addAll(apiResponse.getDrinks());
        }
        else{
            drinkNameLabel.setText("No results found");
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                imageView.setImage(new Image(newValue.getStrDrinkThumb()));
                drinkNameLabel.setText(newValue.getStrDrink());
                showDrinkImage();
            } catch (Exception e) {
            }
        });

        //populate the category combobox with the categories using ApiCalls method named getAllCategoriesJSON
        ApiResponse apiResponse = ApiCalls.getCategoryList();
        if (apiResponse != null) {
            //populate the combobox with the categories from categories.json file
            Gson gson = new Gson();

            ApiResponse response = null;

            try (
                    FileReader reader = new FileReader("src/main/resources/categories.json");
                    JsonReader jsonReader = new JsonReader(reader)
            )
            {
                response = gson.fromJson(jsonReader, ApiResponse.class);

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(response);
            //populate the combo box with the response variable
            categoryComboBox.getItems().addAll(response.getCategories());
        }

        //add listener to the combobox
        //if a category is selected, populate the listview with the drinks of that category
        categoryComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                //when user choose a category, get the list of drinks for that category
                ApiResponse apiResponse1 = ApiCalls.getDrinksByCategory(newValue);
                if (apiResponse1.getDrinks() != null) {
                    ListView.getItems().clear();
                    ListView.getItems().addAll(apiResponse1.getDrinks());
                }
                else{
                    drinkNameLabel.setText("No results found");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        );

    }

    //method that will turn the image visible or not visible depending if a drink is selected
    public void showDrinkImage() {
        if (ListView.getSelectionModel().getSelectedItem() != null) {
            imageView.setVisible(true);
        } else {
            imageView.setVisible(false);
        }
    }

    //create a method that will open the drink details page after getting the drink id
    //it calls the SceneChanger class to open the new scene
    @FXML
    private void getDrinkDetails(ActionEvent event) throws IOException, InterruptedException {
        String drinkId = ListView.getSelectionModel().getSelectedItem().getIdDrink();
        System.out.println(drinkId);
        SceneChanger.changeScenes(event, "drink-details-view.fxml", drinkId);
    }
}
