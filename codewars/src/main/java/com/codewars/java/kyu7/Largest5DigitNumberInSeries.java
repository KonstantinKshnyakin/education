package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In the following 6 digit number:
 *
 * 283910
 * 91 is the greatest sequence of 2 consecutive digits.
 *
 * In the following 10 digit number:
 *
 * 1234567890
 * 67890 is the greatest sequence of 5 consecutive digits.
 *
 * Complete the solution so that it returns the greatest sequence of five consecutive digits found within the number given.
 * The number will be passed in as a string of only digits. It should return a five digit integer.
 * The number passed may be as large as 1000 digits.
 */
public class Largest5DigitNumberInSeries {

    public static int solve(final String digits) {
        int result = Integer.parseInt(digits.substring(0, 5));
        for (int i = 1; i + 5 <= digits.length(); i++) {
            int val = Integer.parseInt(digits.substring(i, i + 5));
            if (val > result) {
                result = val;
            }
        }
        return result;
    }

    @Test
    public void exampleTests() {
        assertEquals(83910, solve("283910"));
        assertEquals(67890, solve("1234567890"));
        assertEquals(74765, solve("731674765"));
    }

}
