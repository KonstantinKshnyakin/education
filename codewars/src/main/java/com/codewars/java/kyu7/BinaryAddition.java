package com.codewars.java.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Implement a function that adds two numbers together and returns their sum in binary. The conversion can be done before, or after the addition.
 * The binary number returned should be a string.
 *
 * Examples:(Input1, Input2 --> Output (explanation)))
 * 1, 1 --> "10" (1 + 1 = 2 in decimal or 10 in binary)
 * 5, 9 --> "1110" (5 + 9 = 14 in decimal or 1110 in binary)
 */
public class BinaryAddition {

    public static String binaryAddition(int a, int b){
        return Integer.toBinaryString(a + b);
    }

    @ParameterizedTest(name = "a = {1}, b = {2}")
    @CsvSource(textBlock = """
                   10,    1,   1
                    1,    0,   1
                    1,    1,   0
                  100,    2,   2
               111111,   51,  12
    """)
    @DisplayName("Sample tests")
    void sampleTests(String expected, int a, int b) {
        assertEquals(expected, binaryAddition(a, b));
    }

}
