package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The word i18n is a common abbreviation of internationalization in the developer community, used instead of typing
 * the whole word and trying to spell it correctly. Similarly, a11y is an abbreviation of accessibility.
 *
 * Write a function that takes a string and turns any and all "words" (see below) within that string of length 4 or
 * greater into an abbreviation, following these rules:
 *
 * A "word" is a sequence of alphabetical characters. By this definition, any other character like a space
 * or hyphen (eg. "elephant-ride") will split up a series of letters into two words (eg. "elephant" and "ride").
 * The abbreviated version of the word should have the first letter, then the number of removed characters, then
 * the last letter (eg. "elephant ride" => "e6t r2e").
 */
public class Worda10nAbbreviation {

    public String abbreviate(String string) {
        Pattern pattern = Pattern.compile("([a-z])([a-z]{2,})([a-z])", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);

        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (matcher.find()) {
            String str = matcher.group(1) + matcher.group(2).length() + matcher.group(3);
            String x =  string.substring(start, matcher.start()) + str;
            sb.append(x);
            start = matcher.end();
        }
        sb.append(string.substring(start));
        return sb.toString();
    }

    @Test
    public void testInternationalization() {
        assertEquals("i18n", abbreviate("internationalization"));
        assertEquals("d4e-b6d: a, is, the m8c-mat. b5n", abbreviate("double-barreled: a, is, the monolithic-mat. balloon"));
        assertEquals("mat, cat. b5n: s2s'the; is_m8c_b5n, the", abbreviate("mat, cat. balloon: sits'the; is_monolithic_balloon, the"));
        assertEquals("the. on-a; sat; m8c-a5b5n", abbreviate("the. on-a; sat; monolithic-a5balloon"));
    }

}
