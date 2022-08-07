package com.trustwave.drink;

import com.trustwave.ingredient.Ingredient;
import com.trustwave.recipe.CaffeAmericanoRecipe;
import java.util.Map;

public class CaffeAmericanoDrink extends Drink {

    private CaffeAmericanoRecipe caffeAmericanoRecipe = new CaffeAmericanoRecipe();

    public CaffeAmericanoDrink(Map<String, Ingredient> ingredients){
        super(ingredients);
        super.setName("Caffe Americano");
        super.setRecipe(caffeAmericanoRecipe.getRecipe());
        super.setCost(calculateCost(getIngredients(), getRecipe()));
    }
}
