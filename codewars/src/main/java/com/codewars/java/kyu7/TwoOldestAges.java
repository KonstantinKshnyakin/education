package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * The two oldest ages function/method needs to be completed. It should take an array of numbers as its argument
 * and return the two highest numbers within the array. The returned value should be an array in the format
 * [second oldest age,  oldest age].
 *
 * The order of the numbers passed in could be any order. The array will always include at least 2 items. If there are
 * two or more oldest age, then return both of them in array format.
 *
 * For example (Input --> Output):
 *
 * [1, 2, 10, 8] --> [8, 10]
 * [1, 5, 87, 45, 8, 8] --> [45, 87]
 * [1, 3, 10, 0]) --> [3, 10]
 */
public class TwoOldestAges {

    public static int[] twoOldestAges(int[] ages) {
        return Arrays.stream(ages)
                .sorted()
                .skip(ages.length - 2)
                .toArray();
    }

    @Test
    void shouldSolveSimpleTests() {
        doTest(new int[]{1,5,87,45,8,8}, new int[]{45, 87}, """
        Input:    [1, 5, 87, 45, 8, 8]
        Expected: [45, 87]
        """);
        doTest(new int[]{6,5,83,5,3,18}, new int[]{18, 83}, """
        Input:    [6, 5, 83, 5, 3, 18]
        Expected: [18, 83]
        """);
    }

    private void doTest(int[] ages, int[] expected, String msg) {
        int[] actual = twoOldestAges(ages.clone());
        assertArrayEquals(expected, actual, msg + "Actual:   " + Arrays.toString(actual) + "\n");
    }

}
