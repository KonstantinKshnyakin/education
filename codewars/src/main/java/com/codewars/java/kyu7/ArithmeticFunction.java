package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two numbers and an arithmetic operator (the name of it, as a string), return the result of the two numbers having that operator used on them.
 *
 * a and b will both be positive integers, and a will always be the first number in the operation, and b always the second.
 *
 * The four operators are "add", "subtract", "divide", "multiply".
 */
public class ArithmeticFunction {

    public static int arithmetic(int a, int b, String operator) {
        return switch (operator) {
            case "add" -> a + b;
            case "subtract" -> a - b;
            case "multiply" -> a * b;
            case "divide" -> a / b;
            default -> throw new IllegalArgumentException("Illegal operator " + operator);
        };
    }

    @Test
    public void testBasic() {
        assertEquals(3, ArithmeticFunction.arithmetic(1, 2, "add"));
        assertEquals(6, ArithmeticFunction.arithmetic(8, 2, "subtract"));
        assertEquals(10, ArithmeticFunction.arithmetic(5, 2, "multiply"));
        assertEquals(4, ArithmeticFunction.arithmetic(8, 2, "divide"));
    }

}
