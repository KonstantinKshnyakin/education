package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Task
 * You will be given an array of numbers. You have to sort the odd numbers in ascending order while leaving
 * the even numbers at their original positions.
 *
 * Examples
 * [7, 1]  =>  [1, 7]
 * [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
 * [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */
public class SortTheOdd {

    public static int[] sortArray(int[] array) {
        ArrayList<Integer> odds = new ArrayList<>();
        for (int n : array) {
            if (n % 2 != 0) {
                odds.add(n);
            }
        }
        if (odds.size() <= 1) {
            return array;
        }
        Collections.sort(odds);
        System.out.println(odds);
        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            if (n % 2 != 0) {
                array[i] = odds.remove(0);
            }
        }
        return array;
    }

    @Test
    public void exampleTest1() {
        assertArrayEquals(new int[]{ 1, 3, 2, 8, 5, 4 }, sortArray(new int[]{ 5, 3, 2, 8, 1, 4 }));
    }

    @Test
    public void exampleTest2() {
        assertArrayEquals(new int[]{ 1, 3, 5, 8, 0 }, sortArray(new int[]{ 5, 3, 1, 8, 0 }));
    }

    @Test
    public void exampleTest3() {
        assertArrayEquals(new int[]{}, sortArray(new int[]{}));
    }

}
