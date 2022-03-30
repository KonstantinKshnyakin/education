package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Your task is to create a function that does four basic mathematical operations.
 * <p>
 * The function should take three arguments - operation(string/char), value1(number), value2(number).
 * The function should return result of numbers after applying the chosen operation.
 * <p>
 * Examples(Operator, value1, value2) --> output
 * ('+', 4, 7) --> 11
 * ('-', 15, 18) --> -3
 * ('*', 5, 5) --> 25
 * ('/', 49, 7) --> 7
 */
public class BasicMathematicalOperations {

    public static Integer basicMath(String op, int v1, int v2) {
        if (!List.of("*", "-", "+", "/").contains(op)) {
            throw new IllegalArgumentException(
                    "One of the operations must be passed to the input: \"*\", \"-\", \"+\", \"/\"");
        }
        if (op.equals("/") && v2 == 0) {
            throw new IllegalArgumentException("You can't divide by zero");
        }
        int result = 0;
        switch (op) {
            case "+":
                result = v1 + v2;
                break;
            case "-":
                result = v1 - v2;
                break;
            case "*":
                result = v1 * v2;
                break;
            case "/":
                result = v1 / v2;
                break;
        }
        return result;
    }

    @Test
    public void testBasics() {
        assertEquals(11, basicMath("+", 4, 7));
        assertEquals(-3, basicMath("-", 15, 18));
        assertEquals(25, basicMath("*", 5, 5));
        assertEquals(7, basicMath("/", 49, 7));
    }

}
