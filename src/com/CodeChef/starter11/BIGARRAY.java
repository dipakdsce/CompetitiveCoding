package com.CodeChef.starter11;

import java.util.Scanner;

/*
Chef is given two integers N,S.

Consider an array A of size N such that A[i]=i for every 1≤i≤N.

You are required to find any position x(1≤x≤N) such that :

(A[1]+A[2]+...A[x−1])+(A[x+1]+A[x+2]+...A[N])=S
If there are multiple such positions x, print any such position. If there is no such position, print −1.

Input Format
First line will contain T, number of testcases. Then the testcases follow.
Each testcase contains of a single line of input, two integers N,S.
Output Format
For each testcase, output the required position or −1 in case there is no such position.

Constraints
1≤T≤1000
2≤N≤109
1≤S≤1018
Sample Input 1
3
4 8
5 10
2 3
Sample Output 1
2
5
-1
Explanation
Test Case 1: A[1]+A[3]+A[4]=1+3+4=8, so x=2 is a suitable position.

Test Case 3: There is no suitable position.
 */
public class BIGARRAY {

    public static int findMissingNumber(int n, long sum) {
        long totalSum = (long) n *(n+1)/2;
        long difference = totalSum - sum;
        if(difference >=1 && difference <=n) {
            return (int)difference;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            long sum = scanner.nextLong();
            System.out.println(findMissingNumber(n, sum));
        }
    }
}
