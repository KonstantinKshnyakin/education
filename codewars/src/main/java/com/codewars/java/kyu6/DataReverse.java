package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * A stream of data is received and needs to be reversed.
 *
 * Each segment is 8 bits long, meaning the order of these segments needs to be reversed, for example:
 *
 * 11111111  00000000  00001111  10101010
 *  (byte1)   (byte2)   (byte3)   (byte4)
 * should become:
 *
 * 10101010  00001111  00000000  11111111
 *  (byte4)   (byte3)   (byte2)   (byte1)
 * The total number of bits will always be a multiple of 8.
 *
 * The data is given in an array as such:
 *
 * [1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0]
 */
public class DataReverse {

    public static int[] dataReverse(int[] data) {
        int dataLength = data.length;
        int[] result = new int[dataLength];
        int byteLength = 8;
        int bytesCount = dataLength / byteLength;
        int srcPos = 0;
        int destPos = dataLength;
        for (int i = 0; i < bytesCount; i++) {
            destPos -= byteLength;
            System.arraycopy(data, srcPos, result, destPos, byteLength);
            srcPos += byteLength;
        }
        return result;
    }

    @Test
    public void Test1() {
        int[] data1= {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
        int[] data2= {1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
        assertArrayEquals(data2, dataReverse(data1));
    }

    @Test
    public void Test2() {
        int[] data1= {0,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1};
        int[] data2= {0,0,1,0,1,0,0,1,0,0,1,1,0,1,1,0};
        assertArrayEquals(data2, dataReverse(data1));

    }
}
