package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Remove the parentheses
 * In this kata you are given a string for example:
 * <p>
 * "example(unwanted thing)example"
 * Your task is to remove everything inside the parentheses as well as the parentheses themselves.
 * <p>
 * The example above would return:
 * <p>
 * "exampleexample"
 * Notes
 * Other than parentheses only letters and spaces can occur in the string. Don't worry about other brackets
 * like "[]" and "{}" as these will never appear.
 * There can be multiple parentheses.
 * The parentheses can be nested.
 */
public class RemoveTheParentheses {

    public static String removeParentheses(final String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')' && count > 0) {
                count--;
            } else if (count == 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public void basicTests() {
        for (String[] trial : new String[][]{
                {"example(unwanted thing)example", "exampleexample"},
                {"example(unwanted thing)example", "exampleexample"},
                {"example (unwanted thing) example", "example  example"},
                {"a (bc d)e", "a e"},
                {"a(b(c))", "a"},
                {"hello example (words(more words) here) something", "hello example  something"},
                {"(first group) (second group) (third group)", "  "}}) {
            assertEquals(trial[1], removeParentheses(trial[0]));
        }
    }

}
