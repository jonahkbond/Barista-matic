package com.trustwave.drink;

import com.trustwave.ingredient.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class DrinkTest {
    Ingredient espressoIngredient;
    Map<String, Ingredient> ingredientsMap;
    CaffeAmericanoDrink caffeAmericano;

    @Before
    public void setUp(){
        espressoIngredient = new EspressoIngredient();
        ingredientsMap = new HashMap<>();
        ingredientsMap.put(espressoIngredient.getName(), espressoIngredient);
        caffeAmericano = new CaffeAmericanoDrink(ingredientsMap);
    }

    @Test
    public void calculateCost() {
        //Set Espresso Cost to 2.00
        espressoIngredient.setCost(2.00);

        //Set Recipe to 5 Espresso
        Map<String, Integer> newRecipe = new HashMap<>();
        newRecipe.put(espressoIngredient.getName(), 5);
        caffeAmericano.setRecipe(newRecipe);

        //Create expected value
        long expectedCost = (long) (2.00 * 5);

        Assert.assertEquals(expectedCost, (long)(caffeAmericano.calculateCost(ingredientsMap, caffeAmericano.getRecipe())));
    }
}