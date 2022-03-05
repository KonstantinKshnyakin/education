package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * It's pretty straightforward. Your goal is to create a function that removes the first and last characters of a string.
 * You're given one parameter, the original string.
 * You don't have to worry with strings with less than two characters.
 */
public class RemoveFirstAndLastCharacter {

    public static String remove(String str) {
        return str.replaceAll("(^.|.$)", "");
    }

    @Test
    public void testRemoval() {
        assertEquals("loquen", remove("eloquent"));
        assertEquals("ountr", remove("country"));
        assertEquals("erso", remove("person"));
        assertEquals("lac", remove("place"));
    }
}
