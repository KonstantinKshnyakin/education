package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Complete the solution so that the function will break up camel casing, using a space between words.
 *
 * Example
 * "camelCasing"  =>  "camel Casing"
 * "identifier"   =>  "identifier"
 * ""             =>  ""
 */
public class BreakCamelcase {

    public static String camelCase(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }

    @Test
    public void tests() {
        assertEquals( "camel Casing", camelCase("camelCasing"));
        assertEquals( "camel Casing Test", camelCase("camelCasingTest"));
        assertEquals( "camelcasingtest", camelCase("camelcasingtest"));
    }

}
