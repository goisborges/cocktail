package com.example.cocktail;

public class Cocktail {
    private String idDrink;
    private String strDrink;
    private String strCategory;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;
    private String strDrinkThumb;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;

    public Cocktail(String idDrink, String strDrink, String strCategory, String strAlcoholic, String strGlass, String strInstructions, String strDrinkThumb, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.strCategory = strCategory;
        this.strAlcoholic = strAlcoholic;
        this.strGlass = strGlass;
        this.strInstructions = strInstructions;
        this.strDrinkThumb = strDrinkThumb;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        if(strIngredient3 != null) {
            this.strIngredient3 = strIngredient3;
        }
        if(strIngredient4 != null) {
        this.strIngredient4 = strIngredient4;
        }
        if(strIngredient5 != null) {
        this.strIngredient5 = strIngredient5;
        }
        if(strIngredient6 != null) {
        this.strIngredient6 = strIngredient6;
        }
        if(strIngredient7 != null) {
        this.strIngredient7 = strIngredient7;
        }
        if(strIngredient8 != null) {
        this.strIngredient8 = strIngredient8;
        }
        if(strIngredient9 != null) {
        this.strIngredient9 = strIngredient9;
        }
        if(strIngredient10 != null) {
        this.strIngredient10 = strIngredient10;
        }

        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        if(strMeasure3 != null) {
        this.strMeasure3 = strMeasure3;
        }
        if(strMeasure4 != null) {
        this.strMeasure4 = strMeasure4;
        }
        if(strMeasure5 != null) {
        this.strMeasure5 = strMeasure5;
        }
        if(strMeasure6 != null) {
        this.strMeasure6 = strMeasure6;
        }
        if(strMeasure7 != null) {
        this.strMeasure7 = strMeasure7;
        }
        if(strMeasure8 != null) {
        this.strMeasure8 = strMeasure8;
        }
        if(strMeasure9 != null) {
        this.strMeasure9 = strMeasure9;
        }
        if(strMeasure10 != null) {
        this.strMeasure10 = strMeasure10;
        }
    }

    public String getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public String toString(){
        return String.format("%s %s", strDrink, idDrink);
    }
}
