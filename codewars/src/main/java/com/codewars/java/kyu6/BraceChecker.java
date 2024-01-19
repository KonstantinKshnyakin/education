package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Write a function that takes a string of braces, and determines if the order of the braces is valid.
 * It should return true if the string is valid, and false if it's invalid.
 * <p>
 * This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}.
 * Thanks to @arnedag for the idea!
 * <p>
 * All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
 * <p>
 * What is considered Valid?
 * A string of braces is considered valid if all braces are matched with the correct brace.
 */
public class BraceChecker {

    public static boolean isValid(String braces) {
        Stack<Character> brackets = new Stack<>();
        for (char br : braces.toCharArray()) {
            switch (br) {
                case '(' -> brackets.push(')');
                case '{' -> brackets.push('}');
                case '[' -> brackets.push(']');
                case ')', '}', ']' -> {
                    if (!brackets.isEmpty()) {
                        boolean equals = brackets.peek().equals(br);
                        if (equals) {
                            brackets.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return brackets.isEmpty();
    }

    @Test
    public void testValid() {
        assertTrue(isValid("()"));
        assertTrue(isValid("(){}[]"));
        assertTrue(isValid("([{}])"));
        assertTrue(isValid("{{{}}}"));
    }

    @Test
    public void testInvalid() {
        assertFalse(isValid("[(])"));
        assertFalse(isValid("(}"));
        assertFalse(isValid("}"));
        assertFalse(isValid("[({})](]"));
    }

//    public static boolean isValid(String braces) {
//        String[] split = braces.split("");
//        int isOpen1 = 0;
//        int isOpen2 = 0;
//        int isOpen3 = 0;
//        int closeCount = 1;
//        for (int i = 0; i < split.length; i++) {
//
//            switch (split[i]) {
//                case "(" -> {
//                    isOpen1 += 1;
//                    closeCount = 1;
//                }
//                case "{" -> {
//                    isOpen2 += 1;
//                    closeCount = 1;
//                }
//                case "[" -> {
//                    isOpen3 += 1;
//                    closeCount = 1;
//                }
//                case ")" -> {
//                    if (isOpen1 == 0) {
//                        return false;
//                    }
//                    isOpen1 -= 1;
//                    boolean b = "(".equals(split[i - closeCount]);
//                    if (!b) {
//                        return false;
//                    }
//                    closeCount += 2;
//                }
//                case "}" -> {
//                    if (isOpen2 == 0) {
//                        return false;
//                    }
//                    isOpen2 -= 1;
//                    boolean b = "{".equals(split[i - closeCount]);
//                    if (!b) {
//                        return false;
//                    }
//                    closeCount += 2;
//                }
//                case "]" -> {
//                    if (isOpen3 == 0) {
//                        return false;
//                    }
//                    isOpen3 -= 1;
//                    boolean b = "[".equals(split[i - closeCount]);
//                    if (!b) {
//                        return false;
//                    }
//                    closeCount += 2;
//                }
//            }
//
//        }
//        return isOpen1 == 0 && isOpen2 == 0 && isOpen3 == 0;
//    }

//    public static boolean isValid(String braces) {
//        String[] split = braces.split("");
//        int closeCount = 1;
//        int openCount = 0;
//        for (int i = 0; i < split.length; i++) {
//
//            switch (split[i]) {
//                case "(", "{", "[" -> openCount++;
//                case ")" -> {
//                    if (i > 0) {
//                        boolean b = "(".equals(split[i - closeCount]);
//                        if (!b) {
//                            return false;
//                        }
//                        openCount--;
//                        if (openCount == 0) {
//                            closeCount = 1;
//                        } else {
//                            closeCount += 2;
//                        }
//                    } else {
//                        return false;
//                    }
//
//                }
//                case "}" -> {
//                    if (i > 0) {
//                        boolean b = "{".equals(split[i - closeCount]);
//                        if (!b) {
//                            return false;
//                        }
//                        openCount--;
//                        if (openCount == 0) {
//                            closeCount = 1;
//                        } else {
//                            closeCount += 2;
//                        }
//                    } else {
//                        return false;
//                    }
//                }
//                case "]" -> {
//                    if (i > 0) {
//                        boolean b = "[".equals(split[i - closeCount]);
//                        if (!b) {
//                            return false;
//                        }
//                        openCount--;
//                        if (openCount == 0) {
//                            closeCount = 1;
//                        } else {
//                            closeCount += 2;
//                        }
//                    } else {
//                        return false;
//                    }
//                }
//            }
//
//        }
//        return true;
//    }

//    public static boolean isValid(String braces) {
//        String[] brackets = braces.split("");
//        int openIndex = 1;
//        int openCount = 0;
//        for (int i = 0; i < brackets.length; i++) {
//            switch (brackets[i]) {
//                case "(", "{", "[" -> openCount++;
//                case ")", "}", "]" -> {
//                    if (openCount > 0) {
//                        String openBrace = null;
//                        switch (brackets[i]) {
//                            case ")" -> openBrace = "(";
//                            case "}" -> openBrace = "{";
//                            case "]" -> openBrace = "[";
//                        }
//                        if (!openBrace.equals(brackets[i - openIndex])) {
//                            return false;
//                        }
//                        openCount--;
//                        if (openCount == 0) {
//                            openIndex = 1;
//                        } else {
//                            openIndex += 2;
//                        }
//                    } else {
//                        return false;
//                    }
//
//                }
//            }
//        }
//        return openCount == 0;
//    }

}
