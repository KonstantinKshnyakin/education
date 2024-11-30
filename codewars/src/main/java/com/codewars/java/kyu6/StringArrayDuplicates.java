package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * In this Kata, you will be given an array of strings and your task is to remove all consecutive duplicate letters
 * from each string in the array.
 * <p>
 * For example:
 * <p>
 * dup(["abracadabra","allottee","assessee"]) = ["abracadabra","alote","asese"].
 * <p>
 * dup(["kelless","keenness"]) = ["keles","kenes"].
 * <p>
 * Strings will be lowercase only, no spaces. See test cases for more examples.
 */
public class StringArrayDuplicates {

    public static String[] dup(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            StringBuilder newStr = new StringBuilder();
            String str = arr[i];
            newStr.append(str.charAt(0));
            for (int j = 0; j < str.length() - 1; j++) {
                char c = str.charAt(j + 1);
                if (str.charAt(j) != c) {
                    newStr.append(c);
                }
            }
            result[i] = newStr.toString();
        }
        return result;
    }

    @Test
    public void basicTests() {
        assertArrayEquals(new String[]{"codewars", "picaniny", "hubububo"}, dup(new String[]{"ccooddddddewwwaaaaarrrrsssss", "piccaninny", "hubbubbubboo"}));
        assertArrayEquals(new String[]{"abracadabra", "alote", "asese"}, dup(new String[]{"abracadabra", "allottee", "assessee"}));
        assertArrayEquals(new String[]{"keles", "kenes"}, dup(new String[]{"kelless", "keenness"}));
    }

}
