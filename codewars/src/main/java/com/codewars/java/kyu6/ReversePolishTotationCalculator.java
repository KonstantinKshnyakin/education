package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Your job is to create a calculator which evaluates expressions in Reverse Polish notation.
 *
 * For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2) * 4) - 3 in normal notation) should evaluate to 14.
 *
 * For your convenience, the input is formatted such that a space is provided between every token.
 *
 * Empty expression should evaluate to 0.
 *
 * Valid operations are +, -, *, /.
 *
 * You may assume that there won't be exceptional situations (like stack underflow or division by zero).
 */
public class ReversePolishTotationCalculator {

    public double evaluate(String expr) {
        if (expr == null || expr.isBlank()) {
            return 0;
        }
        Deque<Double> nums = new ArrayDeque<>();
        for (String el : expr.split(" ")) {
            if (el.matches("^\\d.*")) {
                nums.add(Double.parseDouble(el));
            } else {
                Double pop1 = nums.pollLast();
                Double pop2 = nums.pollLast();
                if ("-".equals(el)) {
                    nums.add(pop2 - pop1);
                } else if ("+".equals(el)) {
                    nums.add(pop2 + pop1);
                } else if ("*".equals(el)) {
                    nums.add(pop2 * pop1);
                } else if ("/".equals(el)) {
                    nums.add(pop2 / pop1);
                }
            }
            System.out.println(nums);
        }
        return nums.pollLast();
    }

    @Test
    public void test1() {
        assertEquals(14, evaluate("5 1 2 + 4 * + 3 -"), 0);
    }

    @Test
    public void shouldWorkWithEmptyString() {
        assertEquals(0, evaluate(""), 0);
    }

    @Test
    public void shouldParseNumbers() {
        assertEquals(3, evaluate("3"), 0);
    }

    @Test
    public void shouldParseFloatNumbers() {
        assertEquals(3.5, evaluate("3.5"), 0);
    }

    @Test
    public void shouldSupportAddition() {
        assertEquals(4, evaluate("1 3 +"), 0);
    }

    @Test
    public void shouldSupportMultiplication() {
        assertEquals(3, evaluate("1 3 *"), 0);
    }

    @Test
    public void shouldSupportSubstraction() {
        assertEquals(-2, evaluate("1 3 -"), 0);
    }

    @Test
    public void shouldSupportDivision() {
        assertEquals(2, evaluate("4 2 /"), 0);
    }
}
