package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Your classmates asked you to copy some paperwork for them.
 * You know that there are 'n' classmates and the paperwork has 'm' pages.
 * <p>
 * Your task is to calculate how many blank pages do you need. If n < 0 or m < 0 return 0.
 * <p>
 * Example:
 * n= 5, m=5: 25
 * n=-5, m=5:  0
 * Waiting for translations and Feedback! Thanks!
 */
public class SchoolPaperwork1 {

    public static int paperWork(int n, int m) {
        if (n < 0 || m < 0) {
            return 0;
        }
        return n * m;
    }

    @Test
    public void test1() {
        assertEquals(25, paperWork(5, 5), "Failed at paperWork(5,5)");
    }

    @Test
    public void test2() {
        assertEquals(0, paperWork(5, -5), "Failed at paperWork(5,-5)");
    }

    @Test
    public void test3() {
        assertEquals(0, paperWork(-5, -5), "Failed at paperWork(-5,-5)");
    }

    @Test
    public void test4() {
        assertEquals(0, paperWork(-5, 5), "Failed at paperWork(-5,5)");
    }

    @Test
    public void test5() {
        assertEquals(0, paperWork(5, 0), "Failed at paperWork(5,0)");
    }
}
