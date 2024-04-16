package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create a function taking a positive integer between 1 and 3999 (both included) as its parameter and returning
 * a string containing the Roman Numeral representation of that integer.
 *
 * Modern Roman numerals are written by expressing each digit separately starting with the left most digit
 * and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC;
 * resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
 */
public class RomanNumeralsEncoder {

    private static final List<String> LIST = List.of("I", "V", "X", "L", "C", "D", "M", "", "");

    public String solution(int n) {
        if (n < 1 || (n > 3999)) {
            throw new IllegalArgumentException(n + " is not in range [1,3999]");
        }
        StringBuilder result = new StringBuilder();
        int i = 1;
        while (n > 0) {
            String rNum = getRoman(n % 10, LIST.get(i - 1), LIST.get(i), LIST.get(i + 1));
            result.insert(0, rNum);
            n /= 10;
            i += 2;
        }
        return result.toString();
    }

    private static String getRoman(int value, String min, String middle, String max) {
        String result = "";
        if (value >= 1) {
            if (value <= 3) {
                result = min.repeat(value);
            } else if (value == 9) {
                result = min + max;
            } else {
                int v = value - 5;
                if (v >= 0) {
                    result = middle + min.repeat(v);
                } else {
                    result = min + middle;
                }
            }
        }
        return result;
    }

    @Test
    public void shouldConvertToRoman() {
        assertEquals("I", solution(1));
        assertEquals("II", solution(2));
        assertEquals("III", solution(3));
        assertEquals("IV", solution(4));
        assertEquals("V", solution(5));
        assertEquals("VI", solution(6));
        assertEquals("VII", solution(7));
        assertEquals("VIII", solution(8));
        assertEquals("IX", solution(9));
        assertEquals("X", solution(10));
        assertEquals("XI", solution(11));
        assertEquals("XII", solution(12));
        assertEquals("XIII", solution(13));
        assertEquals("XIV", solution(14));
        assertEquals("XV", solution(15));
        assertEquals("XVI", solution(16));
        assertEquals("XVII", solution(17));
        assertEquals("XVIII", solution(18));
        assertEquals("XIX", solution(19));
        assertEquals("XXX", solution(30));
        assertEquals("L", solution(50));
        assertEquals("LXXX", solution(80));
        assertEquals("XLVIII", solution(48));
        assertEquals("LXXII", solution(72));
        assertEquals("XCIX", solution(99));
        assertEquals("CCLXVI", solution(266));
        assertEquals("CDXCIX", solution(499));
        assertEquals("DCCXXI", solution(721));
        assertEquals("CMXCIX", solution(999));
        assertEquals("DCC", solution(700));
        assertEquals("CM", solution(900));
        assertEquals("MMMCMXCIX", solution(3999));
    }

}
