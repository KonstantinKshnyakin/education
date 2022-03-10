package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Your goal in this kata is to implement a difference function,
 * which subtracts one list from another and returns the result.

 * It should remove all values from list a, which are present in list b keeping their order.
 *
 * Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
 * If a value is present in b, all of its occurrences must be removed from the other:
 *
 * Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */
public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : a) {
            int countMatch = 0;
            for (int j : b) {
                if (i == j) {
                    countMatch++;
                    break;
                }
            }
            if (countMatch == 0) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void sampleTests() {
        assertArrayEquals(new int[]{2}, arrayDiff(new int[]{1, 2}, new int[]{1}));
        assertArrayEquals(new int[]{2, 2}, arrayDiff(new int[]{1, 2, 2}, new int[]{1}));
        assertArrayEquals(new int[]{1}, arrayDiff(new int[]{1, 2, 2}, new int[]{2}));
        assertArrayEquals(new int[]{1, 2, 2}, arrayDiff(new int[]{1, 2, 2}, new int[]{}));
        assertArrayEquals(new int[]{}, arrayDiff(new int[]{}, new int[]{1, 2}));
    }
}
