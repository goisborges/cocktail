package com.example.cocktail;

public class DrinkDetailsResponse {
    private Cocktail drink;

    public DrinkDetailsResponse(Cocktail drink) {
        this.drink = drink;
    }

    public Cocktail getDrink() {
        return drink;
    }
}
