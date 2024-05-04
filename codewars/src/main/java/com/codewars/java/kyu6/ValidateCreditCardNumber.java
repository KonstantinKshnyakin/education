package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In this Kata, you will implement the Luhn Algorithm, which is used to help validate credit card numbers.
 * <p>
 * Given a positive integer of up to 16 digits, return true if it is a valid credit card number, and false if it is not.
 * <p>
 * Here is the algorithm:
 * <p>
 * Double every other digit, scanning from right to left, starting from the second digit (from the right).
 * <p>
 * Another way to think about it is: if there are an even number of digits, double every other digit starting with
 * the first; if there are an odd number of digits, double every other digit starting with the second:
 * <p>
 * 1714 ==> [1*, 7, 1*, 4] ==> [2, 7, 2, 4]
 * <p>
 * 12345 ==> [1, 2*, 3, 4*, 5] ==> [1, 4, 3, 8, 5]
 * <p>
 * 891 ==> [8, 9*, 1] ==> [8, 18, 1]
 * If a resulting number is greater than 9, replace it with the sum of its own digits (which is the same as
 * subtracting 9 from it):
 * <p>
 * [8, 18*, 1] ==> [8, (1+8), 1] ==> [8, 9, 1]
 * <p>
 * or:
 * <p>
 * [8, 18*, 1] ==> [8, (18-9), 1] ==> [8, 9, 1]
 * Sum all of the final digits:
 * <p>
 * [8, 9, 1] ==> 8 + 9 + 1 = 18
 * Finally, take that sum and divide it by 10. If the remainder equals zero, the original credit card number is valid.
 * <p>
 * 18 (modulus) 10 ==> 8 , which is not equal to 0, so this is not a valid credit card number
 */
public class ValidateCreditCardNumber {

    public static boolean validate(String n) {
        String[] numbers = n.split("");
        int isEven = numbers.length % 2 == 0 ? 1 : 0;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            if (i % 2 == isEven) {
                sum += num;
            } else {
                int doub = (num * 2);
                sum += doub <= 9 ? doub : doub - 9;
            }
        }
        return sum % 10 == 0;
    }

    @Test
    public void test891() {
        assertEquals(false, validate("891"));
    }

}
