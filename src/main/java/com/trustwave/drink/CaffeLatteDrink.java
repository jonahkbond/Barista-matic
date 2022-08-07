package com.trustwave.drink;

import com.trustwave.ingredient.Ingredient;
import com.trustwave.recipe.CaffeLatteRecipe;
import java.util.Map;

public class CaffeLatteDrink extends Drink {

    private CaffeLatteRecipe caffeLatteRecipe = new CaffeLatteRecipe();

    public CaffeLatteDrink(Map<String, Ingredient> ingredients){
        super(ingredients);
        super.setName("Caffe Latte");
        super.setRecipe(caffeLatteRecipe.getRecipe());
        super.setCost(calculateCost(getIngredients(), getRecipe()));
    }
}
