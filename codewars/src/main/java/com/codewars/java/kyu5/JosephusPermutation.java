package com.codewars.java.kyu5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This problem takes its name by arguably the most important event in the life of the ancient historian Josephus:
 * according to his tale, he and his 40 soldiers were trapped in a cave by the Romans during a siege.
 *
 * Refusing to surrender to the enemy, they instead opted for mass suicide, with a twist: they formed a circle and
 * proceeded to kill one man every three, until one last man was left (and that it was supposed to kill himself to end the act).
 *
 * Well, Josephus and another man were the last two and, as we now know every detail of the story, you may have
 * correctly guessed that they didn't exactly follow through the original idea.
 *
 * You are now to create a function that returns a Josephus permutation, taking as parameters the initial array/list
 * of items to be permuted as if they were in a circle and counted out every k places until none remained.
 *
 * Tips and notes: it helps to start counting from 1 up to n, instead of the usual range 0 to n-1; k will always be >=1.
 *
 * For example, with an array=[1,2,3,4,5,6,7] and k=3, the function should act this way.
 *
 * [1,2,3,4,5,6,7] - initial sequence
 * [1,2,4,5,6,7] => 3 is counted out and goes into the result [3]
 * [1,2,4,5,7] => 6 is counted out and goes into the result [3,6]
 * [1,4,5,7] => 2 is counted out and goes into the result [3,6,2]
 * [1,4,5] => 7 is counted out and goes into the result [3,6,2,7]
 * [1,4] => 5 is counted out and goes into the result [3,6,2,7,5]
 * [4] => 1 is counted out and goes into the result [3,6,2,7,5,1]
 * [] => 4 is counted out and goes into the result [3,6,2,7,5,1,4]
 */
public class JosephusPermutation {

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> result = new ArrayList<>();
        int i = 1;
        while (!items.isEmpty()) {
            Iterator<T> iterator = items.iterator();
            while (iterator.hasNext()) {
                T item = iterator.next();
                if (i % k == 0 || items.size() == 1) {
                    result.add(item);
                    iterator.remove();
                }
                i++;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1, new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

    @Test
    public void test2() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2, new Object[]{2, 4, 6, 8, 10, 3, 7, 1, 9, 5});
    }

    @Test
    public void test3() {
        josephusTest(new Object[]{"C", "o", "d", "e", "W", "a", "r", "s"}, 4, new Object[]{"e", "s", "W", "o", "C", "d", "r", "a"});
    }

    @Test
    public void test4() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7}, 3, new Object[]{3, 6, 2, 7, 5, 1, 4});
    }

    @Test
    public void test5() {
        josephusTest(new Object[]{}, 3, new Object[]{});
    }

    @Test
    public void test6() {
        josephusTest(new Object[]{true, false, true, false, true, false, true, false, true}, 9, new Object[]{true, true, true, false, false, true, false, true, false});
    }

    private void josephusTest(final Object[] items, final int k, final Object[] result) {
        Assertions.assertEquals(Arrays.asList(result), josephusPermutation(new ArrayList(Arrays.asList(items)), k));
    }

}
