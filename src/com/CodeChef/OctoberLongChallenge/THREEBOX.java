package com.CodeChef.OctoberLongChallenge;

import java.util.Scanner;

public class THREEBOX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int bagCount = 0;
            if(a == d) {
                bagCount++;
                a = 0;
            }
            b += a;
            if(b > d) {
                bagCount += 2;
                b = 0;
            } else if (b == d) {
                bagCount++;
                b = 0;
            }
            c += b;
            if(c > d) {
                bagCount++;
            }
            System.out.println(bagCount + 1);
        }
    }
}
