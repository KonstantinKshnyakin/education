package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/****************************************************************************************
 * Given an array of integers, find the one that appears an odd number of times.
 *
 * There will always be only one integer that appears an odd number of times.
 ***************************************************************************************/

public class FindOddInt {

    public static int findIt(int[] a) {
        int counter = 0;
        for (int i : a) {
            for (int j : a) {
                if (i == j) {
                    counter++;
                }
            }
            if (counter % 2 != 0) {
                return i;
            }
        }
        return 0;
    }

    @Test
    public void findTest() {
        assertEquals(5, findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, findIt(new int[]{10}));
        assertEquals(10, findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
}
