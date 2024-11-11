package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This kata is about multiplying a given number by eight if it is an even number and by nine otherwise.
 */
public class SimpleMultiplication {

    public static int simpleMultiplication(int n) {
        return n % 2 == 0 ? n * 8 : n * 9;
    }

    @Test
    public void test1() {
        System.out.println("Checking for Odd numbers.");
        assertEquals(9,simpleMultiplication(1));
        assertEquals(27,simpleMultiplication(3));
        assertEquals(189,simpleMultiplication(21));
        assertEquals(207,simpleMultiplication(23));
    }

    @Test
    public void test2() {
        System.out.println("Checking for Even numbers.");
        assertEquals(16,simpleMultiplication(2));
        assertEquals(32,simpleMultiplication(4));
        assertEquals(176,simpleMultiplication(22));
        assertEquals(208,simpleMultiplication(26));
    }

}
