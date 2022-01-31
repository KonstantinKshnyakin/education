package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Our football team finished the championship. The result of each match look like "x:y".
 * Results of all matches are recorded in the collection.
 *
 * For example: ["3:1", "2:2", "0:1", ...]
 *
 * Write a function that takes such collection and counts the points of our team in the championship.
 * Rules for counting points for each match:
 *
 * if x>y - 3 points
 * if x<y - 0 point
 * if x=y - 1 point
 * Notes:
 *
 * there are 10 matches in the championship
 * 0 <= x <= 4
 * 0 <= y <= 4
 */
public class TotalAmountOfPoints {

    public static int points(String[] games) {
        return Arrays.stream(games)
                .mapToInt(g -> {
                    if (g.length() < 3) {
                        throw new IllegalArgumentException();
                    }
                    char x = g.charAt(0);
                    char y = g.charAt(2);
                    if (!Character.isDigit(x) || !Character.isDigit(y)) {
                        throw new IllegalArgumentException();
                    }
                    if (x > y) {
                        return 3;
                    } else if (x < y) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .sum();
    }

    @Test
    public void basicTests() {
        assertEquals(30, points(new String[]
                {"1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"}));

        assertEquals(10, points(new String[]
                {"1:1","2:2","3:3","4:4","2:2","3:3","4:4","3:3","4:4","4:4"}));

        assertEquals(0, points(new String[]
                {"0:1","0:2","0:3","0:4","1:2","1:3","1:4","2:3","2:4","3:4"}));

        assertEquals(15, points(new String[]
                {"1:0","2:0","3:0","4:0","2:1","1:3","1:4","2:3","2:4","3:4"}));

        assertEquals(12, points(new String[]
                {"1:0","2:0","3:0","4:4","2:2","3:3","1:4","2:3","2:4","3:4"}));
    }
}
