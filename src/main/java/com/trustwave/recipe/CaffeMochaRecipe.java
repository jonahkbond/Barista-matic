package com.trustwave.recipe;

import com.trustwave.ingredient.Ingredient;

public class CaffeMochaRecipe extends Recipe {
    private Ingredient espresso;
    private Ingredient cocoa;
    private Ingredient steamedMilk;
    private Ingredient whippedCream;

    public CaffeMochaRecipe(){
        super.setName("Caffe Mocha Recipe");
        this.espresso = new Ingredient("Espresso", 1.10);
        this.cocoa = new Ingredient("Cocoa", 0.90);
        this.steamedMilk = new Ingredient("Steamed Milk", 0.35);
        this.whippedCream = new Ingredient("Whipped Cream", 1.00);
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.espresso, 1);
        super.addIngredient(this.cocoa, 1);
        super.addIngredient(this.steamedMilk, 1);
        super.addIngredient(this.whippedCream, 1);
    }
}
