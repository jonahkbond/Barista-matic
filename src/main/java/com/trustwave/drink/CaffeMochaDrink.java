package com.trustwave.drink;

import com.trustwave.ingredient.Ingredient;
import com.trustwave.recipe.CaffeMochaRecipe;
import java.util.Map;

public class CaffeMochaDrink extends Drink {

    private CaffeMochaRecipe caffeMochaRecipe = new CaffeMochaRecipe();

    public CaffeMochaDrink(Map<String, Ingredient> ingredients){
        super(ingredients);
        super.setName("Caffe Mocha");
        super.setRecipe(caffeMochaRecipe.getRecipe());
        super.setCost(calculateCost(getIngredients(), getRecipe()));
    }
}
