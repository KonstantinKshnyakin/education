package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  A Nice array is defined to be an array where for every value n in the array,
 *  there is also an element n-1 or n+1 in the array.
 *
 *  example:
 *
 *  [2,10,9,3] is Nice array because
 *
 *  2=3-1
 *  10=9+1
 *  3=2+1
 *  9=10-1
 *  Write a function named isNice/IsNice that returns true if its array argument is a Nice array, else false.
 *  You should also return false if input array has no elements.
 */
public class CenterYourself {

    public static boolean isNice(Integer[] arr) {
        if (arr == null || arr.length < 2) {
            return false;
        }
        int countMatch = 0;
        for (Integer i : arr) {
            for (Integer j : arr) {
                if (i + 1 == j || i - 1 == j) {
                    countMatch++;
                    break;
                }
            }
        }
        return countMatch == arr.length;
    }

    @Test
    public void sampleTest() {
        assertEquals(true, isNice(new Integer[]{1,2,3,4,5}));
        assertEquals(true, isNice(new Integer[]{5,4,3,2,1}));
        assertEquals(false, isNice(new Integer[]{1,3,5,2}));
        assertEquals(false, isNice(new Integer[]{10,10,2,2,3}));
        assertEquals(false, isNice(new Integer[]{}));
        assertEquals(false, isNice(new Integer[]{1}));
    }
}
