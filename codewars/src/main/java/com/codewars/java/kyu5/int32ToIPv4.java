package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Take the following IPv4 address: 128.32.10.1
 *
 * This address has 4 octets where each octet is a single byte (or 8 bits).
 *
 * 1st octet 128 has the binary representation: 10000000
 * 2nd octet 32 has the binary representation: 00100000
 * 3rd octet 10 has the binary representation: 00001010
 * 4th octet 1 has the binary representation: 00000001
 * So 128.32.10.1 == 10000000.00100000.00001010.00000001
 *
 * Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361
 *
 * Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.
 */
public class int32ToIPv4 {

    public static String longToIP(long ip) {
        String bs = "%32s".formatted(Long.toBinaryString(ip)).replaceAll(" ", "0");
        StringJoiner result = new StringJoiner(".");
        for (int i = 0; i < bs.length(); i+=8) {
            String s = bs.substring(i, i + 8);
            result.add(Integer.valueOf(s, 2).toString());
        }
        return result.toString();
    }

    @Test
    public void sampleTest() {
        assertEquals("128.32.10.1", longToIP(2149583361L));
        assertEquals("0.0.0.0", longToIP(0));
        assertEquals("128.114.17.104", longToIP(2154959208L));
        assertEquals("128.32.10.1", longToIP(2149583361L));
    }

}
