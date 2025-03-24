package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Have a look at the following numbers.
 *
 *  n | score
 * ---+-------
 *  1 |  50
 *  2 |  150
 *  3 |  300
 *  4 |  500
 *  5 |  750
 * Can you find a pattern in it? If so, then write a function getScore(n)/get_score(n)/GetScore(n)
 * which returns the score for any positive number n.
 */
public class SequencesAndSeries {

    public static long getScore(long n) {
        return (50 + (n - 1) * 25) * n;
    }

    @Test
    public void basicTests() {
        assertEquals(50, getScore(1));
        assertEquals(150, getScore(2));
        assertEquals(300, getScore(3));
        assertEquals(500, getScore(4));
        assertEquals(750, getScore(5));
    }

}
