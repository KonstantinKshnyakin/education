package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Your task, is to create N×N multiplication table, of size provided in parameter.
 *
 * For example, when given size is 3:
 *
 * 1 2 3
 * 2 4 6
 * 3 6 9
 * For the given example, the return value should be:
 *
 * [[1,2,3],[2,4,6],[3,6,9]]
 */
public class Multiplication {

    public static int [][] multiplicationTable(int n){
        int[][] results = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                results[i][j] = (j + 1) * (i + 1);
            }
        }
        return results;
    }

    @Test
    void test3() {
        int[][] test = {{1,2,3},{2,4,6},{3,6,9}};
        assertArrayEquals(test,Multiplication.multiplicationTable(3));
    }
    @Test
    void test1(){
        int[][] test1 = {{1}};
        assertArrayEquals(test1, Multiplication.multiplicationTable(1));
    }

}
