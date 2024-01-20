package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
 * <p>
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * // should be 6: {4, -1, 2, 1}
 * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
 * If the list is made up of only negative numbers, return 0 instead.
 * <p>
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */
public class MaximumSubarraySum {

    public static int sequence(int[] arr) {
        ArrayList<Integer> amounts = new ArrayList<>();
        int max = 0;
        for (int i : arr) {
            for (int j = 0; j < amounts.size(); j++) {
                int sum = amounts.get(j) + i;
                if (sum > max) {
                    max = sum;
                }
                amounts.set(j, sum);
            }
            amounts.add(i);
        }
        return max;
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, sequence(new int[]{}));
    }

    @Test
    public void testExampleArray() {
        assertEquals(6, sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
