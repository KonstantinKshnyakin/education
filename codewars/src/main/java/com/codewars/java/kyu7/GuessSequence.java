package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You have read the title: you must guess a sequence. It will have something to do with the number given.
 *
 * Example
 * x = 16
 *
 * result = [1, 10, 11, 12, 13, 14, 15, 16, 2, 3, 4, 5, 6, 7, 8, 9]
 * Good luck!
 */
public class GuessSequence {

    static int[] sequence(int x) {
        return IntStream.rangeClosed(1, x)
                .mapToObj(String::valueOf)
                .sorted()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    @Test
    public void test0() {
        int[] result = {1, 10, 11, 12, 13, 14, 15, 16, 2, 3, 4, 5, 6, 7, 8, 9};
        int x = 16;
        String expected = Arrays.toString(result),
                actual = Arrays.toString(sequence(x));
        assertEquals(expected, actual);
    }
    @Test
    public void test1() {
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int x = 9;
        String expected = Arrays.toString(result),
                actual = Arrays.toString(sequence(x));
        assertEquals(expected, actual);
    }
}
