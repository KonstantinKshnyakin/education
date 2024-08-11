package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * For a given string s find the character c (or C) with longest consecutive repetition and return:
 * <p>
 * Object[]{c, l};
 * where l (or L) is the length of the repetition. If there are two or more characters with the same l
 * return the first in order of appearance.
 * <p>
 * For empty string return:
 * <p>
 * Object[]{"", 0}
 * Happy coding! :)
 */
public class CharacterWithLongestConsecutiveRepetition {

    public static Object[] longestRepetition(String s) {
        if (s == null || s.isEmpty()) {
            return new Object[]{"", 0};
        }
        String[] split = s.split("");
        String cymbMax = "";
        int countMax = 0;
        for (int j = 0; j < split.length; j++) {
            String symb = split[j];
            int count = 1;
            for (int k = j + 1; k < split.length; k++) {
                if (symb.equals(split[k])) {
                    count++;
                } else {
                    j = k - 1;
                    break;
                }
            }
            if (count > countMax) {
                countMax = count;
                cymbMax = symb;
            }
        }
        return new Object[]{cymbMax, countMax};
    }

    @Test
    public void exampleTests() {
        assertArrayEquals(new Object[]{"a", 4}, longestRepetition("aaaabb"));
        assertArrayEquals(new Object[]{"u", 3}, longestRepetition("cbdeuuu900"));
        assertArrayEquals(new Object[]{"a", 4}, longestRepetition("bbbaaabaaaa"));
        assertArrayEquals(new Object[]{"b", 5}, longestRepetition("abbbbb"));
        assertArrayEquals(new Object[]{"a", 2}, longestRepetition("aabb"));
        assertArrayEquals(new Object[]{"", 0}, longestRepetition(""));
    }

}
