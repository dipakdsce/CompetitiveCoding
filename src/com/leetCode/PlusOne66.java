package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 * Explanation: The array represents the integer 0.
 * Incrementing by one gives 0 + 1 = 1.
 * Thus, the result should be [1].
 * Example 4:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int i = 0;
        for(i = length -1; i>=0; i--) {
            digits[i] += 1;
            if(digits[i] > 9) {
                digits[i] = 0;
                continue;
            } else {
                break;
            }
        }
        if(i < 0) {
            int[] newArray = new int[digits.length + 1];
            Arrays.setAll(newArray, j -> 0);
            newArray[0] = 1;
            digits = newArray;
        }
        return digits;
    }

    public static void main(String[] args) {
        int digits[] = {4, 3, 2, 1};
        int[] res = plusOne(digits);
        for(int i=0 ;i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
