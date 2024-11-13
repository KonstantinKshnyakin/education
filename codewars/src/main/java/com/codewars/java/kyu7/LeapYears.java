package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this kata you should simply determine, whether a given year is a leap year or not.
 * In case you don't know the rules, here they are:
 *
 * Years divisible by 4 are leap years,
 * but years divisible by 100 are not leap years,
 * but years divisible by 400 are leap years.
 * Tested years are in range 1600 ≤ year ≤ 4000.
 */
public class LeapYears {

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }

    @Test
    public void testYear2020() {
        assertEquals(true, LeapYears.isLeapYear(2020));
    }

    @Test
    public void testYear2000() {
        assertEquals(true, LeapYears.isLeapYear(2000));
    }

    @Test
    public void testYear2015() {
        assertEquals(false, LeapYears.isLeapYear(2015));
    }

    @Test
    public void testYear2100() {
        assertEquals(false, LeapYears.isLeapYear(2100));
    }

}
