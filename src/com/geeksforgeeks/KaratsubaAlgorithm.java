package com.geeksforgeeks;

import java.util.Scanner;

/**
 * Given two binary strings that represent value of two integers, find the product of two strings. For example, if the first bit string is “1100” and second bit string is “1010”, output should be 120.
 *
 * Input:
 * First line consists of T test cases. Only line of every test case consists of 2 binary strings.
 *
 * Output:
 * Single line output, print the multiplied value.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=Length of string<=100
 *
 * Example:
 * Input:
 * 2
 * 1100 01
 * 01 01
 * Output:
 * 12
 * 1
 */
public class KaratsubaAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i=0; i< t; i++) {
            String str = sc.nextLine();
            String[] strings = str.split(" ");
            int n1 = Integer.parseInt(strings[0], 2);
            int n2 = Integer.parseInt(strings[1], 2);
            System.out.println(n1*n2);
        }
    }
}
