package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Your car is old, it breaks easily. The shock absorbers are gone and you think it can handle about 15 more
 * bumps before it dies totally.
 *
 * Unfortunately for you, your drive is very bumpy! Given a string showing either flat road (_) or bumps (n).
 * If you are able to reach home safely by encountering 15 bumps or less, return Woohoo!, otherwise return Car Dead
 */
public class BumpsInRoad {

    public static String bumps(final String road) {
        return road.replaceAll("[^n]", "").length() > 15 ? "Car Dead" : "Woohoo!";
    }

    @Test
    public void basicTest() {
        assertEquals("Woohoo!", bumps("n"));
        assertEquals("Woohoo!", bumps("__nn_nnnn__n_n___n____nn__nnn"));
        assertEquals("Woohoo!", bumps("nnn_n__n_n___nnnnn___n__nnn__"));
        assertEquals("Car Dead", bumps("_nnnnnnn_n__n______nn__nn_nnn"));
        assertEquals("Woohoo!", bumps("______n___n_"));
        assertEquals("Car Dead", bumps("nnnnnnnnnnnnnnnnnnnnn"));
    }
}
