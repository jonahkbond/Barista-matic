package com.trustwave.menu;

import com.trustwave.drink.Drink;
import com.trustwave.inventory.Inventory;
import java.util.Map;
import static java.lang.String.format;

public class Menu {
    private Map<Integer, Drink> drinkMap;
    private Inventory inventory;

    public Menu(Map<Integer, Drink> drinkMap, Inventory inventory){
        this.drinkMap = drinkMap;
        this.inventory = inventory;
    }

    public boolean isAvailable(Drink drink){
        boolean available = false;
        for (Map.Entry<String, Integer> entry : drink.getRecipe().entrySet()) {
            if(entry.getValue() > this.inventory.getInventoryMap().get(entry.getKey())){
                available = false;
                break;
            }
            else available = true;
        }
        return available;
    }

    public void display(){
        System.out.println("Menu:");
        for (Map.Entry<Integer, Drink> entry : drinkMap.entrySet()){
            System.out.println( entry.getKey() + ", " + entry.getValue().getName() + ", $" +
                    format("%.2f", entry.getValue().getCost()) + ", " + isAvailable(entry.getValue()));
        }
    }
}
