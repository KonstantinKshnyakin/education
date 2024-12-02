package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Backwards Read Primes are primes that when read backwards in base 10 (from right to left) are a different prime.
 * (This rules out primes which are palindromes.)
 *
 * Examples:
 * 13 17 31 37 71 73 are Backwards Read Primes
 * 13 is such because it's prime and read from right to left writes 31 which is prime too. Same for the others.
 *
 * Task
 * Find all Backwards Read Primes between two positive given numbers (both inclusive), the second one always being
 * greater than or equal to the first one. The resulting array or the resulting string will be ordered following
 * the natural order of the prime numbers.
 *
 * Examples (in general form):
 * backwardsPrime(2, 100) => [13, 17, 31, 37, 71, 73, 79, 97] backwardsPrime(9900, 10000) => [9923, 9931, 9941, 9967]
 * backwardsPrime(501, 599) => []
 *
 * See "Sample Tests" for your language.
 */
public class BackwardsReadPrimes {

    public static String backwardsPrime(long start, long end) {
        StringJoiner sj = new StringJoiner(" ");
        BigInteger num = BigInteger.valueOf(start);
        if (!isPrime(num)) {
            num = num.nextProbablePrime();
        }
        BigInteger numEnd = BigInteger.valueOf(end);
        while (numEnd.compareTo(num) == 0 || numEnd.compareTo(num) >= 1) {
            if (isBackwardPrime(num)) {
                sj.add(num.toString());
            }
            num = num.nextProbablePrime();
        }
        return sj.toString();
    }

    public static boolean isBackwardPrime(BigInteger num) {
        String numStr = num.toString();
        String reverseNumStr = new StringBuilder(numStr).reverse().toString();
        if (reverseNumStr.length() < 2
                || numStr.equals(reverseNumStr)
                || reverseNumStr.startsWith("0")) {
            return false;
        }
        return isPrime(new BigInteger(reverseNumStr));
    }

    private static boolean isPrime(BigInteger num) {
        return num.isProbablePrime(100);
    }

    @Test
    public void backWardsPrime13() {
        assertEquals("13 17 31 37 71 73 79 97", backwardsPrime(1, 100));
    }

    @Test
    public void backWardsPrime21() {
        assertEquals("9923 9931 9941 9967", backwardsPrime(9900, 10000));
    }

}
