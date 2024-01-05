package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an odd-length array of integers, in which all of them are the same, except for one single number.
 * <p>
 * Complete the method which accepts such an array, and returns that single different number.
 * <p>
 * The input array will always be valid! (odd-length >= 3)
 */
public class FindStrayNumber {

    static int stray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0] == numbers[1] ? numbers[numbers.length - 1] : numbers[0];
    }

    @Test
    public void threeElements1() {
        assertEquals(2, getActualFor(2, 1, 1));
    }

    @Test
    public void threeElements2() {
        assertEquals(2, getActualFor(1, 2, 1));
    }

    @Test
    public void threeElements3() {
        assertEquals(2, getActualFor(1, 1, 2));
    }

    private int getActualFor(int... numbers) {
        return stray(numbers);
    }

}
