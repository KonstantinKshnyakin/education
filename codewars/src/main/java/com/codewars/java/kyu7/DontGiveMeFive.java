package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Don't give me five!
 * In this kata you get the start number and the end number of a region and should return the count of
 * all numbers except numbers with a 5 in it. The start and the end number are both inclusive!
 *
 * Examples:
 *
 * 1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
 * 4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12
 * The result may contain fives. ;-)
 * The start number will always be smaller than the end number. Both numbers can be also negative!
 */
public class DontGiveMeFive {

    public static int dontGiveMeFive(int start, int end) {
        System.out.println("start:" + start);
        System.out.println("end:" + end);
        int result = 0;
        for (int i = start; i <= end; i++) {
            if (hasFive(i)) {
                System.out.println("continue 5:" + i);
                continue;
            }
            result++;
        }
        return result;
    }

    private static boolean hasFive(int n) {
        while (n != 0) {
            if (Math.abs(n) % 10 == 5) {
                return true;
            }
            n = n / 10;
        }
        return false;
    }

    @Test
    public void exampleTests() {
        assertEquals(8, dontGiveMeFive(1,9));
        assertEquals(12, dontGiveMeFive(4,17));
        assertEquals(13, dontGiveMeFive(4,18));
        assertEquals(18, dontGiveMeFive(5,25));
        assertEquals(58, dontGiveMeFive(-49,15));
        assertEquals(72, dontGiveMeFive(1,90));
        assertEquals(136, dontGiveMeFive(70,230));
        assertEquals(0, dontGiveMeFive(501,555));
    }

//    public static int dontGiveMeFive(int start, int end) {
//        System.out.println("start:" + start);
//        System.out.println("end:" + end);
//        int result = 0;
//        for (int i = start; i <= end; i++) {
//            if (Math.abs(i) % 10 == 5) {
//                System.out.println("continue 5:" + i);
//                continue;
//            }
//            int j = i % 50;
//            if (i > 9 && j >=  0 && j <= 9 && Math.abs(i / 50) % 2 == 1) {
//                System.out.println("continue 50:" + i);
//                continue;
//            }
//            result++;
//        }
//        return result;
//    }
}
