package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Simple, given a string of words, return the length of the shortest word(s).
 *
 * String will never be empty and you do not need to account for different data types.
 */
public class ShortestWord {

    public static int findShort(String s) {
        if (Objects.isNull(s)) {
            throw new IllegalArgumentException("Argument must not be null");
        }
        if (s.isBlank()) {
            return 0;
        }
        return Arrays.stream(s.split("\\s"))
                .min(Comparator.comparingInt(String::length)).get().length();
    }

    @Test
    public void findShort() {
        assertEquals(3, findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, findShort("turns out random test cases are easier than writing out basic ones"));
        assertEquals(2, findShort("Let's travel abroad shall we"));
    }
}
