package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Usually when you buy something, you're asked whether your credit card number, phone number or answer
 * to your most secret question is still correct. However, since someone could look over your shoulder,
 * you don't want that shown on your screen. Instead, we mask it.
 *
 * Your task is to write a function maskify, which changes all but the last four characters into '#'.
 *
 * Examples
 * Maskify.Maskify("4556364607935616"); // should return "############5616"
 * Maskify.Maskify("64607935616");      // should return "#######5616"
 * Maskify.Maskify("1");                // should return "1"
 * Maskify.Maskify("");                 // should return ""
 *
 * // "What was the name of your first pet?"
 * Maskify.Maskify("Skippy");                                   // should return "##ippy"
 * Maskify.Maskify("Nananananananananananananananana Batman!"); // should return "####################################man!"
 */
public class CreditCardMask {

    public static String maskify(String str) {
        if (Objects.isNull(str)) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        if (length <= 4) {
            return str;
        }
        for (int i = 0; i < length - 4; i++) {
            chars[i] = '#';
        }
        return new String(chars);
    }

    @Test
    public void testSolution() {
        assertEquals("############5616", maskify("4556364607935616"));
        assertEquals("#######5616",      maskify(     "64607935616"));
        assertEquals("1",                maskify(               "1"));
        assertEquals("",                 maskify(                ""));

        // "What was the name of your first pet?"
        assertEquals("##ippy",                                    maskify("Skippy")                                  );
        assertEquals("####################################man!",  maskify("Nananananananananananananananana Batman!"));
    }
}
