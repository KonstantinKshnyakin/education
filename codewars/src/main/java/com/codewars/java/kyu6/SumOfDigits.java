package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

    import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Digital root is the recursive sum of all the digits in a number.
 *
 * Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until
 * a single-digit number is produced. The input will be a non-negative integer.
 *
 * Examples
 *     16  -->  1 + 6 = 7
 *    942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
 * 132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
 * 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 */
public class SumOfDigits {

    public static int digital_root(int n) {
        String string = Integer.toString(n);
        if (string.length() > 1) {
            int result = Arrays.stream(string.split(""))
                    .mapToInt(Integer::parseInt)
                    .sum();
            return digital_root(result);
        } else {
            return n;
        }
    }

    @Test
    public void Test1() {
        assertEquals(7, digital_root(16));
    }
    @Test
    public void Test2() {
        assertEquals(6, digital_root(456));
    }

}
