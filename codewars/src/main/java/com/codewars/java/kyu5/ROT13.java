package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * How can you tell an extrovert from an introvert at NSA?
 * Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.
 *
 * I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
 * According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.
 *
 * For this task you're only supposed to substitute characters. Not spaces, punctuation, numbers, etc.
 *
 * Test examples:
 *
 * "EBG13 rknzcyr." -> "ROT13 example."
 *
 * "This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"
 */
public class ROT13 {

    public static String rot13(String message) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((c >= 65 && c < 78) || (c >= 97 && c < 110)) {
                chars[i] = (char) (c + 13);
            } else if ((c >= 78 && c <= 90) || (c >= 110 && c <= 122)){
                chars[i] = (char) (c - 13);
            }
        }
        return new String(chars);
    }

    @Test
    void testSomething1() {
        assertEquals("uryyb", rot13("hello"), "For input: `hello`");
    }

    @Test
    void testSomething2() {
        assertEquals("UryybJbeyq", rot13("HelloWorld"), "For input: `HelloWorld`");
    }

    @Test
    void testSomething3() {
        assertEquals("Uryyb Jbeyq!", rot13("Hello World!"), "For input: `Hello World!`");
    }

    @Test
    void testSomething4() {
        assertEquals("123@#!!#@  33", rot13("123@#!!#@  33"), "For input: `123@#!!#@  33`");
    }

    @Test
    void testSomething5() {
        assertEquals("J3 ne3 va lr@e 2023$$$!äöü", rot13("W3 ar3 in ye@r 2023$$$!äöü"), "For input: `W3 ar3 in ye@r 2023$$$!äöü`");
    }

}
