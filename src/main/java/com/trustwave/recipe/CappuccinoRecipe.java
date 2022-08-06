package com.trustwave.recipe;

import com.trustwave.ingredient.EspressoIngredient;
import com.trustwave.ingredient.FoamedMilkIngredient;
import com.trustwave.ingredient.Ingredient;
import com.trustwave.ingredient.SteamedMilkIngredient;

public class CappuccinoRecipe extends Recipe {
    private Ingredient espresso;
    private Ingredient steamedMilk;
    private Ingredient foamedMilk;

    public CappuccinoRecipe(){
        super.setName("Cappuccino Recipe");
        this.espresso = new EspressoIngredient();
        this.steamedMilk = new SteamedMilkIngredient();
        this.foamedMilk = new FoamedMilkIngredient();
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.espresso, 2);
        super.addIngredient(this.steamedMilk, 1);
        super.addIngredient(this.foamedMilk, 1);
    }
}
