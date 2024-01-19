package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order
 * of the strings of a1 which are substrings of strings of a2.
 *
 * Example 1:
 * a1 = ["arp", "live", "strong"]
 *
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *
 * returns ["arp", "live", "strong"]
 *
 * Example 2:
 * a1 = ["tarp", "mice", "bull"]
 *
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *
 * returns []
 */
public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> result = new HashSet<>();
        for (String s1 : array1) {
            for (String s2 : array2) {
                if (s2.contains(s1)) {
                    result.add(s1);
                    break;
                }
            }
        }
        return result.stream()
                .sorted()
                .toArray(String[]::new);
    }

    @Test
    public void test1() {
        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        assertArrayEquals(r, inArray(a, b));
    }

}
