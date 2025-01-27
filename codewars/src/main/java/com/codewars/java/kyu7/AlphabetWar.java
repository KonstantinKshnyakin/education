package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**There is a war and nobody knows - the alphabet war!
 There are two groups of hostile letters. The tension between left side letters and right side letters was too high and the war began.

 Task
 Write a function that accepts fight string consists of only small letters and return who wins the fight. When the left
 side wins return Left side wins!, when the right side wins return Right side wins!, in other case return Let's fight again!.

 The left side letters and their power:

 w - 4
 p - 3
 b - 2
 s - 1
 The right side letters and their power:

 m - 4
 q - 3
 d - 2
 z - 1
 The other letters don't have power and are only victims.

 Example
 AlphabetWar("z");        //=> Right side wins!
 AlphabetWar("zdqmwpbs"); //=> Let's fight again!
 AlphabetWar("zzzzs");    //=> Right side wins!
 AlphabetWar("wwwwwwz");  //=> Left side wins!
 */
public class AlphabetWar {

    private static final Map<Character, Integer> LEFT = Map.of(
            'w', 4,
            'p', 3,
            'b', 2,
            's', 1
    );

    private static final Map<Character, Integer> RIGHT = Map.of(
            'm', 4,
            'q', 3,
            'd', 2,
            'z', 1
    );

    public static String alphabetWar(String fight) {
        char[] charArray = fight.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            Integer cLeft = LEFT.get(c);
            Integer cRight = RIGHT.get(c);
            if (cLeft != null) {
                sum += cLeft;
            } else if (cRight != null) {
                sum -= cRight;
            }
        }
        if (sum==0) {
            return "Let's fight again!";
        }
        return sum > 0 ? "Left side wins!" : "Right side wins!";
    }

    @Test
    public void BasicTest() {
        assertEquals("Right side wins!", alphabetWar("z"));
        assertEquals("Let's fight again!", alphabetWar("zdqmwpbs"));
        assertEquals("Right side wins!", alphabetWar("zzzzs"));
        assertEquals("Left side wins!", alphabetWar("wwwwwwz"));
    }

}
