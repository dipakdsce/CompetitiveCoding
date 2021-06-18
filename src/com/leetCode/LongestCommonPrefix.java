package com.leetCode;

import java.util.List;
import java.util.Scanner;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for(int i = 0; i<n; i++) {
            strings[i] = scanner.nextLine();
        }
        System.out.println(getCommonPrefix(strings));
    }

    public static String getCommonPrefix(String[] strs) {
        String result = "";
        for(int i=0; i<strs[0].length(); i++) {
            int j;
            for(j=1; j< strs.length; j++) {
                if((strs[j].length() > i) && strs[0].charAt(i) == strs[j].charAt(i)) {
                    continue;
                } else {
                    break;
                }
            }
            if(j == strs.length) {
                result += String.valueOf(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return result;
    }
}
