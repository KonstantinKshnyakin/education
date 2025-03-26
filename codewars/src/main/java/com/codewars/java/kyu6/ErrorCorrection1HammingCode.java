package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Background information
 * The Hamming Code is used to correct errors, so-called bit flips, in data transmissions. Later in the description
 * follows a detailed explanation of how it works.
 * In this Kata we will implement the Hamming Code with bit length 3; this has some advantages and disadvantages:
 *
 * [ + ] It's simple to implement
 * [ + ] Compared to other versions of hamming code, we can correct more mistakes
 * [ - ] The size of the input triples
 * Task 1: Encode function
 * Implement the encode function, using the following steps:
 *
 * convert every letter of the text to its ASCII value; (ASCII value of space is 32)
 * convert ASCII values to 8-bit binary;
 * triple every bit;
 * concatenate the result;
 * For example:
 *
 * input: "hey"
 * --> 104, 101, 121                  // ASCII values
 * --> 01101000, 01100101, 01111001   // binary
 * --> 000111111000111000000000 000111111000000111000111 000111111111111000000111  // tripled
 * --> "000111111000111000000000000111111000000111000111000111111111111000000111"  // concatenated
 * Task 2: Decode function:
 * Check if any errors happened and correct them. Errors will be only bit flips, and not a loss of bits:
 *
 * 111 --> 101 : this can and will happen
 * 111 --> 11 : this cannot happen
 * Note: the length of the input string is also always divisible by 24 so that you can convert it to an ASCII value.
 *
 * Steps:
 *
 * Split the input into groups of three characters;
 * Check if an error occurred: replace each group with the character that occurs most often, e.g. 010 --> 0, 110 --> 1, etc;
 * Take each group of 8 characters and convert that binary number;
 * Convert the binary values to decimal (ASCII);
 * Convert the ASCII values to characters and concatenate the result
 * For example:
 *
 * input: "100111111000111001000010000111111000000111001111000111110110111000010111"
 * --> 100, 111, 111, 000, 111, 001, ...  // triples
 * -->  0,   1,   1,   0,   1,   0,  ...  // corrected bits
 * --> 01101000, 01100101, 01111001       // bytes
 * --> 104, 101, 121                      // ASCII values
 * --> "hey"
 */
public class ErrorCorrection1HammingCode {

    public static String encode(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i);
            String binaryString = Integer.toBinaryString(c);
            String pandingBinaryString = "%8s".formatted(binaryString).replace(" ", "0");
            String repeatBinaryString = repeat(pandingBinaryString);
            result.append(repeatBinaryString);
        }
        return result.toString();
    }

    private static String repeat(String binary) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            result.append(String.valueOf(binary.charAt(i)).repeat(3));
        }
        return result.toString();
    }

    public static String decode(String bits) {
        String[] bitArr = bits.split("(?<=\\G.{3})");
        StringBuilder symbol = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (String bit : bitArr) {
            char c = bit.charAt(0);
            if (c != bit.charAt(1)) {
                c = bit.charAt(2);
            }
            symbol.append(c);
            if (symbol.length() == 8) {
                result.append((char) Integer.parseInt(symbol.toString(), 2));
                symbol.setLength(0);
            }
        }
        return result.toString();
    }

    @Test
    public void test_encode_function() {
        assertEquals("000111111000111000000000000111111000000111000111000111111111111000000111", encode("hey"));
        assertEquals("000111000111000111000000000111111000111000000000000111111000000111000111000000111000000000000000000111000111000000111111000111111000000111000111000111111000111111111000000111111111000000111111000111111000000111000111000111111000111000000111000000111000000000000000000111111111000111000000000111111000111111111111000111111000111111000000000111111000000111000000000000111000000000000000000111111000111111000111000111111000000111000111000000111000000000000000000111111111000111000000000111111000111000000000000111111000000000000111000111111111000111000000000000111000000000000000000111111000111000000111000000111000000000000000000111111000000000111111000111111000000000000111000111111000111111111000000000111000000000000000000111111000000111000000000111111000111111111111000000111000000000000000000111111111000111000000000111111000111000000000000111111000111000000111000111111111000000111111000000111000000000000000000111111000111000111111000111111000000000000111000111111111000111000000000111111000000000000111", encode("The Sensei told me that i can do this kata"));
        assertEquals("000111000111000111000000000000111111000000111111000111111111000000111111000111111111000111000000", encode("T3st"));
        assertEquals("000111000111000111000000000000111111111111111111000111111111000000111111000111111111000111000000000000111000000000000111000000111000000111000111", encode("T?st!%"));
    }

    @Test
    public void test_decode_function() {
        assertEquals("hey", decode("100111111000111001000010000111111000000111001111000111110110111000010111"));
        assertEquals("The Sensei told me that i can do this kata", decode("000111000111000111000100000111111000111000001000000111111000000111000111000100111000000000000000000111000111000000111111000111111000000111000111000111111000111111111000000111111111000000111111000110111000010111000111000111111000111001000111000000111000000000000000000111111111000111000000000111111000111111111111000111111000111111000000000111111000000111000001000000111000000000001000000111111000111111000111000111111000000111000111000000111000000000000000000111111111000111000000000111111000111000000000000111111000000010000111000111111111000111000000000100111000000000000000000111111000111000000111000000111000000000000000000111111000000000111111000111111000000000000111000111111000111111111000000000111000000000000010000111111000000111000000000111111000111111110111000000111000000000000000000111111111000111000000000111111000111000000000000111111000111000000111000111111111000000111111000000111000000000000000000111111000111000111111000111111000000000000111000111111111000111000000000111111000000000000111"));
        assertEquals("T3st", decode("000111000111000111000001000000111111000000111111000111111111000000111011000111111111000111000000"));
        assertEquals("T?st!%", decode("000111000111000111000010000000111111111111011111000111111111000000111111000111101111000111000000000000111000000000000111000000111000000111000111"));
    }

}
