package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMissingTermInArithmeticProgression {

    public static int findMissing(int[] numbers) {
        int delta = getDelta(numbers);
        if (delta == 0) {
            return numbers[0];
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] - numbers[i] != delta) {
                return numbers[i] + delta;
            }
        }
        throw new IllegalArgumentException();
    }

    private static int getDelta(int[] numbers) {
        int i1 = numbers[1] - numbers[0];
        int i2 = numbers[numbers.length - 1] - numbers[numbers.length - 2];
        if (Math.abs(i1) > Math.abs(i2)) {
            return i2;
        }
        return i1;
    }

    @Test
    void testIncreasing_1() {
        assertEquals(3, findMissing(new int[]{1, 2, 4}), "Incorrect answer for [1, 2, 4]");
    }

    @Test
    void testIncreasing_2() {
        assertEquals(2, findMissing(new int[]{1, 3, 4}), "Incorrect answer for [1, 3, 4]");
    }

    @Test
    void testDecreasing_1() {
        assertEquals(3, findMissing(new int[]{4, 2, 1}), "Incorrect answer for [4, 2, 1]");
    }

    @Test
    void testDecreasing_2() {
        assertEquals(2, findMissing(new int[]{4, 3, 1}), "Incorrect answer for [4, 3, 1]");
    }

    @Test
    void testConstant() {
        assertEquals(1, findMissing(new int[]{1, 1, 1}), "Incorrect answer for [1, 1, 1]");
    }

}
