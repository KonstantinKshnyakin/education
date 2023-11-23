package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits,
 * each raised to the power of the number of digits in a given base. In this Kata, we will restrict
 * ourselves to decimal (base 10).
 * <p>
 * For example, take 153 (3 digits), which is narcissistic:
 * <p>
 * 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
 * and 1652 (4 digits), which isn't:
 * <p>
 * 1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938
 * The Challenge:
 * <p>
 * Your code must return true or false (not 'true' and 'false') depending upon whether the given number is a Narcissistic number in base 10.
 * <p>
 * This may be True and False in your language, e.g. PHP.
 * <p>
 * Error checking for text strings or other invalid inputs is not required, only valid positive non-zero integers will be passed into the function.
 */
public class DoesMyNumberLookBigInThis {

    public static boolean isNarcissistic(int number) {
        String[] strings = Integer.toString(number).split("");
        int degree = strings.length;
        double result = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .mapToDouble(i -> Math.pow(i, degree))
                .sum();
        return number == (int) result;
    }

    @Test
    void exampleTests() {
        assertTrue(isNarcissistic(153), "153 is narcissistic");
        assertTrue(isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(isNarcissistic(112), "112 is not narcissistic");
    }
}
