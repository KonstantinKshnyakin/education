package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * It's the academic year's end, fateful moment of your school report.
 * The averages must be calculated. All the students come to you and
 * entreat you to calculate their average for them. Easy ! You just need
 * to write a script.
 *
 * Return the average of the given array rounded down to its nearest integer.
 *
 * The array will never be empty.
 */
public class GetTheMeanOfArray {

    public static int getAverage(int[] marks) {
        int result = 0;
        for (int mark : marks) {
            result += mark;
        }
        return result / marks.length;
    }

    @Test
    public void simpleTest() {
        assertEquals(2, getAverage(new int[]{2, 2, 2, 2}));
        assertEquals(3, getAverage(new int[]{1, 2, 3, 4, 5}));
        assertEquals(1, getAverage(new int[]{1, 1, 1, 1, 1, 1, 1, 2}));
    }
}
