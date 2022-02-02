package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Some numbers have funny properties. For example:
 *
 * 89 --> 8¹ + 9² = 89 * 1
 * 695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
 * 46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 *
 * Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p
 *
 * we want to find a positive integer k, if it exists, such as the sum of the digits of n taken
 * to the successive powers of p is equal to k * n.
 * In other words:
 *
 * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
 *
 * If it is the case we will return k, if not return -1.
 *
 * Note: n and p will always be given as strictly positive integers.
 *
 * digPow(89, 1) should return 1 since 8¹ + 9² = 89 = 89 * 1
 * digPow(92, 1) should return -1 since there is no k such as 9¹ + 2² equals 92 * k
 * digPow(695, 2) should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
 * digPow(46288, 3) should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 */
public class PlayingWithDigits {

    public static long digPow(int n, int p) {
        String str = String.valueOf(n);
        double sum = 0;
        for (int i = 0; i < str.length(); i++, p++) {
            int d = Character.digit(str.charAt(i), 10);
            sum += Math.pow(d, p);
        }
        double result = sum / n;
        if (result % 1 == 0) {
            return (int) result;
        }
        return -1;
    }


    @Test
    public void Test1() {
        assertEquals(1, digPow(89, 1));
    }

    @Test
    public void Test2() {

        assertEquals(-1, digPow(92, 1));
    }

    @Test
    public void Test3() {
        assertEquals(51, digPow(46288, 3));
    }

}
