package com.trustwave.recipe;

import com.trustwave.ingredient.EspressoIngredient;
import com.trustwave.ingredient.Ingredient;
import com.trustwave.ingredient.SteamedMilkIngredient;

public class CaffeLatteRecipe extends Recipe {
    private Ingredient espresso;
    private Ingredient steamedMilk;

    public CaffeLatteRecipe(){
        super.setName("Caffe Latte Recipe");
        this.espresso = new EspressoIngredient();
        this.steamedMilk = new SteamedMilkIngredient();
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.espresso, 2);
        super.addIngredient(this.steamedMilk, 1);
    }
}
