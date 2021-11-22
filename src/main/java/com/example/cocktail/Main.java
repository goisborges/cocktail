package com.example.cocktail;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
//        ApiResponse resultAPI = ApiCalls.getAllCocktailsAPI("margarita");
//        System.out.println(resultAPI);

        ApiResponse resultAPI = ApiCalls.searchCocktailByIngredient("rum");
        System.out.println(resultAPI);

    }

}
