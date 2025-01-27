package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Complete the method which accepts an array of integers, and returns one of the following:
 * <p>
 * "yes, ascending" - if the numbers in the array are sorted in an ascending order
 * "yes, descending" - if the numbers in the array are sorted in a descending order
 * "no" - otherwise
 * You can assume the array will always be valid, and there will always be one correct answer.
 */
public class SortedYesNoHow {

    public static String isSortedAndHow(int[] array) {
        boolean isDescBase = isDesc(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            boolean isDesc = isDesc(array[i - 1], array[i]);
            if (isDescBase != isDesc) {
                return "no";
            }
        }
        return isDescBase ? "yes, descending" : "yes, ascending";
    }

    private static boolean isDesc(int i1, int i2) {
        return i1 - i2 > 0;
    }

    @Test
    public void test1() {
        int[] array = new int[]{1, 2};
        assertEquals("yes, ascending", isSortedAndHow(array));
    }

    @Test
    public void test2() {
        int[] array = new int[]{15, 7, 3, -8};
        assertEquals("yes, descending", isSortedAndHow(array));
    }

    @Test
    public void test3() {
        int[] array = new int[]{4, 2, 30};
        assertEquals("no", isSortedAndHow(array));
    }

}
