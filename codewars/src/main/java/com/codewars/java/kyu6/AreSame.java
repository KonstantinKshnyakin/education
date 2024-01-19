package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given two arrays a and b write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have the
 * "same" elements, with the same multiplicities (the multiplicity of a member is the number of times it appears).
 * "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
 *
 * Examples
 * Valid arrays
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
 * comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 the square of 144,
 * 361 the square of 19, 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of squares:
 *
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]
 * Invalid arrays
 * If, for example, we change the first number to something else, comp is not returning true anymore:
 *
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]
 * comp(a,b) returns false because in b 132 is not the square of any number of a.
 *
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]
 * comp(a,b) returns false because in b 36100 is not the square of any number of a.
 *
 * Remarks
 * a or b might be [] or {} (all languages except R, Shell).
 * a or b might be nil or null or None or nothing
 * If a or b are nil (or null or None, depending on the language), the problem doesn't make sense so return false.
 */
public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if ((a == null || b == null) || (a.length != b.length)) {
            return false;
        }
        if (a.length == 0 && b.length == 0) {
            return true;
        }
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * a[i];
        }
        Arrays.sort(b);
        Arrays.sort(c);
        return Arrays.equals(c, b);
    }

    @Test
    public void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertTrue(comp(a, b));
    }

    @Test
    public void test2() {
        int[] a = new int[]{2, 2, 3};
        int[] b = new int[]{4, 9, 9};
        assertFalse(comp(a, b));
    }

    @Test
    public void test3() {
        int[] a = new int[]{};
        int[] b = new int[]{1};
        assertFalse(comp(a, b));
    }

}
