package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string)
 * of size sz (ignore the last chunk if its size is less than sz).
 *
 * If the sum of a chunk's digits is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position.
 * Put together these modified chunks and return the result as a string.
 *
 * If
 *
 * sz is <= 0 or if str == "" return ""
 * sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
 * Examples:
 * ("123456987654", 6) --> "234561876549"
 * ("123456987653", 6) --> "234561356789"
 * ("66443875", 4) --> "44668753"
 * ("66443875", 8) --> "64438756"
 * ("664438769", 8) --> "67834466"
 * ("123456779", 8) --> "23456771"
 * ("", 8) --> ""
 * ("123456779", 0) --> ""
 * ("563000655734469485", 4) --> "0365065073456944"
 */
public class RevRot {

    public static String revRot(String strng, int sz) {
        String result = "";
        if (sz == 0 || sz > strng.length()) {
            return result;
        }
        int index = sz;
        while (index <= strng.length()) {
            String numPart = strng.substring(index - sz, index);
            long sum = sum(numPart);
            if (sum % 2 == 0) {
                result += new StringBuilder(numPart).reverse().toString();
            } else {
                result += numPart.substring(1) + numPart.charAt(0);
            }
            index += sz;
        }
        return result;
    }

    private static long sum(String num) {
        BigInteger i = new BigInteger(num);
        int sum = 0;
        while (i.compareTo(BigInteger.ZERO) > 0) {
            sum += i.mod(BigInteger.valueOf(10)).intValue();
            i = i.divide(BigInteger.valueOf(10));
        }
        return sum;
    }

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests: revRot");
        testing(RevRot.revRot("1234", 0), "");
        testing(RevRot.revRot("", 0), "");
        testing(RevRot.revRot("1234", 5), "");
        String s = "733049910872815764";
        testing(RevRot.revRot(s, 5), "330479108928157");
        testing(RevRot.revRot("73304991087281576455176044327690580265896", 8), "1994033775182780067155464327690480265895");
    }

}
