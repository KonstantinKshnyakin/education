package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * If you can't sleep, just count sheep!!
 * <p>
 * Task:
 * Given a non-negative integer, 3 for example, return a string with a murmur: "1 sheep...2 sheep...3 sheep...".
 * Input will always be valid, i.e. no negative integers.
 */
public class IfYouCantSleepJustCountSheep {

    public static String countingSheep(int num) {
        return IntStream.rangeClosed(1, num + 1)
                .mapToObj(i -> i + " sheep...")
                .collect(Collectors.joining());
    }

    @Test
    public void testSomething() {
        assertEquals("", countingSheep(0));
        assertEquals("1 sheep...", countingSheep(1));
        assertEquals("1 sheep...2 sheep...", countingSheep(2));
        assertEquals("1 sheep...2 sheep...3 sheep...", countingSheep(3));
    }
}
