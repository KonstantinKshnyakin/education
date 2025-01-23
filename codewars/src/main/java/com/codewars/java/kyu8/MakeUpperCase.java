package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function which converts the input string to uppercase.
 */
public class MakeUpperCase {

    public static String makeUpperCase(String str) {
        StringBuilder result = new StringBuilder();
        str.chars()
                .map(Character::toUpperCase)
                .forEach(result::append);
        return str.toUpperCase();
    }

    @Test
    public void testSomething() {
        assertEquals("HELLO", makeUpperCase("hello"));
    }

}
