package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Implement a function that receives two IPv4 addresses, and returns the number of addresses
 * between them (including the first one, excluding the last one).
 *
 * All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater
 * than the first one.
 */
public class CountIPAddresses {

    public static long ipsBetween(String start, String end) {
        String[] s1 = start.split("\\.");
        String[] s2 = end.split("\\.");
        long result = 0;
        for (int i = s1.length - 1, j = 0; i >= 0; i--, j++) {
            long sum =  Long.parseLong(s2[i]) - Long.parseLong(s1[i]);
            if (i != s1.length - 1) {
                sum = sum * (long)Math.pow(256, j);
            }
            result += sum;
        }
        return result;
    }

    @Test
    public void ipsBetween() throws Exception {
        assertEquals( 50, ipsBetween( "10.0.0.0", "10.0.0.50" ) );
        assertEquals(246, ipsBetween("20.0.0.10", "20.0.1.0"));
        assertEquals(758, ipsBetween("20.0.0.10", "20.0.3.0"));
        assertEquals(131072, ipsBetween("20.0.0.0", "20.2.0.0"));
        assertEquals(131840, ipsBetween("20.0.0.0", "20.2.3.0"));
        assertEquals(131850, ipsBetween("20.0.0.0", "20.2.3.10"));
        assertEquals( (1l << 32l) - 1l, ipsBetween( "0.0.0.0", "255.255.255.255" ) );
    }

}
