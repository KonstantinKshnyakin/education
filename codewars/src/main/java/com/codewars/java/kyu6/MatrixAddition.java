package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Write a function that accepts two square matrices (N x N two dimensional arrays), and return the sum of the two.
 * Both matrices being passed into the function will be of size N x N (square), containing only integers.
 *
 * How to sum two matrices:
 *
 * Take each cell [n][m] from the first matrix, and add it with the same [n][m] cell from the second matrix.
 * This will be cell [n][m] of the solution matrix. (Except for C where solution matrix will be
 * a 1d pseudo-multidimensional array).
 *
 * Visualization:
 *
 * |1 2 3|     |2 2 1|     |1+2 2+2 3+1|     |3 4 4|
 * |3 2 1|  +  |3 2 3|  =  |3+3 2+2 1+3|  =  |6 4 4|
 * |1 1 1|     |1 1 3|     |1+1 1+1 1+3|     |2 2 4|
 */
public class MatrixAddition {

    public static int[][] matrixAddition(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Матрицы должны быть квадратными");
        }

        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    @Test
    public void sampleTest() {
        int[][] expected = new int[][] { { 3, 4, 4 }, { 6, 4, 4 }, { 2, 2, 4 } };

        assertArrayEquals(expected,
                matrixAddition(
                        new int[][] { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 1, 1 } },
                        new int[][] { { 2, 2, 1 }, { 3, 2, 3 }, { 1, 1, 3 } }));

        expected = new int[][] { { 3 } };
        assertArrayEquals(expected,
                matrixAddition(
                        new int[][] { { 1 } },
                        new int[][] { { 2 } }));

        expected = new int[][] { { 3, 5 }, { 3, 5 } };
        assertArrayEquals(expected,
                matrixAddition(
                        new int[][] { { 1, 2 }, { 1, 2 } },
                        new int[][] { { 2, 3 }, { 2, 3 } }));
    }

}
