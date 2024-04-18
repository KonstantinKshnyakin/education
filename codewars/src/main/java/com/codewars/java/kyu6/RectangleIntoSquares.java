package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The drawing below gives an idea of how to cut a given "true" rectangle into squares
 * ("true" rectangle meaning that the two dimensions are different).
 *
 * alternative text
 *
 * Can you translate this drawing into an algorithm?
 *
 * You will be given two dimensions
 *
 * a positive integer length
 * a positive integer width
 * You will return a collection or a string (depending on the language; Shell bash, PowerShell, Pascal
 * and Fortran return a string) with the size of each of the squares.
 *
 * Examples in general form:
 * (depending on the language)
 *
 *   sqInRect(5, 3) should return [3, 2, 1, 1]
 *   sqInRect(3, 5) should return [3, 2, 1, 1]
 *
 *   You can see examples for your language in **"SAMPLE TESTS".**
 */
public class RectangleIntoSquares {

    public static List<Integer> sqInRect(int lng, int wdth) {
        if (wdth == lng) {
            return null;
        }
        int l = lng;
        int w = wdth;
        List<Integer> result = new ArrayList<>();
        while (w > 0) {
            int temp = Math.min(l, w);
            result.add(temp);
            w = Math.max(l, w) - temp;
            l = temp;
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals(new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1)), sqInRect(5, 3));
    }

    @Test
    public void test2() {
        assertEquals(null, sqInRect(5, 5));
    }

}
