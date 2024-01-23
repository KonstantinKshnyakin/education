package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :
 *
 *  "(p1**n1)(p2**n2)...(pk**nk)"
 * with the p(i) in increasing order and n(i) empty if n(i) is 1.
 *
 * Example: n = 86240 should return "(2**5)(5)(7**2)(11)"
 */
public class PrimesInNumbers {

    public static String factors(long n) {
        StringBuilder sb = new StringBuilder();
        long simpleNum = 2;
        long countSN = 0;
        long limit = (long) Math.sqrt(n);
        while (n != 1) {
            boolean isMod = n % simpleNum == 0;
            if (isMod) {
                countSN++;
                n /= simpleNum;
                limit = (long) Math.sqrt(n);
            }
            if ((!isMod && countSN > 0) || n == 1) {
                if (countSN == 1) {
                    sb.append("(%s)".formatted(simpleNum));
                } else {
                    sb.append("(%s**%s)".formatted(simpleNum, countSN));
                }
            }
            if (!isMod) {
                countSN = 0;
                simpleNum = getNextSimpleNum(simpleNum);
                if (simpleNum > limit) {
                    simpleNum = n;
                }
            }
        }
        return sb.toString();
    }

    private static long getNextSimpleNum(long num) {
        boolean isSimple = false;
        long result = num;
        while (!isSimple) {
            result++;
            isSimple = true;
            for (long i = 2; i * i <= result; i++) {
                if (result % i == 0) {
                    isSimple = false;
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void testPrimeDecompOne() {
        long lst = 7775460;
        assertEquals("(2**2)(3**3)(5)(7)(11**2)(17)", factors(lst));
    }

    @Test
    public void testPrimeDecompOne2() {
        long lst = 72391115;
        assertEquals("(5)(14478223)", factors(lst));
    }

}
