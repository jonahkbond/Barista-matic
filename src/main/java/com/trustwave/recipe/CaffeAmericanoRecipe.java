package com.trustwave.recipe;

import com.trustwave.ingredient.Ingredient;

public class CaffeAmericanoRecipe extends Recipe {
    private Ingredient espresso;

    public CaffeAmericanoRecipe(){
        super.setName("Caffe Americano Recipe");
        this.espresso = new Ingredient("Espresso", 1.10);
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.espresso, 3);
    }
}
