package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
 * Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter,
 * he is known for almost always capitalizing every word. For simplicity, you'll have to capitalize each word,
 * check out how contractions are expected to be in the example below.
 *
 * Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from
 * Jaden Smith, but they are not capitalized in the same way he originally typed them.
 *
 * Example:
 *
 * Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 * Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 * Note that the Java version expects a return value of null for an empty string or null.
 *
 * Link to Jaden's former Twitter account @officialjaden via archive.org
 */
public class JadenCasingStrings {

    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        String[] strArr = phrase.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            char c = str.charAt(0);
            if (Character.isLowerCase(c)) {
                char[] chars = str.toCharArray();
                chars[0] = Character.toUpperCase(c);
                strArr[i] = new String(chars);
            }
        }
        return String.join(" ", strArr);
    }

    @Test
    public void test() {
        assertEquals("Most Trees Are Blue", toJadenCase("most trees are blue"));
    }

    @Test
    public void testNullArg() {
        assertNull(toJadenCase(null));
    }

    @Test
    public void testEmptyArg() {
        assertNull(toJadenCase(""));
    }
}
