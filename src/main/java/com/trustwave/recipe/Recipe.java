package com.trustwave.recipe;

import com.trustwave.ingredient.Ingredient;

import java.util.HashMap;
import java.util.Map;

public abstract class Recipe {
    private String name;
    private Map<String, Integer> recipe;

    public Recipe(){
        recipe = new HashMap<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public abstract void setRecipe();

    public Map<String, Integer> getRecipe(){
        return this.recipe;
    }

    public void addIngredient(Ingredient ingredient, int units){
        this.recipe.put(ingredient.getName(), units);
    }

    public void removeIngredient(Ingredient ingredient){
        this.recipe.remove(ingredient.getName());
    }

    public void updateIngredient(Ingredient ingredient, int units){
        this.recipe.replace(ingredient.getName(), units);
    }

    public void display(){
        for (Map.Entry<String, Integer> entry : this.recipe.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}
