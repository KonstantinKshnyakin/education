package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Define a function that takes an integer argument and returns a logical value true or false depending on if the integer is a prime.
 * <p>
 * Per Wikipedia, a prime number ( or a prime ) is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * <p>
 * Requirements
 * You can assume you will be given an integer input.
 * You can not assume that the integer will be only positive. You may be given negative numbers as well ( or 0 ).
 * NOTE on performance: There are no fancy optimizations required, but still the most trivial solutions might time out.
 * Numbers go up to 2^31 ( or similar, depending on language ). Looping all the way up to n, or n/2, will be too slow.
 * Example
 * is_prime(1)  false
 * is_prime(2)  true
 * is_prime(-1) false
 */
public class IsANumberPrime {

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (List.of(2, 3, 5, 7).contains(num)) {
            return true;
        }
        if (num % 2 == 0
                || num % 3 == 0
                || num % 5 == 0
                || num % 7 == 0) {
            return false;
        }
        double sqrt = Math.sqrt(num);
        for (int i = 11; i <= sqrt; i++) {
            if (i % 2 == 0
                    || i % 3 == 0
                    || i % 5 == 0
                    || i % 7 == 0) {
                continue;
            }
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testBasic() {
        assertFalse(isPrime(0));
        assertFalse(isPrime(1));
        assertTrue(isPrime(2));
        assertTrue(isPrime(73));
        assertFalse(isPrime(75));
        assertFalse(isPrime(-1));
        assertFalse(isPrime(48762289));
    }

    @Test
    public void testPrime() {
        assertTrue(isPrime(3));
        assertTrue(isPrime(5));
        assertTrue(isPrime(7));
        assertTrue(isPrime(41));
        assertTrue(isPrime(5099));
    }

    @Test
    public void testNotPrime() {
        assertFalse(isPrime(4));
        assertFalse(isPrime(6));
        assertFalse(isPrime(8));
        assertFalse(isPrime(9));
        assertFalse(isPrime(45));
        assertFalse(isPrime(-5));
        assertFalse(isPrime(-8));
        assertFalse(isPrime(-41));
    }
}
