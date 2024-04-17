package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a method (or function, depending on the language) that converts a string to camelCase,
 * that is, all words must have their first letter capitalized and spaces must be removed.
 *
 * Examples (input --> output):
 * "hello case" --> "HelloCase"
 * "camel case word" --> "CamelCaseWord"
 */
public class CamelCaseMethod {

    public static String camelCase(String str) {
        Pattern p = Pattern.compile("\\s*(\\p{Alpha})(\\p{Alpha}*)\\s*");
        return p.matcher(str)
                .replaceAll(match -> match.group(1).toUpperCase() + match.group(2));
    }

    @Test
    public void testTwoWords() {
        assertEquals("TestCase", camelCase("test case"));
    }

    @Test
    public void testThreeWords() {
        assertEquals("CamelCaseMethod", camelCase("camel case method"));
    }

    @Test
    public void testLeadingSpace() {
        assertEquals("CamelCaseWord", camelCase(" camel case word"));
    }

    @Test
    public void testTrailingSpace() {
        assertEquals("SayHello", camelCase("say hello "));
    }

    @Test
    public void testSingleLetter() {
        assertEquals("Z", camelCase("z"));
    }

    @Test
    public void testTwoSpacesBetweenWords() {
        assertEquals("AbC", camelCase("ab  c"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", camelCase(""));
    }
}
