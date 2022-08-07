package com.trustwave.drink;

import com.trustwave.ingredient.Ingredient;
import com.trustwave.recipe.CoffeeRecipe;
import java.util.Map;

public class CoffeeDrink extends Drink {

    private CoffeeRecipe coffeeRecipe = new CoffeeRecipe();

    public CoffeeDrink(Map<String, Ingredient> ingredients){
        super(ingredients);
        super.setName("Coffee");
        super.setRecipe(coffeeRecipe.getRecipe());
        super.setCost(calculateCost(getIngredients(), getRecipe()));
    }
}
