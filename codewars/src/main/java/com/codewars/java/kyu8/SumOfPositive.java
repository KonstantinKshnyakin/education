package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You get an array of numbers, return the sum of all of the positives ones.
 * <p>
 * Example [1,-4,7,12] => 1 + 7 + 12 = 20
 * <p>
 * Note: if there is nothing to sum, the sum is default to 0.
 */
public class SumOfPositive {

    public static int sum(int[] arr) {
        return Arrays.stream(arr)
                .filter(i -> i > 0)
                .sum();
    }

    @Test
    public void testSomething() {
        assertEquals(15, sum(new int[]{1, 2, 3, 4, 5}));
        assertEquals(13, sum(new int[]{1, -2, 3, 4, 5}));
        assertEquals(0, sum(new int[]{}));
        assertEquals(0, sum(new int[]{-1, -2, -3, -4, -5}));
        assertEquals(9, sum(new int[]{-1, 2, 3, 4, -5}));
    }
}
