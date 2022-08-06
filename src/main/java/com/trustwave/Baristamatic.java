package com.trustwave;

import com.trustwave.drink.*;
import com.trustwave.ingredient.Ingredient;
import com.trustwave.inventory.Inventory;
import com.trustwave.menu.Menu;
import com.trustwave.recipe.*;
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

        //Create Recipes
        CoffeeRecipe coffeeRecipe = new CoffeeRecipe();
        DecafCoffeeRecipe decafCoffeeRecipe = new DecafCoffeeRecipe();
        CaffeLatteRecipe caffeLatteRecipe = new CaffeLatteRecipe();
        CaffeAmericanoRecipe caffeAmericanoRecipe = new CaffeAmericanoRecipe();
        CaffeMochaRecipe caffeMochaRecipe = new CaffeMochaRecipe();
        CappuccinoRecipe cappuccinoRecipe = new CappuccinoRecipe();

        //Create Drinks
        Drink coffee = new Drink("Coffee", ingredientsMap, coffeeRecipe.getRecipe());
        Drink decafCoffee = new Drink("Decaf Coffee", ingredientsMap, decafCoffeeRecipe.getRecipe());
        Drink caffeLatte = new Drink("Caffe Latte", ingredientsMap, caffeLatteRecipe.getRecipe());
        Drink caffeAmericano = new Drink("Caffe Americano", ingredientsMap, caffeAmericanoRecipe.getRecipe());
        Drink caffeMocha = new Drink("Caffe Mocha", ingredientsMap, caffeMochaRecipe.getRecipe());
        Drink cappuccino = new Drink("Cappuccino", ingredientsMap, cappuccinoRecipe.getRecipe());

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

        //Create DrinkManager
        DrinkManager drinkManger = new DrinkManager();

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
                        drinkManger.dispensing(caffeAmericano);
                        break;
                    }
                    else drinkManger.outOfStock(caffeAmericano);
                    break;
                case "2":
                    if(menu.isAvailable(caffeLatte)){
                        inventory.decreaseIngredientUnitsByDrink(caffeLatte);
                        drinkManger.dispensing(caffeLatte);
                        break;
                    }
                    else drinkManger.outOfStock(caffeLatte);
                    break;
                case "3":
                    if(menu.isAvailable(caffeMocha)){
                        inventory.decreaseIngredientUnitsByDrink(caffeMocha);
                        drinkManger.dispensing(caffeMocha);
                        break;
                    }
                    else drinkManger.outOfStock(caffeMocha);
                    break;
                case "4":
                    if(menu.isAvailable(cappuccino)){
                        inventory.decreaseIngredientUnitsByDrink(cappuccino);
                        drinkManger.dispensing(cappuccino);
                        break;
                    }
                    else drinkManger.outOfStock(cappuccino);
                    break;
                case "5":
                    if(menu.isAvailable(coffee)){
                        inventory.decreaseIngredientUnitsByDrink(coffee);
                        drinkManger.dispensing(coffee);
                        break;
                    }
                    else drinkManger.outOfStock(coffee);
                    break;
                case "6":
                    if(menu.isAvailable(decafCoffee)){
                        inventory.decreaseIngredientUnitsByDrink(decafCoffee);
                        drinkManger.dispensing(decafCoffee);
                        break;
                    }
                    else drinkManger.outOfStock(decafCoffee);
                    break;
                default:
                    System.out.println("Invalid selection: " + input);
                    break;
            }
        }
    }
}
