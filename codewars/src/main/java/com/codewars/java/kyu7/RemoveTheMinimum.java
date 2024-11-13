package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * The museum of incredibly dull things
 * The museum of incredibly dull things wants to get rid of some exhibits. Miriam, the interior architect,
 * comes up with a plan to remove the most boring exhibits. She gives them a rating, and then removes the one with the
 * lowest rating.
 *
 * However, just as she finished rating all exhibits, she's off to an important fair, so she asks you to write a program
 * that tells her the ratings of the exhibits after removing the lowest one. Fair enough.
 *
 * Task
 * Given an array of integers, remove the smallest value. Do not mutate the original array/list. If there are multiple
 * elements with the same value, remove the one with the lowest index. If you get an empty array/list, return an empty
 * array/list.
 *
 * Don't change the order of the elements that are left.
 *
 * Examples
 * * Input: [1,2,3,4,5], output = [2,3,4,5]
 * * Input: [5,3,2,1,4], output = [5,3,2,4]
 * * Input: [2,2,1,2,1], output = [2,2,2,1]
 */
public class RemoveTheMinimum {

    public static int[] removeSmallest(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return numbers;
        }
        int[] result = new int[numbers.length - 1];
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        for (int i = 0, j = 0; i < numbers.length; i++) {
            if (i != minIndex) {
                result[j] = numbers[i];
                j++;
            }
        }
        return result;
    }

    @Test
    void test1() {
        int[] actual = removeSmallest(new int[] {1, 2, 3, 4, 5});
        assertArrayEquals(new int[] {2, 3, 4, 5}, actual,
                "For numbers = [1, 2, 3, 4, 5]:\nexpected: [2, 3, 4, 5]\nactual:   " + Arrays.toString(actual) + "\n");
    }

    @Test
    void test2() {
        int[] actual = removeSmallest(new int[] {5, 3, 2, 1, 4});
        assertArrayEquals(new int[] {5, 3, 2, 4}, actual,
                "For numbers = [5, 3, 2, 1, 4]:\nexpected: [5, 3, 2, 4]\nactual:   " + Arrays.toString(actual) + "\n");
    }

    @Test
    void test3() {
        int[] actual = removeSmallest(new int[] {2, 2, 1, 2, 1});
        assertArrayEquals(new int[] {2, 2, 2, 1}, actual,
                "For numbers = [2, 2, 1, 2, 1]:\nexpected: [2, 2, 2, 1]\nactual:   " + Arrays.toString(actual) + "\n");
    }

    @Test
    void test4() {
        int[] actual = removeSmallest(new int[] {5, 3, 2, 1, 4});
        assertArrayEquals(new int[] {5, 3, 2, 4}, actual,
                "For numbers = [5, 3, 2, 1, 4]:\nexpected: [5, 3, 2, 4]\nactual:   " + Arrays.toString(actual) + "\n");
    }

    @Test
    void test5() {
        int[] actual = removeSmallest(new int[] {5, 4, 3, 2, 1});
        assertArrayEquals(new int[] {5, 4, 3, 2}, actual,
                "For numbers = [5, 4, 3, 2, 1]:\nexpected: [5, 4, 3, 2]\nactual:   " + Arrays.toString(actual) + "\n");
    }

}
