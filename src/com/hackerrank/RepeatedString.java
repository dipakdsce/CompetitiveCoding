package com.hackerrank;

import java.util.Scanner;

/**
 * There is a string, , of lowercase English letters that is repeated infinitely many times. Given an integer, , find and print the number of letter a's in the first  letters of the infinite string.
 *
 * Example
 *
 *
 * The substring we consider is , the first  characters of the infinite string. There are  occurrences of a in the substring.
 *
 * Function Description
 *
 * Complete the repeatedString function in the editor below.
 *
 * repeatedString has the following parameter(s):
 *
 * s: a string to repeat
 * n: the number of characters to consider
 * Returns
 *
 * int: the frequency of a in the substring
 * Input Format
 *
 * The first line contains a single string, .
 * The second line contains an integer, .
 *
 * Constraints
 *
 * For  of the test cases, .
 * Sample Input
 *
 * Sample Input 0
 *
 * aba
 * 10
 * Sample Output 0
 *
 * 7
 * Explanation 0
 * The first  letters of the infinite string are abaabaabaa. Because there are  a's, we return .
 *
 * Sample Input 1
 *
 * a
 * 1000000000000
 * Sample Output 1
 *
 * 1000000000000
 * Explanation 1
 * Because all of the first  letters of the infinite string are a, we return .
 */
public class RepeatedString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        long n = scanner.nextLong();
        System.out.println(getNumberOfRepetitions(string, n));
    }

    public static long getNumberOfRepetitions(String s, long n) {
        long countInOneString = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                countInOneString++;
            }
        }
        if(countInOneString == 0) {
            return countInOneString;
        }
        long numberOfRepeatOfString = n/s.length();
        long remaining = n%s.length();
        long result = countInOneString * numberOfRepeatOfString;
        for(int i = 0; i < remaining; i++) {
            if(s.charAt(i) == 'a') {
                result++;
            }
        }
        return result;
    }
}
