package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * A character string represents a city road.
 * <p>
 * Cars travel on the road obeying the traffic lights..
 * <p>
 * Legend:
 * <p>
 * . = Road
 * C = Car
 * G = GREEN traffic light
 * O = ORANGE traffic light
 * R = RED traffic light
 * Something like this:
 * <p>
 * C...R............G......
 * Rules
 * Simulation
 * At each iteration:
 * <p>
 * the lights change, according to the traffic light rules... then
 * the car moves, obeying the car rules
 * Traffic Light Rules
 * Traffic lights change colour as follows:
 * <p>
 * GREEN for 5 time units... then
 * ORANGE for 1 time unit... then
 * RED for 5 time units....
 * ... and repeat the cycle
 * Car Rules
 * Cars travel left to right on the road, moving 1 character position per time unit
 * <p>
 * Cars can move freely until they come to a traffic light. Then:
 * <p>
 * if the light is GREEN they can move forward (temporarily occupying the same cell as the light)
 * <p>
 * if the light is ORANGE then they must stop (if they have already entered the intersection they can continue through)
 * <p>
 * if the light is RED the car must stop until the light turns GREEN again
 * <p>
 * Kata Task
 * Given the initial state of the road, return the states for all iterations of the simiulation.
 * <p>
 * Input
 * road = the road array
 * n = how many time units to simulate (n >= 0)
 * Output
 * An array containing the road states at every iteration (including the initial state)
 * Note: If a car occupies the same position as a traffic light then show only the car
 * Notes
 * There is only one car
 * For the initial road state
 * the car is always at the first character position
 * traffic lights are either GREEN or RED, and are at the beginning of their countdown cycles
 * There are no reaction delays - when the lights change the car drivers will react immediately!
 * If the car goes off the end of the road it just disappears from view
 * There will always be some road between adjacent traffic lights
 * Example
 * Run simulation for 10 time units
 * <p>
 * Input
 * <p>
 * road = "C...R............G......"
 * n = 10
 * Result
 * <p>
 * [
 * "C...R............G......", // 0 initial state as passed
 * ".C..R............G......", // 1
 * "..C.R............G......", // 2
 * "...CR............G......", // 3
 * "...CR............G......", // 4
 * "....C............O......", // 5 show the car, not the light
 * "....GC...........R......", // 6
 * "....G.C..........R......", // 7
 * "....G..C.........R......", // 8
 * "....G...C........R......", // 9
 * "....O....C.......R......"  // 10
 * ]
 * Good luck!
 */
public class TrafficLightsOneCar {

    public static final char ROAD = '.';
    public static final char CAR = 'C';
    public static final char GREEN = 'G';
    public static final char ORANGE = 'O';
    public static final char RED = 'R';

    public static String[] trafficLights(String road, int n) {
        String[] results = new String[n + 1];
        char[] roadElementsWithoutCar = road.toCharArray();
        char[] roadElements;
        if (roadElementsWithoutCar[0] != CAR) {
            throw new IllegalArgumentException();
        }
        roadElementsWithoutCar[0] = ROAD;
        results[0] = road;

        int machinePosition = 0;
        for (int time = 1; time <= n; time++) {
            roadElements = calcTrafficLights(roadElementsWithoutCar, time);
            if (machinePosition + 1 < roadElementsWithoutCar.length) {
                char nextElement = roadElements[machinePosition + 1];
                if (nextElement == ROAD || nextElement  == GREEN) {
                    roadElements[machinePosition] = roadElementsWithoutCar[machinePosition];
                    roadElements[++machinePosition] = CAR;
                } else if (nextElement == ORANGE || nextElement  == RED) {
                    roadElements[machinePosition] = CAR;
                }
            }
            results[time] = String.valueOf(roadElements);
        }
        return results;
    }

    private static char[] calcTrafficLights(char[] roadElements, int i) {
        if (i % 11 == 5 || i % 11 == 0 || i % 11 == 6 || i % 11 == 10) {
            for (int k = 0; k < roadElements.length; k++) {
                if (i % 11 == 5 || i % 11 == 0) {
                    if (roadElements[k] == ORANGE) {
                        roadElements[k] = RED;
                    } else if (roadElements[k] == GREEN) {
                        roadElements[k] = ORANGE;
                    } else if (roadElements[k] == RED) {
                        roadElements[k] = GREEN;
                    }
                } else if (i % 11 == 6) {
                    if (roadElements[k] == ORANGE) {
                        roadElements[k] = RED;
                    }
                } else {
                    if (roadElements[k] == GREEN) {
                        roadElements[k] = ORANGE;
                    }
                }
            }
        }
        return Arrays.copyOf(roadElements, roadElements.length);
    }

    private static void doTest(String initial, String[] expected, int n) {
        String got[] = trafficLights(initial, n);
        assertEquals(expected.length, got.length, "Result array length");

        int errIdx = -1;
        for (int i = 0; i < got.length; i++) {
            if (!expected[i].equals(got[i])) {
                errIdx = i;
                break;
            }
        }

        System.out.println("Expected:");
        for (int i = 0; i < expected.length; i++) {
            System.out.println(String.format("%03d %s", i, expected[i]));
        }

        if (errIdx >= 0) {
            System.out.println("\nYour result:");
            for (int i = 0; i < got.length; i++) {
                System.out.println(String.format("%03d %s", i, got[i]));
            }
            fail(String.format("A difference was detected at index %d", errIdx));
        }
    }

    @Test
    public void example3() {
        int n = 5;
        String sim[] = {
                "CG...",  // 0
                ".C...",  // 1
                ".GC..",  // 2
                ".G.C.",  // 3
                ".G..C",  // 4
                ".O...",  // 5
        };
        doTest(sim[0], sim, n);
    }

    @Test
    public void example2() {
        int n = 26;
        String sim[] = {
                "C....G........R...",  // 0
                ".C...G........R...",  // 1
                "..C..G........R...",  // 2
                "...C.G........R...",  // 3
                "....CG........R...",  // 4
                "....CO........G...",  // 5
                "....CR........G...",  // 6
                "....CR........G...",  // 7
                "....CR........G...",  // 8
                "....CR........G...",  // 9
                "....CR........O...",  // 10
                ".....C........R...",  // 11
                ".....GC.......R...",  // 12
                ".....G.C......R...",  // 13
                ".....G..C.....R...",  // 14
                ".....G...C....R...",  // 15
                ".....O....C...G...",  // 16
                ".....R.....C..G...",  // 17
                ".....R......C.G...",  // 18
                ".....R.......CG...",  // 19
                ".....R........C...",  // 20
                ".....R........OC..",  // 21
                ".....G........R.C.",  // 22
                ".....G........R..C",  // 23
                ".....G........R...",  // 24
                ".....G........R...",  // 25
                ".....G........R...",  // 26
        };
        doTest(sim[0], sim, n);
    }

    @Test
    public void example() {
        int n = 10;
        String sim[] = {
                "C...R............G......",  // 0
                ".C..R............G......",  // 1
                "..C.R............G......",  // 2
                "...CR............G......",  // 3
                "...CR............G......",  // 4
                "....C............O......",  // 5
                "....GC...........R......",  // 6
                "....G.C..........R......",  // 7
                "....G..C.........R......",  // 8
                "....G...C........R......",  // 9
                "....O....C.......R......"   // 10
        };
        doTest(sim[0], sim, n);
    }

}
