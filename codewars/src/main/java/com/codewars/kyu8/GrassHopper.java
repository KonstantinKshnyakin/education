package com.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a program that finds the summation of every number from 1 to num.
 * The number will always be a positive integer greater than 0.
 */
public class GrassHopper {

    public static int summation(int n) {
        int result = 0;
        for (int i = n; i > 0; i--) {
            result += i;
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals(1,
                GrassHopper.summation(1));
    }

    @Test
    public void test2() {
        assertEquals(36,
                GrassHopper.summation(8));
    }
}
