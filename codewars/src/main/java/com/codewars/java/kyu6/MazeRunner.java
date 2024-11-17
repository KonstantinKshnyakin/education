package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Introduction
 * Welcome Adventurer. Your aim is to navigate the maze and reach the finish point without touching any walls.
 * Doing so will kill you instantly!
 * Task
 * You will be given a 2D array of the maze and an array of directions. Your task is to follow the directions given.
 * If you reach the end point before all your moves have gone, you should return Finish. If you hit any walls or go
 * outside the maze border, you should return Dead. If you find yourself still in the maze after using all the moves,
 * you should return Lost.
 * The Maze array will look like
 * <p>
 * maze = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,3],
 * [1,0,1,0,1,0,1],
 * [0,0,1,0,0,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,2,1,0,1,0,1]]
 * ..with the following key
 * <p>
 * 0 = Safe place to walk
 * 1 = Wall
 * 2 = Start Point
 * 3 = Finish Point
 * direction = {"N","N","N","N","N","E","E","E","E","E"} == "Finish"
 * Rules
 * 1. The Maze array will always be square i.e. N x N but its size and content will alter from test to test.
 * <p>
 * 2. The start and finish positions will change for the final tests.
 * <p>
 * 3. The directions array will always be in upper case and will be in the format of N = North, E = East, W = West and S = South.
 * <p>
 * 4. If you reach the end point before all your moves have gone, you should return Finish.
 * <p>
 * 5. If you hit any walls or go outside the maze border, you should return Dead.
 * <p>
 * 6. If you find yourself still in the maze after using all the moves, you should return Lost.
 */
public class MazeRunner {

    public static final Integer WALL = 1;
    public static final Integer START_POINT = 2;
    public static final Integer FINISH_POINT = 3;

    public static String walk(int[][] maze, String[] directions) {
        int y = 0;
        int x = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                int pos = maze[i][j];
                if (pos == START_POINT) {
                    y = i;
                    x = j;
                }
            }
        }
        for (String direction : directions) {
            switch(direction) {
                case "N" -> y--;
                case "S" -> y++;
                case "W" -> x--;
                case "E" -> x++;
            }
            if (y >= maze.length || y < 0
                    || x >= maze[y].length || x < 0) {
                return "Dead";
            }
            int pos = maze[y][x];
            if (pos == FINISH_POINT) {
                return "Finish";
            } else if (pos == WALL) {
                return "Dead";
            }
        }
        return "Lost";
    }

    int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 3},
            {1, 0, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 2, 1, 0, 1, 0, 1}};

    @Test
    void testBasic() {
        assertEquals("Finish", MazeRunner.walk(maze, new String[]{"N", "N", "N", "N", "N", "E", "E", "E", "E", "E"}), "Expected Finish");
        assertEquals("Finish", MazeRunner.walk(maze, new String[]{"N", "N", "N", "N", "N", "E", "E", "S", "S", "E", "E", "N", "N", "E"}), "Expected Finish");
        assertEquals("Finish", MazeRunner.walk(maze, new String[]{"N", "N", "N", "N", "N", "E", "E", "E", "E", "E", "W", "W"}), "Expected Finish");

        assertEquals("Dead", MazeRunner.walk(maze, new String[]{"N", "N", "N", "W", "W"}), "Expected Dead");
        assertEquals("Dead", MazeRunner.walk(maze, new String[]{"N", "N", "N", "N", "N", "E", "E", "S", "S", "S", "S", "S", "S"}), "Expected Dead");

        assertEquals("Lost", MazeRunner.walk(maze, new String[]{"N", "E", "E", "E", "E"}), "Expected Lost");
    }

}
