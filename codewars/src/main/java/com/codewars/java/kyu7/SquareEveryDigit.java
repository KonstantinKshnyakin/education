package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Welcome. In this kata, you are asked to square every digit of a number and concatenate them.
 * <p>
 * For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.
 * <p>
 * Note: The function accepts an integer and returns an integer
 */
public class SquareEveryDigit {

    public int squareDigits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The function argument must be >= 0.");
        } else if (n == 0) {
            return 0;
        }
        List<Integer> ints = intToArrayInt(n);
        StringBuilder sb = new StringBuilder();
        for (Integer anInt : ints) {
            sb.append(anInt * anInt);
        }
        return Integer.parseInt(sb.toString());
    }

    private List<Integer> intToArrayInt(int n) {
        List<Integer> result = new ArrayList<>();
        while (n != 0) {
            result.add(0, n % 10);
            n /= 10;
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals(811181, squareDigits(9119));
        assertEquals(0, squareDigits(0));
        assertEquals(49, squareDigits(7));
    }
}
