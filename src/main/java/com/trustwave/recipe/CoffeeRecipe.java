package com.trustwave.recipe;

import com.trustwave.ingredient.Ingredient;

public class CoffeeRecipe extends Recipe {
    private Ingredient coffee;
    private Ingredient sugar;
    private Ingredient cream;

    public CoffeeRecipe(){
        super.setName("Coffee Recipe");
        this.coffee = new Ingredient("Coffee", 0.75);
        this.sugar = new Ingredient("Sugar", 0.25);
        this.cream = new Ingredient("Cream", 0.25);
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.coffee, 3);
        super.addIngredient(this.sugar, 1);
        super.addIngredient(this.cream, 1);
    }
}
