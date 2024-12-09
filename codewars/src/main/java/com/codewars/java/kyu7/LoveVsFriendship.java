package com.codewars.java.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * If　a = 1, b = 2, c = 3 ... z = 26
 *
 * Then l + o + v + e = 54
 *
 * and f + r + i + e + n + d + s + h + i + p = 108
 *
 * So friendship is twice as strong as love :-)
 *
 * Your task is to write a function which calculates the value of a word based off the sum of the alphabet
 * positions of its characters.
 *
 * The input will always be made of only lowercase letters and will never be empty.
 */
public class LoveVsFriendship {

    public static int wordsToMarks (String text) {
        return text.toLowerCase()
                .chars()
                .map(i -> i - 96)
                .sum();
    }

    @Test
    @DisplayName("Test predefined words")
    void testSomething() {
        assertEquals(100, wordsToMarks("attitude"), "Input: 'attitude'");
        assertEquals(75, wordsToMarks("friends"), "Input: 'friends'");
        assertEquals(66, wordsToMarks("family"), "Input: 'family'");
        assertEquals(99, wordsToMarks("selfness"), "Input: 'selfness'");
        assertEquals(96, wordsToMarks("knowledge"), "Input: 'knowledge'");
        assertEquals(225, wordsToMarks("incomprehensibility"), "Input: 'incomprehensibility'");
    }

}
