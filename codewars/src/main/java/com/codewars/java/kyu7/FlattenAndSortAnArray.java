package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FlattenAndSortAnArray {

    public static int[] flattenAndSort(int[][] array) {
        return Stream.of(array)
                .flatMapToInt(IntStream::of)
                .sorted()
                .toArray();
    }

    @Test
    public void exampleTest() {
        assertArrayEquals(new int[]{}, flattenAndSort(new int[][]{}));
        assertArrayEquals(new int[]{1}, flattenAndSort(new int[][]{{}, {1}}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, flattenAndSort(new int[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 100}, flattenAndSort(new int[][]{{1, 3, 5}, {100}, {2, 4, 6}}));
        assertArrayEquals(new int[]{111, 222, 333, 444, 555, 666, 777, 888, 999}, flattenAndSort(new int[][]{{111, 999}, {222}, {333}, {444}, {888}, {777}, {666}, {555}}));
    }

}
