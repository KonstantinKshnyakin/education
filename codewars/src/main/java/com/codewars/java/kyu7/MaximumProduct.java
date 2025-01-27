package cocodewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array of integers , Find the maximum product obtained from multiplying 2 adjacent numbers in the array.
 * Note that the array size is at least 2 and consists a mixture of positive, negative integers and also zeroes.
 *
 * Examples
 * [1, 2, 3] returns 6 because the maximum product is obtained from multiplying
 *  2∗3=6
 * [9, 5, 10, 2, 24, -1, -48] returns 50 because the maximum product is obtained from multiplying
 * 5 ∗ 10 = 50
 * [-23, 4, -5, 99, -27, 329, -2, 7, -921] returns -14 because the maximum product is obtained from multiplying
 * 2∗7=−14
 */
public class MaximumProduct {

    public static int adjacentElementsProduct(int[] array) {
        int max = array[0] * array[1];
        for (int i = 1; i < array.length - 1; i++) {
            int m = array[i] * array[i + 1];
            if (m > max) {
                max = m;
            }
        }
        return max;
    }

    private void test(String message, int expected, int actual) {
        assertEquals(expected, actual, message);
    }

    @Test
    public void fixedTests() {
        String message = "Positive numbers";
        test(message, 40, adjacentElementsProduct(new int[]{5, 8}));
        test(message, 6, adjacentElementsProduct(new int[]{1, 2, 3}));
        test(message, 90, adjacentElementsProduct(new int[]{1, 5, 10, 9}));
        test(message, 48, adjacentElementsProduct(new int[]{4, 12, 3, 1, 5}));
        test(message, 6, adjacentElementsProduct(new int[]{5, 1, 2, 3, 1, 4}));

        message = "Both positive and negative values";
        test(message, 21, adjacentElementsProduct(new int[]{3, 6, -2, -5, 7, 3}));
        test(message, 50, adjacentElementsProduct(new int[]{9, 5, 10, 2, 24, -1, -48}));
        test(message, 30, adjacentElementsProduct(new int[]{5, 6, -4, 2, 3, 2, -23}));
        test(message, -14, adjacentElementsProduct(new int[]{-23, 4, -5, 99, -27, 329, -2, 7, -921}));
        test(message, 6, adjacentElementsProduct(new int[]{5, 1, 2, 3, 1, 4}));

        message = "Contains zeroes";
        test(message, 0, adjacentElementsProduct(new int[]{1, 0, 1, 0, 1000}));
        test(message, 6, adjacentElementsProduct(new int[]{1, 2, 3, 0}));
    }
}
