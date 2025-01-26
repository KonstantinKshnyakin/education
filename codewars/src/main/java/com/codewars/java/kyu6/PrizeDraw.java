package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * To participate in a prize draw each one gives his/her firstname.
 * Each letter of a firstname has a value which is its rank in the English alphabet. A and a have rank 1, B and b rank
 * 2 and so on.
 * The length of the firstname is added to the sum of these ranks hence a number som.
 * An array of random weights is linked to the firstnames and each som is multiplied by its corresponding weight to
 * get what they call a winning number.
 * <p>
 * Example:
 * names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
 * weights: [1, 4, 4, 5, 2, 1]
 * <p>
 * PauL -> som = length of firstname + 16 + 1 + 21 + 12 = 4 + 50 -> 54
 * The *weight* associated with PauL is 2 so PauL's *winning number* is 54 * 2 = 108.
 * Now one can sort the firstnames in decreasing order of the winning numbers. When two people have the same winning
 * number sort them alphabetically by their firstnames.
 * <p>
 * Task:
 * parameters: st a string of firstnames, we an array of weights, n a rank
 * return: the firstname of the participant whose rank is n (ranks are numbered from 1)
 * <p>
 * Example:
 * names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
 * weights: [1, 4, 4, 5, 2, 1]
 * n: 4
 * The function should return: "PauL"
 * <p>
 * Notes:
 * The weight array is at least as long as the number of names, it may be longer.
 * If st is empty return "No participants".
 * If n is greater than the number of participants then return "Not enough participants".
 * See Examples Test Cases for more examples.
 */
public class PrizeDraw {

    public static class Participant2 implements Comparable<Participant2> {

        private final String name;
        private final Integer scoreWeight;
        private final Integer winningNumber;

        public Participant2(String name, int scoreWeight) {
            this.name = name;
            this.scoreWeight = scoreWeight;
            this.winningNumber = calculateWinningNumber();
        }

        @Override
        public int compareTo(Participant2 o) {
            return o.getWinningNumber().compareTo(this.getWinningNumber());
        }

        public Integer getWinningNumber() {
            return winningNumber;
        }

        public String getName() {
            return name;
        }

        private Integer calculateWinningNumber() {
            return calculateNameWeight() * this.scoreWeight;
        }

        private Integer calculateNameWeight() {
            return this.name.toLowerCase().chars()
                    .map(c -> c - 96)
                    .sum() + this.name.length();
        }

    }

    public static String nthRank2(String st, Integer[] we, int n) {
        if (st.isEmpty()) {
            return "No participants";
        }
        String[] participants = st.split(",");
        if (participants.length < n) {
            return "Not enough participants";
        }
        ArrayList<Participant2> list = new ArrayList<>();
        for (int i = 0; i < participants.length; i++) {
            String name = participants[i];
            Integer scoreWeight = we[i];
            list.add(new Participant2(name, scoreWeight));
        }
        Collections.sort(list);
        return list.get(n - 1).getName();
    }

    public record Participant(String name, Integer winningNumber) {}

    public static String nthRank(String st, Integer[] we, int n) {
        if (st.isEmpty()) {
            return "No participants";
        }
        String[] participants = st.split(",");
        if (participants.length < n) {
            return "Not enough participants";
        }
        ArrayList<Participant> list = new ArrayList<>();
        for (int i = 0; i < participants.length; i++) {
            int sum = 0;
            String name = participants[i];
            for (int j = 0; j < name.length(); j++) {
                char c = name.charAt(j);
                if (Character.isUpperCase(c)) {
                    sum += c - 64;
                } else {
                    sum += c - 96;
                }
            }
            sum = (sum + name.length()) * we[i];
            list.add(new Participant(name, sum));
        }
        list.sort(Comparator.comparingInt(Participant::winningNumber).reversed().thenComparing(Participant::name));
        return list.get(n - 1).name();
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests");
        String st = "";
        Integer[] we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("No participants", nthRank(st, we, 4));
        st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
        we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("Not enough participants", nthRank(st, we, 8));
        st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
        we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("Benjamin", nthRank(st, we, 4));
        st = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
        we = new Integer[]{1, 3, 5, 5, 3, 6};
        assertEquals("Matthew", nthRank(st, we, 2));
        st = "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH";
        we = new Integer[]{1, 4, 4, 5, 2, 1};
        assertEquals("PauL", nthRank(st, we, 4));
    }

}
