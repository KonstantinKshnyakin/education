package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Your task is to sort a given string. Each word in the string will contain a single number.
 * This number is the position the word should have in the result.
 *
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 *
 * If the input string is empty, return an empty string. The words in the input String will only contain
 * valid consecutive numbers.
 *
 * Examples
 * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
 * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
 * ""  -->  ""
 */
public class YourOrderPlease {

    public static String order(String words) {
        if (Objects.isNull(words)) {
            throw new IllegalArgumentException("String argument must not be null");
        }
        return Stream.of(words.split("\\s"))
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.replaceAll("\\D", ""))))
                .collect(Collectors.joining(" "));
    }

    @Test
    public void test1() {
        assertEquals("Thi1s is2 3a T4est", order("is2 Thi1s T4est 3a"));
    }

    @Test
    public void test2() {
        assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", order("4of Fo1r pe6ople g3ood th5e the2"));
    }

    @Test
    public void test3() {
        assertEquals("", order(""));
    }
}
