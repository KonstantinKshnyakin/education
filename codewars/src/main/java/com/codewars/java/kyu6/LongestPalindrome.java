package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Longest Palindrome
 * Find the length of the longest substring in the given string s that is the same in reverse.
 *
 * As an example, if the input was “I like racecars that go fast”, the substring (racecar) length would be 7.
 *
 * If the length of the input string is 0, the return value must be 0.
 *
 * Example:
 * "a" -> 1
 * "aab" -> 2
 * "abcde" -> 1
 * "zzbaabcd" -> 4
 * "" -> 0
 */
public class LongestPalindrome {

    public static int longestPalindrome(final String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                int length = j - i + 1;
                if (length > result) {
                    if (isPalindrome(s, i, j)) {
                        result = Math.max(result, length);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void basicTests() {
        doTest("a", 1);
        doTest("aa", 2);
        doTest("baa", 2);
        doTest("aab", 2);
        doTest("zyabyz", 1);
        doTest("baabcd", 4);
        doTest("baablkj12345432133d", 9);
    }

    private void doTest(final String s, int expected) {
        assertEquals(expected, longestPalindrome(s));
    }

}
