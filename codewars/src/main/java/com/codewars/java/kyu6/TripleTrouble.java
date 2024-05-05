package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleTrouble {

    public static int tripleDouble(long num1, long num2) {
        String num = num1 + "," + num2;
        return num.matches(".*(\\d)\\1{2}.*,.*\\1{2}.*") ? 1 : 0;
    }

    @Test
    public void test1() {
        assertEquals(1, tripleDouble(451999277L, 41177722899L));
    }

    @Test
    public void test2() {
        assertEquals(0, tripleDouble(1222345L, 12345L));
    }

    @Test
    public void test3() {
        assertEquals(0, tripleDouble(12345L, 12345L));
    }

    @Test
    public void test4() {
        assertEquals(1, tripleDouble(666789L, 12345667L));
    }

    @Test
    public void test5() {
        assertEquals(0, tripleDouble(451999277L, 411777228L));
    }

    @Test
    public void test6() {
        assertEquals(0, tripleDouble(1112L, 122L));
    }
}
