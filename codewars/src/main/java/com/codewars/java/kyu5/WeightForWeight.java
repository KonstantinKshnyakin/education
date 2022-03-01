package com.codewars.java.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month a list
 * with the weights of members is published and each month he is the last on the list which means he is the heaviest.
 * <p>
 * I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list".
 * It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.
 * <p>
 * For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.
 * <p>
 * Given a string with the weights of FFC members in normal order
 * can you give this string ordered by "weights" of these numbers?
 * <p>
 * Example:
 * "56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
 * <p>
 * "100 180 90 56 65 74 68 86 99"
 * When two numbers have the same "weight", let us class them as
 * if they were strings (alphabetical ordering) and not numbers:
 * <p>
 * 180 is before 90 since, having the same "weight" (9), it comes before as a string.
 * <p>
 * All numbers in the list are positive numbers and the list can be empty.
 * <p>
 * Notes
 * it may happen that the input string have leading, trailing whitespaces and more than a unique whitespace
 * between two consecutive numbers
 * For C: The result is freed.
 * ALGORITHMSNUMBERS
 */
public class WeightForWeight {

    public static String orderWeight(String strng) {
        if (strng == null) {
            return null;
        } else if (strng.isBlank()) {
            return strng;
        }
        String[] split = strng.trim().split("\\s");
        List<NumberWeight> collect = Arrays.stream(split).map(NumberWeight::of).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            for (int j = i + 1; j < collect.size(); j++) {
                NumberWeight inw = collect.get(i);
                NumberWeight jnw = collect.get(j);
                if (inw.getWeight() > jnw.getWeight()) {
                    collect.set(j, inw);
                    collect.set(i, jnw);
                } else if (inw.getWeight() == jnw.getWeight()) {
                    if (inw.getNumberStr().compareTo(jnw.getNumberStr()) > 0) {
                        collect.set(j, inw);
                        collect.set(i, jnw);
                    }
                }
            }
        }
        return collect.stream()
                .map(nw -> nw.getNumberInt().toString())
                .collect(Collectors.joining(" "));
    }

    private static class NumberWeight {
        private final Long numberInt;
        private final String numberStr;
        private final Long weight;

        private NumberWeight(String numberStr, Long numberInt, Long weight) {
            this.numberInt = numberInt;
            this.numberStr = numberStr;
            this.weight = weight;
        }

        public static NumberWeight of(String numberStr) {
            Long numberInt = Long.parseLong(numberStr);
            Long weight = weight(numberInt);
            return new NumberWeight(numberStr, numberInt, weight);
        }

        private static Long weight(Long num) {
            long sum = 0L;
            while (num != 0) {
                sum += (num % 10);
                num /= 10;
            }
            return sum;
        }

        public Long getWeight() {
            return weight;
        }

        public Long getNumberInt() {
            return numberInt;
        }

        public String getNumberStr() {
            return numberStr;
        }

    }

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}
