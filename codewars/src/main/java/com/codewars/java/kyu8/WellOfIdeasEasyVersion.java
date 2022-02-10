package com.codewars.java.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WellOfIdeasEasyVersion {

    public static String well(String[] x) {
        long countGood = Stream.of(x)
                .filter("good"::equalsIgnoreCase)
                .count();
        if (countGood > 0 && countGood <= 2) {
            return "Publish!";
        } else if (countGood > 2) {
            return "I smell a series!";
        }
        return "Fail!";
    }

    @Test
    public void basicTests() {
        assertEquals("Fail!", well(new String[]{"bad", "bad", "bad"}));
        assertEquals("Publish!", well(new String[]{"good", "bad", "bad", "bad", "bad"}));
        assertEquals("I smell a series!", well(new String[]{
                "good", "bad", "bad", "bad", "bad", "good", "bad", "bad", "good"}));
    }

}
