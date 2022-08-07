package com.trustwave;

import com.trustwave.drink.*;
import com.trustwave.ingredient.*;
import com.trustwave.inventory.Inventory;
import com.trustwave.menu.Menu;
import java.io.*;
import java.util.*;

public class Baristamatic {
    public static void main(String[] args) {
        boolean quit = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        //Create Ingredients
        Ingredient coffeeIngredient = new CoffeeIngredient();
        Ingredient decafCoffeeIngredient = new DecafCoffeeIngredient();
        Ingredient sugarIngredient = new SugarIngredient();
        Ingredient creamIngredient = new CreamIngredient();
        Ingredient steamedMilkIngredient = new SteamedMilkIngredient();
        Ingredient foamedMilkIngredient = new FoamedMilkIngredient();
        Ingredient espressoIngredient = new EspressoIngredient();
        Ingredient cocoaIngredient = new CocoaIngredient();
        Ingredient whippedCreamIngredient = new WhippedCreamIngredient();

        //Create ingredients map and add Ingredients
        Map<String, Ingredient> ingredientsMap = new HashMap<>();
        ingredientsMap.put(coffeeIngredient.getName(), coffeeIngredient);
        ingredientsMap.put(decafCoffeeIngredient.getName(), decafCoffeeIngredient);
        ingredientsMap.put(sugarIngredient.getName(), sugarIngredient);
        ingredientsMap.put(creamIngredient.getName(), creamIngredient);
        ingredientsMap.put(steamedMilkIngredient.getName(), steamedMilkIngredient);
        ingredientsMap.put(foamedMilkIngredient.getName(), foamedMilkIngredient);
        ingredientsMap.put(espressoIngredient.getName(), espressoIngredient);
        ingredientsMap.put(cocoaIngredient.getName(), cocoaIngredient);
        ingredientsMap.put(whippedCreamIngredient.getName(), whippedCreamIngredient);

        //Create Drinks
        CoffeeDrink coffee = new CoffeeDrink(ingredientsMap);
        DecafCoffeeDrink decafCoffee = new DecafCoffeeDrink(ingredientsMap);
        CaffeLatteDrink caffeLatte = new CaffeLatteDrink(ingredientsMap);
        CaffeAmericanoDrink caffeAmericano = new CaffeAmericanoDrink(ingredientsMap);
        CaffeMochaDrink caffeMocha = new CaffeMochaDrink(ingredientsMap);
        CappuccinoDrink cappuccino = new CappuccinoDrink(ingredientsMap);

        //Create Inventory
        Map<String, Integer> stockMap = new TreeMap<>();
        for (Map.Entry<String, Ingredient> entry : ingredientsMap.entrySet()) {
            stockMap.put(entry.getKey(), 10);
        }
        Inventory inventory = new Inventory(stockMap);

        //Create drinkMap and add Drinks
        Map<Integer, Drink> drinkMap = new TreeMap<>();
        drinkMap.put(1, caffeAmericano);
        drinkMap.put(2, caffeLatte);
        drinkMap.put(3, caffeMocha);
        drinkMap.put(4, cappuccino);
        drinkMap.put(5, coffee);
        drinkMap.put(6, decafCoffee);

        //Create menu
        Menu menu = new Menu(drinkMap,inventory);

        while(quit!=true){
            inventory.display();
            menu.display();
            input = "";

            while(input.isEmpty()){
                try {
                    input = br.readLine();
                }
                catch (IOException e){
                    throw new RuntimeException();
                }
            }

            input = input.toLowerCase();
            switch(input){
                case "q":
                    quit = true;
                    break;
                case "r":
                    inventory.restock();
                    break;
                case "1":
                    if(menu.isAvailable(caffeAmericano)){
                        inventory.decreaseIngredientUnitsByDrink(caffeAmericano);
                        menu.dispensing(caffeAmericano);
                        break;
                    }
                    else menu.outOfStock(caffeAmericano);
                    break;
                case "2":
                    if(menu.isAvailable(caffeLatte)){
                        inventory.decreaseIngredientUnitsByDrink(caffeLatte);
                        menu.dispensing(caffeLatte);
                        break;
                    }
                    else menu.outOfStock(caffeLatte);
                    break;
                case "3":
                    if(menu.isAvailable(caffeMocha)){
                        inventory.decreaseIngredientUnitsByDrink(caffeMocha);
                        menu.dispensing(caffeMocha);
                        break;
                    }
                    else menu.outOfStock(caffeMocha);
                    break;
                case "4":
                    if(menu.isAvailable(cappuccino)){
                        inventory.decreaseIngredientUnitsByDrink(cappuccino);
                        menu.dispensing(cappuccino);
                        break;
                    }
                    else menu.outOfStock(cappuccino);
                    break;
                case "5":
                    if(menu.isAvailable(coffee)){
                        inventory.decreaseIngredientUnitsByDrink(coffee);
                        menu.dispensing(coffee);
                        break;
                    }
                    else menu.outOfStock(coffee);
                    break;
                case "6":
                    if(menu.isAvailable(decafCoffee)){
                        inventory.decreaseIngredientUnitsByDrink(decafCoffee);
                        menu.dispensing(decafCoffee);
                        break;
                    }
                    else menu.outOfStock(decafCoffee);
                    break;
                default:
                    menu.invalidSelection(input);
                    break;
            }
        }
    }
}
