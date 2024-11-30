package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this kata, you will create a function, circle, that produces a string of some radius, according to certain
 * rules that will be explained shortly. Here is the output of circle when passed the integer 10:
 * <p>
      █████████
     ███████████
   ███████████████
   ███████████████
  █████████████████
 ███████████████████
 ███████████████████
 ███████████████████
 ███████████████████
 ███████████████████
 ███████████████████
 ███████████████████
 ███████████████████
 ███████████████████
  █████████████████
   ███████████████
   ███████████████
     ███████████
      █████████
 * (Note: For Python and Ruby users, this will use '#', rather than '█')
 * <p>
 * The circle consists of spaces, and the character \u2588. Note that this is a complete square of characters, so
 * the 'gaps' are filled with spaces. For instance, the last line of the above ends with the five characters "\u2588     ";
 * there are five spaces at the end.
 * <p>
 * All characters whose distance from the center is less than the given radius is defined as 'in the circle', hence the
 * character at that position should be filled with \u2588 rather than spaces. So, for instance, this is a circle of radius 2:
 * <p>
 * ███
 * ███
 * ███
 * Whilst this isn't very circle-y, this is what the rules expect.
 * <p>
 * Here are the edge-case rules; there are examples in the example test cases:
 * <p>
 * A negative radius should result in an empty string.
 * A radius of 0 should produce the string "\n:.
 * Any other result should end with \n.
 * <p>
 * Please note that the distance metric is Euclidean distance (the most common notion of distance) centered around
 * the middle of a character, where each character is of width and height exactly one.
 */
public class DrawCircle {

    public static final String NEXT_LINE = "\n";
    public static final String SQUARE = "\u2588";
    public static final String SPACE = " ";

    public static String circle(int radius) {
        if (radius == 0) {
            return NEXT_LINE;
        } else if (radius < 0) {
            return "";
        }
        ArrayDeque<String> lines = new ArrayDeque<>();
        for (int i = 0; i < radius; i++) {
            String line = getLine(radius, i);
            lines.add(line);
        }
        StringJoiner sj = new StringJoiner(NEXT_LINE, "", NEXT_LINE);
        lines.descendingIterator().forEachRemaining(sj::add);
        lines.removeFirst();
        lines.iterator().forEachRemaining(sj::add);
        return sj.toString();
    }

    private static String getLine(int radius, int i) {
        String line = "";
        double y = Math.pow(i, 2);
        for (int j = 1; j < radius * 2; j++) {
            double x = Math.pow(radius - j, 2);
            double length = Math.sqrt(x + y);
            if (length < radius) {
                line = line.concat(SQUARE);
            } else {
                line = line.concat(SPACE);
            }
        }
        return line;
    }

    @Test
    public void testNegativeRadiiReturnEmptyString() {
        assertEquals(circle(-1), "");
        assertEquals(circle(-321), "");
    }

    @Test
    public void testSmallRadii() {
        assertEquals("\n", circle(0));
        assertEquals("\u2588\n", circle(1));
        assertEquals("\u2588\u2588\u2588\n\u2588\u2588\u2588\n\u2588\u2588\u2588\n", circle(2));
    }

}
