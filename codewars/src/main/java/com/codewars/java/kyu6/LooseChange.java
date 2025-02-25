package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this Kata, you must create a function that takes an amount of US currency in cents, and returns a dictionary/hash
 * which shows the least amount of coins used to make up that amount.
 * <p>
 * The only coin denominations considered in this exercise are: Pennies (1¢), Nickels (5¢), Dimes (10¢) and Quarters (25¢).
 * <p>
 * Therefore, the dictionary returned should contain exactly 4 key/value pairs.
 * <p>
 * Notes:
 * <p>
 * If the function is passed either 0 or a negative number, the function should return the dictionary with all values
 * equal to 0.
 * If a float is passed into the function, its value should be rounded down, and the resulting dictionary should never
 * contain fractions of a coin.
 * Examples
 * 56    ==>  {'Nickels': 1, 'Pennies': 1, 'Dimes': 0, 'Quarters': 2}
 * -435  ==>  {'Nickels': 0, 'Pennies': 0, 'Dimes': 0, 'Quarters': 0}
 * 4.935 ==>  {'Nickels': 0, 'Pennies': 4, 'Dimes': 0, 'Quarters': 0}
 */
public class LooseChange {

    public static final Map<String, Integer> COINS = new LinkedHashMap<>() {{
        put("Quarters", 25);
        put("Dimes", 10);
        put("Nickels", 5);
        put("Pennies", 1);
    }};

    public static HashMap<String, Integer> looseChange(int cent) {
        HashMap<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : COINS.entrySet()) {
            int count = 0;
            if (cent >= 1) {
                Integer denomination = entry.getValue();
                count = cent / denomination;
                cent %= denomination;
            }
            result.put(entry.getKey(), count);
        }
        return result;
    }

    @Test
    public void sampleTest() {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Pennies", 4);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 1);
        assertEquals(map, looseChange(29));

        map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);
        assertEquals(map, looseChange(0));

        map = new HashMap<>();
        map.put("Pennies", 1);
        map.put("Nickels", 1);
        map.put("Dimes", 1);
        map.put("Quarters", 3);
        assertEquals(map, looseChange(91));

        map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);
        assertEquals(map, looseChange(-2));
    }
}
