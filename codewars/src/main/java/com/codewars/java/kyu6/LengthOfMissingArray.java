package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You get an array of arrays.
 * If you sort the arrays by their length, you will see, that their length-values are consecutive.
 * But one array is missing!
 * <p>
 * <p>
 * You have to write a method, that return the length of the missing array.
 * <p>
 * Example:
 * [[1, 2], [4, 5, 1, 1], [1], [5, 6, 7, 8, 9]] --> 3
 * <p>
 * If the array of arrays is null/nil or empty, the method should return 0.
 * <p>
 * When an array in the array is null or empty, the method should return 0 too!
 * There will always be a missing element and its length will be always between the given arrays.
 */
public class LengthOfMissingArray {

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return 0;
        }
        if (Stream.of(arrayOfArrays).anyMatch(arr -> arr == null || arr.length == 0)) {
            return 0;
        }
        IntSummaryStatistics lengthStatistics = Stream.of(arrayOfArrays)
                .mapToInt(arr -> arr.length)
                .summaryStatistics();
        int actSum = Math.toIntExact(lengthStatistics.getSum());
        int max = lengthStatistics.getMax();
        int min = lengthStatistics.getMin();
        int expSum = sumTo(max) - sumTo(min - 1);
        return expSum - actSum;
    }

    private static int sumTo(int i) {
        return i * (i + 1) / 2;
    }

    @Test
    public void BasicTests() {
        assertEquals(3, getLengthOfMissingArray(new Object[][]{new Object[]{1, 2}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, getLengthOfMissingArray(new Object[][]{new Object[]{5, 2, 9}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, getLengthOfMissingArray(new Object[][]{new Object[]{null}, new Object[]{null, null, null}}));
        assertEquals(5, getLengthOfMissingArray(new Object[][]{new Object[]{'a', 'a', 'a'}, new Object[]{'a', 'a'}, new Object[]{'a', 'a', 'a', 'a'}, new Object[]{'a'}, new Object[]{'a', 'a', 'a', 'a', 'a', 'a'}}));
        assertEquals(0, getLengthOfMissingArray(new Object[][]{}));
    }

}
