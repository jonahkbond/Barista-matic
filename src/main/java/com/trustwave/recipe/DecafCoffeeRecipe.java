package com.trustwave.recipe;

import com.trustwave.ingredient.Ingredient;

public class DecafCoffeeRecipe extends Recipe {
    private Ingredient decafCoffee;
    private Ingredient sugar;
    private Ingredient cream;

    public DecafCoffeeRecipe(){
        super.setName("Decaf Coffee Recipe");
        this.decafCoffee = new Ingredient("Decaf Coffee", 0.75);
        this.sugar = new Ingredient("Sugar", 0.25);
        this.cream = new Ingredient("Cream", 0.25);
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.decafCoffee, 3);
        super.addIngredient(this.sugar, 1);
        super.addIngredient(this.cream, 1);
    }
}
