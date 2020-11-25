package com.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ATM machines allow 4 or 6 digit PIN codes and PIN
 * codes cannot contain anything but exactly 4 digits
 * or exactly 6 digits.
 *
 * If the function is passed a valid PIN string, return
 * true, else return false.
 */

public class ValidatePINCode {

    public static boolean validatePin(String pin) {
        return pin.matches("\\d{4}") || pin.matches("\\d{6}");
    }

    @Test
    public void validPins() {
        assertTrue(ValidatePINCode.validatePin("1234"));
        assertTrue(ValidatePINCode.validatePin("0000"));
        assertTrue(ValidatePINCode.validatePin("1111"));
        assertTrue(ValidatePINCode.validatePin("123456"));
        assertTrue(ValidatePINCode.validatePin("098765"));
        assertTrue(ValidatePINCode.validatePin("000000"));
        assertTrue(ValidatePINCode.validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertFalse(ValidatePINCode.validatePin("a234"));
        assertFalse(ValidatePINCode.validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertFalse(ValidatePINCode.validatePin("1"));
        assertFalse(ValidatePINCode.validatePin("12"));
        assertFalse(ValidatePINCode.validatePin("123"));
        assertFalse(ValidatePINCode.validatePin("12345"));
        assertFalse(ValidatePINCode.validatePin("1234567"));
        assertFalse(ValidatePINCode.validatePin("-1234"));
        assertFalse(ValidatePINCode.validatePin("1.234"));
        assertFalse(ValidatePINCode.validatePin("00000000"));
    }
}