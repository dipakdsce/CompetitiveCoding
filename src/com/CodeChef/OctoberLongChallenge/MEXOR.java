package com.CodeChef.OctoberLongChallenge;

import java.util.Scanner;

public class MEXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            long x = scanner.nextInt();
            if(x == 0) {
                System.out.println(1);
            } else if(x == 1) {
                System.out.println(2);
            } else if(x == 2) {
                System.out.println(2);
            } else {
                long result = 1;
                while(result*2 <= x) {
                    result *= 2;
                }
                if(result == x) {
                    System.out.println(result);
                } else if(2*result -1  == x) {
                    System.out.println(x + 1);
                } else {
                    System.out.println(result);
                }
            }
        }
    }
}
