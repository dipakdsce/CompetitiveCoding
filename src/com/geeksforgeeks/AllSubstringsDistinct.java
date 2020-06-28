package com.geeksforgeeks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Given a string s, find the minimum number of changes required to it so that all substrings of the string become distinct.
 *
 * Note: length of string is atmost 26.
 *
 * Input:
 * The first line contains an integer T, number of test cases. For each testcase there is only one line containing s atmost 26 characters.
 *
 * Output:
 * For each testcase in new line, print the minimum number of changes to the string.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= |s| <= 26
 *
 * Example:
 * Input
 * 3
 * aab
 * aebaecedabbee
 * ab
 *
 * Output
 * 1
 * 8
 * 0
 *
 * Explanation
 * Testcase 1: If we change one instance of 'a' to any character from 'c' to 'z', we get all distinct substrings.
 * Testcase 2:  We need to change 2 a's, 2 b's and 4 e's to get distinct substrings.
 * Testcase 3: As no change is required hence 0.
 */
public class AllSubstringsDistinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<t;i++) {
            String str = sc.nextLine();
            HashMap<Character, Integer> charCount = new HashMap<>();
            for(int j=0; j<str.length(); j++) {
                Character c = str.charAt(j);
                if(charCount.containsKey(c)) {
                    int count  = charCount.get(c);
                    charCount.put(c, count +1);
                } else {
                    charCount.put(c, 1);
                }
            }
            int res = 0;
            for(HashMap.Entry<Character, Integer> entry : charCount.entrySet()) {
                int value = entry.getValue();
                if(value > 1) {
                    res += value - 1;
                }
            }
            System.out.println(res);
        }
    }
}
