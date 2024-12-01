package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given a list/array which contains only integers (positive and negative). Your job is to sum only the numbers
 * that are the same and consecutive. The result should be one list.
 *
 * Extra credit if you solve it in one line. You can assume there is never an empty list/array and there will
 * always be an integer.
 *
 * Same meaning: 1 == 1
 *
 * 1 != -1
 *
 * #Examples:
 *
 * [1,4,4,4,0,4,3,3,1] # should return [1,12,0,4,6,1]
 *
 * """So as you can see sum of consecutives 1 is 1
 * sum of 3 consecutives 4 is 12
 * sum of 0... and sum of 2
 * consecutives 3 is 6 ..."""
 *
 * [1,1,7,7,3] # should return [2,14,3]
 * [-5,-5,7,7,12,0] # should return [-10,14,12,0]
 */
public class SumConsecutives {

    public static List<Integer> sumConsecutives(List<Integer> s) {
        ArrayList<Integer> result = new ArrayList<>();
        int num = s.get(0);
        int sum = s.get(0);
        for (int i = 1; i < s.size(); i++) {
            int currentNum = s.get(i);
            if (num == currentNum) {
                sum += currentNum;
            } else {
                result.add(sum);
                num = currentNum;
                sum = currentNum;
            }
        }
        result.add(sum);
        return result;
    }

    @Test
    public void test() {
        System.out.println("Basic Tests");
        List<Integer> i = Arrays.asList(1,4,4,4,0,4,3,3,1);
        List<Integer> o = Arrays.asList(1,12,0,4,6,1);
        System.out.println("Input: {1,4,4,4,0,4,3,3,1}");
        assertEquals(o, sumConsecutives(i));
        i = Arrays.asList(-5,-5,7,7,12,0);
        o = Arrays.asList(-10,14,12,0);
        System.out.println("Input: {-5,-5,7,7,12,0}");
        assertEquals(o, sumConsecutives(i));
    }

}
