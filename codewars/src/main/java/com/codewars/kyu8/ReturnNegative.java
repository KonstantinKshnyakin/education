package com.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this simple assignment you are given a number and have to make it negative.
 * But maybe the number is already negative?
 *
 * - The number can be negative already, in which case no change is required.
 * - Zero (0) is not checked for any specific sign. Negative zeros make no mathematical sense.
 */
public class ReturnNegative {

    public static int makeNegative(final int x) {
        if (x > 0) {
            return x * -1;
        } else if (x < 0) {
            return x;
        }
        return 0;

    }

    @Test
    public void test1() {
        assertEquals(-42, ReturnNegative.makeNegative(42));
    }

    @Test
    public void test2() {
        assertEquals(0, ReturnNegative.makeNegative(0));
    }

    @Test
    public void test3() {
        assertEquals(-13, ReturnNegative.makeNegative(-13));
    }
}
