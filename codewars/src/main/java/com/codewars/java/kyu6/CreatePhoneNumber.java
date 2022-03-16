package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function that accepts an array of 10 integers (between 0 and 9),
 * that returns a string of those numbers in the form of a phone number.
 * <p>
 * Example
 * Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
 * The returned format must be correct in order to complete this challenge.
 * Don't forget the space after the closing parentheses!
 */
public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array numbers must not be null");
        }
        if (numbers.length != 10) {
            throw new IllegalArgumentException("Array length must be = 10");
        }
        long notCorrectCount = IntStream.of(numbers).filter(i -> i < 0 || i > 9).count();
        if (notCorrectCount != 0) {
            throw new IllegalArgumentException("Array numbers must be n >= 0 || n <= 9");
        }
        return IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining())
                .replaceAll("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
    }

    @Test
    public void tests() {
//        finaly
        assertEquals("(123) 456-7890", createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
