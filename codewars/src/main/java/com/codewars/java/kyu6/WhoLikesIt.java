package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You probably know the "like" system from Facebook and other pages. People can "like" blog posts,
 * pictures or other items. We want to create the text that should be displayed next to such an item.
 *
 * Implement the function which takes an array containing the names of people that like an item.
 * It must return the display text as shown in the examples:
 *
 * []                                -->  "no one likes this"
 * ["Peter"]                         -->  "Peter likes this"
 * ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
 * ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
 * ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
 * Note: For 4 or more names, the number in "and 2 others" simply increases.
 */
public class WhoLikesIt {

    public static final String S_LIKES_THIS = "%s likes this";
    public static final String S_LIKE_THIS = "%s like this";
    public static final String S_AND_S = "%s and %s";
    public static final String S_S_AND_S = "%s, %s and %s";

    public static String whoLikesIt(String... names) {
        if (names == null) {
            throw new IllegalArgumentException();
        }
        int length = names.length;
        return switch (length) {
            case 0 -> S_LIKES_THIS.formatted("no one");
            case 1 -> S_LIKES_THIS.formatted(names[0]);
            case 2 -> S_LIKE_THIS.formatted(S_AND_S.formatted(names[0], names[1]));
            case 3 -> S_LIKE_THIS.formatted(S_S_AND_S.formatted(names[0], names[1], names[2]));
            default -> S_LIKE_THIS.formatted(S_S_AND_S.formatted(names[0], names[1], length - 2 + " others"));
        };
    }

    @Test
    public void staticTests() {
        assertEquals("no one likes this", whoLikesIt());
        assertEquals("Peter likes this", whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

}
