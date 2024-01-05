package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer as input, can you round it to the next (meaning, "greater than or equal") multiple of 5?
 *
 * Examples:
 *
 * input:    output:
 * 0    ->   0
 * 2    ->   5
 * 3    ->   5
 * 12   ->   15
 * 21   ->   25
 * 30   ->   30
 * -2   ->   0
 * -5   ->   -5
 * etc.
 * Input may be any positive or negative integer (including 0).
 *
 * You can assume that all inputs are valid integers.
 */
public class RoundToTheNextMultipleOf5 {

    public static int roundToNext5(int number) {
        int i = number % 5;
        if (i > 0) {
            return number + (5 - i);
        } else if (i < 0) {
            return number - i;
        }
        return number;
    }

    @Test
    public void basicTests() {
        int[][] arr = {
                {0, 0},
                {1, 5},
                {3, 5},
                {5, 5},
                {7, 10},
                {-1, 0},
                {-678102, -678100},
                {39, 40}
        };
        Arrays.stream(arr)
                .forEach(
                        (testCase) -> {
                            assertEquals(
                                    testCase[1],
                                    roundToNext5(testCase[0]),
                                    "Input: " + testCase[0]
                            );
                        });
    }
}
