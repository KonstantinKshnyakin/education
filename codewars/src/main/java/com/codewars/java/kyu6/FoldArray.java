package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this kata you have to write a method that folds a given array of integers by the middle x-times.
 * <p>
 * An example says more than thousand words:
 * <p>
 * Fold 1-times:
 * [1,2,3,4,5] -> [6,6,3]
 * <p>
 * A little visualization (NOT for the algorithm but for the idea of folding):
 * <p>
 * Step 1         Step 2        Step 3       Step 4       Step5
 * 5/           5|         5\
 * 4/            4|          4\
 * 1 2 3 4 5      1 2 3/         1 2 3|       1 2 3\       6 6 3
 * ----*----      ----*          ----*        ----*        ----*
 * <p>
 * <p>
 * Fold 2-times:
 * [1,2,3,4,5] -> [9,6]
 * As you see, if the count of numbers is odd, the middle number will stay. Otherwise the fold-point is between
 * the middle-numbers, so all numbers would be added in a way.
 * <p>
 * The array will always contain numbers and will never be null. The parameter runs will always be a positive integer
 * greater than 0 and says how many runs of folding your method has to do.
 * <p>
 * If an array with one element is folded, it stays as the same array.
 * <p>
 * The input array should not be modified!
 * <p>
 * Have fun coding it and please don't forget to vote and rank this kata! :-)
 * <p>
 * I have created other katas. Have a look if you like coding and challenges.
 */
public class FoldArray {

    public static int[] foldArray(int[] array, int runs) {
        int isEven = array.length % 2 == 0 ? 0 : 1;
        int[] result = new int[array.length / 2 + isEven];
        for (int i = 0; i < array.length / 2 + isEven; i++) {
            if (isEven == 1 && i == array.length / 2) {
                result[i] = array[i];
            } else {
                result[i] = array[i] + array[array.length - 1 - i];
            }
        }
        return runs > 1 ? foldArray(result, --runs) : result;
    }

    @Test
    public void basicTests() {
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] expected = new int[]{6, 6, 3};
        assertEquals(Arrays.toString(expected), Arrays.toString(foldArray(input, 1)));

        expected = new int[]{9, 6};
        assertEquals(Arrays.toString(expected), Arrays.toString(foldArray(input, 2)));

        expected = new int[]{15};
        assertEquals(Arrays.toString(expected), Arrays.toString(foldArray(input, 3)));

        input = new int[]{-9, 9, -8, 8, 66, 23};
        expected = new int[]{14, 75, 0};
        assertEquals(Arrays.toString(expected), Arrays.toString(foldArray(input, 1)));
    }

}
