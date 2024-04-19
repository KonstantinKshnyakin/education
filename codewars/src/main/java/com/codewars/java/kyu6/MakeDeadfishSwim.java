package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Write a simple parser that will parse and run Deadfish.
 *
 * Deadfish has 4 commands, each 1 character long:
 *
 * i increments the value (initially 0)
 * d decrements the value
 * s squares the value
 * o outputs the value into the return array
 * Invalid characters should be ignored.
 */
public class MakeDeadfishSwim {

    public static int[] parse(String data) {
        List<Integer> result = new ArrayList<>();
        int v = 0;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if ('i' == c) {
                ++v;
            } else if ('d' == c) {
                --v;
            } else if ('v' == c) {
                v *= v;
            } else if ('o' == c) {
                result.add(v);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void exampleTests() {
        assertArrayEquals(new int[] {8, 64}, parse("iiisdoso"));
        assertArrayEquals(new int[] {8, 64, 3600}, parse("iiisdosodddddiso"));
    }

}
