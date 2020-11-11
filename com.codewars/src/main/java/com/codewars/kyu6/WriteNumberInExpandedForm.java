package com.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You will be given a number and you will need to return it as
 * a string in Expanded Form. For example:
 * <p>
 * Kata.expandedForm(12); # Should return "10 + 2"
 * Kata.expandedForm(42); # Should return "40 + 2"
 * Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
 * <p>
 * NOTE: All numbers will be whole numbers greater than 0.
 */
public class WriteNumberInExpandedForm {

    public static String expandedForm(int num) {
        StringBuilder builder = new StringBuilder();
        int tensMultiplier = 1;
        while (num > 0) {
            int i = num % 10;
            num = num / 10;
            if (i != 0) {
                builder.insert(0, i * tensMultiplier);
                builder.insert(0, " + ");
            }
            tensMultiplier *= 10;
        }
        return builder.substring(3);
    }

    @Test
    public void testSomething() {
        assertEquals("10 + 2", expandedForm(12));
        assertEquals("40 + 2", expandedForm(42));
        assertEquals("70000 + 300 + 4", expandedForm(70304));
        assertEquals("9000000", expandedForm(9000000));
    }
}
