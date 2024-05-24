package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Everyone knows passphrases. One can choose passphrases from poems, songs, movies names and so on but frequently
 * they can be guessed due to common cultural references. You can get your passphrases stronger by different means.
 * One is the following:
 *
 * choose a text in capital letters including or not digits and non alphabetic characters,
 *
 * shift each letter by a given number but the transformed letter must be a letter (circular shift),
 * replace each digit by its complement to 9,
 * keep such as non alphabetic and non digit characters,
 * downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
 * reverse the whole result.
 * Example:
 * your text: "BORN IN 2015!", shift 1
 *
 * 1 + 2 + 3 -> "CPSO JO 7984!"
 *
 * 4 "CpSo jO 7984!"
 *
 * 5 "!4897 Oj oSpC"Everyone knows passphrases. One can choose passphrases from poems, songs, movies names and so on
 * but frequently they can be guessed due to common cultural references. You can get your passphrases stronger
 * by different means. One is the following:
 *
 * choose a text in capital letters including or not digits and non alphabetic characters,
 *
 * shift each letter by a given number but the transformed letter must be a letter (circular shift),
 * replace each digit by its complement to 9,
 * keep such as non alphabetic and non digit characters,
 * downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
 * reverse the whole result.
 * Example:
 * your text: "BORN IN 2015!", shift 1
 *
 * 1 + 2 + 3 -> "CPSO JO 7984!"
 *
 * 4 "CpSo jO 7984!"
 *
 * 5 "!4897 Oj oSpC"Everyone knows passphrases. One can choose passphrases from poems, songs, movies names and so on
 * but frequently they can be guessed due to common cultural references. You can get your passphrases stronger
 * by different means. One is the following:
 *
 * choose a text in capital letters including or not digits and non alphabetic characters,
 *
 * shift each letter by a given number but the transformed letter must be a letter (circular shift),
 * replace each digit by its complement to 9,
 * keep such as non alphabetic and non digit characters,
 * downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
 * reverse the whole result.
 * Example:
 * your text: "BORN IN 2015!", shift 1
 *
 * 1 + 2 + 3 -> "CPSO JO 7984!"
 *
 * 4 "CpSo jO 7984!"
 *
 * 5 "!4897 Oj oSpC"Everyone knows passphrases. One can choose passphrases from poems, songs, movies names and
 * so on but frequently they can be guessed due to common cultural references. You can get your passphrases
 * stronger by different means. One is the following:
 *
 * choose a text in capital letters including or not digits and non alphabetic characters,
 *
 * shift each letter by a given number but the transformed letter must be a letter (circular shift),
 * replace each digit by its complement to 9,
 * keep such as non alphabetic and non digit characters,
 * downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
 * reverse the whole result.
 * Example:
 * your text: "BORN IN 2015!", shift 1
 *
 * 1 + 2 + 3 -> "CPSO JO 7984!"
 *
 * 4 "CpSo jO 7984!"
 *
 * 5 "!4897 Oj oSpC"
 */
public class PlayingWithPassphrases {

    public static String playPass(String s, int n) {
        char[] arr = s.toLowerCase().toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = transform(n, arr[i], i);
            res.append(c);
        }
        return res.toString();
    }

    private static char transform(int n, char ch, int j) {
        if (Character.isDigit(ch)) {
            int digit = 9 - Character.digit(ch, 10);
            return Character.forDigit(digit, 10);
        } else if (Character.isAlphabetic(ch)) {
            char c = (char) (ch + n);
            if (((int) c) > 122) {
                c = (char) (96 + (c - 122));
            }
            if (j % 2 == 0) {
                return Character.toUpperCase(c);
            }
            return Character.toLowerCase(c);
        }
        return ch;
    }

    @Test
    public void test1() {
        assertEquals("!!!vPz fWpM J", playPass("I LOVE YOU!!!", 1));
    }

    @Test
    public void test4() {
        assertEquals("4897 NkTrC Hq fT67 GjV Pq aP OqTh gOcE CoPcTi aO",
                playPass("MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015", 2));
    }

}
