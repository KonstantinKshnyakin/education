package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The prime numbers are not regularly spaced. For example from 2 to 3 the gap is 1. From 3 to 5 the gap is 2.
 * From 7 to 11 it is 4. Between 2 and 50 we have the following pairs of 2-gaps primes:
 * 3-5, 5-7, 11-13, 17-19, 29-31, 41-43
 *
 * A prime gap of length n is a run of n-1 consecutive composite numbers between two successive
 * primes (see: http://mathworld.wolfram.com/PrimeGaps.html).
 *
 * We will write a function gap with parameters:
 *
 * g (integer >= 2) which indicates the gap we are looking for
 *
 * m (integer > 2) which gives the start of the search (m inclusive)
 *
 * n (integer >= m) which gives the end of the search (n inclusive)
 *
 * In the example above gap(2, 3, 50) will return [3, 5] or (3, 5) or {3, 5} which is the first pair
 * between 3 and 50 with a 2-gap.
 *
 * So this function should return the first pair of two prime numbers spaced with a gap of g between the limits m, n
 * if these numbers exist otherwise `nil or null or None or Nothing (or ... depending on the language).
 */
public class GapInPrimes {

    public static long[] gap(int g, long m, long n) {
        long val1 = -1;
        long val2 = -1;
        for (long i = m; i <= n; i++) {
            if (val1 == -1 && isPrime(i)) {
                val1 = i;
            } else if (isPrime(i)) {
                val2 = i;
            }
            if (val2 != -1) {
                if (val2 - val1 == g) {
                    return new long[]{val1, val2};
                } else {
                    val1 = val2;
                    val2 = -1;
                }
            }
        }
        return null;
    }

    public static boolean isPrime(long value) {
        for (long i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests");
        assertEquals("[101, 103]", Arrays.toString(GapInPrimes.gap(2, 100, 110)));
        assertEquals("[103, 107]", Arrays.toString(GapInPrimes.gap(4, 100, 110)));
        assertEquals(null, GapInPrimes.gap(6, 100, 110));
        assertEquals("[359, 367]", Arrays.toString(GapInPrimes.gap(8, 300, 400)));
        assertEquals("[337, 347]", Arrays.toString(GapInPrimes.gap(10, 300, 400)));
    }

}