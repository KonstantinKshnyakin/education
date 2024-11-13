package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array of integers of any length, return an array that has 1 added to the value represented by the array.
 *
 * If the array is invalid (empty, or contains negative integers or integers with more than 1 digit),
 * return nil (or your language's equivalent).
 *
 * Examples
 * Valid arrays
 *
 * [4, 3, 2, 5] would return [4, 3, 2, 6] (4325 + 1 = 4326)
 * [1, 2, 3, 9] would return [1, 2, 4, 0] (1239 + 1 = 1240)
 * [9, 9, 9, 9] would return [1, 0, 0, 0, 0] (9999 + 1 = 10000)
 * [0, 1, 3, 7] would return [0, 1, 3, 8] (0137 + 1 = 0138)
 * Invalid arrays
 *
 * [] is invalid because it is empty
 * [1, -9] is invalid because -9 is not a non-negative integer
 * [1, 2, 33] is invalid because 33 is not a single-digit integer
 */
public class ArrayPlus1 {

    public static int[] upArray(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        if (IntStream.of(arr).filter(i -> i < 0 || i > 9).findAny().isPresent()) {
            return null;
        }
        boolean isMore = true;
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            if (isMore) {
                val += 1;
            }
            if (val > 9) {
                val = 0;
                isMore = true;
            } else {
                isMore = false;
            }
            result.add(0 , val);
        }
        if (isMore) {
            result.add(0 , 1);
        }
        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    @Test
    public void exampleTests() {
        doTest(new int[]{2, 3, 9}, new int[]{2, 4, 0});
        doTest(new int[]{2, 9, 9}, new int[]{3, 0, 0});
        doTest(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0});
        doTest(new int[]{4, 3, 2, 5}, new int[]{4, 3, 2, 6});
        doTest(new int[]{1, -9}, null);
    }

    private static void doTest(final int[] arr, final int[] expected) {
        String arrAsString = Arrays.toString(arr);
        int[] actual = upArray(arr);
        assertArrayEquals(expected, actual, "Incorrect answer for arr = " + arrAsString);
    }

}
