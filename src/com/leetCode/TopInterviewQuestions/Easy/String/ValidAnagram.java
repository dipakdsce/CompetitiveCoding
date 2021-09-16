package com.leetCode.TopInterviewQuestions.Easy.String;

import java.util.HashMap;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            charFreqMap.put(s.charAt(i), charFreqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            if(charFreqMap.isEmpty() || !charFreqMap.containsKey(t.charAt(i))) {
                return false;
            } else {
                if(charFreqMap.get(t.charAt(i)) == 1) {
                    charFreqMap.remove(t.charAt(i));
                } else {
                    charFreqMap.put(t.charAt(i), charFreqMap.get(t.charAt(i)) - 1);
                }
            }
        }
        return charFreqMap.isEmpty();
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "ab";
        System.out.println(isAnagram(s, t));
    }
}
