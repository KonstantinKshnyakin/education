package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Prior to having fancy iPhones, teenagers would wear out their thumbs sending SMS messages on candybar-shaped
 * feature phones with 3x4 numeric keypads.
 *
 * ------- ------- -------
 * |     | | ABC | | DEF |
 * |  1  | |  2  | |  3  |
 * ------- ------- -------
 * ------- ------- -------
 * | GHI | | JKL | | MNO |
 * |  4  | |  5  | |  6  |
 * ------- ------- -------
 * ------- ------- -------
 * |PQRS | | TUV | | WXYZ|
 * |  7  | |  8  | |  9  |
 * ------- ------- -------
 * ------- ------- -------
 * |  *  | |space| |  #  |
 * |     | |  0  | |     |
 * ------- ------- -------
 * Prior to the development of T9 systems (predictive text entry), the method to type words was called 'multi-tap' and
 * involved pressing a button repeatedly to cycle through all its possible values, in order. For example:
 *
 * Pressing the button 7 repeatedly will cycle through the letters P -> Q -> R -> S -> 7 -> P -> ....
 * Pressing the button 0 is cycling through SPACE -> 0 -> SPACE -> 0 -> ....
 * Buttons with a single symbol on it just type this symbol.
 * A character is 'locked in' and inserted into the message once the user presses a different key or pauses for a short
 * period of time (thus, no extra button presses are required beyond what is needed for each letter individually).
 *
 * For example:
 * To type a letter 'R' you would press the 7 key three times (as the screen display for the current character cycles
 * through P->Q->R->S->7).
 * To type in a digit 3, you would press the button 3 four times.
 * To type in the message 'ABC', you would press the button 2 once, wait a second, then press the button 2 twice to
 * enter the letter B, then pause for another second, and press the button 2 three times, to enter the letter C.
 * You would have to press the button 2 six times in total.
 * In order to send the message 'WHERE DO U WANT 2 MEET L8R' a teen would have to actually do 47 button presses.
 * No wonder they abbreviated...
 *
 * For this assignment, write code that can calculate the amount of button presses required for any phrase,
 * with the following requirements:
 *
 * Punctuation can be ignored for this exercise.
 * Likewise, the phone doesn't distinguish between upper and lowercase characters (but you should allow your module
 * to accept input in either form, for convenience).
 * Tested phrases contain letters (A-Z and a-z), digits (0-9), and special characters # and *.
 */
public class MultiTapKeypadTextEntryOnAnOldMobilePhone {

    private static final Map<Character, Integer> NUMBER_TAP_BY_CHAR = new HashMap<>() {{

        put('1', 1); put('a', 1); put('d', 1); 
                     put('b', 2); put('e', 2); 
                     put('c', 3); put('f', 3); 
                     put('2', 4); put('3', 4);
                     
        put('g', 1); put('j', 1); put('m', 1);
        put('h', 2); put('k', 2); put('n', 2);
        put('i', 3); put('l', 3); put('o', 3);
        put('4', 4); put('5', 4); put('6', 4);

        put('p', 1); put('t', 1); put('w', 1);
        put('q', 2); put('u', 2); put('x', 2);
        put('r', 3); put('v', 3); put('y', 3);
        put('s', 4); put('8', 4); put('z', 4);
        put('7', 5);            ; put('9', 5);
        
        put('*', 1); put(' ', 1); put('#', 1);
                     put('0', 2);
    }};

    public static int presses(String phrase) {
        int result = 0;
        for (int i = 0; i < phrase.length(); i++) {
            char c = Character.toLowerCase(phrase.charAt(i));
            result += NUMBER_TAP_BY_CHAR.get(c);
        }
        return result;
    }

    @Test
    public void simpleTest() {
        assertEquals(9, presses("LOL"));
        assertEquals(13, presses("HOW R U"));
    }

}
