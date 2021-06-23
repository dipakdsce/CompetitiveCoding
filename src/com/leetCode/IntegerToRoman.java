package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 3
 * Output: "III"
 * Example 2:
 *
 * Input: num = 4
 * Output: "IV"
 * Example 3:
 *
 * Input: num = 9
 * Output: "IX"
 * Example 4:
 *
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getRomanFromInteger(n));
    }


    public static String getRomanFromInteger(int n) {
        List<Character> characters = new ArrayList<>();

        while (n > 0) {
            if(n >= 1000) {
                characters.add('M');
                n -= 1000;
            } else if( n >= 900) {
                characters.add('C');
                characters.add('M');
                n -= 900;
            } else if( n >= 500) {
                characters.add('D');
                n -= 500;
            } else if( n >= 400) {
                characters.add('C');
                characters.add('D');
                n -= 400;
            } else if ( n >= 100) {
                characters.add('C');
                n -= 100;
            } else if( n >= 90) {
                characters.add('X');
                characters.add('C');
                n -= 90;
            } else if( n >= 50) {
                characters.add('L');
                n -= 50;
            } else if( n >= 40) {
                characters.add('X');
                characters.add('L');
                n -= 40;
            } else if( n >= 10) {
                characters.add('X');
                n -= 10;
            } else if( n == 9) {
                characters.add('I');
                characters.add('X');
                break;
            } else if( n >= 5) {
                characters.add('V');
                n -= 5;
            } else if ( n == 4) {
                characters.add('I');
                characters.add('V');
                break;
            } else {
                characters.add('I');
                n -= 1;
            }
        }
        return characters.stream()              // Stream<Character>
                .map(String::valueOf)   // Stream<String>
                .collect(Collectors.joining());
    }
}
