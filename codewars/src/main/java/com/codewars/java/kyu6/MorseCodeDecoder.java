package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseCodeDecoder {

    public static final Map<String, String> map = new HashMap<>();

    static {
        map.put(".-", "A");
        map.put("-...", "B");
        map.put(".--", "W");
        map.put("--.", "G");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("...-", "V");
        map.put("--..", "Z");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");
        map.put(".--.", "P");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("..-.", "F");
        map.put("....", "H");
        map.put("-.-.", "C");
        map.put("--.-", "Q");
        map.put("-.--", "Y");
        map.put("-..-", "X");
    }

    public static String decode(String morseCode) {
        String[] words = morseCode.strip().split(" {3}");
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : words) {
            String[] chars = word.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String aChar : chars) {
                sb.append(map.get(aChar));
            }
            joiner.add(sb);
        }
        return joiner.toString();
    }

    @Test
    public void testExampleFromDescription() {
        assertEquals("HEY JUDE", decode(".... . -.--   .--- ..- -.. ."));
    }

}
