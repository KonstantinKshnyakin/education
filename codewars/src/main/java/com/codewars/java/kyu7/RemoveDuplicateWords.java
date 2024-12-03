package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Your task is to remove all duplicate words from a string, leaving only single (first) words entries.
 *
 * Example:
 *
 * Input:
 * 'alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta'
 *
 * Output:
 * 'alpha beta gamma delta'
 */
public class RemoveDuplicateWords {

    public static String removeDuplicateWords(String s){
        return Arrays.stream(s.split(" "))
                .distinct()
                .collect(Collectors.joining(" "));
    }

    @Test
    public void basicTests(){
        assertEquals("alpha beta gamma delta", removeDuplicateWords("alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta"));
        assertEquals("my cat is fat", removeDuplicateWords("my cat is my cat fat"));
    }

}
