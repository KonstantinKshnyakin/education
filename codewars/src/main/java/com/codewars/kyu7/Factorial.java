package com.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/****************************************************************************************
 *In mathematics, the factorial of a non-negative integer n, denoted by n!, is
 * the product of all positive integers less than or equal to n. For example:
 * 5! = 5 * 4 * 3 * 2 * 1 = 120.
 * By convention the value of 0! is 1.
 *
 * Write a function to calculate factorial for a given input. If input is below 0 or
 * above 12 throw an exception of type ArgumentOutOfRangeException (C#) or I
 * llegalArgumentException (Java) or RangeException (PHP) or throw a RangeError (JavaScript)
 * or ValueError (Python) or return -1 (C).
 ***************************************************************************************/
public class Factorial {

    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException();
        }
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    @Test
    public void test_factorial0() {
        assertEquals(1, factorial(0));
    }

    @Test
    public void test_factorial3() {
        assertEquals(6, factorial(3));
    }

    @Test
    public void test_factorial5() {
        assertEquals(120, factorial(5));
    }
}
