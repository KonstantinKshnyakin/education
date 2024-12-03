package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Make a program that filters a list of strings and returns a list with only your friends name in it.
 *
 * If a name has exactly 4 letters in it, you can be sure that it has to be a friend of yours! Otherwise,
 * you can be sure he's not...
 *
 * Input = ["Ryan", "Kieran", "Jason", "Yous"]
 * Output = ["Ryan", "Yous"]
 *
 * Input = ["Peter", "Stephen", "Joe"]
 * Output = []
 * Input strings will only contain letters.
 * Note: keep the original order of the names in the output.
 */
public class FriendOrFoe {

    public static List<String> friend(List<String> x){
        return x.stream()
                .filter(n -> n.length() == 4)
                .toList();
    }

    @Test
    void testFriend() {
        assertEquals(List.of("Ryan", "Yous"), friend(List.of("Ryan", "Kieran", "Jason", "Yous")), "Input: [\"Ryan\", \"Kieran\", \"Jason\", \"Yous\"]");
        assertEquals(List.of(), friend(List.of("Peter", "Stephen", "Joe")), "Input: [\"Peter\", \"Stephen\", \"Joe\"]");
    }

}
