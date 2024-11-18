package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pair of gloves
 * Winter is coming, you must prepare your ski holidays. The objective of this kata is to determine the number of pair
 * of gloves you can constitute from the gloves you have in your drawer.
 *
 * Given an array describing the color of each glove, return the number of pairs you can constitute, assuming that
 * only gloves of the same color can form pairs.
 *
 * Examples:
 * input = ["red", "green", "red", "blue", "blue"]
 * result = 2 (1 red pair + 1 blue pair)
 *
 * input = ["red", "red", "red", "red", "red", "red"]
 * result = 3 (3 red pairs)
 */
public class PairOfGloves {

    public static int numberOfPairs(String[] gloves) {
        return Arrays.stream(gloves)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .mapToInt(c -> Math.toIntExact(c / 2))
                .sum();
    }

    @Test
    void tests() {
        assertEquals(0, numberOfPairs(new String[] {}));
        assertEquals(1, numberOfPairs(new String[] {"red", "red"}));
        assertEquals(0, numberOfPairs(new String[] {"red", "green", "blue"}));
        assertEquals(3, numberOfPairs(new String[] {"gray", "black", "purple", "purple", "gray", "black"}));
        assertEquals(4, numberOfPairs(new String[] {"red", "green", "blue", "blue", "red", "green", "red", "red", "red"}));
    }

}
