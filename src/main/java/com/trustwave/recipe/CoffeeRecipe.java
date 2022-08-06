package com.trustwave.recipe;

import com.trustwave.ingredient.CoffeeIngredient;
import com.trustwave.ingredient.CreamIngredient;
import com.trustwave.ingredient.Ingredient;
import com.trustwave.ingredient.SugarIngredient;

public class CoffeeRecipe extends Recipe {
    private Ingredient coffee;
    private Ingredient sugar;
    private Ingredient cream;

    public CoffeeRecipe(){
        super.setName("Coffee Recipe");
        this.coffee = new CoffeeIngredient();
        this.sugar = new SugarIngredient();
        this.cream = new CreamIngredient();
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.coffee, 3);
        super.addIngredient(this.sugar, 1);
        super.addIngredient(this.cream, 1);
    }
}
