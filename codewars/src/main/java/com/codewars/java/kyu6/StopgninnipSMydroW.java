package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function that takes in a string of one or more words, and returns the same string,
 * but with all five or more letter words reversed (Just like the name of this Kata).
 * Strings passed in will consist of only letters and spaces.
 * Spaces will be included only when more than one word is present.
 *
 * Examples:
 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
 * spinWords( "This is a test") => returns "This is a test"
 * spinWords( "This is another test" )=> returns "This is rehtona test"
 */
public class StopgninnipSMydroW {

    public static String spinWords(String sentence) {
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() >= 5) {
                char[] chars = strings[i].toCharArray();
                for (int j = 0; j < chars.length / 2; j++) {
                    char save = chars[j];
                    chars[j] = chars[chars.length - 1 - j];
                    chars[chars.length - 1 - j] = save;
                }
                strings[i] = new String(chars);
            }
        }
        return String.join(" ", strings);
    }

    @Test
    public void test() {
        assertEquals("emocleW", spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", spinWords("Hey fellow warriors"));
    }
}
