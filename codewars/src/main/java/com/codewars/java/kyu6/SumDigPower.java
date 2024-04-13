package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The number
 * 89
 * 89 is the first integer with more than one digit that fulfills the property partially introduced in the title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number:
 *
 * Task
 * We need a function to collect these numbers, that may receive two integers
 * a, b that defines the range
 * [
 * ,]
 * [a,b] (inclusive) and outputs a list of the sorted numbers in the range that fulfills the property described above.
 *
 * Examples
 * Let's see some cases (input -> output):
 *
 * 1, 10  --> [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * 1, 100 --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
 * If there are no numbers of this kind in the range
 * [a,b] the function should output an empty list.
 *
 * 90, 100 --> []
 * Enjoy it!!
 */
public class SumDigPower {

    public static List<Long> sumDigPow(long a, long b) {
        ArrayList<Long> result = new ArrayList<>();
        for (long i = a; i <= b; i++) {
            List<Long> digits = getDigitFromNumber(i);
            long sum = 0;
            for (int j = 0; j < digits.size(); j++) {
                double pow = Math.pow(digits.get(j), j + 1);
                sum += (long) pow;
            }
            if (i == sum) {
                result.add(i);
            }
        }
        return result;
    }

    private static List<Long> getDigitFromNumber(Long value) {
        List<Long> result = new ArrayList<>();
        while (value > 0) {
            long l = value % 10;
            result.add(0, l);
            value /= 10;
        }
        return result;
    }


    private static void testing(long a, long b, long[] res) {
        assertEquals(Arrays.toString(res),
                Arrays.toString(SumDigPower.sumDigPow(a, b).toArray()));
    }
    @Test
    public void test() {
        System.out.println("Basic Tests");
        testing(1, 10, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        testing(1, 100, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 89});
        testing(10, 100,  new long[] {89});
        testing(90, 100, new long[] {});
        testing(90, 150, new long[] {135});
        testing(50, 150, new long[] {89, 135});
        testing(10, 150, new long[] {89, 135});
    }

}
