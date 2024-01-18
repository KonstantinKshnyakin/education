package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You will be given an array and a limit value. You must check that all values in the array are below or
 * equal to the limit value. If they are, return true. Else, return false.
 * <p>
 * You can assume all values in the array are numbers.
 */
public class SmallEnoughBeginner {

    public static boolean smallEnough(int[] a, int limit) {
        return Arrays.stream(a).allMatch(e -> e <= limit);
    }

    @Test
    public void basicTests() {
        assertEquals(true, smallEnough(new int[] { 66, 101 }, 200));
        assertEquals(false, smallEnough(new int[] { 78, 117, 110, 99, 104, 117, 107, 115 }, 100));
        assertEquals(true, smallEnough(new int[] { 101, 45, 75, 105, 99, 107 }, 107));
        assertEquals(true, smallEnough(new int[] { 80, 117, 115, 104, 45, 85, 112, 115 }, 120));
    }

}
