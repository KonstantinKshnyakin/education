package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
 * The function should return true if the string is valid, and false if it's invalid.
 * <p>
 * Examples
 * "()"              =>  true
 * ")(()))"          =>  false
 * "("               =>  false
 * "(())((()())())"  =>  true
 * Constraints
 * 0 <= input.length <= 100
 * <p>
 * Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters.
 * Furthermore, the input string may be empty and/or not contain any parentheses at all.
 * Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).
 */
public class ValidParentheses {

    public static boolean validParentheses(String parens) {
        char[] chars = parens.toCharArray();
        int k = -1;
        boolean b = true;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                c2++;
            }
            if (chars[i] == '(') {
                b = false;
                if (i >= k) {
                    k = i + 1;
                }
                for (int j = k; j < chars.length; j++) {
                    if (chars[j] == ')') {
                        c1++;
                        k = j + 1;
                        b = true;
                        break;
                    }
                }
            }
        }
        return b && c1 == c2;
    }

    @Test
    public void sampleTest() {
        assertFalse(validParentheses("()()=q_vqop_A("));
        assertFalse(validParentheses("())("));
        assertFalse(validParentheses(")()(((()))"));
        assertFalse(validParentheses("T)sN()(p,kL<\\(=((;)5))-;"));
        assertTrue(validParentheses("()"));
        assertTrue(validParentheses("(())((()())())"));
        assertFalse(validParentheses("())))))))"));
        assertTrue(validParentheses("32423(sgsdg)"));
        assertFalse(validParentheses("(dsgdsg))2432"));
        assertTrue(validParentheses("adasdasfa"));
    }

}
