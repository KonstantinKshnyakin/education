package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * If we were to set up a Tic-Tac-Toe game, we would want to know whether the board's current state is solved,
 * wouldn't we? Our goal is to create a function that will check that for us!
 * <p>
 * Assume that the board comes in the form of a 3x3 array, where the value is 0 if a spot is empty,
 * 1 if it is an "X", or 2 if it is an "O", like so:
 * <p>
 * [[0, 0, 1],
 * [0, 1, 2],
 * [2, 1, 0]]
 * We want our function to return:
 * <p>
 * -1 if the board is not yet finished AND no one has won yet (there are empty spots),
 * 1 if "X" won,
 * 2 if "O" won,
 * 0 if it's a cat's game (i.e. a draw).
 * You may assume that the board passed in is valid in the context of a game of Tic-Tac-Toe.
 */
public class TicTacToeChecker {

    public static int isSolved(int[][] board) {
        int win = isWinDiagonal(board);
        if (win == 1 || win == 2) {
            return win;
        }
        for (int i = 0; i < board.length; i++) {
            win = isWinLine(board[i]);
            if (win == 1 || win == 2) {
                return win;
            }
            win = isWinColumn(board, i);
            if (win == 1 || win == 2) {
                return win;
            }
        }
        boolean distinct = Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .anyMatch(i -> i == 0);
        if (distinct) {
            return -1;
        }
        return 0;
    }

    private static int isWinDiagonal(int[][] board) {
        int[] arr1 = new int[board.length];
        int[] arr2 = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            arr1[i] = board[i][i];
            arr2[i] = board[board.length - 1 - i][i];
        }
        int i1 = isWinLine(arr1);
        return i1 != 0 ? i1 : isWinLine(arr2);
    }

    private static int isWinColumn(int[][] board, int i) {
        int[] array = Arrays.stream(board)
                .mapToInt(ints -> ints[i])
                .toArray();
        return isWinLine(array);
    }

    private static int isWinLine(int[] ints) {
        int[] array = Arrays.stream(ints)
                .distinct()
                .toArray();
        if (array.length == 1) {
            return array[0];
        }
        return 0;
    }

    @Test
    void notFinished() {
        assertEquals(-1, isSolved(new int[][]{
                {0, 0, 1},
                {0, 1, 2},
                {2, 1, 0}
        }), "[0, 0, 1]\n[0, 1, 2]\n[2, 1, 0]");
    }

    @Test
    void winnerX() {
        assertEquals(1, isSolved(new int[][]{
                {1, 1, 1},
                {0, 2, 2},
                {0, 0, 0}
        }), "[1, 1, 1]\n[0, 2, 2]\n[0, 0, 0]");
    }

    @Test
    void winnerY() {
        assertEquals(1, isSolved(new int[][]{
                {1, 2, 1},
                {1, 2, 2},
                {1, 0, 0}
        }), "[1, 1, 1]\n[0, 2, 2]\n[0, 0, 0]");
    }

    @Test
    void winnerO() {
        assertEquals(2, isSolved(new int[][]{
                {1, 1, 2},
                {0, 2, 0},
                {2, 1, 1}
        }), "[1, 1, 2]\n[0, 2, 0]\n[2, 1, 1]");
    }

    @Test
    void draw() {
        assertEquals(0, isSolved(new int[][]{
                {1, 2, 1},
                {1, 1, 2},
                {2, 1, 2}
        }), "[1, 2, 1]\n[1, 1, 2]\n[2, 1, 2]");
    }

}
