package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Some new cashiers started to work at your restaurant.
 * <p>
 * They are good at taking orders, but they don't know how to capitalize words, or use a space bar!
 * <p>
 * All the orders they create look something like this:
 * <p>
 * "milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza"
 * <p>
 * The kitchen staff are threatening to quit, because of how difficult it is to read the orders.
 * <p>
 * Their preference is to get the orders as a nice clean string with spaces and capitals like so:
 * <p>
 * "Burger Fries Chicken Pizza Pizza Pizza Sandwich Milkshake Milkshake Coke"
 * <p>
 * The kitchen staff expect the items to be in the same order as they appear in the menu.
 * <p>
 * The menu items are fairly simple, there is no overlap in the names of the items:
 * <p>
 * 1. Burger
 * 2. Fries
 * 3. Chicken
 * 4. Pizza
 * 5. Sandwich
 * 6. Onionrings
 * 7. Milkshake
 * 8. Coke
 */
public class NewCashierDoesNotKnowAboutSpaceOrShift {

    public static final List<Map.Entry<String, String>> MENU = List.of(
            entry("burger",       "Burger"),
            entry("fries",        "Fries"),
            entry("chicken",      "Chicken"),
            entry("pizza",        "Pizza"),
            entry("sandwich",     "Sandwich"),
            entry("onionrings",   "Onionrings"),
            entry("milkshake",    "Milkshake"),
            entry("coke",         "Coke")
    );

    public static String getOrder(String input) {
        String inputLowerCase = input.toLowerCase();
        StringJoiner sj = new StringJoiner(" ");
        for (Map.Entry<String, String> menu : MENU) {
            Pattern pattern = Pattern.compile(menu.getKey());
            Matcher matcher = pattern.matcher(inputLowerCase);
            while (matcher.find()) {
                sj.add(menu.getValue());
            }
        }
        return sj.toString();
    }

    @Test
    public void test() {
        assertEquals("Burger Fries Chicken Pizza Pizza Pizza Sandwich Milkshake Milkshake Coke", getOrder("milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza"));
        assertEquals("Burger Fries Fries Chicken Pizza Sandwich Milkshake Coke", getOrder("pizzachickenfriesburgercokemilkshakefriessandwich"));
    }

}
