package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Complete the method so that it formats the words into a single comma separated value. The last word should be
 * separated by the word 'and' instead of a comma. The method takes in an array of strings and returns a single
 * formatted string.
 *
 * Note:
 *
 * Empty string values should be ignored.
 * Empty arrays or null/nil/None values being passed into the method should result in an empty string being returned.
 * Example: (Input --> output)
 *
 * ['ninja', 'samurai', 'ronin'] --> "ninja, samurai and ronin"
 * ['ninja', '', 'ronin'] --> "ninja and ronin"
 * [] -->""
 */
public class FormatWordsIntoSentence {


    public static String formatWords(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        boolean isFirst = true;
        boolean isResultNoEmpty = false;
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (isResultNoEmpty || !result.isEmpty()) {
                isResultNoEmpty = true;
            }
            if (!word.isEmpty()) {
                if (isResultNoEmpty) {
                    if (isFirst) {
                        result.insert(0, " and ");
                        isFirst = false;
                    } else {
                        result.insert(0, ", ");
                    }
                }
                result.insert(0, word);
            }
        }
        return result.toString();
    }

    public static String formatWords2(String[] words) {
        return words == null ? "" : Arrays.stream(words)
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.joining(", "))
                .replaceFirst("(.+), (.+)$", "$1 and $2");
    }

    @Test
    public void sampleTests() {
        assertEquals("one, two, three and four", formatWords(new String[]{"one", "two", "three", "four"}));
        assertEquals("one", formatWords(new String[]{"one"}));
        assertEquals("one and three", formatWords(new String[]{"one", "", "three"}));
        assertEquals("three", formatWords(new String[]{"", "", "three"}));
        assertEquals("one and two", formatWords(new String[]{"one", "two", ""}));
        assertEquals("", formatWords(new String[]{}));
        assertEquals("", formatWords(null));
        assertEquals("", formatWords(new String[]{""}));
    }
}
