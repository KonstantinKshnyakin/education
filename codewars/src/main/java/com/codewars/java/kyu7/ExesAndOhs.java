package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check to see if a string has the same amount of 'x's and 'o's.
 * The method must return a boolean and be case insensitive.
 * The string can contain any char.
 *
 * Examples input/output:
 * XO("ooxx") => true
 * XO("xooxx") => false
 * XO("ooxXm") => true
 * XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
 * XO("zzoo") => false
 */
public class ExesAndOhs {

    public static boolean getXO(String str) {
        Map<String, Long> collect = str.toLowerCase().chars()
                .filter(i -> i == 'x' || i == 'o')
                .boxed()
                .collect(Collectors.groupingBy(Character::toString, Collectors.counting()));
        return Objects.equals(collect.get("x"), collect.get("o"));
    }

    @Test
    public void testSomething1() {
        assertEquals(true, getXO("xxxooo"));
    }

    @Test
    public void testSomething2() {
        assertTrue(getXO("xxxXooOo"));
    }

    @Test
    public void testSomething3() {
        assertFalse(getXO("xxx23424esdsfvxXXOOooo"));
    }

    @Test
    public void testSomething4() {
        assertFalse(getXO("xXxxoewrcoOoo"));
    }

    @Test
    public void testSomething5() {
        assertFalse(getXO("XxxxooO"));
    }

    @Test
    public void testSomething6() {
        assertTrue(getXO("zssddd"));
    }

    @Test
    public void testSomething7() {
        assertFalse(getXO("Xxxxertr34"));
    }
}
