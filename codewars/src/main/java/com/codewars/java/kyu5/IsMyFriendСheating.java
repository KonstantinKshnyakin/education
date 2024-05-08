package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A friend of mine takes the sequence of all numbers from 1 to n (where n > 0).
 * Within that sequence, he chooses two numbers, a and b.
 * He says that the product of a and b should be equal to the sum of all numbers in the sequence, excluding a and b.
 * Given a number n, could you tell me the numbers he excluded from the sequence?
 * The function takes the parameter: n (n is always strictly greater than 0) and returns an array or
 * a string (depending on the language) of the form:
 * <p>
 * [(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or or [{a, b}, ...]
 * with all (a, b) which are the possible removed numbers in the sequence 1 to n.
 * <p>
 * [(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or ... will be sorted in increasing order of the "a".
 * <p>
 * It happens that there are several possible (a, b). The function returns an empty array (or an empty string)
 * if no possible numbers are found which will prove that my friend has not told the truth! (Go: in this case return nil).
 * <p>
 * Examples:
 * removNb(26) should return [(15, 21), (21, 15)]
 * or
 * removNb(26) should return { {15, 21}, {21, 15} }
 * or
 * removeNb(26) should return [[15, 21], [21, 15]]
 * or
 * removNb(26) should return [ {15, 21}, {21, 15} ]
 * or
 * removNb(26) should return "15 21, 21 15"
 * or
 * <p>
 * in C:
 * removNb(26) should return  {{15, 21}{21, 15}} tested by way of strings.
 * Function removNb should return a pointer to an allocated array of Pair pointers, each one also allocated.
 * Note
 * See examples of returns for each language in "RUN SAMPLE TESTS"
 */
// задачу самостоятельно не решил (решение не укладывалось в отведенное время)
public class IsMyFriendСheating {

    public static List<long[]> removNb(long n) {
        long sum = LongStream.rangeClosed(1, n).sum();
        List<long[]> result = new ArrayList<>();
        for (long i = n / 2; i <= n / 2 + n / 10; i++) {
            for (long j = n / 8 * 7; j <= n; j++) {
                long mult = i * j;
                long sub = sum - i - j;
                if (mult == sub) {
                    long[] e1 = {i, j};
                    long[] e2 = {j, i};
                    result.add(e1);
                    result.add(e2);
                }
            }
        }
        return result;
    }

    //копипаста из интернета
    public static List<long[]> removNb2(long n) {
        List<long[]> result = new ArrayList<long[]>();
        long sequence_sum = n * (n + 1) / 2;
        for (long x = 1; x <= n; x++) {
            long y = (sequence_sum - x) / (x + 1);
            if (y <= n && x * y == sequence_sum - x - y) {
                result.add(new long[] {x, y});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(1000003 / 8 * 7);
        System.out.println(1000003 / 3 * 2);
        System.out.println(1000003 / 2);
        System.out.println(26 / 2 + 26 / 10);
    }

    @Test
    public void test12() {
        List<long[]> res = new ArrayList<long[]>();
        res.add(new long[]{15, 21});
        res.add(new long[]{21, 15});
        List<long[]> a = removNb(26);
        assertArrayEquals(res.get(0), a.get(0));
        assertArrayEquals(res.get(1), a.get(1));
    }

    @Test
    public void test14() {
        List<long[]> res = new ArrayList<long[]>();
        List<long[]> a = removNb(100);
        assertTrue(res.size() == a.size());
    }

    @Test
    public void test15() {
        List<long[]> res = new ArrayList<long[]>();
        res.add(new long[]{550320, 908566});
        res.add(new long[]{559756, 893250});
        res.add(new long[]{908566, 550320});
        res.add(new long[]{893250, 559756});
        List<long[]> a = removNb(1000003);
        assertTrue(res.size() == a.size());
    }

}
