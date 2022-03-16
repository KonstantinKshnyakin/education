package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters
 * can be rearranged to match str2, otherwise returns false.
 *
 * Notes:
 *
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered.
 * Examples
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 */
public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        char[] chars1 = str1.replaceAll("[^a-z]", "").toCharArray();
        char[] chars2 = str2.replaceAll("[^a-z]", "").toCharArray();
        int countMatch = 0;
        for (char c2 : chars2) {
            for (int j = 0; j < chars1.length; j++) {
                char c1 = chars1[j];
                if (c1 == c2) {
                    countMatch++;
                    chars1[j] = '~';
                    break;
                }
            }
        }
        return str2.length() == countMatch;
    }

    @Test
    public void test() {
        assertTrue(scramble("rkqodlw", "world"));
        assertTrue(scramble("cedewaraaossoqqyt", "codewars"));
        assertFalse(scramble("katas", "steak"));
        assertFalse(scramble("scriptjavx", "javascript"));
        assertTrue(scramble("scriptingjava", "javascript"));
        assertTrue(scramble("scriptsjava", "javascripts"));
        assertFalse(scramble("javscripts", "javascript"));
        assertTrue(scramble("aabbcamaomsccdd", "commas"));
        assertTrue(scramble("commas", "commas"));
        assertTrue(scramble("sammoc", "commas"));
    }
}
