package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Introduction
 * The first century spans from the year 1 up to and including the year 100, the second century - from the year 101
 * up to and including the year 200, etc.
 *
 * Task
 * Given a year, return the century it is in.
 *
 * Examples
 * 1705 --> 18
 * 1900 --> 19
 * 1601 --> 17
 * 2000 --> 20
 */
public class CenturyFromYear {

    public static int century(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Year must be positive");
        }
        int century = number / 100;
        return number % 100 == 0 ? century : century + 1;
    }

    @Test
    public void FixedTests() {
        assertEquals(18, century(1705));
        assertEquals(19, century(1900));
        assertEquals(17, century(1601));
        assertEquals(20, century(2000));
        assertEquals(1,  century(89));
    }
}
