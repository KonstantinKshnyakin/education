package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Determine the total number of digits in the integer (n>=0) given as input to the function. For example, 9 is a
 * single digit, 66 has 2 digits and 128685 has 6 digits. Be careful to avoid overflows/underflows.
 *
 * All inputs will be valid.
 */
public class NumberOfDecimalDigits {

    public static int digits(long n) {
        return String.valueOf(n).length();
    }

    @Test
    public void digits() {
        assertEquals(1,  digits(5l));
        assertEquals(5,  digits(12345l));
        assertEquals(10, digits(9876543210l));
    }

}
