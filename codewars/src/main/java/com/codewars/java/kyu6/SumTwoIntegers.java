package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given Two integers a , b , find The sum of them , BUT You are not allowed to use the operators + and -
 * <p>
 * Notes
 * The numbers (a,b) may be positive , negative values or zeros .
 * <p>
 * Returning value will be an integer .
 * <p>
 * Java: the following methods are prohibited: addExact, average, collect, decrement, increment, nextAfter, nextDown,
 * nextUp, reduce, subtractExact, sum, summing . The following classes are prohibited: BigDecimal and BigInteger .
 * Input >> Output Examples
 * 1- Add (5,19) ==> return (24)
 * <p>
 * 2- Add (-27,18) ==> return (-9)
 * <p>
 * 3- Add (-14,-16) ==> return (-30)
 */
public class SumTwoIntegers {

    public static int add(int x, int y) {
        int carry;
        while(y != 0x00)
        {
            carry	= (x & y);
            x	= x ^ y;
            y	= (carry << 1);
        }
        return x;
    }

    @Test
    public void checkPositiveValues() {
        assertEquals(3, add(1, 2));
        assertEquals(24, add(5, 19));
        assertEquals(40, add(23, 17));
    }

    @Test
    public void checkNegativeValues() {
        assertEquals(-30, add(-14, -16));
        assertEquals(-226, add(-50, -176));
        assertEquals(-39, add(-10, -29));
    }

    @Test
    public void checkMixtureValues() {
        assertEquals(0, add(-13, 13));
        assertEquals(-9, add(-27, 18));
        assertEquals(-60, add(-90, 30));
    }

}
