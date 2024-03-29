package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function which calculates the average of the numbers in a given list.
 *
 * Note: Empty arrays should return 0.
 */
public class CalculateAverage {

    private static final double DELTA = 1e-15;

    public static double find_average(int[] array){
        return Arrays.stream(array)
                .average()
                .orElse(0);
    }

    @Test
    public void testSomething() {
        assertEquals(1, find_average(new int[]{1,1,1}), DELTA);
        assertEquals(2, find_average(new int[]{1, 2, 3}), DELTA);
        assertEquals(0, find_average(new int[]{}), DELTA);
    }

}
