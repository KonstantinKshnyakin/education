package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create a function that accepts a string as an argument and validates whether the vowels (a, e, i, o, u)
 * and consonants are in alternate order.
 * <p>
 * Examples
 * "amazon" --> true
 * "apple" --> false
 * "banana" --> true
 */
public class AreWeAlternate {

    public static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static boolean isAlt(String word) {
        boolean nextMustBeVowel = !VOWELS.contains(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isVowel = VOWELS.contains(c);
            if (isVowel != nextMustBeVowel) {
                return false;
            }
            nextMustBeVowel = !nextMustBeVowel;
        }
        return true;
    }

    @Test
    public void exampleTests() {
        assertEquals(false, isAlt("iboqaieo"));
        assertEquals(true, isAlt("amazon"));
        assertEquals(true, isAlt("banana"));
        assertEquals(false, isAlt("apple"));
    }

}