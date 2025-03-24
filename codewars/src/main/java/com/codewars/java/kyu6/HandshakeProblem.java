package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Johnny is a farmer and he annually holds a beet farmers convention "Drop the beet".
 * <p>
 * Every year he takes photos of farmers handshaking. Johnny knows that no two farmers handshake more than once.
 * He also knows that some of the possible handshake combinations may not happen.
 * <p>
 * However, Johnny would like to know the minimal amount of people that participated this year just by counting all the handshakes.
 * <p>
 * Help Johnny by writing a function, that takes the amount of handshakes and returns the minimal amount of people needed to perform these handshakes (a pair of farmers handshake only once).
 */
public class HandshakeProblem {

    public static int getParticipants(int handshakes) {
        int countFarmer = 0;
        while (handshakes > 0) {
            countFarmer++;
            handshakes -= countFarmer - 1;
        }
        return countFarmer;
    }

    @Test
    void sampleTests() {
        assertEquals(0, getParticipants(0), "0 handshakes");
        assertEquals(2, getParticipants(1), "1 handshake");
        assertEquals(3, getParticipants(3), "3 handshakes");
        assertEquals(4, getParticipants(6), "6 handshakes");
        assertEquals(5, getParticipants(7), "7 handshakes");
    }

}
