package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this kata you will create a function that takes a list of non-negative integers
 * and strings and returns a new list with the strings filtered out.
 *
 * Example
 * Kata.filterList(Arrays.asList(1, 2, "a", "b")) => Arrays.asList(1,2)
 * Kata.filterList(Arrays.asList(1, 2, "a", "b", 0, 15)) => Arrays.asList(1,2,0,15)
 * Kata.filterList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 231)) => Arrays.asList(1, 2, 231)
 */
public class ListFiltering {

    public static List<Integer> filterList(final List<?> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Object o : list) {
            if (o instanceof Integer) {
                result.add((Integer) o);
            }
        }
        return result;
    }

    @Test
    public void examples() {
        assertEquals(Arrays.asList(1,2), filterList(Arrays.asList(1,2,"a","b")));
        assertEquals(Arrays.asList(1,0,15), filterList(Arrays.asList(1,"a","b",0,15)));
        assertEquals(Arrays.asList(1,2,123), filterList(Arrays.asList(1,2,"aasf","1","123",123)));
    }
}
