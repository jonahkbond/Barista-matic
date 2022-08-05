package com.trustwave.menu;

import com.trustwave.drink.Drink;
import com.trustwave.inventory.Inventory;

import java.util.Map;

public class Menu {
    private Map<Integer, Drink> drinkMap;
    private Inventory inventory;

    public Menu(Map<Integer, Drink> drinkMap, Inventory inventory){
        this.drinkMap = drinkMap;
        this.inventory = inventory;
    }

    public boolean isAvailable(Drink drink){
        boolean available = false;
        //int ingredientUnitsAvailable = inventory.getInventoryMap().get(drink.getRecipe());
        for (Map.Entry<String, Integer> entry : drink.getRecipe().entrySet()) {
            available = (entry.getValue() <= this.inventory.getInventoryMap().get(entry.getKey())) ? true : false;
            System.out.println(entry);
            System.out.println("inventory " + entry.getKey() + ": " + this.inventory.getInventoryMap().get(entry.getKey()));
        }
        System.out.println("available: " + available);
        return available;
    }
}
