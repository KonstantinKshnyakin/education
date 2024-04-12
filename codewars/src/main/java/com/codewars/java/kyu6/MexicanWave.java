package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MexicanWave {

    public static String[] wave(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char[] chars = str.toCharArray();
            char c = chars[i];
            if (!Character.isWhitespace(c)) {
                chars[i] = Character.toUpperCase(c);
                result.add(String.valueOf(chars));
            }
        }
        return result.toArray(new String[0]);
    }

    @Test
    public void basicTest1() {
        String[] result = new String[]{"Hello", "hEllo", "heLlo", "helLo", "hellO"};
        assertArrayEquals(result, MexicanWave.wave("hello"), "it should return '" + Arrays.toString(result) + "'");
    }

    @Test
    public void basicTest2() {
        String[] result = new String[]{"Codewars", "cOdewars", "coDewars", "codEwars", "codeWars", "codewArs", "codewaRs", "codewarS"};
        assertArrayEquals(result, MexicanWave.wave("codewars"), "it should return '" + Arrays.toString(result) + "'");
    }

    @Test
    public void basicTest3() {
        String[] result = new String[]{};
        assertArrayEquals(result, MexicanWave.wave(""), "it should return '" + Arrays.toString(result) + "'");
    }

    @Test
    public void basicTest4() {
        String[] result = new String[]{"Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS"};
        assertArrayEquals(result, MexicanWave.wave("two words"), "it should return '" + Arrays.toString(result) + "'");
    }

    @Test
    public void basicTest5() {
        String[] result = new String[]{" Gap ", " gAp ", " gaP "};
        assertArrayEquals(result, MexicanWave.wave(" gap "), "it should return '" + Arrays.toString(result) + "'");
    }

}
