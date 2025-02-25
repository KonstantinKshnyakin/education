package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function that takes in a binary string and returns the equivalent decoded text (the text is ASCII encoded).
 *
 * Each 8 bits on the binary string represent 1 character on the ASCII table.
 *
 * The input string will always be a valid binary string.
 *
 * Characters can be in the range from "00000000" to "11111111" (inclusive)
 *
 * Note: In the case of an empty binary string your function should return an empty string.
 */
public class BinaryToTextASCIIConversion {

    public static String binaryToText(String binary) {
        if (binary.isBlank()) {
            return binary;
        }
        String[] strBytes = binary.split("(?<=\\G.{8})");
        StringBuilder sb = new StringBuilder();
        for (String strByte : strBytes) {
            byte b = Byte.valueOf(strByte, 2);
            sb.append((char) b);
        }
        return sb.toString();
    }

    @Test
    public void testHello() {
        assertEquals(
                "Hello",
                binaryToText("0100100001100101011011000110110001101111"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(
                "",
                binaryToText(""));
    }

}
