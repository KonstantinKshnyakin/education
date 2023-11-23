package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

/**
 * Your task is to write a function which returns the sum of following series upto nth term(parameter).
 * Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
 * Rules:
 * You need to round the answer to 2 decimal places and return it as String.
 * If the given value is 0 then it should return 0.00
 * You will only be given Natural Numbers as arguments.
 *
 * Examples:(Input --> Output)
 * 1 --> 1 --> "1.00"
 * 2 --> 1 + 1/4 --> "1.25"
 * 5 --> 1 + 1/4 + 1/7 + 1/10 + 1/13 --> "1.57"
 */
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Your task is to write a function which returns the sum of following series upto nth term(parameter).
 *
 * Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
 * Rules:
 * You need to round the answer to 2 decimal places and return it as String.
 *
 * If the given value is 0 then it should return 0.00
 *
 * You will only be given Natural Numbers as arguments.
 *
 * Examples:(Input --> Output)
 * 1 --> 1 --> "1.00"
 * 2 --> 1 + 1/4 --> "1.25"
 * 5 --> 1 + 1/4 + 1/7 + 1/10 + 1/13 --> "1.57"
 */
public class SumOfTheFirstNthTermOfSeries {

    static {
        Locale.setDefault(Locale.ENGLISH);
    }

    public static String seriesSum(int n) {
        if (n <= 1) {
            return format(n);
        }
        double result = 1d;
        for (int i = 0; i < n - 1; i++) {
            result += 1d / (4 + (3 * i));
        }
        return format(result);
    }

    private static String format(double n) {
        return "%.2f".formatted(n);
    }

    @Test
    public void test1() {
        assertEquals("1.57", seriesSum(5));
    }

    @Test
    public void test2() {
        assertEquals("1.77", seriesSum(9));
    }

    @Test
    public void test3() {
        assertEquals("1.94", seriesSum(15));
    }

}
