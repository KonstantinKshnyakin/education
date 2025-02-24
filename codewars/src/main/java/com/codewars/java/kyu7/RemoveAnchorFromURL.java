package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Complete the function/method so that it returns the url with anything after the anchor (#) removed.
 *
 * Examples
 * "www.codewars.com#about" --> "www.codewars.com"
 * "www.codewars.com?page=1" -->"www.codewars.com?page=1"
 */
public class RemoveAnchorFromURL {

    public static String removeUrlAnchor(String url) {
        return url.replaceAll("(.+)#.+", "$1");
    }

    private static void doTest(String url, String expected) {
        assertEquals(expected, removeUrlAnchor(url), String.format("Incorrect answer for url = \"%s\"\n\n", url));
    }

    @Test
    public void testSampleCases() {
        doTest("www.codewars.com#about", "www.codewars.com");
        doTest("www.codewars.com/katas/?page=1#about", "www.codewars.com/katas/?page=1");
        doTest("www.codewars.com/katas/", "www.codewars.com/katas/");
        doTest("https://example.com#section1", "https://example.com");
    }

}
