package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function that receives two strings and returns n, where n is equal to the number of characters we should
 * shift the first string forward to match the second. The check should be case sensitive.
 * <p>
 * For instance, take the strings "fatigue" and "tiguefa". In this case, the first string has been rotated 5 characters
 * forward to produce the second string, so 5 would be returned.
 * <p>
 * If the second string isn't a valid rotation of the first string, the method returns -1.
 * Examples:
 * "coffee", "eecoff" => 2
 * "eecoff", "coffee" => 4
 * "moose", "Moose" => -1
 * "isn't", "'tisn" => 2
 * "Esham", "Esham" => 0
 * "dog", "god" => -1
 */
public class CalculateStringRotation {

    public static int shiftedDiff(String first, String second) {
        if (first.equals(second)) {
            return 0;
        }
        for (int i = 1; i <= first.length(); i++) {
            String substring = first.substring(i) + first.substring(0, i);
            if (substring.equals(second)) {
                return second.length() - i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(-1, shiftedDiff("hoop", "pooh"));
        assertEquals(2, shiftedDiff("coffee", "eecoff"));
        assertEquals(4, shiftedDiff("eecoff", "coffee"));
        assertEquals(0, shiftedDiff("Esham", "Esham"));
        assertEquals(14, shiftedDiff("9+egXkh(a9+VQbd", "+egXkh(a9+VQbd9"));
    }

}
