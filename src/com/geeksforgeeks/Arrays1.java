package com.geeksforgeeks;

import java.util.Scanner;

/**
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.
 *
 * Output:
 * For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1010
 *
 * Example:
 * Input:
 * 2
 * 5 12
 * 1 2 3 7 5
 * 10 15
 * 1 2 3 4 5 6 7 8 9 10
 * Output:
 * 2 4
 * 1 5
 *
 * Explanation :
 * Testcase1: sum of elements from 2nd position to 4th position is 12
 * Testcase2: sum of elements from 1st position to 5th position is 15
 */
public class Arrays1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0; j<n; j++) {
                arr[j] = sc.nextInt();
            }

            int start = 0;
            int end = 0;
            int tmpSum = 0;
            boolean flag = false;
            int j=0;
            while(j <= n) {
                if(tmpSum == sum) {
                    flag = true;
                    break;
                } else if(tmpSum > sum) {
                    tmpSum -= arr[start];
                    start++;
                } else {
                    if (j < n) {
                        end = j;
                        tmpSum += arr[j++];
                    }
                }
            }
            if(flag) {
                System.out.println((start + 1) + " " + (end + 1));
            } else {
                System.out.println(-1);
            }
        }
    }
}
