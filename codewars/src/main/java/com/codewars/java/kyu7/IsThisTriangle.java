package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Implement a function that accepts 3 integer values a, b, c.
 * The function should return true if a triangle can be built
 * with the sides of given length and false in any other case.
 *
 * (In this case, all triangles must have surface greater than 0 to be accepted).
 */
public class IsThisTriangle {

    public static boolean isTriangle(int a, int b, int c){
        if (a == 0 || b == 0 || c == 0) {
            return false;
        }
        return a < b + c && b < a + c && c < a + b;
    }

    @Test
    public void publicTests() {
        assertTrue(isTriangle(1, 2, 2));
        assertFalse(isTriangle(7, 2, 2));
    }
}
