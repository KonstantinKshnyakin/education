package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Due to lack of maintenance the minute-hand has fallen off Town Hall clock face.
 *
 * And because the local council has lost most of our tax money to an elaborate email scam there are no funds
 * to fix the clock properly.
 *
 * Instead, they are asking for volunteer programmers to write some code that tell the time by only looking at
 * the remaining hour-hand!
 *
 * What a bunch of cheapskates!
 *
 * Can you do it?
 *
 * Kata
 * Given the angle (in degrees) of the hour-hand, return the time in 12 hour HH:MM format. Round down to
 * the nearest minute.
 *
 * Examples
 * 12:00 = 0 degrees
 *
 * 03:00 = 90 degrees
 *
 * 06:00 = 180 degrees
 *
 * 09:00 = 270 degrees
 *
 * 12:00 = 360 degrees
 *
 * Notes
 * 0 <= angle <= 360
 *
 * Do not make any AM or PM assumptions for the HH:MM result. They are indistinguishable for this Kata.
 *
 * 3 o'clock is 03:00, not 15:00
 * 7 minutes past midnight is 12:07
 * 7 minutes past noon is also 12:07
 */
public class ClockyMcClockFace {

    public static String whatTimeIsIt(final double angle) {
        int hour = (int) ( angle) / 30;
        if (hour == 0) {
            hour = 12;
        }
        int minutes = (int) ((angle % 30) / 0.5);
        return "%02d:%02d".formatted(hour, minutes);
    }

    @Test
    public void test1200() {
        assertEquals("12:04", whatTimeIsIt(2));
        assertEquals("12:00", whatTimeIsIt(360));
    }

    @Test
    public void test0300() {
        assertEquals("03:30", whatTimeIsIt(105));
        assertEquals("03:00", whatTimeIsIt(90));
    }

    @Test
    public void test0600() {
        assertEquals("06:00", whatTimeIsIt(180));
    }

    @Test
    public void test0900() {
        assertEquals("01:14", whatTimeIsIt(37));
        assertEquals("09:00", whatTimeIsIt(270));
    }

}
