package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringIncrementer {

    public static String incrementString(String str) {
        String[] split = str.replaceAll("^(.*(?=\\d))((?<!\\d)[0-9]*)$", "$1 $2").split(" ");
        long size = split.length;
        if (size == 2) {
            String i = getIncrementNum(split[1]);
            return split[0] + i; // you code here
        } else if (size == 1 && str.matches("[0-9]+")) {
                return getIncrementNum(str);
        }
        return str + 1;
    }

    private static String getIncrementNum(String number) {
        BigInteger num = new BigInteger(number, 10).add(BigInteger.ONE);
        if (number.startsWith("0")) {
            String format = "%0" + number.length() + "d";
            return format.formatted(num);
        }
        return String.valueOf(num);
    }

    @Test
    public void exampleTests() {
        doTest("foobar099", "foobar100");
        doTest("foobar99", "foobar100");
        doTest("foo", "foo1");
        doTest("Lo|Q*v\"wv\"V)G<JCbSeYP^P!nN6857225861880512965145303892", "Lo|Q*v\"wv\"V)G<JCbSeYP^P!nN6857225861880512965145303893");
        doTest("ckDEjXs!NQ$0PnMw|e]e)0{yM(7&~;so0000000000000000000088743770376", "ckDEjXs!NQ$0PnMw|e]e)0{yM(7&~;so0000000000000000000088743770377");
        doTest("fo99obar99", "fo99obar100");
        doTest("foobar000", "foobar001");
        doTest("foobar001", "foobar002");
        doTest("1", "2");
        doTest("", "1");
    }

    private static void doTest(String str, String expected) {
        String actual = assertDoesNotThrow(() -> incrementString(str), "Solution thrown an unexpected exception for str=\"" + str + "\"\n\n");
        assertEquals(expected, actual, "Incorrect answer for str=\"" + str + "\"\n\n");
    }

}
