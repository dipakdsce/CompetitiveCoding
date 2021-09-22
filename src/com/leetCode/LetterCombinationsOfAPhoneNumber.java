package com.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        int[] digitArray = new int[digits.length()];
        List<String> results = new ArrayList<>();
        for(int i=0; i<digits.length(); i++) {
            digitArray[i] = Character.getNumericValue(digits.charAt(i));
        }

        String[] stringMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        while(!queue.isEmpty()) {
            String s = queue.remove();
            if(s.length() == digits.length()) {
                results.add(s);
            } else {
                String value = stringMap[digitArray[s.length()]];
                for(int i=0; i<value.length(); i++) {
                    queue.add(s + value.charAt(i));
                }
            }
        }
        if(results.get(0).isEmpty()) {
            return new ArrayList<>();
        }
        return results;
    }

    public static void main(String[] args) {
        String digits = "";
        List<String> results = letterCombinations(digits);
        for(String string : results) {
            System.out.print(string + " ");
        }
    }
}
