package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Are the numbers in order?
 * In this Kata, your function receives an array of integers as input.
 * Your task is to determine whether the numbers are in ascending order.
 * An array is said to be in ascending order if there are no two adjacent integers where the left integer
 * exceeds the right integer in value.
 *
 * For the purposes of this Kata, you may assume that all inputs are valid, i.e. non-empty arrays containing only integers.
 *
 * Note that an array of 1 integer is automatically considered to be sorted in ascending order since all (zero)
 * adjacent pairs of integers satisfy the condition that the left integer does not exceed the right integer in value.
 * An empty list is considered a degenerate case and therefore will not be tested in this Kata - feel free to raise
 * an Issue if you see such a list being tested.
 *
 * For example:
 * isAscOrder(new int[]{1,2,4,7,19}) == true
 * isAscOrder(new int[]{1,2,3,4,5}) == true
 * isAscOrder(new int[]{1,6,10,18,2,4,20}) == false
 * isAscOrder(new int[]{9,8,7,6,5,4,3,2,1}) == false // numbers are in DESCENDING order
 * N.B. If your solution passes all fixed tests but fails at the random tests, make sure you aren't mutating the input array.
 */
public class AreNumbersInOrder {

    public static boolean isAscOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void arrayOf2Integers() {
        assertTrue(isAscOrder(new int[] {1, 2}));
        assertFalse(isAscOrder(new int[] {2, 1}));
    }

    @Test
    public void arrayOf3Integers() {
        assertTrue(isAscOrder(new int[] {1, 2, 3}));
        assertFalse(isAscOrder(new int[] {1, 3, 2}));
        assertTrue(isAscOrder(new int[] {1, 4, 13, 97, 508, 1047, 20058}));
        assertFalse(isAscOrder(new int[] {56, 98, 123, 67, 742, 1024, 32, 90969}));
    }

    @Test
    public void moreAdvancedCases() {
        assertTrue(isAscOrder(new int[] {1, 4, 13, 97, 508, 1047, 20058}));
        assertFalse(isAscOrder(new int[] {56, 98, 123, 67, 742, 1024, 32, 90969}));
    }
}
