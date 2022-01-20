package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/****************************************************************************************
 *Complete the function that accepts a string parameter, and reverses each word in
 * the string. All spaces in the string should be retained.
 ***************************************************************************************/
public class ReverseWords {

    public static String reverseWords(final String original) {
        if (original.isBlank()) {
            return original;
        }
        return Stream.of(original.split(" "))
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));
    }

    @Test
    public void exampleCases() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", reverseWords("apple"));
        assertEquals("a b c d", reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", reverseWords("double  spaced  words"));
    }
}
