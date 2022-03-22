package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You might know some pretty large perfect squares. But what about the NEXT one?
 *
 * Complete the findNextSquare method that finds the next integral perfect square
 * after the one passed as a parameter. Recall that an integral perfect square
 * is an integer n such that sqrt(n) is also an integer.
 *
 * If the parameter is itself not a perfect square then -1 should be returned. Y
 * ou may assume the parameter is non-negative.
 *
 * Examples:(Input --> Output)
 *
 * 121 --> 144
 * 625 --> 676
 * 114 --> -1 since 114 is not a perfect square
 */
public class FindNextPerfectSquare {

    public static long findNextSquare(long sq) {
        if (sq < 0) {
            throw new IllegalArgumentException("Argument must be non-negative");
        }
        double sqrt = Math.sqrt(sq);
        if (sqrt % 1 != 0) {
            return -1;
        }
        long next = (long)sqrt + 1;
        return next * next;
    }

    @Test
    public void test1() {
        assertEquals(144, findNextSquare(121));
    }

    @Test
    public void test2() {
        assertEquals(676, findNextSquare(625));
    }

    @Test
    public void test3() {
        assertEquals(-1, findNextSquare(114));
    }
}
