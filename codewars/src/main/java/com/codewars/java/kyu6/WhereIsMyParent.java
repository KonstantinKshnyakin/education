package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Mothers arranged a dance party for the children in school. At that party, there are only mothers and their children.
 * All are having great fun on the dance floor when suddenly all the lights went out. It's a dark night and no one can
 * see each other. But you were flying nearby and you can see in the dark and have ability to teleport people anywhere
 * you want.
 * <p>
 * Legend:
 * -Uppercase letters stands for mothers, lowercase stand for their children, i.e. "A" mother's children are "aaaa".
 * -Function input: String contains only letters, uppercase letters are unique.
 * Task:
 * Place all people in alphabetical order where Mothers are followed by their children, i.e. "aAbaBb" => "AaaBbb".
 */
public class WhereIsMyParent {

    static String findChildren(final String text) {
        if (text == null || text.isBlank()) {
            return text;
        }
        char[] chars = text.toLowerCase().toCharArray();
        Arrays.sort(chars);
        char previous = chars[0];
        chars[0] = Character.toUpperCase(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if (previous != current) {
                previous = current;
                chars[i] = Character.toUpperCase(current);
            }
        }
        return new String(chars);
    }

    private static void test(final String expected, final String input) {
        assertEquals(expected, WhereIsMyParent.findChildren(input), "For input \"" + input + '"');
    }

    @Test
    public void basicTests() {
        test("AaBb", "abBA");
        test("AaaaaaZzzz", "AaaaaZazzz");
        test("AaBbbCcc", "CbcBcbaA");
        test("FfUuuuXx", "xXfuUuuF");
        test("", "");
    }

}
