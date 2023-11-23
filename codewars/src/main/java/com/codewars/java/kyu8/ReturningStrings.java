package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Make a function that will return a greeting statement that uses an input;
 * your program should return, "Hello, <name> how are you doing today?".
 *
 * [Make sure you type the exact thing I wrote or the program may not execute properly]
 */
public class ReturningStrings {

    public static String greet(String name) {
        return "Hello, %s how are you doing today?".formatted(name);
    }

    @Test
    public void testSomething() {
        assertEquals("Hello, Ryan how are you doing today?",greet("Ryan"));
    }

}
