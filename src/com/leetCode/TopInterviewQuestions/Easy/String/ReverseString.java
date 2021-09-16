package com.leetCode.TopInterviewQuestions.Easy.String;

import java.util.Arrays;
/*
Write a function that reverses a string. The input string is given as an array of characters s.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.


Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {

    public static void swap (char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void reverseString(char[] s) {
        for(int i= 0; i<s.length/2; i++) {
            swap(s, i, s.length-1-i);
        }
    }

    public static void main(String[] args) {
        String str = "hell";
        char[] chars = str.toCharArray();
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
