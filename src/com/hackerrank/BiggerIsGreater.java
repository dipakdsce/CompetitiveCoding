package com.hackerrank;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;

/**
 * Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.
 *
 * Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
 *
 * It must be greater than the original word
 * It must be the smallest word that meets the first condition
 * Example
 *
 * The next largest word is .
 *
 * Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.
 *
 * Function Description
 *
 * Complete the biggerIsGreater function in the editor below.
 *
 * biggerIsGreater has the following parameter(s):
 *
 * string w: a word
 * Returns
 * - string: the smallest lexicographically higher string possible or no answer
 *
 * Input Format
 *
 * The first line of input contains , the number of test cases.
 * Each of the next  lines contains .
 *
 * Constraints
 *
 *  will contain only letters in the range ascii[a..z].
 * Sample Input 0
 *
 * 5
 * ab
 * bb
 * hefg
 * dhck
 * dkhc
 * Sample Output 0
 *
 * ba
 * no answer
 * hegf
 * dhkc
 * hcdk
 * Explanation 0
 *
 * Test case 1:
 * ba is the only string which can be made by rearranging ab. It is greater.
 * Test case 2:
 * It is not possible to rearrange bb and get a greater string.
 * Test case 3:
 * hegf is the next string greater than hefg.
 * Test case 4:
 * dhkc is the next string greater than dhck.
 * Test case 5:
 * hcdk is the next string greater than dkhc.
 * Sample Input 1
 *
 * 6
 * lmno
 * dcba
 * dcbb
 * 1
 * abcd
 * fedcbabcd
 * Sample Output 1
 *
 * lmon
 * no answer
 * no answer
 * acbd
 * abdc
 * fedcbabdc
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        scanner.nextLine();
        for(int i=0; i<n; i++) {
            strings[i] = scanner.nextLine();
        }
        String[] results = getBiggerString(strings, n);

        for (int i = 0; i < n; i++) {
            System.out.println(results[i]);
        }
    }

    public static String[] getBiggerString(String[] strings, int n) {
        String[] results = new String[n];
        for (int i = 0; i < n; i++) {
            results[i] = getNextBiggerString(strings[i]);
        }
        return results;
    }

    public static String getNextBiggerString(String str) {
        char[] chars = str.toCharArray();
        int smallerCharIndex = Integer.MIN_VALUE;
        int i;
        if(str.length() > 2) {
            for (i = str.length() - 1; i > 0; i--) {
                if(str.charAt(i-1) < str.charAt(i)) {
                    smallerCharIndex = i-1;
                    break;
                }
            }

            if(smallerCharIndex == Integer.MIN_VALUE) {
                return "no answer";
            }

            for(int j = str.length()-1; j > smallerCharIndex; j--) {
                if(chars[j] > chars[smallerCharIndex]) {
                    char temp = chars[j];
                    chars[j] = chars[smallerCharIndex];
                    chars[smallerCharIndex] = temp;
                    break;
                }
            }

            int m = 1;
            for(int k=smallerCharIndex+1 ; k <= (str.length() + smallerCharIndex)/2 ; k++) {
                char temp = chars[k];
                chars[k] = chars[str.length() - m];
                chars[str.length() - m] = temp;
                m++;
            }
            return String.copyValueOf(chars);
        } else if(str.length() == 1){
            return "no answer";
        } else {
            if(chars[0] >=  chars[1]) {
                return "no answer";
            } else {
                char temp = chars[1];
                chars[1] = chars[0];
                chars[0] = temp;
                return String.copyValueOf(chars);
            }
        }

    }
}
