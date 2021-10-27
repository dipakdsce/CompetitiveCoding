package com.CodeChef.OctoberLongChallenge;

import java.util.Scanner;

public class MIXTURE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(a>0 && b>0) {
                System.out.println("Solution");
            }else if(a == 0) {
                System.out.println("Liquid");
            } else {
                System.out.println("Solid");
            }
        }
    }
}
