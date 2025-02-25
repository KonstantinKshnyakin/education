package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This Kata is intended as a small challenge for my students
 *
 * Your family runs a shop and have just brought a Scrolling Text Machine
 * (http://3.imimg.com/data3/RP/IP/MY-2369478/l-e-d-multicolour-text-board-250x250.jpg) to help get some more business.
 *
 * The scroller works by replacing the current text string with a similar text string, but with the first letter
 * shifted to the end; this simulates movement.
 *
 * Your father is far too busy with the business to worry about such details, so, naturally, he's making you come
 * up with the text strings.
 *
 * Create a function that accepts a string argument and returns an array of strings with each letter from the input
 * string being rotated to the end.
 *
 * Examples:
 * "Hello" --> ["elloH", "lloHe", "loHel", "oHell", "Hello"]
 * Note:
 * The original string should be included in the output array.
 *
 * The order matters. Each element of the output array should be the rotated version of the previous element.
 *
 * The output array SHOULD be the same length as the input string.
 *
 * The function should return an empty array with an empty string ('') as input.
 */
public class TextScrollingMachine {

    public static String[] rotate(String text) {
        String[] result = new String[text.length()];
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < text.length(); i++) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            result[i] = sb.toString();
        }
        return result;
    }

    @Test
    void testSomething() {
        String[] actual = rotate("Hello");
        assertEquals(5, actual.length);
        assertEquals("elloH", actual[0]);
        assertEquals("lloHe", actual[1]);
        assertEquals("loHel", actual[2]);
        assertEquals("oHell", actual[3]);
        assertEquals("Hello", actual[4]);
    }

}
