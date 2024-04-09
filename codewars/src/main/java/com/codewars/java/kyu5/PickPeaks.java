package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this kata, you will write a function that returns the positions and the values of the "peaks" (or local maxima)
 * of a numeric array.
 *
 * For example, the array arr = [0, 1, 2, 5, 1, 0] has a peak at position 3 with a value of 5 (since arr[3] equals 5).
 *
 * The output will be returned as a ``Map<String,List>with two key-value pairs:"pos"and"peaks". If there is no peak in
 * the given array, simply return {"pos" => [], "peaks" => []}`.
 *
 * Example: pickPeaks([3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3]) should return {pos: [3, 7],
 * peaks: [6, 3]} (or equivalent in other languages)
 *
 * All input arrays will be valid integer arrays (although it could still be empty),
 * so you won't need to validate the input.
 *
 * The first and last elements of the array will not be considered as peaks (in the context of a mathematical function,
 * we don't know what is after and before and therefore, we don't know if it is a peak or not).
 *
 * Also, beware of plateaus !!! [1, 2, 2, 2, 1] has a peak while [1, 2, 2, 2, 3] and [1, 2, 2, 2, 2] do not.
 * In case of a plateau-peak, please only return the position and value of the beginning of the plateau.
 * For example: pickPeaks([1, 2, 2, 2, 1]) returns {pos: [1], peaks: [2]} (or equivalent in other languages)
 *
 * Have fun!
 */
public class PickPeaks {

    public static final String POS = "pos";
    public static final String PEAKS = "peaks";

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> result = new HashMap<>();
        result.put(POS, new ArrayList<>());
        result.put(PEAKS, new ArrayList<>());

        int platoPos = -1;
        for (int i = 1; i < arr.length - 1; i++) {
            int v1 = arr[i - 1];
            int v2 = arr[i];
            int v3 = arr[i + 1];
            if (platoPos == -1 && v2 > v1 && v2 == v3) {
                platoPos = i;
            } else if (platoPos != -1 && v2 > v3) {
                add(arr[platoPos], platoPos, result);
                platoPos = -1;
            } else if (platoPos != -1 && v2 != v3) {
                platoPos = -1;
            } else if (v2 > v1 && v2 > v3) {
                add(v2, i, result);
            }
        }
        return result;
    }

    private static void add(int value, int position, Map<String, List<Integer>> result) {
        result.get("pos").add(position);
        result.get("peaks").add(value);
    }

    private static String[] msg = {
            "",
            "",
            "",
            "",
            "should support finding peaks",
            "should support finding peaks, but should ignore peaks on the edge of the array",
            "should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
            "should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
            "should support finding peaks, but should ignore peaks on the edge of the array"};

    private static int[][] array = {
            {2, 19, 17, 17, 6, 7, -3, -3, 5, -3, -2, -2, 19, 19, 11, 1, 13, 13, -2, 11, -5, 5, -3, 7, 13, -2, 4, -3},
            {13, 5, 11, 6, 4, -3, 1, -2, 15, 7, 16, 1, 1, -2, 19, 7, 11, 6, 6, 6, -5},
            {11, 12, 17, 8, 17, 17, 1, 17, 17, -5, 5, 8, 12, 3, 9, 18, -2, 11, 1, 18, 6, 1, 9, 13, -3, 2, 11, 15},
            {4, 10, 14, 0, -2, 8, 14, 3, 0, 14, 4, 12, 16, 16, -2, 17, 11, 2, 17, 3, 3},
            {1, 2, 3, 6, 4, 1, 2, 3, 2, 1},
            {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3},
            {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1},
            {2, 1, 3, 1, 2, 2, 2, 2, 1},
            {2, 1, 3, 1, 2, 2, 2, 2}
    };

    private static int[][] posS = {
            {1, 5, 8, 12, 16, 19, 21, 24, 26},
            {2, 6, 8, 10, 14, 16},
            {2, 4, 7, 12, 15, 17, 19, 23},
            {2, 6, 9, 12, 15, 18},
            {3, 7},
            {3, 7},
            {3, 7, 10},
            {2, 4},
            {2},};

    private static int[][] peaksS = {
            {19, 7, 5, 19, 13, 11, 5, 13, 4},
            {11, 1, 15, 16, 19, 11},
            {17, 17, 17, 12, 18, 11, 18, 13},
            {14, 14, 14, 16, 17, 17},
            {6, 3},
            {6, 3},
            {6, 3, 2},
            {3, 2},
            {3}};

    @Test
    public void sampleTests() {
        for (int n = 0; n < array.length; n++) {
            final int[] p1 = posS[n], p2 = peaksS[n];
            Map<String, List<Integer>> expected = new HashMap<>() {{
                put("pos", Arrays.stream(p1).boxed().collect(Collectors.toList()));
                put("peaks", Arrays.stream(p2).boxed().collect(Collectors.toList()));
            }};
            Map<String, List<Integer>> actual = PickPeaks.getPeaks(array[n]);
            assertEquals(expected, actual, msg[n]);
        }
    }

}
