package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given a string of n lines, each substring being n characters long: For example:
 *
 * s = "abcd\nefgh\nijkl\nmnop"
 *
 * We will study some transformations of this square of strings.
 *
 * rot(s):
 * Clock rotation 180 degrees.
 * rot(s) => "ponm\nlkji\nhgfe\ndcba"
 * selfie_and_rot(s) (or selfieAndRot or selfie-and-rot):
 * It is an initial string combined with its 180-degree clock-rotated version, interspersed with dots proportional
 * to the length of the segments, to better illustrate the rotation when printed.
 * s = "abcd\nefgh\nijkl\nmnop" -->
 * "abcd....\nefgh....\nijkl....\nmnop....\n....ponm\n....lkji\n....hgfe\n....dcba"
 * On printing, these functions work as follows:
 *
 * |rot             |selfie_and_rot
 * |abcd --> ponm   |abcd --> abcd....
 * |efgh     lkji   |efgh     efgh....
 * |ijkl     hgfe   |ijkl     ijkl....
 * |mnop     dcba   |mnop     mnop....
 *                            ....ponm
 *                            ....lkji
 *                            ....hgfe
 *                            ....dcba
 * Notice that the number of dots is the common length of "abcd", "efgh", "ijkl", "mnop".
 *
 * Task:
 * Write these two functions rot and selfie_and_rot
 * and
 *
 * high-order function oper(fct, s) where
 *
 * fct is the function of one variable f to apply to the string s (fct will be one of rot, selfie_and_rot)
 *
 * Examples:
 * s = "abcd\nefgh\nijkl\nmnop"
 * oper(rot, s) => "ponm\nlkji\nhgfe\ndcba"
 * oper(selfie_and_rot, s) => "abcd....\nefgh....\nijkl....\nmnop....\n....ponm\n....lkji\n....hgfe\n....dcba"
 * Notes:
 * The form of the parameter fct in oper changes according to the language. You can see each form according to the
 * language in "Your test cases".
 * It could be easier to take these katas from number (I) to number (IV)
 * Forthcoming katas will study other tranformations.
 *
 * Bash Note:
 * The input strings are separated by , instead of \n. The ouput strings should be separated by \r instead of \n.
 * See "Sample Tests".
 */
public class MovesInSquaredStrings {

    public static String rot(String strng) {
        return new StringBuilder(strng).reverse().toString();
    }

    public static String selfieAndRot(String strng) {
        String[] arr = strng.split("(?=\\n)");
        StringBuilder selfie = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String value = arr[i];
            int length = value.length();
            if (i != 0) {
                length -= 1;
            }
            selfie.append(value).append(".".repeat(length));
        }
        StringBuilder rot = new StringBuilder(selfie).reverse();
        return selfie.append("\n").append(rot).toString();
    }

    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests rot");
        testing(oper(MovesInSquaredStrings::rot, "fijuoo\nCqYVct\nDrPmMJ\nerfpBA\nkWjFUG\nCVUfyL"),
                "LyfUVC\nGUFjWk\nABpfre\nJMmPrD\ntcVYqC\nooujif");
        testing(oper(MovesInSquaredStrings::rot, "rkKv\ncofM\nzXkh\nflCB"),
                "BClf\nhkXz\nMfoc\nvKkr");

        System.out.println("Fixed Tests selfieAndRot");
        testing(oper(MovesInSquaredStrings::selfieAndRot, "xZBV\njsbS\nJcpN\nfVnP"),
                "xZBV....\njsbS....\nJcpN....\nfVnP....\n....PnVf\n....NpcJ\n....Sbsj\n....VBZx");
        testing(oper(MovesInSquaredStrings::selfieAndRot, "uLcq\nJkuL\nYirX\nnwMB"),
                "uLcq....\nJkuL....\nYirX....\nnwMB....\n....BMwn\n....XriY\n....LukJ\n....qcLu");
    }

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }
}
