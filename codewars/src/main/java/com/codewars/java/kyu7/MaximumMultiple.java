package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Task
 * Given a Divisor and a Bound , Find the largest integer N , Such That ,
 *
 * Conditions :
 * N is divisible by divisor
 *
 * N is less than or equal to bound
 *
 * N is greater than 0.
 *
 * Notes
 * The parameters (divisor, bound) passed to the function are only positive values .
 */
public class MaximumMultiple {

    public static int maxMultiple(int divisor, int bound) {
        return bound / divisor * divisor;
    }

    @Test
    public void smallPositives() {
        test("The largest multiple of 2 between 0 and 7 is 6.", 6, maxMultiple(2, 7));
        test("The largest multiple of 3 between 0 and 10 is 9.", 9, maxMultiple(3, 10));
        test("The largest multiple of 7 between 0 and 17 is 14.", 14, maxMultiple(7, 17));
    }

    @Test
    public void largerPositives() {
        test("The largest multiple of 10 between 0 and 50 is 50.", 50, maxMultiple(10, 50));
        test("The largest multiple of 37 between 0 and 200 is 185.", 185, maxMultiple(37, 200));
        test("The largest multiple of 7 between 0 and 100 is 98.", 98, maxMultiple(7, 100));
    }

    private void test(String message, int expected, int actual) {
        assertEquals(expected, actual, message);
    }

}
