package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Implement a function which convert the given boolean value into its string representation.
 *
 * Note: Only valid inputs will be given.
 */
public class ConvertBooleanToString {

    public static String convert(boolean b) {
        return b ? "true" : "false";
    }

    @Test
    public void testTrue(){
        assertEquals("true", convert(true));
    }

    @Test
    public void testFalse(){
        assertEquals("false", convert(false));
    }

}
