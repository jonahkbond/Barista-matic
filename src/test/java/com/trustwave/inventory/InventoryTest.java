package com.trustwave.inventory;

import com.trustwave.drink.*;
import com.trustwave.ingredient.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class InventoryTest {
    Ingredient coffeeIngredient;
    Ingredient decafCoffeeIngredient;
    Ingredient sugarIngredient;
    Ingredient creamIngredient;
    Ingredient steamedMilkIngredient;
    Ingredient foamedMilkIngredient;
    Ingredient espressoIngredient;
    Ingredient cocoaIngredient;
    Ingredient whippedCreamIngredient;

    Map<String, Ingredient> ingredientsMap;

    CoffeeDrink coffee;
    DecafCoffeeDrink decafCoffee;
    CaffeLatteDrink caffeLatte;
    CaffeAmericanoDrink caffeAmericano;
    CaffeMochaDrink caffeMocha;
    CappuccinoDrink cappuccino;

    Map<Integer, Drink> drinkMap;
    Map<String, Integer> stockMap;
    Inventory inventory;

    @Before
    public void setUp(){
        //Create Ingredients
        coffeeIngredient = new CoffeeIngredient();
        decafCoffeeIngredient = new DecafCoffeeIngredient();
        sugarIngredient = new SugarIngredient();
        creamIngredient = new CreamIngredient();
        steamedMilkIngredient = new SteamedMilkIngredient();
        foamedMilkIngredient = new FoamedMilkIngredient();
        espressoIngredient = new EspressoIngredient();
        cocoaIngredient = new CocoaIngredient();
        whippedCreamIngredient = new WhippedCreamIngredient();

        //Create ingredients map and add Ingredients
        ingredientsMap = new HashMap<>();
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
        coffee = new CoffeeDrink(ingredientsMap);
        decafCoffee = new DecafCoffeeDrink(ingredientsMap);
        caffeLatte = new CaffeLatteDrink(ingredientsMap);
        caffeAmericano = new CaffeAmericanoDrink(ingredientsMap);
        caffeMocha = new CaffeMochaDrink(ingredientsMap);
        cappuccino = new CappuccinoDrink(ingredientsMap);

        //Create drinkMap and add Drinks
        drinkMap = new TreeMap<>();
        drinkMap.put(1, caffeAmericano);
        drinkMap.put(2, caffeLatte);
        drinkMap.put(3, caffeMocha);
        drinkMap.put(4, cappuccino);
        drinkMap.put(5, coffee);
        drinkMap.put(6, decafCoffee);

        // Create inventory and fully stock to 10 for each ingredient
        stockMap = new TreeMap<>();
        for (Map.Entry<String, Ingredient> entry : ingredientsMap.entrySet()) {
            stockMap.put(entry.getKey(), 10);
        }
        inventory = new Inventory(stockMap);
    }

    @Test
    public void getInventoryMapTest() {
        Assert.assertEquals(stockMap, inventory.getInventoryMap());
    }

    @Test
    public void addIngredientTest() {
        //Create new Ingredient
        Ingredient pumpkinCocoaIngredient = new CocoaIngredient();
        pumpkinCocoaIngredient.setName("Pumpkin Cocoa");
        pumpkinCocoaIngredient.setCost(0.50);

        //Add new Ingredient to inventory
        inventory.addIngredient(pumpkinCocoaIngredient, 5);

        //assert
        Assert.assertEquals(5, inventory.getInventoryMap().get(pumpkinCocoaIngredient.getName()).intValue());
        Assert.assertTrue(inventory.getInventoryMap().containsKey(pumpkinCocoaIngredient.getName()));
    }

    @Test
    public void removeIngredientTest() {
        inventory.removeIngredient(cocoaIngredient);

        Assert.assertFalse(inventory.getInventoryMap().containsKey(cocoaIngredient.getName()));
    }

    @Test
    public void decreaseIngredientUnitsTest() {
        inventory.decreaseIngredientUnits(cocoaIngredient, 2);

        Assert.assertEquals(8, inventory.getInventoryMap().get(cocoaIngredient.getName()).intValue());
    }

    @Test
    public void decreaseIngredientUnitsByDrinkTest() {
        inventory.decreaseIngredientUnitsByDrink(caffeLatte);

        Assert.assertEquals(8, inventory.getInventoryMap().get(espressoIngredient.getName()).intValue());
        Assert.assertEquals(9, inventory.getInventoryMap().get(steamedMilkIngredient.getName()).intValue());
    }

    @Test
    public void restockTest() {
        inventory.decreaseIngredientUnitsByDrink(caffeAmericano);
        inventory.decreaseIngredientUnitsByDrink(caffeLatte);

        inventory.restock();

        Assert.assertEquals(10, inventory.getInventoryMap().get(espressoIngredient.getName()).intValue());
        Assert.assertEquals(10, inventory.getInventoryMap().get(steamedMilkIngredient.getName()).intValue());
    }

    @Test
    public void displayTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput = "Inventory:\r\n" +
                "Cocoa,10\r\n" +
                "Coffee,10\r\n" +
                "Cream,10\r\n" +
                "Decaf Coffee,10\r\n" +
                "Espresso,10\r\n" +
                "Foamed Milk,10\r\n" +
                "Steamed Milk,10\r\n" +
                "Sugar,10\r\n" +
                "Whipped Cream,10\r\n";

        inventory.display();

        Assert.assertEquals(expectedOutput, outContent.toString());
    }
}