package com.trustwave.drink;

import com.trustwave.ingredient.Ingredient;
import java.util.Map;

public abstract class Drink {
    private String name;
    private Map<String, Ingredient> ingredients;
    private Map<String, Integer> recipe;
    private double cost;

    public Drink(Map<String, Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Ingredient> getIngredients(){
        return this.ingredients;
    }

    public void setIngredients(Map<String, Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<String, Integer> getRecipe(){
        return this.recipe;
    }

    public void setRecipe(Map<String, Integer> recipe){
        this.recipe = recipe;
    }

    public double getCost(){
        return this.cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public double calculateCost(Map<String, Ingredient> ingredients, Map<String, Integer> recipe) {
        double cost = 0.0;

        for (Map.Entry<String, Integer> entry : recipe.entrySet()) {
            cost += ingredients.get(entry.getKey()).getCost() * (double)entry.getValue();
        }

        return cost;
    }

    public String display(){
        return name + ", " + cost;
    }
}
