package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function that accepts a string, and returns true if it is in the form of a phone number.
 * Assume that any integer from 0-9 in any of the spots will produce a valid phone number.
 *
 * Only worry about the following format:
 * (123) 456-7890 (don't forget the space after the close parentheses)
 */
public class ValidPhoneNumber {

    public static boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
    }

    @Test
    public void tests() {
        assertEquals(true, validPhoneNumber("(123) 456-7890"));
        assertEquals(false, validPhoneNumber("(1111)555 2345"));
        assertEquals(false, validPhoneNumber("(098) 123 4567"));
    }

}
