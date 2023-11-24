package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Complete the solution so that it splits the string into pairs of two characters.
 * If the string contains an odd number of characters then it should replace the missing
 * second character of the final pair with an underscore ('_').
 *
 * Examples:
 *
 * * 'abc' =>  ['ab', 'c_']
 * * 'abcdef' => ['ab', 'cd', 'ef']
 */
public class SplitStrings {

    public static String[] solution(String s) {
        int n = 0;
        String[] chars = s.split("");
        String[] result = new String[s.length() / 2 + s.length() % 2];
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length) {
                result[n] = chars[i].concat(chars[i + 1]);
                i++;
            } else if (i == chars.length - 1 && i != 0) {
                result[n] = chars[i].concat("_");
            }
            n++;
        }
        return result;
    }

    @Test
    public void testEvenString() {
        String s = "abcdef";
        String s1 = "HelloWorld";
        String s2 = "";
        assertEquals("[ab, cd, ef]", Arrays.toString(solution(s)));
        assertEquals("[He, ll, oW, or, ld]", Arrays.toString(solution(s1)));
        assertEquals("[]", Arrays.toString(solution(s2)));
    }

    @Test
    public void testOddString() {
        String s = "abcde";
        String s1 = "LovePizza";
        assertEquals("[ab, cd, e_]", Arrays.toString(solution(s)));
        assertEquals("[Lo, ve, Pi, zz, a_]", Arrays.toString(solution(s1)));
    }

}
