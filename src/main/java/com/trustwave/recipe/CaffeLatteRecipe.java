package com.trustwave.recipe;

import com.trustwave.ingredient.Ingredient;

public class CaffeLatteRecipe extends Recipe {
    private Ingredient espresso;
    private Ingredient steamedMilk;

    public CaffeLatteRecipe(){
        super.setName("Caffe Latte Recipe");
        this.espresso = new Ingredient("Espresso", 1.10);
        this.steamedMilk = new Ingredient("Steamed Milk", 0.35);
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.espresso, 2);
        super.addIngredient(this.steamedMilk, 1);
    }
}
