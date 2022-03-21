package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is "("
 * if that character appears only once in the original string, or ")" if that character appears more than once
 * in the original string. Ignore capitalization when determining if a character is a duplicate.
 * <p>
 * Examples
 * "din"      =>  "((("
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))(("
 * Notes
 * Assertion messages may be unclear about what they display in some languages.
 * If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
 */
public class DuplicateEncoder {

    static String encode(String word) {
        if (word == null) {
            throw new IllegalArgumentException("String argument must not be null");
        }
        char[] chars = word.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            boolean is = false;
            for (int j = 0; j < chars.length; j++) {
                if (i != j) {
                    if (chars[i] == chars[j]) {
                        is = true;
                        break;
                    }
                }
            }
            if (is) {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals(")()())()(()()(", encode("Prespecialized"));
        assertEquals("(((", encode("din"));
        assertEquals("()()()", encode("recede"));
        assertEquals("))((", encode("(( @"));
        assertEquals("))))())))", encode("   ()(   "));
    }
}
