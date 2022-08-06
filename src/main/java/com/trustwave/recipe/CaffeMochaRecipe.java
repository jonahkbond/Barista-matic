package com.trustwave.recipe;

import com.trustwave.ingredient.*;

public class CaffeMochaRecipe extends Recipe {
    private Ingredient espresso;
    private Ingredient cocoa;
    private Ingredient steamedMilk;
    private Ingredient whippedCream;

    public CaffeMochaRecipe(){
        super.setName("Caffe Mocha Recipe");
        this.espresso = new EspressoIngredient();
        this.cocoa = new CocoaIngredient();
        this.steamedMilk = new SteamedMilkIngredient();
        this.whippedCream = new WhippedCreamIngredient();
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
