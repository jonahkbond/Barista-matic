package com.trustwave.drink;

import com.trustwave.ingredient.Ingredient;
import com.trustwave.recipe.DecafCoffeeRecipe;
import java.util.Map;

public class DecafCoffeeDrink extends Drink {

    private DecafCoffeeRecipe decafCoffeeRecipe = new DecafCoffeeRecipe();

    public DecafCoffeeDrink(Map<String, Ingredient> ingredients){
        super(ingredients);
        super.setName("Decaf Coffee");
        super.setRecipe(decafCoffeeRecipe.getRecipe());
        super.setCost(calculateCost(getIngredients(), getRecipe()));
    }
}
