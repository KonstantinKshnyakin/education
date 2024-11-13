package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given a string, capitalize the letters that occupy even indexes and odd indexes separately,
 * and return as shown below. Index 0 will be considered even.
 *
 * For example, capitalize("abcdef") = ['AbCdEf', 'aBcDeF']. See test cases for more examples.
 *
 * The input will be a lowercase string with no spaces.
 */
public class AlternateCapitalization {

    public static String[] capitalize(String s){
        String result1 = "";
        String result2 = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                result1 += Character.toUpperCase(c);
                result2 += Character.toLowerCase(c);
            } else {
                result1 += Character.toLowerCase(c);
                result2 += Character.toUpperCase(c);

            }
        }
        return new String[]{result1, result2};
    }

    @Test
    public void basicTests(){
        assertArrayEquals(new String[]{"AbCdEf", "aBcDeF"}, capitalize("abcdef"));
        assertArrayEquals(new String[]{"CoDeWaRs", "cOdEwArS"}, capitalize("codewars"));
        assertArrayEquals(new String[]{"AbRaCaDaBrA", "aBrAcAdAbRa"}, capitalize("abracadabra"));
        assertArrayEquals(new String[]{"CoDeWaRrIoRs", "cOdEwArRiOrS"}, capitalize("codewarriors"));
    }

}
