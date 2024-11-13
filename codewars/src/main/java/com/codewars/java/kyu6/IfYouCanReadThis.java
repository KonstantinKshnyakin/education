package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Task
 * You'll have to translate a string to Pilot's alphabet (NATO phonetic alphabet).
 * <p>
 * Input:
 * <p>
 * If, you can read?
 * <p>
 * Output:
 * <p>
 * India Foxtrot , Yankee Oscar Uniform Charlie Alfa November Romeo Echo Alfa Delta ?
 * <p>
 * Note:
 * <p>
 * There is a preloaded dictionary that you can use, named NATO. It uses uppercase keys, e.g. NATO['A'] is "Alfa".
 * See comments in the initial code to see how to access it in your language.
 * The set of used punctuation is ,.!?.
 * Punctuation should be kept in your return string, but spaces should not.
 * Xray should not have a dash within.
 * Every word and punctuation mark should be seperated by a space ' '.
 * There should be no trailing whitespace
 */
public class IfYouCanReadThis {

    public static final Map<Character, String> NATO = Map.ofEntries(
            entry('A', "Alfa"),
            entry('B', "Bravo"),
            entry('C', "Charlie"),
            entry('D', "Delta"),
            entry('E', "Echo"),
            entry('F', "Foxtrot"),
            entry('G', "Golf"),
            entry('H', "Hotel"),
            entry('I', "India"),
            entry('J', "Juliett"),
            entry('K', "Kilo"),
            entry('L', "Lima"),
            entry('M', "Mike"),
            entry('N', "November"),
            entry('O', "Oscar"),
            entry('P', "Papa"),
            entry('Q', "Quebec"),
            entry('R', "Romeo"),
            entry('S', "Sierra"),
            entry('T', "Tango"),
            entry('U', "Uniform"),
            entry('V', "Victor"),
            entry('W', "Whiskey"),
            entry('X', "Xray"),
            entry('Y', "Yankee"),
            entry('Z', "Zulu"),
            entry(',', ","),
            entry('.', "."),
            entry('!', "!"),
            entry('?', "?")
    );

    public static String toNATO(String string) {
        String up = string.trim().replaceAll(" ", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < up.length(); i++) {
            char c = up.charAt(i);
            String s = NATO.getOrDefault(c, "");
            sb.append(s);
            if (i != up.length() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Test
    void sampleTests() {
        doTest(
                "If you can read",
                "India Foxtrot Yankee Oscar Uniform Charlie Alfa November Romeo Echo Alfa Delta"
        );
        doTest(
                "Did not see that coming",
                "Delta India Delta November Oscar Tango Sierra Echo Echo Tango Hotel Alfa Tango Charlie Oscar Mike India November Golf"
        );
        doTest(
                "go for it!",
                "Golf Oscar Foxtrot Oscar Romeo India Tango !"
        );
        doTest(
                "the five boxing wizards jump quickly.",
                "Tango Hotel Echo Foxtrot India Victor Echo Bravo Oscar Xray India November Golf Whiskey India Zulu Alfa Romeo Delta Sierra Juliett Uniform Mike Papa Quebec Uniform India Charlie Kilo Lima Yankee ."
        );
        doTest(
                "PACK MY BOX WITH FIVE DOZEN LIQUOR JUGS?",
                "Papa Alfa Charlie Kilo Mike Yankee Bravo Oscar Xray Whiskey India Tango Hotel Foxtrot India Victor Echo Delta Oscar Zulu Echo November Lima India Quebec Uniform Oscar Romeo Juliett Uniform Golf Sierra ?"
        );
        doTest(
                "  p ? u . n  c t u  , a t i o n  ! ",
                "Papa ? Uniform . November Charlie Tango Uniform , Alfa Tango India Oscar November !"
        );
    }

    private static void doTest(String input, String expected) {
        String actual = toNATO(input);
        assertEquals(expected, actual, "for string: <" + input + ">\n");
    }

}
