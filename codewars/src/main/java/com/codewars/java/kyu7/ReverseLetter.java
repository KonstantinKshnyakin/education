package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Task:
 * Given a string str, reverse it omitting all non-alphabetic characters.
 *
 * Example:
 * For str = "krishan", the output should be "nahsirk".
 * For str = "ultr53o?n", the output should be "nortlu".
 *
 * Input/Output:
 * [input] string str
 * A string consists of lowercase latin letters, digits and symbols.
 * [output] a string
 */
public class ReverseLetter {

    public static String reverseLetter(final String str) {
        String onlyAlphabetic = str.replaceAll("[^a-z]", "");
        char[] chars = onlyAlphabetic.toCharArray();
        int length = chars.length;
        for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }

    @Test
    public void testSomething() {
        doTest("ultr53o?n", "nortlu");
        doTest("krishan", "nahsirk");
        doTest("ab23c", "cba");
        doTest("krish21an", "nahsirk");
    }

    private void doTest(final String str, final String expected) {
        assertEquals(expected, reverseLetter(str));
    }
}
