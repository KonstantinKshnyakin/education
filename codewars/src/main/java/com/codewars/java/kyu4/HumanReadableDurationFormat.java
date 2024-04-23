package com.codewars.java.kyu4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanReadableDurationFormat {

    public static final List<String> TIME_POSTFIX = List.of(" second", " minute", " hour", " day", " year");
    public static final List<Integer> DIVIDERS = List.of(60, 60, 24, 365, 100);

    public static String formatDuration(int seconds) {
        int countAdd = 0;
        int index = 0;
        int time = seconds;
        StringBuilder result = new StringBuilder();
        while (time > 0) {
            int count = time % DIVIDERS.get(index);
            time /= DIVIDERS.get(index);
            if (count > 0) {
                String s = String.valueOf(count).concat(TIME_POSTFIX.get(index));
                if (count > 1) {
                    s = s.concat("s");
                }
                String postfix = getPostfix(countAdd);
                result.insert(0, s.concat(postfix));
                countAdd++;
            }
            index++;
        }
        return result.isEmpty() ? "now" : result.toString();
    }

    private static String getPostfix(int c) {
        String postfix;
        if (c == 0) {
            postfix = "";
        } else if (c == 1) {
            postfix = " and ";
        } else {
            postfix = ", ";
        }
        return postfix;
    }

    @Test
    public void exampleTests() {
        assertEquals("now", formatDuration(0));
        assertEquals("1 second", formatDuration(1));
        assertEquals("1 minute and 2 seconds", formatDuration(62));
        assertEquals("2 minutes", formatDuration(120));
        assertEquals("1 hour", formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", formatDuration(3662));
        assertEquals("4 days, 5 hours, 43 minutes and 42 seconds", formatDuration(366222));
        assertEquals("1 year, 58 days, 20 hours, 50 minutes and 12 seconds", formatDuration(36622212));
    }

}
