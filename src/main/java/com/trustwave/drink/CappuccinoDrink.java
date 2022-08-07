package com.trustwave.drink;

import com.trustwave.ingredient.Ingredient;
import com.trustwave.recipe.CappuccinoRecipe;
import java.util.Map;

public class CappuccinoDrink extends Drink {

    private CappuccinoRecipe cappuccinoRecipe = new CappuccinoRecipe();

    public CappuccinoDrink(Map<String, Ingredient> ingredients){
        super(ingredients);
        super.setName("Cappuccino");
        super.setRecipe(cappuccinoRecipe.getRecipe());
        super.setCost(calculateCost(getIngredients(), getRecipe()));
    }
}
