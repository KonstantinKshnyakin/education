package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/****************************************************************************************
 * An anagram is the result of rearranging the letters of a word to produce a new word (see wikipedia).
 *
 * Note: anagrams are case insensitive
 *
 * Complete the function to return true if the two arguments given are anagrams of each other; return false otherwise.
 ***************************************************************************************/
public class AnagramDetection {

    public static boolean isAnagram(String test, String original) {
        return test.toLowerCase().chars().sum() == original.toLowerCase().chars().sum();
    }

    @Test
    public void exampleTests() {
        assertTrue(isAnagram("foefet", "toffee"));
        assertTrue(isAnagram("Buckethead", "DeathCubeK"));
        assertTrue(isAnagram("Twoo", "Woot"));
        assertFalse(isAnagram("apple", "pale"));
    }
}
