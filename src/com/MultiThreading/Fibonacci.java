package com.MultiThreading;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 3;
        print(n);
    }

    public static void print(int n) {

        int f1 = 0; int f2 = 1;
        for(int k=0; k<=n/2; k++) {
            System.out.print(" ");
        }
        System.out.println(0);

        for(int k=1; k<=n/2; k++) {
            System.out.print(" ");
        }
        System.out.println(1 + " " + 1);


        for(int i=1; i<n; i++) {
            for(int k=i; k<=n/2; k++) {
                System.out.print(" ");
            }
            for(int j=0; j<i; j++) {
                System.out.print((f1 + f2) + " ");
                int temp =  f1 + f2;
                f1 = f2;
                f2 = temp;
            }
            System.out.println();
        }

        for(int i = n-1; i >0; i--) {
            for(int j=0; j < i; j++) {
                System.out.print((f1 + f2) + " ");
                int temp =  f1 + f2;
                f1 = f2;
                f2 = temp;
            }
            System.out.println();
        }
    }
}
