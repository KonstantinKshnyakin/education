package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a method that takes an array of consecutive (increasing) letters as input and
 * that returns the missing letter in the array.
 * <p>
 * You will always get an valid array. And it will be always exactly one letter be missing.
 * The length of the array will always be at least 2.
 * The array will always contain letters in only one case.
 * <p>
 * Example:
 * <p>
 * ['a','b','c','d','f'] -> 'e'
 * ['O','Q','R','S'] -> 'P'
 */
public class FindTheMissingLetter {

    public static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int n = array[i + 1] - array[i];
            if (n != 1) {
                return (char) (array[i] + 1);
            }
        }
        throw new IllegalArgumentException(Arrays.toString(array));
    }

    @Test
    public void exampleTests() {
        assertEquals('e', findMissingLetter(new char[] { 'a','b','c','d','f' }));
        assertEquals('P', findMissingLetter(new char[] { 'O','Q','R','S' }));
    }

}
