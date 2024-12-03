package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Several people are standing in a row divided into two teams. The first person goes into team 1, the second goes into
 * team 2, the third goes into team 1, and so on.
 * <p>
 * Task
 * Given an array of positive integers (the weights of the people), return a new array / tuple of two integers (depending
 * on your language), whereby the first one is the total weight of team 1, and the second one is the total weight of
 * team 2. Note that the array will never be empty.
 * <p>
 * Examples
 * [13, 27, 49] returns [62, 27] or (62, 27) (depending on your language) because the total weight of team 1 is
 * 13+49=62 and the total weight of team 2 is 27.
 * <p>
 * [50, 60, 70, 80] returns [120, 140] or (120, 140) (depending on your language) because the total weight of team 1 is
 * 50+70=120 and the total weight of team 2 is 60+80=140.
 * <p>
 * [80] returns [80, 0] or (80, 0) (depending on your language) because the total weight of team 1 is
 * 80 and the total weight of team 2 is 0.
 */
public class RowWeights {

    public static int[] rowWeights(final int[] weights) {
        int weight1 = 0;
        int weight2 = 0;
        for (int i = 0; i < weights.length; i++) {
            if (i % 2 == 0) {
                weight1 += weights[i];
            } else {
                weight2 += weights[i];
            }
        }
        return new int[]{weight1, weight2};
    }

    @Test
    public void Basic_Tests() {
        assertArrayEquals(new int[]{80, 0}, rowWeights(new int[]{80}));
        assertArrayEquals(new int[]{100, 50}, rowWeights(new int[]{100, 50}));
        assertArrayEquals(new int[]{120, 140}, rowWeights(new int[]{50, 60, 70, 80}));
    }

    @Test
    public void Odd_Vector_Length() {
        assertArrayEquals(new int[]{62, 27}, rowWeights(new int[]{13, 27, 49}));
        assertArrayEquals(new int[]{236, 92}, rowWeights(new int[]{70, 58, 75, 34, 91}));
        assertArrayEquals(new int[]{211, 164}, rowWeights(new int[]{29, 83, 67, 53, 19, 28, 96}));
    }

    @Test
    public void Even_Vector_Length() {
        assertArrayEquals(new int[]{100, 50}, rowWeights(new int[]{100, 50}));
        assertArrayEquals(new int[]{150, 151}, rowWeights(new int[]{100, 51, 50, 100}));
        assertArrayEquals(new int[]{207, 235}, rowWeights(new int[]{39, 84, 74, 18, 59, 72, 35, 61}));
    }

}
