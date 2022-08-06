package com.trustwave.inventory;

import com.trustwave.drink.Drink;
import com.trustwave.ingredient.Ingredient;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> inventoryMap;

    public Inventory(Map<String, Integer> inventoryMap){
        this.inventoryMap = inventoryMap;
    }

    public Map<String, Integer> getInventoryMap(){
        return this.inventoryMap;
    }

    public void addIngredient(Ingredient ingredient, int units){
        this.inventoryMap.put(ingredient.getName(), units);
    }

    public void removeIngredient(Ingredient ingredient){
        this.inventoryMap.remove(ingredient.getName());
    }

    public void decreaseIngredientUnits(Ingredient ingredient, int units){
        this.inventoryMap.replace(ingredient.getName(), this.inventoryMap.get(ingredient.getName())-units);
    }

    public void decreaseIngredientUnitsByDrink(Drink drink){
        for (Map.Entry<String, Integer> entry : drink.getRecipe().entrySet()){
            this.inventoryMap.replace(entry.getKey(), this.inventoryMap.get(entry.getKey()) - entry.getValue());
        }
    }

    public void restock(){
        for (Map.Entry<String, Integer> entry : this.inventoryMap.entrySet()) {
            entry.setValue(10);
        }
    }

    public void display(){
        System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : this.inventoryMap.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}
