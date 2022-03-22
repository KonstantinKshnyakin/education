package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given the triangle of consecutive odd numbers:
 * <p>
 * 1
 * 3     5
 * 7     9    11
 * 13    15    17    19
 * 21    23    25    27    29
 * ...
 * Calculate the sum of the numbers in the nth row of this triangle (starting at index 1) e.g.: (Input --> Output)
 * <p>
 * 1 -->  1
 * 2 --> 3 + 5 = 8
 */
public class SumOfOddNumbers {

    public static int rowSumOddNumbers(int n) {
        int result = 0;
        int number = 1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            while (count != i) {
                if (number % 2 == 1) {
                    count++;
                    if (i == n) {
                        result += number;
                    }
                }
                number++;
            }
        }
//        return result;
        int count = IntStream.rangeClosed(1, n).sum();
        return IntStream.rangeClosed(1, Integer.MAX_VALUE)
                .filter(i -> i % 2 == 1)
                .skip(count - n)
                .limit(n)
                .sum();
    }

    @Test
    public void test1() {
        assertEquals(1, rowSumOddNumbers(1));
        assertEquals(74088, rowSumOddNumbers(42));
    }
}
