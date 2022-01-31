package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Move the first letter of each word to the end of it, then add "ay" to the end of the word.
 * Leave punctuation marks untouched.
 */
public class SimplePigLatin {

    public static String pigIt(String str) {
        for (String s : str.split(" ")) {
            char c = s.charAt(0);
            String s2 = s.substring(1) + c + "ay";
            System.out.println(s2);
        }
        return Stream.of(str.split(" "))
                .map(s -> {
                    if (s.matches("\\w+")) {
                        return s.substring(1) + s.charAt(0) + "ay";
                    }
                    return s;
                })
                .collect(Collectors.joining(" "));
    }

    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", pigIt("This is my string"));
    }
}
