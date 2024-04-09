package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pete likes to bake some cakes. He has some recipes and ingredients. Unfortunately he is not good in maths.
 * Can you help him to find out, how many cakes he could bake considering his recipes?
 *
 * Write a function cakes(), which takes the recipe (object) and the available ingredients (also an object)
 * and returns the maximum number of cakes Pete can bake (integer). For simplicity there are no units
 * for the amounts (e.g. 1 lb of flour or 200 g of sugar are simply 1 or 200). Ingredients that are not present
 * in the objects, can be considered as 0.
 */
public class PeteBaker {

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        Integer cakes = null;
        for (Map.Entry<String, Integer> ingredient : recipe.entrySet()) {
            String ingredientName = ingredient.getKey();
            Integer availableIngredients = available.get(ingredientName);
            if (availableIngredients != null) {
                Integer requiredIngredients  = ingredient.getValue();
                int actNumber = availableIngredients / requiredIngredients;
                if (cakes == null || actNumber < cakes) {
                    cakes = actNumber;
                }
            } else {
                return 0;
            }
        }
        return cakes;
    }

    @Test
    void basicTest() {
        Map<String, Integer> recipe = Map.of(
                "flour", 500,
                "sugar", 200,
                "eggs", 1);
        Map<String, Integer> available = Map.of(
                "flour", 1200,
                "sugar", 1200,
                "eggs", 5,
                "milk", 200);
        assertEquals(2, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
    }

    @Test
    void missingIngredient() {
        Map<String, Integer> recipe = Map.of(
                "flour", 500,
                "sugar", 200,
                "eggs", 1,
                "cinnamon", 300);
        Map<String, Integer> available = Map.of(
                "flour", 1200,
                "sugar", 1200,
                "eggs", 5,
                "milk", 200);
        assertEquals(0, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
    }

}
