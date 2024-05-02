package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a lowercase string that has alphabetic characters only and no spaces, return the highest value of
 * consonant substrings. Consonants are any letters of the alphabet except "aeiou".
 *
 * We shall assign the following values: a = 1, b = 2, c = 3, .... z = 26.
 */
public class ConsonantValue {

    public static int solve(final String s) {
        int max = 0;
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (!List.of('a', 'e', 'i', 'o', 'u').contains(c)) {
                sum += c - 'a' + 1;
            } else {
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        return max;
    }

    @Test
    public void basicTests() {
        assertEquals(26, solve("zodiac"));
        assertEquals(80, solve("chruschtschov"));
        assertEquals(38, solve("khrushchev"));
        assertEquals(57, solve("strength"));
        assertEquals(73, solve("catchphrase"));
        assertEquals(103, solve("twelfthstreet"));
        assertEquals(80, solve("mischtschenkoana"));
    }

}
