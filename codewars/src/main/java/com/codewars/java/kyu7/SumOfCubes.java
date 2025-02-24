package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function that takes a positive integer n, sums all the cubed values from 1 to n (inclusive), and returns that sum.
 * <p>
 * Assume that the input n will always be a positive integer.
 * <p>
 * Examples: (Input --> output)
 * <p>
 * 2 --> 9 (sum of the cubes of 1 and 2 is 1 + 8)
 * 3 --> 36 (sum of the cubes of 1, 2, and 3 is 1 + 8 + 27)
 */
public class SumOfCubes {

    public static long sumCubes(long n) {
        return LongStream.rangeClosed(1, n)
                .map(i -> i * i * i)
                .sum();
    }


    @Test
    public void exampleTests() {
        assertEquals(1, sumCubes(1));
        assertEquals(9, sumCubes(2));
        assertEquals(36, sumCubes(3));
        assertEquals(100, sumCubes(4));
        assertEquals(3025, sumCubes(10));
        assertEquals(58155876, sumCubes(123));
    }

}
