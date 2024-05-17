package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Common denominators
 *
 * You will have a list of rationals in the form
 *
 * { {numer_1, denom_1} , ... {numer_n, denom_n} }
 * or
 * [ [numer_1, denom_1] , ... [numer_n, denom_n] ]
 * or
 * [ (numer_1, denom_1) , ... (numer_n, denom_n) ]
 * where all numbers are positive ints. You have to produce a result in the form:
 *
 * (N_1, D) ... (N_n, D)
 * or
 * [ [N_1, D] ... [N_n, D] ]
 * or
 * [ (N_1', D) , ... (N_n, D) ]
 * or
 * {{N_1, D} ... {N_n, D}}
 * or
 * "(N_1, D) ... (N_n, D)"
 * depending on the language (See Example tests) in which D is as small as possible and
 *
 * N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.
 * Example:
 * convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]
 * Note:
 * Due to the fact that the first translations were written long ago - more than 6 years - these first translations
 * have only irreducible fractions.
 *
 * Newer translations have some reducible fractions. To be on the safe side it is better to do a bit more work by
 * simplifying fractions even if they don't have to be.
 *
 * Note for Bash:
 * input is a string, e.g "2,4,2,6,2,8" output is then "6 12 4 12 3 12"
 */
public class CommonDenominators {

    public static String convertFrac(long[][] lst) {
        simplify(lst);
        long lcm = leastCommonMultiple(lst);
        return Arrays.stream(lst)
                .map(e -> {
                    long m = lcm / e[1];
                    return "(%d,%d)".formatted(e[0] * m, lcm);
                })
                .collect(Collectors.joining());
    }

    private static long leastCommonMultiple(long[][] lst) {
        long max = Arrays.stream(lst).mapToLong(i -> i[1]).max().orElse(1);
        long lcm = max;
        boolean isFound = false;

        while (!isFound) {
            long lcmL = lcm;
            if (Arrays.stream(lst).mapToLong(i -> i[1]).allMatch(i -> lcmL % i == 0)) {
                isFound = true;
            } else {
                lcm += max;
            }
        }
        return lcm;
    }

    private static void simplify(long[][] lst) {
        for (int i = 0; i < lst.length; i++) {
            long[] arr = lst[i];
            long e0 = arr[0];
            for (long j = e0; j > 1; j--) {
                long e1 = arr[1];
                if (e0 % j == 0 && e1 % j == 0) {
                    lst[i] = new long[]{e0 / j, e1 / j};
                    break;
                }
            }
        }
    }

    @Test
    public void test_fractions() throws Exception {
        long[][] lst;
        lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };
        assertEquals("(6,12)(4,12)(3,12)", convertFrac(lst));
    }

}
