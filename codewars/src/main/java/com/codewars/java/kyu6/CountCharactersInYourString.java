package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The main idea count all the occurring characters in a string. If you have a string like aba,
 * then the result should be {'a': 2, 'b': 1}.
 * <p>
 * What if the string is empty? Then the result should be empty object literal, {}.
 */
public class CountCharactersInYourString {

    public static Map<Character, Integer> count(String str) {
        return str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum));
    }

    @Test
    public void testEmptyString() {
        Map<Character, Integer> d = new HashMap<>();
        assertEquals(d, count(""));
    }

    @Test
    public void testSingleCharacter() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 1);
        assertEquals(d, count("a"));
    }

    @Test
    public void testMultipleCharacters() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 3);
        d.put('b', 3);
        d.put('c', 1);
        assertEquals(d, count("aabbbac"));
    }

    @Test
    public void testAllCharactersUnique() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 1);
        d.put('b', 1);
        d.put('c', 1);
        assertEquals(d, count("abc"));
    }

    @Test
    public void testAllCharactersSame() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 5);
        assertEquals(d, count("aaaaa"));
    }

    @Test
    public void testDifferentCharacters() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 2);
        Map<Character, Integer> actual = count("aabb");
        assertEquals(expected, actual);
    }

}
