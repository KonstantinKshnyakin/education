package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildPileOfCubes {

    public static long findNb(long m) {
        long totalSize = 1;
        long cubeSize = 1;
        while (totalSize < m) {
            totalSize += (long) Math.pow(++cubeSize, 3);
        }
        return totalSize == m ? totalSize : -1;
    }

    @Test
    public void test1() {
        assertEquals(2022, findNb(4183059834009L));
    }

    @Test
    public void test2() {
        assertEquals(-1, findNb(24723578342962L));
    }

    @Test
    public void test3() {
        assertEquals(4824, findNb(135440716410000L));
    }

    @Test
    public void test4() {
        assertEquals(3568, findNb(40539911473216L));
    }

}
