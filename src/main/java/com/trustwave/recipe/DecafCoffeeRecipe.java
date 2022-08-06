package com.trustwave.recipe;

import com.trustwave.ingredient.CreamIngredient;
import com.trustwave.ingredient.DecafCoffeeIngredient;
import com.trustwave.ingredient.Ingredient;
import com.trustwave.ingredient.SugarIngredient;

public class DecafCoffeeRecipe extends Recipe {
    private Ingredient decafCoffee;
    private Ingredient sugar;
    private Ingredient cream;

    public DecafCoffeeRecipe(){
        super.setName("Decaf Coffee Recipe");
        this.decafCoffee = new DecafCoffeeIngredient();
        this.sugar = new SugarIngredient();
        this.cream = new CreamIngredient();
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.decafCoffee, 3);
        super.addIngredient(this.sugar, 1);
        super.addIngredient(this.cream, 1);
    }
}
