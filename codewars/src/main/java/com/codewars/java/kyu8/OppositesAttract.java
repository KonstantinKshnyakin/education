package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Timmy & Sarah think they are in love, but around where they live, they will only know once they pick a flower each.
 * If one of the flowers has an even number of petals and the other has an odd number of petals it means they are in love.
 *
 * Write a function that will take the number of petals of each flower and return true
 * if they are in love and false if they aren't.
 */
public class OppositesAttract {

    public static boolean isLove(final int flower1, final int flower2) {
        return flower1 % 2 == 0 ^ flower2 % 2 == 0;
    }

    @Test
    public void testOddAndEven() {
        assertEquals(true, isLove(1, 4));
    }

    @Test
    public void testEvenAndEven() {
        assertEquals(false, isLove(2, 2));
    }

    @Test
    public void testOddAndOdd() {
        assertEquals(false, isLove(1, 1));
    }

    @Test
    public void testEvenAndOdd() {
        assertEquals(true, isLove(0, 1));
    }
}
