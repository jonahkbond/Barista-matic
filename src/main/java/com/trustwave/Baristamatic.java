package com.trustwave;

import com.trustwave.drink.Drink;
import com.trustwave.ingredient.Ingredient;
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
        Ingredient coffeeIngredent = new Ingredient("Coffee", 0.75);
        Ingredient decafCoffeeIngredent = new Ingredient("Decaf Coffee", 0.75);
        Ingredient sugarIngredient = new Ingredient("Sugar", 0.25);
        Ingredient creamIngredient = new Ingredient("Cream", 0.25);
        Ingredient steamedMilkIngredient = new Ingredient("Steamed Milk", 0.35);
        Ingredient foamedMilkIngredient = new Ingredient("Foamed Milk", 0.35);
        Ingredient espressoIngredient = new Ingredient("Espresso", 1.10);
        Ingredient cocoaIngredient = new Ingredient("Cocoa", 0.90);
        Ingredient whippedCreamIngredient = new Ingredient("Whipped Cream", 1.00);

        //Create ingredients map and add Ingredients
        Map<String, Ingredient> ingredientsMap = new HashMap<>();
        ingredientsMap.put(coffeeIngredent.getName(), coffeeIngredent);
        ingredientsMap.put(decafCoffeeIngredent.getName(), decafCoffeeIngredent);
        ingredientsMap.put(sugarIngredient.getName(), sugarIngredient);
        ingredientsMap.put(creamIngredient.getName(), creamIngredient);
        ingredientsMap.put(steamedMilkIngredient.getName(), steamedMilkIngredient);
        ingredientsMap.put(foamedMilkIngredient.getName(), foamedMilkIngredient);
        ingredientsMap.put(espressoIngredient.getName(), espressoIngredient);
        ingredientsMap.put(cocoaIngredient.getName(), cocoaIngredient);
        ingredientsMap.put(whippedCreamIngredient.getName(), whippedCreamIngredient);

        //Create Coffee Recipe
        Map<String, Integer> coffeeRecipeMap = new HashMap<>();
        coffeeRecipeMap.put(coffeeIngredent.getName(), 3);
        coffeeRecipeMap.put(sugarIngredient.getName(), 1);
        coffeeRecipeMap.put(creamIngredient.getName(), 1);

        //Create Decaf Coffee Recipe
        Map<String, Integer> decafCoffeeRecipeMap = new HashMap<>();
        decafCoffeeRecipeMap.put(decafCoffeeIngredent.getName(), 3);
        decafCoffeeRecipeMap.put(sugarIngredient.getName(), 1);
        decafCoffeeRecipeMap.put(creamIngredient.getName(), 1);

        //Create Cafe Latte Recipe
        Map<String, Integer> cafeLatteRecipeMap = new HashMap<>();
        cafeLatteRecipeMap.put(espressoIngredient.getName(), 2);
        cafeLatteRecipeMap.put(steamedMilkIngredient.getName(), 1);

        //Create Cafe Americano Recipe
        Map<String, Integer> cafeAmericanoRecipeMap = new HashMap<>();
        cafeAmericanoRecipeMap.put(espressoIngredient.getName(), 3);

        //Create Cafe Mocha Recipe
        Map<String, Integer> cafeMochaRecipeMap = new HashMap<>();
        cafeMochaRecipeMap.put(espressoIngredient.getName(), 1);
        cafeMochaRecipeMap.put(cocoaIngredient.getName(), 1);
        cafeMochaRecipeMap.put(steamedMilkIngredient.getName(), 1);
        cafeMochaRecipeMap.put(whippedCreamIngredient.getName(), 1);

        //Create Cappuccino Recipe
        Map<String, Integer> cappuccinoRecipeMap = new HashMap<>();
        cappuccinoRecipeMap.put(espressoIngredient.getName(), 2);
        cappuccinoRecipeMap.put(steamedMilkIngredient.getName(), 1);
        cappuccinoRecipeMap.put(foamedMilkIngredient.getName(), 1);

        //Create Drinks
        Drink coffee = new Drink("Coffee", ingredientsMap, coffeeRecipeMap);
        Drink decafCoffee = new Drink("Decaf Coffee", ingredientsMap, decafCoffeeRecipeMap);
        Drink cafeLatte = new Drink("Cafe Latte", ingredientsMap, cafeLatteRecipeMap);
        Drink cafeAmericano = new Drink("Cafe Americano", ingredientsMap, cafeAmericanoRecipeMap);
        Drink cafeMocha = new Drink("Cafe Mocha", ingredientsMap, cafeMochaRecipeMap);
        Drink cappuccino = new Drink("Cappuccino", ingredientsMap, cappuccinoRecipeMap);

        //Create Inventory
        Map<String, Integer> stockMap = new TreeMap<>();
        for (Map.Entry<String, Ingredient> entry : ingredientsMap.entrySet()) {
            stockMap.put(entry.getKey(), 10);
        }
        Inventory inventory = new Inventory(stockMap);

        //Create drinkMap and add Drinks
        Map<Integer, Drink> drinkMap = new TreeMap<>();
        drinkMap.put(1, cafeAmericano);
        drinkMap.put(2, cafeLatte);
        drinkMap.put(3, cafeMocha);
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
                    if(menu.isAvailable(cafeAmericano)){
                        inventory.decreaseIngredientUnitsByDrink(cafeAmericano);
                        dispensing(cafeAmericano);
                        break;
                    }
                    else outOfStock(cafeAmericano);
                    break;
                case "2":
                    if(menu.isAvailable(cafeLatte)){
                        inventory.decreaseIngredientUnitsByDrink(cafeLatte);
                        dispensing(cafeLatte);
                        break;
                    }
                    else outOfStock(cafeLatte);
                    break;
                case "3":
                    if(menu.isAvailable(cafeMocha)){
                        inventory.decreaseIngredientUnitsByDrink(cafeMocha);
                        dispensing(cafeMocha);
                        break;
                    }
                    else outOfStock(cafeMocha);
                    break;
                case "4":
                    if(menu.isAvailable(cappuccino)){
                        inventory.decreaseIngredientUnitsByDrink(cappuccino);
                        dispensing(cappuccino);
                        break;
                    }
                    else outOfStock(cappuccino);
                    break;
                case "5":
                    if(menu.isAvailable(coffee)){
                        inventory.decreaseIngredientUnitsByDrink(coffee);
                        dispensing(coffee);
                        break;
                    }
                    else outOfStock(coffee);
                    break;
                case "6":
                    if(menu.isAvailable(decafCoffee)){
                        inventory.decreaseIngredientUnitsByDrink(decafCoffee);
                        dispensing(decafCoffee);
                        break;
                    }
                    else outOfStock(decafCoffee);
                    break;
                default:
                    System.out.println("Invalid selection: " + input);
                    break;
            }
        }
    }

    public static void dispensing(Drink drink){
        System.out.println("Dispensing: " + drink.getName());
    }

    public static void outOfStock(Drink drink){
        System.out.println("Out of stock: " + drink.getName());
    }
}
