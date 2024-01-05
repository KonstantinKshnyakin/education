package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Your task is to write a function which returns the sum of a sequence of integers.
 *
 * The sequence is defined by 3 non-negative values: begin, end, step.
 *
 * If begin value is greater than the end, your function should return 0. If end is not the result of an integer number of steps, then don't add it to the sum. See the 4th example below.
 *
 * Examples
 *
 * 2,2,2 --> 2
 * 2,6,2 --> 12 (2 + 4 + 6)
 * 1,5,1 --> 15 (1 + 2 + 3 + 4 + 5)
 * 1,5,3  --> 5 (1 + 4)
 */
public class SumOfSequence {

    public static int sequenceSum(int start, int end, int step) {
        int result = 0;
        for (int i = start; i <= end; i += step) {
            result += i;
        }
        return result;
    }

    @Test
    void testSomething() {
        assertEquals(12, sequenceSum( 2,  6, 2), "sequenceSum(2, 6, 2)");
        assertEquals(2, sequenceSum( 2,  2, 2), "sequenceSum(2, 2, 2)");
        assertEquals(15, sequenceSum( 1,  5, 1), "sequenceSum(1, 5, 1)");
        assertEquals( 5, sequenceSum( 1,  5, 3), "sequenceSum(1, 5, 3)");
        assertEquals(45, sequenceSum( 0, 15, 3), "sequenceSum(0, 15, 3)");
        assertEquals( 0, sequenceSum(16, 15, 3), "sequenceSum(16, 15, 3)");
    }
}
