package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Your task is to make a function that can take any non-negative integer as an argument
 * and return it with its digits in descending order. Essentially, rearrange the digits
 * to create the highest possible number.
 * <p>
 * Examples:
 * Input: 42145 Output: 54421
 * Input: 145263 Output: 654321
 * Input: 123456789 Output: 987654321
 */
public class DescendingOrder {

    public static int sortDesc(final int num) {
        String str = String.valueOf(num)
                .chars()
                .map(c -> Integer.parseInt(String.valueOf((char) c)))
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(Object::toString)
                .collect(Collectors.joining());
        return Integer.parseInt(str);
    }

    @Test
    public void test_01() {
        assertEquals(0, sortDesc(0));
    }

    @Test
    public void test_02() {
        assertEquals(51, sortDesc(15));
    }

    @Test
    public void test_03() {
        assertEquals(987654321, sortDesc(123456789));
    }
}
