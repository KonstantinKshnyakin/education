package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastDigitOfLargeNumber {

    public static final List<List<Integer>> MOD = List.of(
            List.of(),
            List.of(),
            List.of(6, 2, 4, 8),
            List.of(1, 3, 9, 7),
            List.of(6, 4, 6, 4),
            List.of(),
            List.of(),
            List.of(1, 7, 9, 3),
            List.of(6, 8, 4, 2),
            List.of(1, 9, 1, 9)
    );

    public static int lastDigit(BigInteger n1, BigInteger n2) {
        BigInteger bigInteger = n1.modPow(n2, BigInteger.valueOf(10));
        System.out.println(bigInteger);
        if (BigInteger.ZERO.equals(n2)) {
            return 1;
        }
        BigInteger v1 = n1.mod(BigInteger.valueOf(10));
        if (List.of(0, 1, 5, 6).contains(v1.intValue())) {
            return v1.intValue();
        }
        BigInteger V2 = n2.mod(BigInteger.valueOf(4));
        return MOD.get(v1.intValue()).get(V2.intValue());
    }

    @Test
    public void testSomething() {
        assertEquals(8, lastDigit(new BigInteger("1020768822"), new BigInteger("1032814799")));
        assertEquals(8, lastDigit(new BigInteger("1020768822"), new BigInteger("1032814799")));
        assertEquals(4, lastDigit(new BigInteger("1020768822"), new BigInteger("1032814798")));
        assertEquals(6, lastDigit(new BigInteger("1294868056"), new BigInteger("1364035540")));
        assertEquals(4, lastDigit(new BigInteger("1468023652"), new BigInteger("1074721354")));
        assertEquals(0, lastDigit(new BigInteger("10"), new BigInteger("10000000000")));
        assertEquals(9, lastDigit(new BigInteger("19"), new BigInteger("15")));
        assertEquals(8, lastDigit(new BigInteger("2"), new BigInteger("7")));
        assertEquals(4, lastDigit(new BigInteger("4"), new BigInteger("1")));
        assertEquals(6, lastDigit(new BigInteger("4"), new BigInteger("2")));
        assertEquals(9, lastDigit(new BigInteger("9"), new BigInteger("7")));
        assertEquals(1, lastDigit(new BigInteger("9"), new BigInteger("0")));
        assertEquals(0, lastDigit(new BigInteger("0"), new BigInteger("85341")));
        assertEquals(1, lastDigit(new BigInteger("1"), new BigInteger("5")));
        assertEquals(5, lastDigit(new BigInteger("5"), new BigInteger("728")));
        assertEquals(6, lastDigit(new BigInteger("6"), new BigInteger("123")));
    }

}
