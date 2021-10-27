package com.CodeChef.starter12;

import java.util.Scanner;

public class MakeItDivisible {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            if(n == 1) {
                System.out.println(3);
            } else {
                System.out.print("3");
                for(int j=1; j<n-1; j++) {
                    System.out.print("0");
                }
                System.out.print("3");
                System.out.println();
            }
        }
    }
}
