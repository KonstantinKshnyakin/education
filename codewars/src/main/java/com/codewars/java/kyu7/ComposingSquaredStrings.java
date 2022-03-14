package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A squared string is a string of n lines, each substring being n characters long.
 * We are given two n-squared strings. For example:
 *
 * s1 = "abcd\nefgh\nijkl\nmnop" s2 = "qrst\nuvwx\nyz12\n3456"
 *
 * Let us build a new string strng of size (n + 1) x n in the following way:
 *
 * The first line of strng has the first char of the first line of s1 plus the chars of the last line of s2.
 * The second line of strng has the first two chars of the second line of s1 plus the chars
 * of the penultimate line of s2 except the last char
 * and so on until the nth line of strng has the n chars of the nth line of s1 plus the first char of the first line of s2.
 * Calling this function compose(s1, s2) we have:
 *
 * compose(s1, s2) -> "a3456\nefyz1\nijkuv\nmnopq"
 * or printed:
 * abcd    qrst  -->  a3456
 * efgh    uvwx       efyz1
 * ijkl    yz12       ijkuv
 * mnop    3456       mnopq
 */
public class ComposingSquaredStrings {

    public static String compose(String s1, String s2) {
        if (Objects.isNull(s1) || Objects.isNull(s2)) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        String[] arr1 = s1.split("\\s");
        String[] arr2 = s2.split("\\s");
        if (s1.length() != s2.length() || arr1.length != arr2.length) {
            throw new IllegalArgumentException("Line lengths should be equal");
        }
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < arr1.length; i++) {
            String str1 = arr1[i];
            String str2 = arr2[arr2.length - 1 - i];
            String sub1 = str1.substring(0, i + 1);
            String sub2 = str2.substring(0, str2.length() - i);
            sj.add(sub1.concat(sub2));
        }
        return sj.toString();
    }


    @Test
    public void test() {
        assertEquals("bNkTB\nhTrWO\nRTFVi\nCnnIj", compose("byGt\nhTts\nRTFF\nCnnI", "jIRl\nViBu\nrWOb\nNkTB"));
        assertEquals("HgYPW\nTGGbM\nIPhqt\nuUMDH", compose("HXxA\nTGBf\nIPhg\nuUMD", "Hcbj\nqteH\nGbMJ\ngYPW"));
        assertEquals("tzlYf\nOOmYF\nsqPEZ\nxMkBh", compose("tSrJ\nOONy\nsqPF\nxMkB", "hLqw\nEZuh\nmYFl\nzlYf"));
    }
}
