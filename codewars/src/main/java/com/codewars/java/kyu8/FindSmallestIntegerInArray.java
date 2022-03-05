package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array of integers your solution should find the smallest integer.
 *
 * For example:
 *
 * Given [34, 15, 88, 2] your solution will return 2
 * Given [34, -345, -1, 100] your solution will return -345
 * You can assume, for the purpose of this kata, that the supplied array will not be empty.
 */
public class FindSmallestIntegerInArray {

    public static int findSmallestInt(int[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Array length must be more then 0");
        }
        int min = Integer.MAX_VALUE;
        for (int arg : args) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }

    @Test
    public void example1() {
        int expected = 11;
        int actual = findSmallestInt(new int[]{78, 56, 232, 12, 11, 43});
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int expected = -33;
        int actual = findSmallestInt(new int[]{78, 56, -2, 12, 8, -33});
        assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int expected = Integer.MIN_VALUE;
        int actual = findSmallestInt(new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE});
        assertEquals(expected, actual);
    }

}
