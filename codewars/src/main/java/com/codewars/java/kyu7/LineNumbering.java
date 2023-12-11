package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * Your team is writing a fancy new text editor and you've been tasked with implementing the line numbering.
 *
 * Write a function which takes a list of strings and returns each line prepended by the correct number.
 *
 * The numbering starts at 1. The format is n: string. Notice the colon and space in between.
 *
 * Examples: (Input --> Output)
 *
 * [] --> []
 * ["a", "b", "c"] --> ["1: a", "2: b", "3: c"]
 */
public class LineNumbering {

    public static List<String> number(List<String> lines) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            result.add("%s: %s".formatted(i + 1, lines.get(i)));
        }
        return result;
    }

    @Test
    public void basicTests() {
        assertIterableEquals(Arrays.asList(), number(Arrays.asList()));
        assertIterableEquals(Arrays.asList("1: a", "2: b", "3: c"), number(Arrays.asList("a", "b", "c")));
        assertIterableEquals(Arrays.asList("1: ", "2: ", "3: ", "4: ", "5: "), number(Arrays.asList("", "", "", "", "")));
    }
}
