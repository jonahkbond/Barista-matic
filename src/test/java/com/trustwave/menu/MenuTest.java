package com.trustwave.menu;

import com.trustwave.drink.*;
import com.trustwave.ingredient.*;
import com.trustwave.inventory.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MenuTest {
    //Create Ingredients
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
    Menu menu;

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

        menu = new Menu(drinkMap,inventory);
    }

    @Test
    public void testIsAvailableReturnsTrue() {
        // Create inventory and stock Espresso to 3
        stockMap = new TreeMap<>();
        for (Map.Entry<String, Ingredient> entry : ingredientsMap.entrySet()) {
            if(entry.getKey()=="Espresso"){
                stockMap.put(entry.getKey(), 3);
            }
            else
                stockMap.put(entry.getKey(), 10);
        }

        inventory = new Inventory(stockMap);
        menu = new Menu(drinkMap,inventory);

        Assert.assertTrue(menu.isAvailable(caffeAmericano));
    }

    @Test
    public void IsAvailableReturnsFalse() {
        // Create inventory but only stock Espresso to 2.
        stockMap = new TreeMap<>();
        for (Map.Entry<String, Ingredient> entry : ingredientsMap.entrySet()) {
            if(entry.getKey()=="Espresso"){
                stockMap.put(entry.getKey(), 2);
            }
            else stockMap.put(entry.getKey(), 10);
        }

        inventory = new Inventory(stockMap);
        menu = new Menu(drinkMap,inventory);

        Assert.assertFalse(menu.isAvailable(caffeAmericano));
    }

    @Test
    public void testDispensing() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menu.dispensing(coffee);

        Assert.assertEquals("Dispensing: " + coffee.getName() + "\r\n", outContent.toString());
    }

    @Test
    public void testOutOfStock() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menu.outOfStock(coffee);

        Assert.assertEquals("Out of stock: " + coffee.getName() + "\r\n", outContent.toString());
    }

    @Test
    public void testInvalidSelection() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String input = "Invalid input";
        menu.invalidSelection(input);

        Assert.assertEquals("Invalid selection: " + input + "\r\n", outContent.toString());
    }

    @Test
    public void testDisplay() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menu.display();

        String expectedOutput = "Menu:\r\n" +
                "1,Caffe Americano,$3.30,true\r\n" +
                "2,Caffe Latte,$2.55,true\r\n" +
                "3,Caffe Mocha,$3.35,true\r\n" +
                "4,Cappuccino,$2.90,true\r\n" +
                "5,Coffee,$2.75,true\r\n" +
                "6,Decaf Coffee,$2.75,true\r\n";

        Assert.assertEquals(expectedOutput, outContent.toString());
    }
}