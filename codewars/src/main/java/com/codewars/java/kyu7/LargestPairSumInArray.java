package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a sequence of numbers, find the largest pair sum in the sequence.
 *
 * For example
 *
 * [10, 14, 2, 23, 19] -->  42 (= 23 + 19)
 * [99, 2, 2, 23, 19]  --> 122 (= 99 + 23)
 * Input sequence contains minimum two elements and every element is an integer.
 */
public class LargestPairSumInArray {

    public static int largestPairSum(int[] numbers) {
        if (numbers.length < 2) {
            return -1;
        }
        int[] ints = Arrays.stream(numbers)
                .sorted()
                .toArray();
        int lastIndex = ints.length - 1;
        return ints[lastIndex] + ints[lastIndex - 1];
    }

    @Test
    public void basicTestCases() {
        assertEquals(42, largestPairSum(new int[]{10, 14, 2, 23, 19}));
        assertEquals(0, largestPairSum(new int[]{-100, -29, -24, -19, 19}));
        assertEquals(10, largestPairSum(new int[]{1, 2, 3, 4, 6, -1, 2}));
        assertEquals(-18, largestPairSum(new int[]{-10, -8, -16, -18, -19}));
    }

}
