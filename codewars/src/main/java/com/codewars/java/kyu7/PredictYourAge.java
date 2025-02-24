package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * My grandfather always predicted how old people would get, and right before he passed away he revealed his secret!
 *
 * In honor of my grandfather's memory we will write a function using his formula!
 *
 * Take a list of ages when each of your great-grandparent died.
 * Multiply each number by itself.
 * Add them all together.
 * Take the square root of the result.
 * Divide by two.
 * Example
 * predictAge(65, 60, 75, 55, 60, 63, 64, 45) === 86
 * Note: the result should be rounded down to the nearest integer.
 *
 * Some random tests might fail due to a bug in the JavaScript implementation. Simply resubmit if that happens to you.
 */
public class PredictYourAge {

    public static int predictAge(int... ages) {
        int sumSquares = Arrays.stream(ages)
                .map(i -> i * i)
                .sum();
        return (int) Math.sqrt(sumSquares) / 2;
    }

    @Test
    public void FixedTests() {
        assertEquals(86, predictAge(65,60,75,55,60,63,64,45));
        assertEquals(79, predictAge(32,54,76,65,34,63,64,45));
    }

}
