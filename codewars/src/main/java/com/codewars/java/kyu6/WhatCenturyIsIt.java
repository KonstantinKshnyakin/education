package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Return the century of the input year. The input will always be a 4 digit string, so there is no need for validation.
 *
 * Examples
 * "1999" --> "20th"
 * "2011" --> "21st"
 * "2154" --> "22nd"
 * "2259" --> "23rd"
 * "1124" --> "12th"
 * "2000" --> "20th"
 */
public class WhatCenturyIsIt {

    public static String whatCentury(int year) {
        if (year % 100 != 0) {
            year += 100;
        }
        String century = String.valueOf(year);
        century = century.substring(0 , century.length() - 2);
        if (century.matches("[2-9]?1")) {
            century = century.concat("st");
        } else if (century.matches("[2-9]?2")) {
            century = century.concat("nd");
        } else if (century.matches("[2-9]?3")) {
            century = century.concat("rd");
        } else {
            century = century.concat("th");
        }
        return century;
    }

    @Test
    public void testSomething() {
        assertEquals("20th", whatCentury(1999));
        assertEquals("99th", whatCentury(9900));
        assertEquals("21st", whatCentury(2011));
        assertEquals("22nd", whatCentury(2154));
        assertEquals("23rd", whatCentury(2259));
        assertEquals("12th", whatCentury(1124));
    }
}
