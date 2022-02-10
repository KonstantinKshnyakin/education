package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VowelCount {

    public static int getCount(String str) {
        Set<Character> consonants = Set.of('a', 'e', 'i', 'o', 'u');
        return (int) str.chars()
                .mapToObj(i -> (char) i)
                .filter(consonants::contains)
                .count();
    }

    @Test
    public void testCase1() {
        assertEquals(5, getCount("abracadabra"));
    }

}
