package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringRepeat {

    public static String repeatStr(final int repeat, final String string) {
        return string.repeat(repeat);
    }

    @Test public void test4a() {
        assertEquals("aaaa", repeatStr(4, "a"));
    }
    @Test public void test3Hello() {
        assertEquals("HelloHelloHello", repeatStr(3, "Hello"));
    }
    @Test public void test5empty() {
        assertEquals("", repeatStr(5, ""));
    }
    @Test
    public void test0kata() {
        assertEquals("", repeatStr(0, "kata"));
    }
}
