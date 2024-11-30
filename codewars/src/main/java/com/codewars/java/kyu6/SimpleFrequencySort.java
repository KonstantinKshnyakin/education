package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * In this kata, you will sort elements in an array by decreasing frequency of elements. If two elements have the same
 * frequency, sort them by increasing value.
 * <p>
 * Solution.sortByFrequency(new int[]{2, 3, 5, 3, 7, 9, 5, 3, 7});
 * // Returns {3, 3, 3, 5, 5, 7, 7, 2, 9}
 * // We sort by highest frequency to lowest frequency.
 * // If two elements have same frequency, we sort by increasing value.
 * More examples in test cases.
 */
public class SimpleFrequencySort {

    public static int[] sortByFrequency(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()))
                .values().stream()
                .sorted(Comparator.comparing((List<Integer> l) -> -l.size()).thenComparingInt(l -> l.get(0)))
                .flatMapToInt(i -> i.stream().mapToInt(d -> d))
                .toArray();
    }

    @Test
    public void basicTests() {
        assertArrayEquals(new int[]{3, 3, 3, 5, 5, 7, 7, 2, 9}, sortByFrequency(new int[]{2, 3, 5, 3, 7, 9, 5, 3, 7}));
        assertArrayEquals(new int[]{1, 1, 1, 0, 0, 6, 6, 8, 8, 2, 3, 5, 9}, sortByFrequency(new int[]{1, 2, 3, 0, 5, 0, 1, 6, 8, 8, 6, 9, 1}));
        assertArrayEquals(new int[]{9, 9, 9, 9, 4, 4, 5, 5, 6, 6}, sortByFrequency(new int[]{5, 9, 6, 9, 6, 5, 9, 9, 4, 4}));
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 8}, sortByFrequency(new int[]{4, 4, 2, 5, 1, 1, 3, 3, 2, 8}));
        assertArrayEquals(new int[]{0, 0, 4, 4, 9, 9, 3, 5, 7, 8}, sortByFrequency(new int[]{4, 9, 5, 0, 7, 3, 8, 4, 9, 0}));
    }

}
