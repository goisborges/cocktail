package com.example.cocktail;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ApiCalls {

    //create a method that returns all cocktails list from JSON file
    public static ApiResponse getAllCocktailsJSON() {
        //create a GSON object
        Gson gson = new Gson();

        ApiResponse response = null;

        try (
            FileReader reader = new FileReader("src/main/resources/response.json");
            JsonReader jsonReader = new JsonReader(reader)
        )
        {
        response = gson.fromJson(jsonReader, ApiResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }

    //create a method that returns all cocktails list from an API
    public static ApiResponse getAllCocktailsAPI(String searchTerm) throws IOException, InterruptedException {
        searchTerm = searchTerm.trim().replace(" ", "%20");

        String uri = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + searchTerm;
        System.out.println(uri);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        //this sends the result from the API to a file
//        HttpResponse<Path> response = client.send(httpRequest, HttpResponse
//                                                                .BodyHandlers
//                                                                .ofFile(Paths.get("jsonData.json")));
//        return getMoviesJsonFile();

        //this approach stores the API response to a String and then creates objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String jsonString =response.body();

        Gson gson = new Gson();
        ApiResponse apiResponse = null;

        try{
            apiResponse  = gson.fromJson(jsonString, ApiResponse.class);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;
    }

    //create a method that returns all cocktails list from an API
    public static ApiResponse searchCocktailByIngredient (String searchTerm) {
        //modify the search so it replaces spaces with %20
        searchTerm = searchTerm.trim().replace(" ", "%20");

        //create a GSON object
        Gson gson = new Gson();

        ApiResponse response = null;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.thecocktaildb.com/api/json/v1/1/filter.php?i="+searchTerm))
                    .build();
            System.out.println(request);
            HttpResponse<Path> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("src/main/resources/response.json")));
//            response = gson.fromJson(httpResponse.body(), ApiResponse.class);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return getAllCocktailsJSON();

    }

    //method that will parse JSON file to retrieve all categories
    //create a method that returns all cocktails list from JSON file
    public static ApiResponse getAllCategoriesJSON() {
        //create a GSON object
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
        return response;

    }

    //create a method named getCategoryList that returns a list of categories
    public static ApiResponse getCategoryList() {
        //create a GSON object
        Gson gson = new Gson();

        ApiResponse response = null;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list"))
                    .build();
            HttpResponse<Path> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("src/main/resources/categories.json")));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return getAllCategoriesJSON();

    }

    //method that will get drinks details from API
    //create a method that returns all cocktails list from an API
    public static ApiResponse getDrinkDetails(String drinkId) throws IOException, InterruptedException {
        drinkId = drinkId.trim().replace(" ", "%20");

        String uri = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i="+drinkId;
        System.out.println("uri: " + uri);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ApiResponse apiResponse = null;
        apiResponse  = gson.fromJson(response.body(), ApiResponse.class);
        System.out.println("API REsponse" + apiResponse);
        System.out.println(apiResponse.getDrinks());
        return apiResponse;
    }

    //create an API method that returns a list of drinks by category
    public static ApiResponse getDrinksByCategory(String category) {
        category = category.trim().replace(" ", "%20");

        //create a GSON object
        Gson gson = new Gson();

        ApiResponse response = null;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c="+category))
                    .build();
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            response = gson.fromJson(httpResponse.body(), ApiResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }

}
