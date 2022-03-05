package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this little assignment you are given a string of space separated numbers,
 * and have to return the highest and lowest number.
 * <p>
 * Examples
 * highAndLow("1 2 3 4 5")  // return "5 1"
 * highAndLow("1 2 -3 4 5") // return "5 -3"
 * highAndLow("1 9 3 4 -5") // return "9 -5"
 * Notes
 * All numbers are valid Int32, no need to validate them.
 * There will always be at least one number in the input string.
 * Output string must be two numbers separated by a single space, and highest number is first.
 */
public class HighestAndLowest {

    public static String highAndLow(String numbers) {
        List<Integer> intList = Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        if (intList.size() == 0) {
            throw new IllegalArgumentException("String must consist of at least one number");
        } else if (intList.size() == 1) {
            return String.format("%d %d", intList.get(0), intList.get(0));
        } else {
            return String.format("%d %d", intList.get(intList.size() - 1), intList.get(0));
        }
    }

    @Test
    public void test1() {
        assertEquals("42 -9", highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    @Test
    public void test2() {
        assertEquals("3 1", highAndLow("1 2 3"));
    }
}
