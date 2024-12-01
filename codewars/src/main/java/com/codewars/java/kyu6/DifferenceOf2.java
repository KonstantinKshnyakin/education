package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * The objective is to return all pairs of integers from a given array of integers that have a difference of 2.
 *
 * The result array should be sorted in ascending order of values.
 *
 * Assume there are no duplicate integers in the array. The order of the integers in the input array should not matter.
 *
 * Examples
 * [1, 2, 3, 4]  should return [[1, 3], [2, 4]]
 *
 * [4, 1, 2, 3]  should also return [[1, 3], [2, 4]]
 *
 * [1, 23, 3, 4, 7] should return [[1, 3]]
 *
 * [4, 3, 1, 5, 6] should return [[1, 3], [3, 5], [4, 6]]
 */
public class DifferenceOf2 {

    public static int[][] twosDifference(int[] array) {
        List<int[]> result = new ArrayList<>();
        List<Integer> list = Arrays.stream(array).sorted().boxed().toList();
        for (int i = 0; i < list.size(); i++) {
            int first = list.get(i);
            int expNext = first + 2;
            for (int j = i + 1; j < list.size(); j++) {
                int next = list.get(j);
                if (expNext == next) {
                    result.add(new int[]{first, next});
                    break;
                } else if (next > expNext) {
                    break;
                }
            }
        }
        return result.toArray(new int[0][0]);
    }

    @Test
    public void sample_tests() {
        assertArrayEquals(
                new int[][]{{1, 3}, {2, 4}},
                twosDifference(new int[]{1, 2, 3, 4})
        );

        assertArrayEquals(
                new int[][]{{1, 3}, {4, 6}},
                twosDifference(new int[]{1, 3, 4, 6})
        );
    }
}
