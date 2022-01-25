package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.
 * <p>
 * Rules for a smiling face:
 * <p>
 * Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
 * A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
 * Every smiling face must have a smiling mouth that should be marked with either ) or D
 * No additional characters are allowed except for those mentioned.
 * <p>
 * Valid smiley face examples: :) :D ;-D :~)
 * Invalid smiley faces: ;( :> :} :]
 * <p>
 * Example
 * countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
 * countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
 * countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;
 * <p>
 * Note
 * In case of an empty array return 0. You will not be tested with invalid input (input will always be an array).
 * Order of the face (eyes, nose, mouth) elements will always be the same.
 */
public class CountSmileyFaces {

    public static int countSmileys(List<String> arr) {
        return (int) arr.stream()
                .filter(s -> s.matches("[:;]{1}[-~]?[)D]{1}"))
                .count();
    }

    @Test
    public void test1() {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add(":D");
        a.add(":-}");
        a.add(":-()");
        assertEquals(2, countSmileys(a));
    }

    @Test
    public void test2() {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add("XD");
        a.add(":0}");
        a.add("x:-");
        a.add("):-");
        a.add("D:");
        assertEquals(1, countSmileys(a));
    }

    @Test
    public void test4() {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add(":D");
        a.add("X-}");
        a.add("xo)");
        a.add(":X");
        a.add(":-3");
        a.add(":3");
        assertEquals(2, countSmileys(a));
    }

    @Test
    public void test5() {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add(":)");
        a.add("x-]");
        a.add(":ox");
        a.add(";-(");
        a.add(";-)");
        a.add(";~(");
        a.add(":~D");
        assertEquals(4, countSmileys(a));
    }

}
