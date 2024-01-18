package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create a function which answers the question "Are you playing banjo?".
 * If your name starts with the letter "R" or lower case "r", you are playing banjo!
 */
public class AreYouPlayingBanjo {

    public static String areYouPlayingBanjo(String name) {
        if (name.matches("^(?i)r.*")) {
            return "%s plays banjo".formatted(name);
        }
        return "%s does not play banjo".formatted(name);
    }

    @Test
    public void PeopleThatPlayBanjo() {
        assertEquals( "Martin does not play banjo", areYouPlayingBanjo("Martin"));
        assertEquals( "Rikke plays banjo", areYouPlayingBanjo("Rikke"));
        assertEquals( "rolf plays banjo", areYouPlayingBanjo("rolf"));
        assertEquals( "bravo does not play banjo", areYouPlayingBanjo("bravo"));
    }

}
