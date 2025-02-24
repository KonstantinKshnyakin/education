package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Return an array containing the numbers from 1 to N, where N is the parametered value.
 *
 * Replace certain values however if any of the following conditions are met:
 *
 * If the value is a multiple of 3: use the value "Fizz" instead
 * If the value is a multiple of 5: use the value "Buzz" instead
 * If the value is a multiple of 3 & 5: use the value "FizzBuzz" instead
 * N will never be less than 1.
 *
 * Method calling example:
 *
 * FizzBuzzArray.fizzBuzz(3) -->  ["1", "2", "Fizz"]
 */
public class FizzBuzz {

    public static String[] fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> {
                    String result = "";
                    boolean isMultipleOf5 = i % 5 == 0;
                    boolean isMultipleOf3 = i % 3 == 0;
                    if (!isMultipleOf3 && !isMultipleOf5) {
                        return String.valueOf(i);
                    }
                    if (isMultipleOf3) {
                        result += "Fizz";
                    }
                    if (isMultipleOf5) {
                        result += "Buzz";
                    }
                    return result;
                })
                .toArray(String[]::new);
    }

    @Test
    public void sampleTests() {
        String[] expected = {"1"};
        String[] actual = fizzBuzz(1);
        assertArrayEquals(expected, actual, "Input: 1\nExpected: {\"1\"}\nActual:   " + Arrays.toString(actual) + "\n");

        expected = new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"};
        actual = fizzBuzz(10);
        assertArrayEquals(expected, actual, "Input: 10\nExpected: {\"1\", \"2\", \"Fizz\", \"4\", \"Buzz\", \"Fizz\", \"7\", \"8\", \"Fizz\", \"Buzz\"}\nActual:   " + Arrays.toString(actual) + "\n");
    }
}
