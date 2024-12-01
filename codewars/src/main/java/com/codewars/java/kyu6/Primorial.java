package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Definition (Primorial Of a Number)
 * Is similar to factorial of a number, In primorial, not all the natural numbers get multiplied, only prime
 * numbers are multiplied to calculate the primorial of a number. It's denoted with P# and it is the product
 * of the first n prime numbers.
 *
 * Task
 * Given a number N , calculate its primorial.
 *
 * Notes
 * Only positive numbers will be passed (N > 0) .
 * Input >> Output Examples:
 *
 * 1- numPrimorial (3) ==> return (30)
 * Explanation:
 * Since the passed number is (3) ,Then the primorial should obtained by multiplying 2 * 3 * 5 = 30 .
 * Mathematically written as , P3# = 30 .
 *
 * 2- numPrimorial (5) ==> return (2310)
 * Explanation:
 * Since the passed number is (5) ,Then the primorial should obtained by multiplying  2 * 3 * 5 * 7 * 11 = 2310 .
 * Mathematically written as , P5# = 2310 .
 *
 * 3- numPrimorial (6) ==> return (30030)
 * Explanation:
 * Since the passed number is (6) ,Then the primorial should obtained by multiplying  2 * 3 * 5 * 7 * 11 * 13 = 30030 .
 * Mathematically written as , P6# = 30030 .
 */
public class Primorial {

    public static String numPrimorial(int n) {
        return getPrimes(n).stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.valueOf(1), BigInteger::multiply)
                .toString();
    }

    public static List<Integer> getPrimes(int count) {
        List<Integer> primes = new ArrayList<>();
        if (count > 0) {
            primes.add(2);
        }
        for (var i = 3; primes.size() < count; i += 2) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int n, List<Integer> primes) {
        for (var i = 0; i < primes.size(); i++) {
            var prime = primes.get(i);
            if (prime * prime > n) {
                return true;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void checkSmallValues() {
        assertEquals(  "30", numPrimorial(3));
        assertEquals( "210", numPrimorial(4));
        assertEquals("2310", numPrimorial(5));
    }

    @Test
    public void checkLargerValues() {
        assertEquals(  "9699690", numPrimorial(8));
        assertEquals("223092870", numPrimorial(9));
    }

}
