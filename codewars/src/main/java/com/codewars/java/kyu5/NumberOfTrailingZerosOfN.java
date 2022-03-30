package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfTrailingZerosOfN {

    public static int zeros(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    @Test
    public void testZeros() {
        assertEquals(7, zeros(30));
        assertEquals(4, zeros(20));
        assertEquals(2, zeros(14));
        assertEquals(0, zeros(0));
        assertEquals(1, zeros(6));
    }
}
