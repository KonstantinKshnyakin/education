package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Story
 * The Pied Piper has been enlisted to play his magical tune and coax all the rats out of town.
 *
 * But some of the rats are deaf and are going the wrong way!
 *
 * Kata Task
 * How many deaf rats are there?
 *
 * Legend
 * P = The Pied Piper
 * O~ = Rat going left
 * ~O = Rat going right
 * Example
 * ex1 ~O~O~O~O P has 0 deaf rats
 *
 * ex2 P O~ O~ ~O O~ has 1 deaf rat
 *
 * ex3 ~O~O~O~OP~O~OO~ has 2 deaf rats
 *
 */
public class TheDeafRatsOfHamelin {

    public static int countDeafRats(final String town) {
        String[] split = town.replaceAll("[^~OP]", "").split("P");
        int result = 0;
        int length = split.length;
        if (length > 0) {
            result += getDeafRats(split[0], "O~");
            if (length == 2) {
                result += getDeafRats(split[1], "~O");
            }
        }
        return result;
    }

    private static Integer getDeafRats(String part, String deafRats) {
        int count = 0;
        for (int i = 0; i < part.length(); i+=2) {
            String x = part.substring(i, i + 2);
            if (deafRats.equals(x)) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void ex1() {
        assertEquals(0, countDeafRats("~O~O~O~O P"));
    }

    @Test
    public void ex2() {
        assertEquals(1, countDeafRats("P O~ O~ ~O O~"));
    }

    @Test
    public void ex3() {
//        assertEquals(2, countDeafRats("~O~O~O~OP~O~OO~"));
        assertEquals(3, countDeafRats("~O~O~O~OP~O~OO~~O"));
    }

}
