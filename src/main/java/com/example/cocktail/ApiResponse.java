package com.example.cocktail;

public class ApiResponse {
    private Cocktail[] drinks;
    //make it an ArrayList if wants to sort by name

    public Cocktail[] getDrinks() {
        return drinks;
    }

    //create a field that will hold all the strCategory from the drinks
    //create a method that will return the array of categories
    public String[] getCategories() {
            String[] categories = new String[drinks.length];
            for (int i = 0; i < drinks.length; i++) {
                categories[i] = drinks[i].getStrCategory();
            }
            return categories;
        }




}
