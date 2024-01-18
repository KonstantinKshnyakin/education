package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clock shows h hours, m minutes and s seconds after midnight.
 *
 * Your task is to write a function which returns the time since midnight in milliseconds.
 */
public class Clock2 {

    public static int past(int h, int m, int s) {
        int secToMill = s * 1000;
        int minToMill = m * 60000;
        int hToMill = h * 3600000;
        return secToMill + minToMill + hToMill;
    }

    @Test
    public void test1(){
        assertEquals(61000, past(0,1,1));
    }

}
