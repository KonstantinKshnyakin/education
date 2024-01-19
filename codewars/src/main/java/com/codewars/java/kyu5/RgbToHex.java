package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal
 * representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range
 * must be rounded to the closest valid value.
 *
 * Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
 *
 * Examples (input --> output):
 * 255, 255, 255 --> "FFFFFF"
 * 255, 255, 300 --> "FFFFFF"
 * 0, 0, 0       --> "000000"
 * 148, 0, 211   --> "9400D3"
 */
public class RgbToHex {

    public static String rgb(int r, int g, int b) {
        return "%02X%02X%02X".formatted(round(r), round(g), round(b));
    }

    public static int round(int a) {
        return a < 0 ? 0 : Math.min(a, 255);
    }

    @Test
    public void sampleTests() {
        assertEquals("000000", rgb(0, 0, 0));
        assertEquals("010203", rgb(1, 2, 3));
        assertEquals("FFFFFF", rgb(255, 255, 255));
        assertEquals("FEFDFC", rgb(254, 253, 252));
        assertEquals("00FF7D", rgb(-20, 275, 125));
    }

}
