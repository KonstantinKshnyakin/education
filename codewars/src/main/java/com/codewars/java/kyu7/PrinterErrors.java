package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In a factory a printer prints labels for boxes. For one kind of boxes the printer has to use colors which,
 * for the sake of simplicity, are named with letters from a to m.
 * <p>
 * The colors used by the printer are recorded in a control string. For example a "good" control string
 * would be aaabbbbhaijjjm meaning that the printer used three times color a, four times color b,
 * one time color h then one time color a...
 * <p>
 * Sometimes there are problems: lack of colors, technical malfunction and a "bad" control string
 * is produced e.g. aaaxbbbbyyhwawiwjjjwwm with letters not from a to m.
 * <p>
 * You have to write a function printer_error which given a string will return the error rate of the printer
 * as a string representing a rational whose numerator is the number of errors and the denominator the length
 * of the control string. Don't reduce this fraction to a simpler expression.
 * <p>
 * The string has a length greater or equal to one and contains only letters from ato z.
 * <p>
 * Examples:
 * s="aaabbbbhaijjjm"
 * printer_error(s) => "0/14"
 * <p>
 * s="aaaxbbbbyyhwawiwjjjwwm"
 * printer_error(s) => "8/22"
 */
public class PrinterErrors {

    public static String printerError(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String argument must not be null");
        }
        if (s.length() < 1) {
            throw new IllegalArgumentException("String length must be >= 1");
        }

        long countNotMatch = s.chars()
                .filter(i -> i < 'a' || i > 'm')
                .count();
        return String.format("%d/%d", countNotMatch, s.length());
    }

    @Test
    public void test() {
        String s = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("3/56", printerError(s));
    }
}
