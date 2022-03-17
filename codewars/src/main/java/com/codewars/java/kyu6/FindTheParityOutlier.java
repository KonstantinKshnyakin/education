package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an array (which will have a length of at least 3, but could be very large) containing integers.
 * The array is either entirely comprised of odd integers or entirely comprised of even integers
 * except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
 *
 * Examples
 * [2, 4, 0, 100, 4, 11, 2602, 36]
 * Should return: 11 (the only odd number)
 *
 * [160, 3, 1719, 19, 11, 13, -21]
 * Should return: 160 (the only even number)
 */
public class FindTheParityOutlier {

    static int find(int[] integers){
        if (integers == null) {
            throw new IllegalArgumentException("Integer array must not be null");
        }
        if (integers.length < 3) {
            throw new IllegalArgumentException("Integer array length must be >= 3");
        }
        Map<Integer, Long> counting = IntStream.of(integers)
                .boxed()
                .collect(Collectors.groupingBy(i -> Math.abs(i % 2), Collectors.counting()));
        if (counting.get(0) != 1 && counting.get(1) != 1) {
            throw new IllegalArgumentException();
        }
        int c = counting.get(0) == 1 ? 0 : 1;
        return IntStream.of(integers)
                .filter(i -> Math.abs(i % 2) == c)
                .findFirst().getAsInt();
    }

    @Test
    public void testExample() {
        int[] exampleTest1 = {2,6,8, -3};
        int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        assertEquals(3, find(exampleTest1));
        assertEquals(206847684, find(exampleTest2));
        assertEquals(0, find(exampleTest3));
    }
}
