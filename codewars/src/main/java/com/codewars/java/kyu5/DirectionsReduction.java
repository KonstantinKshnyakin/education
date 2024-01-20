package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Once upon a time, on a way through the old wild mountainous west,…
 * … a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.
 * <p>
 * Going to one direction and coming back the opposite direction right away is a needless effort. Since this is the wild west, with dreadful weather and not much water, it's important to save yourself some energy, otherwise you might die of thirst!
 * <p>
 * How I crossed a mountainous desert the smart way.
 * The directions given to the man are, for example, the following (depending on the language):
 * <p>
 * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
 * or
 * { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
 * or
 * [North, South, South, East, West, North, West]
 * You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place!
 * So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:
 * <p>
 * ["WEST"]
 * or
 * { "WEST" }
 * or
 * [West]
 * Other examples:
 * In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.
 * <p>
 * The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).
 * <p>
 * In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become
 * directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
 * <p>
 * Task
 * Write a function dirReduc which will take an array of strings and returns an array of strings with the needless
 * directions removed (W<->E or S<->N side by side).
 * <p>
 * The Haskell version takes a list of directions with data Direction = North | East | West | South.
 * The Clojure version returns nil when the path is reduced to nothing.
 * The Rust version takes a slice of enum Direction {North, East, West, South}.
 * See more examples in "Sample Tests:"
 * Notes
 * Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible.
 * "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other
 * and can't become such. Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
 * if you want to translate, please ask before translating.
 */
public class DirectionsReduction {

    public static String[] dirReduc(String[] arr) {
        int lastSize = -1;
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        while (list.size() != lastSize) {
            lastSize = list.size();
            for (int i = 0; i < list.size() - 1; i++) {
                String first = list.get(i);
                String second = list.get(i + 1);
                if (first.equals("NORTH") && second.equals("SOUTH") ||
                        first.equals("SOUTH") && second.equals("NORTH") ||
                        first.equals("EAST") && second.equals("WEST") ||
                        first.equals("WEST") && second.equals("EAST")) {
                    list.remove(i);
                    list.remove(i);
                    i--;
                }
            }
        }
        return list.toArray(String[]::new);
    }

    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals(
                new String[]{"WEST"},
                dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals(
                new String[]{},
                dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}));
        assertArrayEquals(
                new String[]{},
                dirReduc(new String[]{"NORTH", "SOUTH", "NORTH", "SOUTH"}));
    }

//    public static String[] dirReduc(String[] arr) {
//        boolean isSorted = true;
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
//        ArrayList<String> res = new ArrayList<>();
//        while (isSorted) {
//            for (int i = 0; i < list.size(); i++) {
//                if (i < list.size() - 1) {
//                    String first = list.get(i);
//                    String second = list.get(i + 1);
//                    if (first.equals("NORTH") && second.equals("SOUTH") ||
//                            first.equals("SOUTH") && second.equals("NORTH") ||
//                            first.equals("EAST") && second.equals("WEST") ||
//                            first.equals("WEST") && second.equals("EAST")) {
//                        i++;
//                    } else {
//                        res.add(first);
//                    }
//                } else {
//                    res.add(list.get(list.size() - 1));
//                }
//            }
//            if (list.size() == res.size()) {
//                isSorted = false;
//            } else {
//                list.clear();
//                list.addAll(res);
//                res.clear();
//            }
//        }
//        return res.toArray(String[]::new);
//    }

}
