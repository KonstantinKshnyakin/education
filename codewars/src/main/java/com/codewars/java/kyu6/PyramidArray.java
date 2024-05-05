package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Write a function that when given a number >= 0, returns an Array of ascending length subarrays.
 *
 * pyramid(0) => [ ]
 * pyramid(1) => [ [1] ]
 * pyramid(2) => [ [1], [1, 1] ]
 * pyramid(3) => [ [1], [1, 1], [1, 1, 1] ]
 * Note: the subarrays should be filled with 1s
 */
public class PyramidArray {

    public static int[][] pyramid(int n){
        int[][] result = new int[n][0];
        for (int i = 0; i < n; i++) {
            int[] ints = new int[i + 1];
            Arrays.fill(ints, 1);
            result[i] = ints;
        }
        return result;
    }


    @Test
    public void fixedTests() {
        test(0, new int[][]{});
        test(1, new int[][]{{1}});
        test(2, new int[][]{{1}, {1, 1}});
        test(3, new int[][]{{1}, {1, 1}, {1,1,1}});
    }

    private static String pyramidToString(int[][] p) {
        return "{" + Arrays.stream(p)
                .map(row -> "{" + Arrays.stream(row).mapToObj(Integer::toString).collect(Collectors.joining(",")) + "}")
                .collect(Collectors.joining(",")) + "}";
    }

    private void test(int n, int[][] correct) {
        int[][] userSolution = pyramid(n);
        String scorrect = pyramidToString(correct);
        String suser = pyramidToString(userSolution);
        String text = suser + "\nshould equal:\n" + scorrect + "\n";
        assertArrayEquals(correct, userSolution, text);
    }

}
