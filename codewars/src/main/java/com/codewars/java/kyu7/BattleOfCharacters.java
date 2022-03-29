package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description:
 * Groups of characters decided to make a battle. Help them to figure out which group is more powerful.
 * Create a function that will accept 2 strings and return the one who's stronger.
 *
 * Rules:
 * Each character have its own power: A = 1, B = 2, ... Y = 25, Z = 26
 * Strings will consist of uppercase letters only
 * Only two groups to a fight.
 * Group whose total power (A + B + C + ...) is bigger wins.
 * If the powers are equal, it's a tie.
 *
 * Examples:
 *   battle("ONE", "TWO"); // => "TWO"`
 *   battle("ONE", "NEO"); // => "Tie!"
 */
public class BattleOfCharacters {

    public static String battle(final String x, final String y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        int ySum = getSum(y);
        int xSum = getSum(x);
        return ySum >= xSum
                ? ySum == xSum ? "Tie!" : y
                : x;
    }

    private static int getSum(String s) {
        return s.chars()
                .filter(c -> c >= 65 && c <= 90)
                .map(c -> c - 64)
                .sum();
    }

    @Test
    public void basicTests() {
        assertEquals( "Z", battle("AAA",  "Z"));
        assertEquals( "TWO", battle("ONE",  "TWO"));
        assertEquals("Tie!", battle("ONE",  "NEO"));
        assertEquals( "FOUR", battle("FOUR", "FIVE"));
    }
}
