package com.CodeChef.SnackdownQfl;

import java.util.*;


public class MAXDISTKT {
    static class pair {
        int value;
        int index;
        pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static List<pair> findMaxDistinct(List<pair> input, int n) {
        Collections.sort(input, Comparator.comparing(a -> ((Integer) a.value)));
        int k = 0;
        for(int i=0; i<n; i++) {
            if(input.get(i).value > k) {
                input.set(i, new pair(k, input.get(i).index));
                k++;
            } else if(input.get(i).value == k){
                input.set(i, new pair(k, input.get(i).index));
            }
        }
        Collections.sort(input, Comparator.comparing(a -> ((Integer) a.index)));
        return input;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            List<pair> pairList = new ArrayList<>();
            for(int j=0; j<n; j++) {
                pairList.add(new pair(scanner.nextInt(), j));
            }
            List<pair> result = findMaxDistinct(pairList, n);
            for(pair p : result) {
                System.out.print(p.value + " ");
            }
            System.out.println();
        }
    }
}
