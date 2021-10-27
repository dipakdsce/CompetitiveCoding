package com.leetCode.OctoberChallenge2021;

/*
Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.



Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0


Constraints:

0 <= left <= right <= 2^31 - 1
 */
public class BitwiseANDOfNumbersRange201 {
    public static int findBitwiseAND(int left, int right) {
        if((left == 1 && right == 0) || left == 0) {
            return 0;
        }
        if(left == 1 && right > 1) {
            return 0;
        }
        int leftSqrt = (int) (Math.log(left)/Math.log(2));
        int rightSqrt = (int) (Math.log(right)/Math.log(2));
        if(leftSqrt == rightSqrt) {
            int number = (int )Math.pow(2, leftSqrt);
            left -= number;
            right -= number;
            number += findBitwiseAND(left, right);
            return number;
        }
        else
            return 0;
    }
    public static void main(String[] args) {
        int left = 6;
        int right = 7;

        System.out.println(findBitwiseAND(left, right));
    }
}
