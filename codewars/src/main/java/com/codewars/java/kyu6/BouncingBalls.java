package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A child is playing with a ball on the nth floor of a tall building. The height of this floor above ground level, h, is known.
 *
 * He drops the ball out of the window. The ball bounces (for example), to two-thirds of its height (a bounce of 0.66).
 *
 * His mother looks out of a window 1.5 meters from the ground.
 *
 * How many times will the mother see the ball pass in front of her window (including when it's falling and bouncing)?
 *
 * Three conditions must be met for a valid experiment:
 * Float parameter "h" in meters must be greater than 0
 * Float parameter "bounce" must be greater than 0 and less than 1
 * Float parameter "window" must be less than h.
 * If all three conditions above are fulfilled, return a positive integer, otherwise return -1.
 *
 * Note:
 * The ball can only be seen if the height of the rebounding ball is strictly greater than the window parameter.
 */
public class BouncingBalls {

    public static int bouncingBall(double h, double bounce, double window) {
        if (h <= 0 || (bounce <= 0 || bounce >= 1) || window >= h) {
            return -1;
        }
        double height = h * bounce;
        int count = 1;
        while (height > window) {
            count += 2;
            height *= bounce;
        }
        return count;
    }

    @Test
    public void test1() {
        assertEquals(3, bouncingBall(3.0, 0.66, 1.5));
    }
    @Test
    public void test2() {
        assertEquals(15, bouncingBall(30.0, 0.66, 1.5));
    }

    @Test
    public void test3() {
        assertEquals(-1, bouncingBall(3, 1, 1.5));
    }

    @Test
    public void test4() {
        assertEquals(-1, bouncingBall(3.0, 0.75, 3.0));
    }

}
