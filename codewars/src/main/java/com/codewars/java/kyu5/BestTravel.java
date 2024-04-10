package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * John and Mary want to travel between a few towns A, B, C ... Mary has on a sheet of paper a list of distances between
 * these towns. ls = [50, 55, 57, 58, 60]. John is tired of driving and he says to Mary that he doesn't want to drive
 * more than t = 174 miles and he will visit only 3 towns.
 * <p>
 * Which distances, hence which towns, they will choose so that the sum of the distances is the biggest possible
 * to please Mary and John?
 * <p>
 * Example:
 * With list ls and 3 towns to visit they can make a choice between: [50,55,57],[50,55,58],[50,55,60],[50,57,58],
 * [50,57,60],[50,58,60],[55,57,58],[55,57,60],[55,58,60],[57,58,60].
 * <p>
 * The sums of distances are then: 162, 163, 165, 165, 167, 168, 170, 172, 173, 175.
 * <p>
 * The biggest possible sum taking a limit of 174 into account is then 173 and the distances of the 3 corresponding
 * towns is [55, 58, 60].
 * <p>
 * The function chooseBestSum (or choose_best_sum or ... depending on the language) will take as parameters t
 * (maximum sum of distances, integer >= 0), k (number of towns to visit, k >= 1) and ls (list of distances, all
 * distances are positive or zero integers and this list has at least one element). The function returns the "best"
 * sum ie the biggest possible sum of k distances less than or equal to the given limit t, if that sum exists, or
 * otherwise nil, null, None, Nothing, depending on the language. In that case with C, C++, D, Dart, Fortran, F#,
 * Go, Julia, Kotlin, Nim, OCaml, Pascal, Perl, PowerShell, Reason, Rust, Scala, Shell, Swift return -1.
 * <p>
 * Examples:
 * ts = [50, 55, 56, 57, 58] choose_best_sum(163, 3, ts) -> 163
 * <p>
 * xs = [50] choose_best_sum(163, 3, xs) -> nil (or null or ... or -1 (C++, C, D, Rust, Swift, Go, ...)
 * <p>
 * ys = [91, 74, 73, 85, 73, 81, 87] choose_best_sum(230, 3, ys) -> 228
 * <p>
 * Notes:
 */
public class BestTravel {

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        if (ls.size() < k) {
            return null;
        }
        Set<Integer> allSum = sum(0, 0, k - 1, ls);
        Integer result = -1;
        for (Integer sum : allSum) {
            if (sum == t) {
                return sum;
            } else if (sum > result && sum < t) {
                result = sum;
            }
        }
        return result == -1 ? null : result;
    }

    private static Set<Integer> sum(Integer value, int start, int end, List<Integer> ls) {
        Set<Integer> allSum = new HashSet<>();
        if (end > 0) {
            for (int i = start; i < ls.size() - end; i++) {
                int sum = value + ls.get(i);
                Set<Integer> sums = sum(sum, i + 1, end - 1, ls);
                allSum.addAll(sums);
            }
            return allSum;
        } else {
            for (int i = start; i < ls.size() - end; i++) {
                int sum = value + ls.get(i);
                allSum.add(sum);
            }
            return allSum;
        }
    }

    @Test
    public void BasicTests1() {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts;
        int n;

        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = chooseBestSum(331, 2, ts);
        assertEquals(178, n);


        ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        n = chooseBestSum(163, 3, ts);
        assertEquals(163, n);

        ts = new ArrayList<>(Arrays.asList(50));
        Integer m = chooseBestSum(163, 3, ts);
        assertEquals(null, m);

        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = chooseBestSum(230, 3, ts);
        assertEquals(228, n);
    }

//    private static List<List<Integer>> sum(List<Integer> values, int start, int end, List<Integer> ls) {
//        if (values == null || start == 0) {
//            values = new ArrayList<>();
//        }
//        List<List<Integer>> sums2 = new ArrayList<>();
//        if (end > 0) {
//            for (int i = start; i < ls.size() - end; i++) {
//                ArrayList<Integer> list = new ArrayList<>(values);
//                list.add(ls.get(i));
//                List<List<Integer>> sum = sum(list, i + 1, end - 1, ls);
//                sums2.addAll(sum);
//            }
//            return sums2;
//        } else {
//            for (int i = start; i < ls.size() - end; i++) {
//                ArrayList<Integer> list = new ArrayList<>(values);
//                list.add(ls.get(i));
//                sums2.add(list);
//            }
//            return sums2;
//        }
//    }

}
