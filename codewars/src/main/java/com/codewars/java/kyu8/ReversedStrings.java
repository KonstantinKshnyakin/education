package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversedStrings {

    public static String solution(String str) {
        char[] chars = str.toCharArray();
        int lastIndex = chars.length - 1;
        for (int i = 0; i < chars.length / 2; i++) {
            char save = chars[i];
            chars[i] = chars[lastIndex - i];
            chars[lastIndex - i] = save;
        }
        return new String(chars);
    }

    @Test
    public void sampleTests() {
        assertEquals("dlrow", solution("world"));
    }

}
