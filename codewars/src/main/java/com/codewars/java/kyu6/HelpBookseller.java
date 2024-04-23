package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A bookseller has lots of books classified in 26 categories labeled A, B, ... Z.
 * Each book has a code c of 3, 4, 5 or more characters. The 1st character of a code is a capital letter
 * which defines the book category.
 * <p>
 * In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which
 * indicates the quantity of books of this code in stock.
 * <p>
 * For example an extract of a stocklist could be:
 * <p>
 * L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
 * or
 * L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"] or ....
 * You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :
 * <p>
 * M = {"A", "B", "C", "W"}
 * or
 * M = ["A", "B", "C", "W"] or ...
 * and your task is to find all the books of L with codes belonging to each category of M and to sum their quantity
 * according to each category.
 * <p>
 * For the lists L and M of example you have to return the string (in Haskell/Clojure/Racket/Prolog a list of pairs):
 * <p>
 * (A : 20) - (B : 114) - (C : 50) - (W : 0)
 * where A, B, C, W are the categories, 20 is the sum of the unique book of category A, 114 the sum corresponding
 * to "BKWRK" and "BTSQZ", 50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.
 * <p>
 * If L or M are empty return string is "" (Clojure/Racket/Prolog should return an empty array/list instead).
 */
public class HelpBookseller {

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt == null || lstOfArt.length == 0
                || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }
        Map<String, Integer> map = Stream.of(lstOf1stLetter)
                .collect(Collectors.toMap(Function.identity(), i -> 0, (v1, v2) -> v2, LinkedHashMap::new));
        for (int i = 0; i < lstOfArt.length; i++) {
            String category = lstOfArt[i].substring(0, 1);
            String quantity = lstOfArt[i].split(" ")[1];
            map.computeIfPresent(category, (k, v) -> v + Integer.parseInt(quantity));
        }
        return map.entrySet().stream()
                .map(e -> "(%s : %s)".formatted(e.getKey(), e.getValue()))
                .collect(Collectors.joining(" - "));
    }

    @Test
    public void test1() {
        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[]{"A", "B"};
        assertEquals("(A : 200) - (B : 1140)", stockSummary(art, cd));


        art = new String[]{"ROXANNE 102", "RHODODE 123", "BKWRKAA 125", "BTSQZFG 239", "DRTYMKH 060"};
        cd = new String[]{"B", "R", "D", "X"};
        assertEquals("(B : 364) - (R : 225) - (D : 60) - (X : 0)", stockSummary(art, cd));
    }
}
