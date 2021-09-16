package com.CodeChef.starter11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class POSSPEW {

    public static int[] afterModification(int[] arr, int n) {
        HashSet<Integer> zeroIndex = new HashSet<>();
        for(int i=0;i<n; i++) {
            if(arr[i] == 0) {
                zeroIndex.add(i);
            }
        }

        for(int i=0; i<n; i++) {
            if(zeroIndex.contains(i)) {
                continue;
            } else {
                if(i == 0) {
                    arr[1] += 1;
                    arr[n-1] += 1;
                } else if(i == n-1) {
                    arr[n-2] += 1;
                    arr[0] += 1;
                } else {
                    arr[i-1] += 1;
                    arr[i+1] += 1;
                }
            }
        }
        return arr;
    }

    public static int sumOfAllElementsAfterModification(int[] arr, int n, int k) {
        for(int i=0; i<k; i++) {
            arr = afterModification(arr, n);
        }
        int sum = 0;
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for(int j=0; j<n; j++) {
                arr[j]= scanner.nextInt();
            }
            System.out.println(sumOfAllElementsAfterModification(arr, n, k));
        }
    }
}
