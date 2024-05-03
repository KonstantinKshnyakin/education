package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Assume "#" is like a backspace in string. This means that string "a#bc#d" actually is "bd"
 *
 * Your task is to process a string with "#" symbols.
 */
public class BackspacesInString {

    public String cleanString(String s) {
        while (s.contains("#")) {
            s = s.replaceAll("^#|[^#]#", "");
        }
        return s;
    }

    @Test
    public void testCleanString() {
        assertEquals("ac", cleanString("abc#d##c"));
        assertEquals("", cleanString("abc####d##c#"));
        assertEquals("OZd", cleanString("vI#Y##OZd"));
        assertEquals("fGh", cleanString("fGy#V#Ky##q#h"));
        assertEquals("", cleanString("dHX###"));
    }

}
