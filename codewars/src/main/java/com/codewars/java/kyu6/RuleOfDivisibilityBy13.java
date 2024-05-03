package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RuleOfDivisibilityBy13 {

    private static final int[] SEQ = new int[]{1, 10, 9, 12, 3, 4};

    public static long thirt(long n) {
        String[] arr = String.valueOf(n).split("");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int i1 = SEQ[i % 6];
            int i2 = Integer.parseInt(arr[arr.length - 1 - i]);
            sum += i1 * i2;

        }
        return sum == n ? n : thirt(sum);
    }

    private static void testing(long actual, long expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests: thirt");
        testing(thirt(8529), 79);
        testing(thirt(85299258), 31);
        testing(thirt(5634), 57);
        testing(thirt(1111111111), 71);
        testing(thirt(987654321), 30);
    }

}
