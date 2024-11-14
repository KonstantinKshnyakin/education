package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * In mathematics, Pascal's triangle is a triangular array of the binomial coefficients expressed with formula
 * where n denotes a row of the triangle, and k is a position of a term in the row.
 *
 * Pascal's Triangle
 *
 * You can read Wikipedia article on Pascal's Triangle for more information.
 *
 * Task
 * Write a function that, given a depth n, returns n top rows of Pascal's Triangle flattened into a one-dimensional list/array.
 *
 * Example:
 * n = 1: [1]
 * n = 2: [1,  1, 1]
 * n = 4: [1,  1, 1,  1, 2, 1,  1, 3, 3, 1]
 * Note
 * Beware of overflow. Requested terms of a triangle are guaranteed to fit into the returned type, but depending on
 * seleced method of calculations, intermediate values can be larger.
*/
public class PascalsTriangle {

    public static long[] generate(int level) {
        List<Long> result = new ArrayList<>();
        long one = 1;
        for (int i = 0; i < level; i++) {
            int prevStartIndex = result.size() - i;
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    result.add(one);
                } else {
                    int index = prevStartIndex + j;
                    Long v1 = result.get(index - 1);
                    Long v2 = result.get(index);
                    result.add(v2 + v1);
                }
            }
        }
        return result.stream().mapToLong(i -> i).toArray();
    }

    @Test
    public void testOneLevelTriangle() {
        final long[] terms = { 1L };
        assertArrayEquals(PascalsTriangle.generate(1), terms);
    }

    @Test
    public void testTwoLevelsTriangle() {
        final long[] terms = { 1L, 1L, 1L };
        assertArrayEquals(PascalsTriangle.generate(2), terms);
    }

    @Test
    public void testFourLevelsTriangle() {
        final long[] terms = { 1L, 1L, 1L, 1L, 2L, 1L, 1L, 3L, 3L, 1L };
        assertArrayEquals(PascalsTriangle.generate(4), terms);
    }

}
