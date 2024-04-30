package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Encrypt this!
 *
 * You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:
 *
 * Your message is a string containing space separated words.
 * You need to encrypt each word in the message using the following rules:
 * The first letter must be converted to its ASCII code.
 * The second letter must be switched with the last letter
 * Keepin' it simple: There are no special characters in the input.
 */
public class EncryptThis {

    public static String encryptThis(String text) {
        if (text == null || text.isBlank()) {
            return text;
        }
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = word.charAt(0);
            if (word.length() > 2) {
                char second = word.charAt(1);
                String middle = word.substring(2, word.length() - 1);
                char last = word.charAt(word.length() - 1);
                word = "" + first + last + middle + second;
            }
            words[i] = (int)first + word.substring(1);
        }
        return String.join(" ", words);
    }

    @Test
    public void exampleTests() {
        assertEquals("", encryptThis(""));
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", encryptThis("A wise old owl lived in an oak"));
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", encryptThis("The more he saw the less he spoke"));
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", encryptThis("The less he spoke the more he heard"));
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", encryptThis("Why can we not all be like that wise old bird"));
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", encryptThis("Thank you Piotr for all your help"));
    }

}
