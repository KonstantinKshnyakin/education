package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * There is a war...between alphabets!
 * There are two groups of hostile letters. The tension between left side letters and right side letters was too high
 * and the war began. The letters called airstrike to help them in war - dashes and dots are spread throughout
 * the battlefield. Who will win?
 *
 * Task
 * Write a function that accepts a fight string which consists of only small letters and * which represents a bomb
 * drop place. Return who wins the fight after bombs are exploded. When the left side wins return Left side wins!,
 * and when the right side wins return Right side wins!. In other cases, return Let's fight again!.
 *
 * The left side letters and their power:
 *
 *  w - 4
 *  p - 3
 *  b - 2
 *  s - 1
 * The right side letters and their power:
 *
 *  m - 4
 *  q - 3
 *  d - 2
 *  z - 1
 * The other letters don't have power and are only victims.
 * The * bombs kill the adjacent letters ( i.e. aa*aa => a___a, **aa** => ______ );
 *
 * Example (Input --> Output)
 * "s*zz"           --> "Right side wins!"
 * "*zd*qm*wp*bs*"  --> "Let's fight again!"
 * "zzzz*s*"        --> "Right side wins!"
 * "www*www****z"   --> "Left side wins!"
 */
public class AlphabetWarAirstrikeLettersMassacre {

    public static final Map<Character, Integer> POWER = Map.of(
            //left
            'w', 4,
            'p', 3,
            'b', 2,
            's', 1,
            //right
            'm', -4,
            'q', -3,
            'd', -2,
            'z', -1
    );

    public static String alphabetWar(String fight) {
        String s = fight.replaceAll("[^*]?\\*[^*]?", "");
        int powerSum = s.chars()
                .map(c -> POWER.getOrDefault((char) c, 0))
                .sum();
        if (powerSum == 0) {
            return "Let's fight again!";
        }
        return powerSum < 0 ? "Right side wins!" : "Left side wins!";
    }

    @Test
    public void SampleTestCases() {
        assertEquals("Right side wins!", alphabetWar("*mg*e*dns*ts**gcv**pw*c*x*j*bmdwkrtpqbdh"));
        assertEquals("Right side wins!", alphabetWar("z"));
        assertEquals("Let's fight again!", alphabetWar("****"));
        assertEquals("Let's fight again!", alphabetWar("z*dq*mw*pb*s"));
        assertEquals("Let's fight again!", alphabetWar("zdqmwpbs"));
        assertEquals("Right side wins!", alphabetWar("zz*zzs"));
        assertEquals("Left side wins!", alphabetWar("sz**z**zs"));
        assertEquals("Left side wins!", alphabetWar("z*z*z*zs"));
        assertEquals("Left side wins!", alphabetWar("*wwwwww*z*"));
    }

}
