package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create a function that returns the sum of the two lowest positive numbers given an array of minimum 4 positive integers.
 * No floats or non-positive integers will be passed.
 *
 * For Java, those integers will come as double precision (long).
 *
 * For example, when an array is passed like [19, 5, 42, 2, 77], the output should be 7.
 *
 * [10, 343445353, 3453445, 3453545353453] should return 3453455.
 */
public class SumOfTwoLowestPositiveIntegers {

    public static long sumTwoSmallestNumbers(final long [] numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Length of array must be more than 2, but: " + Arrays.toString(numbers));
        }
        Arrays.sort(numbers);
        return numbers[0] + numbers[1];
    }

    @Test
    void basicTests() {
        assertEquals(13L, sumTwoSmallestNumbers(new long []{5, 8, 12, 19, 22}));
        assertEquals(6L, sumTwoSmallestNumbers(new long []{15, 28, 4, 2, 43}));
        assertEquals(6L, sumTwoSmallestNumbers(new long []{3, 87, 3, 12, 7}));
        assertEquals(24L, sumTwoSmallestNumbers(new long []{23, 71, 33, 82, 1}));
        assertEquals(16L, sumTwoSmallestNumbers(new long []{52, 76, 14, 12, 4}));
    }

}
