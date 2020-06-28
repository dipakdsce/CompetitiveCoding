package com.leetCode;

/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubStrWithoutRepeat {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[256];
        for(int i=0; i<256; i++) {
            lastIndex[i] = -1;
        }
        int res = 0;
        int i=0;
        for(int j=0; j<s.length(); j++) {
            i = Math.max(i, lastIndex[s.charAt(j)] + 1);
            res = Math.max(res, j - i + 1 );
            lastIndex[s.charAt(j)] = j;
        }
        return res;
    }
}
