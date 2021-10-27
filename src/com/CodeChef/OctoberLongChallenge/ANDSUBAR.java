package com.CodeChef.OctoberLongChallenge;

import java.util.Scanner;

public class ANDSUBAR {
    public static int findNoOfBits(int n) {
        int noOfBits = 0;
        while(n > 0) {
            noOfBits++;
            n = n>>1;
        }
        return noOfBits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            if(n == 1) {
                System.out.println(1);
            }else {
                int bitsCount = findNoOfBits(n);
                int lengthOfArrayWithMaxBit = n - (int)Math.pow(2, bitsCount - 1) + 1;
                int lengthOfArrayWithLessBit =(int)Math.pow(2, bitsCount -1 ) - (int)Math.pow(2, bitsCount -2);
                System.out.println(Math.max(lengthOfArrayWithLessBit, lengthOfArrayWithMaxBit));
            }
        }
    }
}
