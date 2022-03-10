package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * An isogram is a word that has no repeating letters, consecutive or non-consecutive.
 * Implement a function that determines whether a string that contains only letters is an isogram.
 * Assume the empty string is an isogram. Ignore letter case.
 *
 * Example: (Input --> Output)
 * "Dermatoglyphics" --> true
 * "aba" --> false
 * "moOse" --> false (ignore letter case)
 */
public class Isograms {

    public static boolean  isIsogram(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String argument must not be null");
        }
        if (str.isBlank()) {
            return true;
        }
        return Arrays.stream(str.toLowerCase().split(""))
                .distinct()
                .count() == str.length();
    }

    @Test
    public void FixedTests() {
        assertEquals(true, isIsogram("Dermatoglyphics"));
        assertEquals(true, isIsogram("isogram"));
        assertEquals(false, isIsogram("moose"));
        assertEquals(false, isIsogram("isIsogram"));
        assertEquals(false, isIsogram("aba"));
        assertEquals(false, isIsogram("moOse"));
        assertEquals(true, isIsogram("thumbscrewjapingly"));
        assertEquals(true, isIsogram(""));
    }
}
