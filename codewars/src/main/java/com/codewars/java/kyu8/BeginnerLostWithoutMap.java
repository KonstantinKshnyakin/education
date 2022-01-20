package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array of integers, return a new array with each value doubled.
 *
 * For example:
 *
 * [1, 2, 3] --> [2, 4, 6]
 */
public class BeginnerLostWithoutMap {

    public static int[] map(int[] arr) {
        return IntStream.of(arr).map(n -> n * 2).toArray();
    }

    @Test
    public void sampleTests() {
        assertArrayEquals(new int[] {2, 4, 6}, map(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {8, 2, 2, 2, 8}, map(new int[] {4, 1, 1, 1, 4}));
        assertArrayEquals(new int[] {2, 2, 2, 2, 2, 2}, map(new int[] {1, 1, 1, 1, 1, 1}));
    }
}
