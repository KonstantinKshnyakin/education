package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You have to sort the inner content of every word of a string in descending order.
 *
 * The inner content is the content of a word without first and the last char.
 *
 * Some examples:
 *
 * "sort the inner content in descending order"  -->  "srot the inner ctonnet in dsnnieedcg oredr"
 * "wait for me"        -->  "wiat for me"
 * "this kata is easy"  -->  "tihs ktaa is esay"
 * Words are made up of lowercase letters.
 *
 * The string will never be null and will never be empty. In C/C++ the string is always nul-terminated.
 *
 * Have fun coding it and please don't forget to vote and rank this kata! :-)
 *
 * I have also created other katas. Take a look if you enjoyed this kata!
 */
public class SrotTheInnerCtonnetInDsnnieedcgOredr {

    public static String sortTheInnerContent(String words) {
        String[] arr = words.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (s.length() > 3) {
                arr[i] = sort(s);
            }
        }
        return String.join(" ", arr);
    }

    private static String sort(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        char[] chars = str.substring(1, str.length() - 1).toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        sb.append(chars);
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }

    @Test
    public void exampleTests() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr", sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me", sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", sortTheInnerContent("this kata is easy"));
    }

}
