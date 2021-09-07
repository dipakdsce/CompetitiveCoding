package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        List<Character> characters = new ArrayList<>();
        boolean carry = false;
        int i = a.length() - 1;
        int j = b.length() - 1;
        for(; i>=0 && j>=0; i--, j--) {
            if(a.charAt(i) == '1' && b.charAt(j) == '1') {
                if(carry) {
                    characters.add('1');
                } else {
                    characters.add('0');
                }
                carry = true;
            } else if(a.charAt(i) == '1') {
                if(carry) {
                    characters.add('0');
                } else {
                    characters.add('1');
                }
            } else if(b.charAt(j) == '1') {
                if(carry) {
                    characters.add('0');
                } else {
                    characters.add('1');
                }
            } else {
                if(carry) {
                    characters.add('1');
                    carry =  false;
                } else {
                    characters.add('0');
                }
            }
        }
        while (i >= 0) {
            if(carry && a.charAt(i) == '1') {
                characters.add('0');
            } else if(carry) {
                characters.add('1');
                carry = false;
            } else {
                characters.add(a.charAt(i));
            }
            i--;
        }

        while (j >= 0) {
            if(carry && b.charAt(j) == '1') {
                characters.add('0');
            } else if(carry) {
                characters.add('1');
                carry = false;
            } else {
                characters.add(b.charAt(j));
            }
            j--;
        }
        if(carry)
            characters.add('1');
        Collections.reverse(characters);
        String string = characters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return string;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        System.out.println(addBinary(a, b));
    }
}
