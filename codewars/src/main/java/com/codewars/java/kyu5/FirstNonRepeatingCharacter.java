package com.codewars.java.kyu5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Write a function named first_non_repeating_letter† that takes a string input, and returns the first character
 * that is not repeated anywhere in the string.
 *
 * For example, if given the input 'stress', the function should return 't', since the letter t only occurs once
 * in the string, and occurs first in the string.
 *
 * As an added challenge, upper- and lowercase letters are considered the same character, but the function should
 * return the correct case for the initial letter. For example, the input 'sTreSS' should return 'T'.
 *
 * If a string contains all repeating characters, it should return an empty string ("");
 *
 * † Note: the function is called firstNonRepeatingLetter for historical reasons, but your function should handle
 * any Unicode character.
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstNonRepeatingCharacter {

    public static String firstNonRepeatingLetter(String s){
        char[] isRepeat = s.toCharArray();
        for (int i = 0; i < isRepeat.length; i++) {
            boolean flag = true;
            char c1 = isRepeat[i];
            for (int j = 0; j < isRepeat.length; j++) {
                char c2 = isRepeat[j];
                if (i != j && Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                    flag = false;
                }
            }
            if (flag) {
                return String.valueOf(c1);
            }
        }
        return "";
    }

    @Test
    @DisplayName("Sample tests")
    void sampleTests() {
        assertEquals("a", firstNonRepeatingLetter("a"), "For input \"a\"");
        assertEquals("t", firstNonRepeatingLetter("streSS"), "For input \"streSS\"");
        assertEquals("-", firstNonRepeatingLetter("moon-men"), "For input \"moon-men\"");
        assertEquals("", firstNonRepeatingLetter("moonmoon"), "For input \"moonmoon\"");
        assertEquals("D", firstNonRepeatingLetter("DstreSS"), "For input \"streSS\"");
    }

}
