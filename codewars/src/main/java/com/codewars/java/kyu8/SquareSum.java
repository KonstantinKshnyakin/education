package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Complete the square sum function so that it squares each number passed into it and then sums the results together.
 *
 * For example, for [1, 2, 2] it should return 9 because 1^2 + 2^2 + 2^2 = 9.
 */
public class SquareSum {

    public static int squareSum(int[] n) {
        return Arrays.stream(n)
                .map(i -> i * i)
                .sum();
    }

    @Test
    public void testBasic() {
        assertEquals(9, squareSum(new int[]{1, 2, 2}));
        assertEquals(5, squareSum(new int[]{1, 2}));
        assertEquals(50, squareSum(new int[]{5, -3, 4}));
        assertEquals(0, squareSum(new int[]{}));
    }
}
