package com.leetCode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static void main(String[] args) {
//        int num = 1534236469;
        int num = 1463847412;
        System.out.println(reverse(num));
    }

    public static int reverse(int x) {
        int rev = 0;

        while(x != 0) {
            if(rev < Integer.MIN_VALUE/10 || rev > Integer.MAX_VALUE/10) {
                return 0;
            }
            int r = x % 10;
            x = x/10;
            rev = rev * 10 + r;
        }
        return rev;
    }
}
