package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Trolls are attacking your comment section!
 * <p>
 * A common way to deal with this situation is to remove all of the vowels
 * from the trolls' comments, neutralizing the threat.
 * <p>
 * Your task is to write a function that takes a string and return a new string with all vowels removed.
 * <p>
 * For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
 * <p>
 * Note: for this kata y isn't considered a vowel.
 */
public class DisemvowelTrolls {

    public static String disemvowel(String str) {
        return str.replaceAll("[AEIOUaeiou]", "");
    }

    @Test
    public void FixedTests() {
        assertEquals("Ths wbst s fr lsrs LL!", disemvowel("This website is for losers LOL!")
        );
        assertEquals("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd", disemvowel(
                "No offense but,\nYour writing is among the worst I've ever read"));
        assertEquals("Wht r y,  cmmnst?", disemvowel("What are you, a communist?"));
    }

}
