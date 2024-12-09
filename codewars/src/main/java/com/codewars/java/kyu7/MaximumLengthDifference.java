package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given two arrays a1 and a2 of strings. Each string is composed with letters from a to z. Let x be any
 * string in the first array and y be any string in the second array.
 *
 * Find max(abs(length(x) − length(y)))
 *
 * If a1 and/or a2 are empty return -1 in each language except in Haskell (F#) where you will return Nothing (None).
 *
 * Example:
 * a1 = ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"]
 * a2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"]
 * mxdiflg(a1, a2) --> 13
 */
public class MaximumLengthDifference {

    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1.length == 0 || a2.length == 0) {
            return -1;
        }
        IntSummaryStatistics statistics1 = Stream.of(a1).mapToInt(String::length).summaryStatistics();
        IntSummaryStatistics statistics2 = Stream.of(a2).mapToInt(String::length).summaryStatistics();
        int max1 = statistics1.getMax() - statistics2.getMin();
        int max2 = statistics2.getMax() - statistics1.getMin();
        return Math.max(max1, max2);
    }

    @Test
    public void test() {
        System.out.println("mxdiflg Fixed Tests");
        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        assertEquals(13, mxdiflg(s1, s2)); // 13

        String[] s12 = new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"};
        String[] s22 = new String[]{"bbbaaayddqbbrrrv"};
        assertEquals(10, mxdiflg(s12, s22));

        String[] s13 = new String[]{"sspeeeetttgwww"};
        String[] s23 = new String[]{"mmmmss", "fsaaaaa", "ttttfffkkklllllss", "lvdduu", "bbblllxx"};
        assertEquals(8, mxdiflg(s13, s23));
    }

}
