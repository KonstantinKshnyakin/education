package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer, return a string with dash '-' marks before and after each odd digit,
 * but do not begin or end the string with a dash mark.
 *
 * Ex:
 *
 * 274 -> '2-7-4'
 * 6815 -> '68-1-5'
 */
public class DashatizeIt {

    public static String dashatize(int num) {
        String[] arr = String.valueOf(num).replace("-", "").split("");
        boolean bef = false;
        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i]) % 2 == 1) {
                if (!bef && i != 0) {
                    arr[i] = "-" + arr[i];
                }
                if (i != arr.length - 1) {
                    arr[i] += "-";
                }
                bef = true;
            }
            else {
                bef = false;
            }
        }
//        return String.join("", arr);
        return String.valueOf(num)
                .replaceAll("([13579])", "-$1-")
                .replaceAll("--", "-")
                .replaceAll("^-|-$", "");
    }

    @Test
    public void testBasic() {
        assertEquals("2-7-4", dashatize(274));
        assertEquals("5-3-1-1", dashatize(5311));
        assertEquals("86-3-20", dashatize(86320));
        assertEquals("9-7-4-3-02", dashatize(974302));
    }

    @Test
    public void testWeird() {
        assertEquals("0", dashatize(0));
        assertEquals("1", dashatize(-1));
        assertEquals("28-3-6-9", dashatize(-28369));
    }

    @Test
    public void testEdgeCases() {
        assertEquals("2-1-4-7-48-3-64-7", dashatize(Integer.MAX_VALUE));
        assertEquals("2-1-4-7-48-3-648", dashatize(Integer.MIN_VALUE));
        assertEquals("1-1-1-1-1-1-1-1-1-1", dashatize(-1111111111));
    }

}
