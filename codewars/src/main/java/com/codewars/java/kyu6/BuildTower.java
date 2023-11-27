package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Build Tower
 * Build a pyramid-shaped tower, as an array/list of strings, given a positive integer number of floors.
 * A tower block is represented with "*" character.
 * <p>
 * For example, a tower with 3 floors looks like this:
 * <p>
 * [
 * "  *  ",
 * " *** ",
 * "*****"
 * ]
 */
public class BuildTower {

    public static String[] towerBuilder(int nFloors) {
        String[] result = new String[nFloors];
        int width = 2 * (nFloors - 1) + 1;
        for (int i = 0; i < nFloors; i++) {
            int countStar = (i * 2) + 1;
            int countSpace = (width - countStar) / 2;
            String spaces = " ".repeat(countSpace);
            String starts = "*".repeat(countStar);
            String res = spaces.concat(starts).concat(spaces);
            result[i] = res;
        }
        return result;
    }

    @Test
    public void basicTests() {
        assertEquals(String.join(",", "*"), String.join(",", towerBuilder(1)));
        assertEquals(String.join(",", " * ", "***"), String.join(",", towerBuilder(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", towerBuilder(3)));
    }

}
