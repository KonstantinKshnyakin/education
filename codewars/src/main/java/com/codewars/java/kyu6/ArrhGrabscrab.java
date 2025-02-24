package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pirates have notorious difficulty with enunciating. They tend to blur all the letters together and scream at people.
 *
 * At long last, we need a way to unscramble what these pirates are saying.
 *
 * Write a function that will accept a jumble of letters as well as a dictionary, and output a list of words
 * that the pirate might have meant.
 *
 * For example:
 *
 * grabscrab( "ortsp", ["sport", "parrot", "ports", "matey"] )
 * Should return ["sport", "ports"].
 *
 * Return matches in the same order as in the dictionary. Return an empty array if there are no matches.
 *
 */
public class ArrhGrabscrab {

    public static List<String> grabscrab(String pirateWord, List<String> words){
        List<String> result = new ArrayList<>();
        Map<Integer, Long> pirateCount = toCountMap(pirateWord);
        for (String word : words) {
            if (pirateWord.length() == word.length()) {
                Map<Integer, Long> wordCount = toCountMap(word);
                if (pirateCount.hashCode() == wordCount.hashCode() && pirateCount.equals(wordCount)) {
                    result.add(word);
                }
            }
        }
        return result;
    }

    private static Map<Integer, Long> toCountMap(String s) {
        return s.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    static private String[][][] DATA = {
            //    anagram       words_as_array                       expected_as_array
            {{"trisf"},     {"first"},                             {"first"}},
            {{"oob"},       {"bob", "baobab"},                     {}},
            {{"ainstuomn"}, {"mountains", "hills", "mesa"},        {"mountains"}},
            {{"oolp"},      {"donkey", "pool", "horse", "loop"},   {"pool", "loop"}},
            {{"ortsp"},     {"sport", "parrot", "ports", "matey"}, {"sport", "ports"}},
            {{"ourf"},      {"one","two","three"},                 {}}
    };

    @Test
    void fixed_tests() {
        for(String[][] data: DATA){
            var anagram = data[0][0];
            var words   = Arrays.stream(data[1]).collect(Collectors.toList());
            var exp     = Arrays.stream(data[2]).collect(Collectors.toList());
            var msg     = String.format("Testing \"%s\" against %s", anagram, words);
            var actual  = grabscrab(anagram,words);
            assertEquals(exp, actual, msg);
        }
    }

}
