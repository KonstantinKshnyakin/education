package com.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
/****************************************************************************************
 *Count the number of divisors of a positive integer n.
 *
 * Random tests go up to n = 500000.
 ***************************************************************************************/
public class FindDivisor {

    public long numberOfDivisors(int n) {
        if (n == 0) {
            return 0;
        }
        boolean[] hash = new boolean[n + 1];
        Arrays.fill(hash, true);

        for (int p = 2; p * p < n; p++) {
            for (int i = p * 2; i < n; i += p) {
                hash[i] = false;
            }
        }

        int total = 1;
        for (int p = 2; p <= n; p++) {
            if (hash[p]) {
                int count = 0;
                if (n % p == 0) {
                    while (n % p == 0) {
                        n = n / p;
                        count++;
                    }
                    total = total * (count + 1);
                }
            }
        }
        return total;
    }

    @Test
    public void fourTest() {
        assertEquals(3, numberOfDivisors(4), "Sould return 3 if the parameter equals 4");
    }

    @Test
    public void fiveTest() {
        assertEquals(2, numberOfDivisors(5), "Sould return 2 if the parameter equals 5");
    }

    @Test
    public void twelveTest() {
        assertEquals(6, numberOfDivisors(12), "Sould return 6 if the parameter equals 12");
    }

    @Test
    public void thirtyTest() {
        assertEquals(8, numberOfDivisors(30), "Sould return 8 if the parameter equals 30");
    }
}
