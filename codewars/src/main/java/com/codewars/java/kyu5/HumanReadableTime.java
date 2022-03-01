package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function, which takes a non-negative integer (seconds)
 * as input and returns the time in a human-readable format (HH:MM:SS)
 *
 * HH = hours, padded to 2 digits, range: 00 - 99
 * MM = minutes, padded to 2 digits, range: 00 - 59
 * SS = seconds, padded to 2 digits, range: 00 - 59
 * The maximum time never exceeds 359999 (99:59:59)
 *
 * You can find some examples in the test fixtures.
 */
public class HumanReadableTime {

    public static String makeReadable(int seconds) {
        int s = seconds % 60;
        int m = (seconds % 3600) / 60;
        int h = seconds / 3600;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    @Test
    public void Tests() {
        assertEquals("00:00:00", makeReadable(0));
        assertEquals("00:00:05", makeReadable(5));
        assertEquals("00:01:00", makeReadable(60));
        assertEquals("23:59:59", makeReadable(86399));
        assertEquals("99:59:59", makeReadable(359999));
    }
}
