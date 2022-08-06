package com.trustwave.drink;

public class DrinkManager {

    public void dispensing(Drink drink){
        System.out.println("Dispensing: " + drink.getName());
    }

    public void outOfStock(Drink drink){
        System.out.println("Out of stock: " + drink.getName());
    }
}
