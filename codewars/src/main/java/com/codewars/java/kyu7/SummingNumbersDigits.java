package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function which takes a number as input and returns the sum of the absolute value of each
 * of the number's decimal digits.
 *
 * For example: (Input --> Output)
 *
 * 10 --> 1
 * 99 --> 18
 * -32 --> 5
 * Let's assume that all numbers in the input will be integer values.
 *
 * Fundamentals
 */
public class SummingNumbersDigits {

    public static int sumDigits(int number) {
        number = Math.abs(number);
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number = number / 10;
        }
        return result;
    }

    private static void doTest(int num, int expected) {
        assertEquals(expected, sumDigits(num), String.format("Incorrect answer for num = %d\n\n", num));
    }

    @Test
    public void testSampleCases() {
        doTest(10, 1);
        doTest(99, 18);
        doTest(-32, 5);
    }
}
