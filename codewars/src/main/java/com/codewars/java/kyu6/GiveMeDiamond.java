package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James.
 * Since James doesn't know how to make this happen, he needs your help.
 *
 * Task
 * You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters.
 * Trailing spaces should be removed, and every line must be terminated with a newline character (\n).
 *
 * Return null/nil/None/... if the input is an even number or negative, as it is not possible to print
 * a diamond of even or negative size.
 *
 * Examples
 * A size 3 diamond:
 *
 *  *
 * ***
 *  *
 * ...which would appear as a string of " *\n***\n *\n"
 *
 * A size 5 diamond:
 *
 *   *
 *  ***
 * *****
 *  ***
 *   *
 * ...that is:
 *
 * "  *\n ***\n*****\n ***\n  *\n"
 */
public class GiveMeDiamond {

    public static String print(int n) {
        if (n % 2 == 0 || n < 1) {
            return null;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                StringBuilder ap = new StringBuilder()
                        .append(" ".repeat((n - i) / 2))
                        .append("*".repeat(i))
                        .append("\n");
                if (i == n) {
                    sb1.append(ap);
                } else {
                    sb1.append(ap);
                    sb2.insert(0, ap);
                }
            }
        }
        return sb1.append(sb2).toString();
    }

    @Test
    public void testDiamond3() {
        StringBuffer expected = new StringBuffer();
        expected.append(" *\n");
        expected.append("***\n");
        expected.append(" *\n");

        assertEquals(expected.toString(), print(3));
    }

    @Test
    public void testDiamond5() {
        StringBuffer expected = new StringBuffer();
        expected.append("  *\n");
        expected.append(" ***\n");
        expected.append("*****\n");
        expected.append(" ***\n");
        expected.append("  *\n");

        assertEquals(expected.toString(), print(5));
    }

    @Test
    public void testDiamond1() {
        StringBuffer expected = new StringBuffer();
        expected.append("*\n");
        assertEquals(expected.toString(), print(1));
    }

    @Test
    public void testDiamond0() {
        assertEquals(null, print(0));
    }

    @Test
    public void testDiamondMinus2() {
        assertEquals(null, print(-2));
    }

    @Test
    public void testDiamond2() {
        assertEquals(null, print(2));
    }

}
