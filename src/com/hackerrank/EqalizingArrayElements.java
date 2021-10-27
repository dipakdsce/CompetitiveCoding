package com.hackerrank;

import java.util.*;

public class EqalizingArrayElements {
    public static int minOperations(List<Integer> arr, int threshold, int d) {
        // Write your code here
        int MAX = 2000000;
        Vector<Integer> []vectors = new Vector[MAX];
        for(int i=0; i<vectors.length; i++) {
            vectors[i] = new Vector<>();
        }

        for(int i=0; i<arr.size(); i++) {
            int count = 0;
            vectors[arr.get(i)].add(0);

            while(arr.get(i) > 0) {
                int num = arr.get(i);
                num /= d;
                arr.remove(i);
                arr.add(i, num);
                count++;
                vectors[arr.get(i)].add(count);
            }
        }
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<MAX; i++) {
            if(vectors[i].size() >= threshold) {
                int move = 0;
                Collections.sort(vectors[i]);
                for(int j=0; j<threshold; j++) {
                    move += vectors[i].get(j);
                }
                ans = Math.min(ans, move);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {64,30,25,33};
        List<Integer> list = new ArrayList<>();
        list.add(64);
        list.add(30);
        list.add(25);
        list.add(33);
        System.out.println(minOperations(list, 2, 2));
    }
}
