package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You're working in a number zoo, and it seems that one of the numbers has gone missing!
 *
 * Zoo workers have no idea what number is missing, and are too incompetent to figure it out, so they're
 * hiring you to do it for them.
 *
 * In case the zoo loses another number, they want your program to work regardless of how many numbers there are
 * in total.
 *
 * Task:
 * Write a function that takes a shuffled list of unique numbers from 1 to n with one element missing (which can be
 * any number including n). Return this missing number.
 *
 * Note: huge lists will be tested.
 *
 * Examples:
 * [1, 3, 4]  =>  2
 * [1, 2, 3]  =>  4
 * [4, 2, 3]  =>  1
 */
public class NumberZooPatrol {

    public static int findMissingNumber(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            return 1;
        }
        IntSummaryStatistics statistics = IntStream.of(numbers)
                .summaryStatistics();
        int max = statistics.getMax();
        long sum = statistics.getSum();
        long expSum = (long) max * (max + 1) / 2;
        if (sum < expSum) {
            return (int) Math.subtractExact(expSum, sum);
        }
        return max + 1;
    }

    @Test
    public void testDescriptionExamples() {
        assertEquals(2, findMissingNumber(1, 3));
        assertEquals(1, findMissingNumber(2, 3, 4));
        assertEquals(12, findMissingNumber(13, 11, 10, 3, 2, 1, 4, 5, 6, 9, 7, 8));
    }

    @Test
    public void testPerformanceIsLinear() {
        // Solutions with linear runtime should finish in about 200 to 300 ms.
        // 1. Generate an array with 999,999 numbers with increasing and
        //    decreasing values interleaved so sorting algorithms which
        //    are able detect pre-sorted arrays would still need
        //    at least loglinear time.
        // 2. Find the missing number 100 times.
        int[] numbers = generateNumbers(1_000_000, 66_667);
        for (int i = 0; i < 249_999; i++) {
            int temp = numbers[i * 2];
            numbers[i * 2] = numbers[999_997 - i * 2];
            numbers[999_997 - i * 2] = temp;
        }
        for (int i = 0; i < 100; i++)
            findMissingNumber(numbers.clone());
    }

    private static int[] generateNumbers(int bound, int missingNumber) {
        if (missingNumber < 1 || missingNumber > bound)
            throw new IllegalArgumentException("Missing number is not in allowed range");
        int[] numbers = new int[bound - 1];
        int pos = 0;
        for (int i = 1; i <= bound; i++)
            if (i != missingNumber)
                numbers[pos++] = i;
        return numbers;
    }

}
