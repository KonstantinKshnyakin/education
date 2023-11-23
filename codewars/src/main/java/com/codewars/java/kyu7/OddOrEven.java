package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a list of integers, determine whether the sum of its elements is odd or even.
 * Give your answer as a string matching "odd" or "even".
 * If the input array is empty consider it as: [0] (array with a zero).
 *
 * Examples:
 * Input: [0]
 * Output: "even"
 *
 * Input: [0, 1, 4]
 * Output: "odd"
 *
 * Input: [0, -1, -5]
 * Output: "even"
 */
public class OddOrEven {

    public static String oddOrEven (int[] array) {
        return Arrays.stream(array).sum() % 2 == 0 ? "even" : "odd";
    }

    @Test
    public void exampleTest() {
        assertEquals("odd", oddOrEven(new int[] {2, 5, 34, 6}));
    }

}
