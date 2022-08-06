package com.trustwave.recipe;

import com.trustwave.ingredient.EspressoIngredient;
import com.trustwave.ingredient.Ingredient;

public class CaffeAmericanoRecipe extends Recipe {
    private Ingredient espresso;

    public CaffeAmericanoRecipe(){
        super.setName("Caffe Americano Recipe");
        this.espresso = new EspressoIngredient();
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.espresso, 3);
    }
}
