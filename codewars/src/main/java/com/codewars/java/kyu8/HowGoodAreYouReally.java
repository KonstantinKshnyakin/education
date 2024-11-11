package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * There was a test in your class and you passed it. Congratulations!
 *
 * But you're an ambitious person. You want to know if you're better than the average student in your class.
 *
 * You receive an array with your peers' test scores. Now calculate the average and compare your score!
 *
 * Return true if you're better, else false!
 *
 * Note:
 * Your points are not included in the array of your class's points. Do not forget them when calculating the average score!
 */
public class HowGoodAreYouReally {

    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        return IntStream.of(classPoints).average().orElse(-1) < yourPoints;
    }

    @Test
    public void tests() {
        assertTrue(betterThanAverage(new int[]{2, 3}, 5));
        assertTrue(betterThanAverage(new int[]{100, 40, 34, 57, 29, 72, 57, 88}, 75));
        assertTrue(betterThanAverage(new int[]{12, 23, 34, 45, 56, 67, 78, 89, 90}, 69));
        assertFalse(betterThanAverage(new int[]{100, 90}, 11));
    }

}
