package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Complete the method that takes a boolean value and return a "Yes" string for true, or a "No" string for false.
 */
public class ConvertBooleanValuesToStringsYesOrNo {

    public static String boolToWord(boolean b) {
        return b ? "Yes" : "No";
    }

    @Test
    public void testBoolToWord() {
        assertEquals(boolToWord(true), "Yes");
        assertEquals(boolToWord(false), "No");
    }

}
