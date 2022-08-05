package com.trustwave;

import com.trustwave.drink.Drink;
import com.trustwave.ingredient.Ingredient;
import com.trustwave.inventory.Inventory;
import com.trustwave.menu.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        //Create ingredients map
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
        Map<String, Integer> stockMap = new HashMap<>();
        for (Map.Entry<String, Ingredient> entry : ingredientsMap.entrySet()) {
            //entry.setValue(10);
            stockMap.put(entry.getKey(), 10);
        }
        Inventory inventory = new Inventory(stockMap);

        //Add drinks to drinkMap
        Map<Integer, Drink> drinkMap = new HashMap<>();
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
            while(input.isEmpty()){
                try {
                    input = br.readLine();
                }
                catch (IOException e){
                    throw new RuntimeException();
                }
            }

            input = input.toLowerCase();
            System.out.println("You entered: " + input);
            switch(input){
                case "q":
                    quit = true;
                    break;
                case "r":
                    System.out.println("Restock inventory");
                    input = "";
                    break;
                case "1":
                    System.out.println("Dispensing Coffee");
                    System.out.println("item: " + coffee.getName() + ", cost: " + coffee.getCost());
                    input = "";
                    break;
                case "2":
                    System.out.println("Dispensing Decaf Coffee");
                    input = "";
                    break;
                case "3":
                    System.out.println("Dispensing Cafe latte");
                    input = "";
                    break;
                case "4":
                    System.out.println("Dispensing Cafe Americano");
                    input = "";
                    break;
                case "5":
                    System.out.println("Dispensing Cafe Mocha");
                    input = "";
                    break;
                case "6":
                    System.out.println("Dispensing Cappuccino");
                    input = "";
                    break;
                default:
                    System.out.println("Invalid selection: " + input);
                    input = "";
                    break;
            }
        }
    }
}
