package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a list of positive integers, determine the minimum non-negative integer that needs to be inserted so that
 * the sum of all elements becomes a prime number.
 * <p>
 * Notes
 * The list will always have at least 2 elements.
 * All elements will be positive integers (n > 0).
 * The list may contain duplicate values.
 * The new sum must be the closest prime number that is greater than or equal to the current sum.
 * <p>
 * <p>
 * Examples
 * [3, 1, 2] ==> Should return 1
 * Explanation: The sum is 6
 * The closest prime greater than or equal to 6 is 7
 * We need to add 1 to make the sum 7 (a prime)
 * <p>
 * [2, 12, 8, 4, 6] ==> Should return 5
 * Explanation: The sum is 32
 * The closest prime greater than or equal to 32 is 37
 * We need to add 5 to make the sum 37 (a prime)
 * <p>
 * [50, 39, 49, 6, 17, 28] ==> Should return 2
 * Explanation: The sum is 189
 * The closest prime greater than or equal to 189 is 191
 * We need to add 2 to make the sum 191 (a prime)
 */
public class TransformToPrime {

    public static int minimumNumber(int[] numbers) {
        int sum = IntStream.of(numbers)
                .sum();
        BigInteger nextPrime = new BigInteger(String.valueOf(sum));
        if (!nextPrime.isProbablePrime(10)) {
            nextPrime = nextPrime.nextProbablePrime();
        }
        System.out.println(sum);
        System.out.println(nextPrime);
        System.out.println("-----------------------");
        return nextPrime.intValueExact() - sum;
    }

    @Test
    public void checkSmallArraySize() {
        assertEquals(1, minimumNumber(new int[]{3, 1, 2}));
        assertEquals(0, minimumNumber(new int[]{5, 2}));
        assertEquals(0, minimumNumber(new int[]{1, 1, 1}));
    }

    @Test
    public void checkLargerArraySize() {
        assertEquals(5, minimumNumber(new int[]{2, 12, 8, 4, 6}));
        assertEquals(2, minimumNumber(new int[]{50, 39, 49, 6, 17, 28}));
    }
}
