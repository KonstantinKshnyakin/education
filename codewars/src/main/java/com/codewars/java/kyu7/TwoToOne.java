package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Take 2 strings s1 and s2 including only letters from ato z. Return a new sorted string,
 * the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.
 *
 * Examples:
 * a = "xyaabbbccccdefww"
 * b = "xxxxyyyyabklmopq"
 * longest(a, b) -> "abcdefklmopqwxy"
 *
 * a = "abcdefghijklmnopqrstuvwxyz"
 * longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
 */
public class TwoToOne {

    public static String longest (String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        return IntStream.concat(s1.chars(), s2.chars())
                .distinct()
                .filter(i -> Character.isAlphabetic(i) && Character.isLowerCase(i))
                .sorted()
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    @Test
    public void test() {
        assertEquals("aehrsty", longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", longest("inmanylanguages", "theresapairoffunctions"));
    }
}
