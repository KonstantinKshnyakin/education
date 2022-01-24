package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string of words, you need to find the highest scoring word.
 * <p>
 * Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
 * <p>
 * You need to return the highest scoring word as a string.
 * <p>
 * If two words score the same, return the word that appears earliest in the original string.
 * <p>
 * All letters will be lowercase and all inputs will be valid.
 */
public class HighestScoringWord {

    public static String high(String s) {
        String s2 = s.toLowerCase();
        Map<Integer, String> collect = Arrays.stream(s2.split(" "))
                .collect(HashMap::new,
                        (map, str) -> map.putIfAbsent(
                                str.chars()
                                .filter(c -> c >= 'a' && c <= 'z')
                                .map(c -> c + 1 - 'a')
                                .sum(),
                                str
                        ),
                        HashMap::putAll
                );
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).orElse("");
    }

    @Test
    public void sampleTests() {
        assertEquals("taxi", high("man i need a taxi up to ubud"));
        assertEquals("volcano", high("what time are we climbing up to the volcano"));
        assertEquals("semynak", high("take me to semynak"));
    }

    @Test
    public void edgeCaseTests() {
        assertEquals("aa", high("aa b"));
        assertEquals("b", high("b aa"));
        assertEquals("bb", high("bb d"));
        assertEquals("d", high("d bb"));
        assertEquals("aaa", high("aaa b"));
    }
}
