package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
 *
 * Note: If the number is a multiple of both 3 and 5, only count it once.
 *
 * Courtesy of projecteuler.net (Problem 1)
 */
public class MultiplesOf3Or5 {

    public static int solution(int number) {
        return IntStream.range(1, number)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .sum();
    }

    @Test
    public void test() {
        assertEquals(23, solution(10));
    }

}
