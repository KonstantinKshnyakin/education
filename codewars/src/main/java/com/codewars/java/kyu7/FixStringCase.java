package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/****************************************************************************************
 *In this Kata, you will be given a string that may have mixed uppercase and lowercase
 * letters and your task is to convert that string to either lowercase only or uppercase
 * only based on:
 *
 * - make as few changes as possible.
 * - if the string contains equal number of uppercase and lowercase letters, convert
 * the string to lowercase.
 *
 * For example:
 *
 * solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D" to lowercase.
 * solve("CODe") = "CODE". Uppercase characters > lowecase. Change only the "e" to uppercase.
 * solve("coDE") = "code". Upper == lowercase. Change all to lowercase.
 * More examples in test cases. Good luck!
 ***************************************************************************************/
public class FixStringCase {

    public static String solve(final String str) {
        int half = str.length() / 2;
        Matcher upMatcher = Pattern.compile("([A-Z])").matcher(str);
        long upCaseCount = upMatcher.results().count();
        if (upCaseCount > half) {
            return str.toUpperCase();
        }
        return str.toLowerCase();
    }

    @Test
    public void BasicTests() {
        assertEquals("CODE", solve("CODe"));
        assertEquals("code", solve("code"));
        assertEquals("code", solve("COde"));
        assertEquals("code", solve("Code"));
        assertEquals("", solve(""));
    }

    @Test
    public void BasicTests4() {
        String str1 = "UwswHnwaYxEomh";
        assertEquals(str1.toLowerCase(), solve(str1));
        String str2 = "wQbxfYoKDwkUtUuukioIKbHooEESqJaX";
        assertEquals(str2.toLowerCase(), solve(str2));
        String str3 = "JNXmxcUuXVNfzVJFEjbFjctNlEMPLGE";
        assertEquals(str3.toUpperCase(), solve(str3));
    }
}
