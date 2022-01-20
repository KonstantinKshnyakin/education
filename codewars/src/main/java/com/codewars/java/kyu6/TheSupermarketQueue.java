package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate
 * the total time required for all the customers to check out!
 *
 * INPUT
 * customers: an array of positive integers representing the queue. Each integer represents a customer,
 * and its value is the amount of time they require to check out.
 *
 * n: a positive integer, the number of checkout tills.
 *
 * OUTPUT
 * The function should return an integer, the total time required.
 *
 * Important
 * Please look at the examples and clarifications below, to ensure you understand the task correctly :)
 *
 * Examples
 * queueTime([5,3,4], 1)
 * // should return 12
 * // because when there is 1 till, the total time is just the sum of the times
 *
 * queueTime([10,2,3,3], 2)
 * // should return 10
 * // because here n=2 and the 2nd, 3rd, and 4th people in the
 * // queue finish before the 1st person has finished.
 *
 * queueTime([2,3,10], 2)
 * // should return 12
 * Clarifications
 * There is only ONE queue serving many tills, and
 * The order of the queue NEVER changes, and
 * The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
 * N.B. You should assume that all the test input will be valid, as specified above.
 *
 * P.S. The situation in this kata can be likened to the more-computer-science-related idea of a thread pool,
 * with relation to running multiple processes at the same time: https://en.wikipedia.org/wiki/Thread_pool
 */
public class TheSupermarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (n < 0 || customers == null) {
            throw new IllegalArgumentException();
        }
        if (n == 0 || customers.length == 0) {
            return 0;
        }
        if (n == 1) {
            return IntStream.of(customers).sum();
        }
        int[] queues = new int[n];
        for (int minuteInQueue : customers) {
            int minIndex = getMinIndex(queues);
            queues[minIndex] += minuteInQueue;
        }
        return IntStream.of(queues).max().orElse(-1);
    }

    private static int getMinIndex(int[] queues) {
        int index = 0;
        int min = queues[index];
        for (int i = 1; i < queues.length; i++) {
            if (queues[i] < min) {
                min = queues[i];
                index = i;
            }
        }
        return index;
    }

    @Test
    public void testNormalCondition() {
        assertEquals(9, solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, solveSuperMarketQueue(new int[] {}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
    }

}
