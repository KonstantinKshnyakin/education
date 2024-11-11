package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given a set of numbers, return the additive inverse of each. Each positive becomes negatives,
 * and the negatives become positives.
 *
 * [1, 2, 3, 4, 5] --> [-1, -2, -3, -4, -5]
 * [1, -2, 3, -4, 5] --> [-1, 2, -3, 4, -5]
 * [] --> []
 */
public class InvertValues {

    public static int[] invert(int[] array) {
        return IntStream.of(array)
                .map(i -> -i)
                .toArray();
    }

    private void runTest(int[] expected, int[] input) {
        assertArrayEquals(expected, invert(input), () -> String.format("Input: %s", Arrays.toString(input)));
    }

    @Test
    void sampleTests() {
        runTest(new int[]{-1, -2, -3, -4, -5}, new int[]{1, 2, 3, 4, 5});
        runTest(new int[]{-1, 2, -3, 4, -5}, new int[]{1, -2, 3, -4, 5});
        runTest(new int[]{1, 2, 3, 4, 5}, new int[]{-1, -2, -3, -4, -5});
        runTest(new int[]{}, new int[]{});
        runTest(new int[]{0}, new int[]{0});
    }

}
