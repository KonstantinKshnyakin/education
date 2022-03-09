package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are going to be given a word. Your job is to return the middle character of the word. If the word's length is odd, return the middle character. If the word's length is even, return the middle 2 characters.
 * <p>
 * #Examples:
 * Kata.getMiddle("test") should return "es"
 * Kata.getMiddle("testing") should return "t"
 * Kata.getMiddle("middle") should return "dd"
 * Kata.getMiddle("A") should return "A"
 * <p>
 * #Input
 * A word (string) of length 0 < str < 1000 (In javascript you may get slightly more than 1000 in some test cases
 * due to an error in the test cases). You do not need to test for this. This is only here to tell you
 * that you do not need to worry about your solution timing out.
 * <p>
 * #Output
 * The middle character(s) of the word represented as a string.
 */
public class GetMiddleCharacter {

    public static String getMiddle(String word) {
        int length = word.length();
        int i = length / 2;
        if (length % 2 == 0) {
            return word.substring(i - 1, i + 1);
        } else {
            return word.substring(i, i + 1);
        }
    }

    @Test
    public void evenTests() {
        assertEquals("es", getMiddle("test"));
        assertEquals("dd", getMiddle("middle"));
    }

    @Test
    public void oddTests() {
        assertEquals("t", getMiddle("testing"));
        assertEquals("A", getMiddle("A"));
    }
}
