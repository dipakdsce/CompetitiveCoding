package com.leetCode.TopInterviewQuestions.Easy.String;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1


Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters. */
public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        int[] charFreq = new int[26];
        for(int i=0 ;i<26; i++) {
            charFreq[i] = -1;
        }
        for(int i=0; i<s.length(); i++) {
            if(charFreq[s.charAt(i)-97] == -1) {
                charFreq[s.charAt(i) - 97] = i;
            } else {
                charFreq[s.charAt(i)-97] = -2;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            if(charFreq[i] >= 0) {
                min = Math.min(min, charFreq[i]);
            }
        }
        return min ==  Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
