package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Four Seven
 * Simple kata, simple rules: your function should accept the inputs 4 and 7.
 * If 4 is entered, the function should return 7. If 7 is entered, the function should return 4.
 * Anything else entered as input should return 0. There's only one catch, your function cannot include if statements,
 * switch statements, or the ternary operator.
 *
 * There are some very simple ways of answering this problem, but I encourage you to try and be as creative as possible.
 *
 * Good Luck!
 */
public class FourSeven {

    public static int fourSeven(int n){
        return Map.of(7, 4, 4, 7).getOrDefault(n , 0);
    }

    @Test
    public void exampleTests() {
        assertEquals(fourSeven(7), 4);
        assertEquals(fourSeven(4), 7);
    }
}
