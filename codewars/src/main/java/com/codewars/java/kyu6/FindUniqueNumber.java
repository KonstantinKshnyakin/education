package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * There is an array with some numbers. All numbers are equal except for one. Try to find it!
 *
 * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * It’s guaranteed that array contains at least 3 numbers.
 *
 * The tests contain some very huge arrays, so think about performance.
 */
public class FindUniqueNumber {

    public static double findUniq(double[] arr) {
        if (arr.length < 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < arr.length; i++) {
            boolean match = false;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i] == arr[j]) {
                        match = true;
                        break;
                    }
                }
            }
            if (!match) {
                return arr[i];
            }
        }
        return 0;
    }

    private final double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }
}
