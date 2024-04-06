package com.codewars.java.kyu5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * In this example you have to validate if a user input string is alphanumeric.
 * The given string is not nil/null/NULL/None, so you don't have to check that.
 *
 * The string has the following conditions to be alphanumeric:
 *
 * At least one character ("" is not valid)
 * Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9
 * No whitespaces / underscore
 */
public class NotVerySecure {

    public static boolean alphanumeric(String s){
        return s.matches("[0-9A-Za-z]+");
    }

    @Test
    @DisplayName("Valid input")
    void testValidInput() {
        assertTrue(alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
    }

    @DisplayName("Invalid character")
    @ParameterizedTest(name="Should return false for \"{0}\"")
    @ValueSource(strings = {"", "with space", "with_underscore", "punctuation.", "naïve", "１strangedigit", "emoji😊"})
    void testInvalidChars(String input) {
        assertFalse(alphanumeric(input));
    }

}
