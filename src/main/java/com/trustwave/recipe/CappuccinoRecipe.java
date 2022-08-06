package com.trustwave.recipe;

import com.trustwave.ingredient.Ingredient;

public class CappuccinoRecipe extends Recipe {
    private Ingredient espresso;
    private Ingredient steamedMilk;
    private Ingredient foamedMilk;

    public CappuccinoRecipe(){
        super.setName("Cappuccino Recipe");
        this.espresso = new Ingredient("Espresso", 1.10);
        this.steamedMilk = new Ingredient("Steamed Milk", 0.35);
        this.foamedMilk = new Ingredient("Foamed Milk", 0.35);
        setRecipe();
    }

    @Override
    public void setRecipe() {
        super.addIngredient(this.espresso, 2);
        super.addIngredient(this.steamedMilk, 1);
        super.addIngredient(this.foamedMilk, 1);
    }
}
