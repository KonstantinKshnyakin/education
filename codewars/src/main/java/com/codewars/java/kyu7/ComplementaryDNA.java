package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplementaryDNA {

    public static final Map<Character, Character> map = Map.of(
            'T', 'A',
            'A', 'T',
            'C', 'G',
            'G', 'C'
    );

    public static String makeComplement(String dna) {
        char[] chars = dna.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            result += map.get(chars[i]);
        }
        return result;
    }

    @Test
    public void test01() {
        assertEquals("TTTT", makeComplement("AAAA"));
    }
    @Test
    public void test02() {
        assertEquals("TAACG", makeComplement("ATTGC"));
    }
    @Test
    public void test03() {
        assertEquals("CATA", makeComplement("GTAT"));
    }

}
