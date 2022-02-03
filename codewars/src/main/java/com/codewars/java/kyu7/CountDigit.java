package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Take an integer n (n >= 0) and a digit d (0 <= d <= 9) as an integer.
 * <p>
 * Square all numbers k (0 <= k <= n) between 0 and n.
 * <p>
 * Count the numbers of digits d used in the writing of all the k**2.
 * <p>
 * Call nb_dig (or nbDig or ...) the function taking n and d as parameters and returning this count.
 * <p>
 * Examples:
 * n = 10, d = 1
 * the k*k are 0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
 * We are using the digit 1 in: 1, 16, 81, 100. The total count is then 4.
 * <p>
 * nb_dig(25, 1) returns 11 since
 * the k*k that contain the digit 1 are:
 * 1, 16, 81, 100, 121, 144, 169, 196, 361, 441.
 * So there are 11 digits 1 for the squares of numbers between 0 and 25.
 * Note that 121 has twice the digit 1.
 */
public class CountDigit {

    public static int nbDig(int n, int d) {
        return IntStream.rangeClosed(0, n)
                .map(i1 -> i1 * i1)
                .map(
                        i2 -> (int) String.valueOf(i2).chars()
                                .map(i3 -> Character.digit(i3, 10))
                                .filter(i4 -> i4 == d)
                                .count()
                )
                .sum();
    }

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println();
        System.out.println("Fixed Tests nbDig");
        testing(nbDig(5750, 0), 4700);
        testing(nbDig(11011, 2), 9481);
        testing(nbDig(12224, 8), 7733);
        testing(nbDig(11549, 1), 11905);
    }
}
