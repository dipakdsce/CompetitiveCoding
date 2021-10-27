package com.test;

import java.util.*;

public class Grab3 {
    public static int findP(int num, HashMap<Integer, Integer> map) {
        if(!map.containsKey(num) || map.get(num) == num){
            map.put(num, num);
            return num;
        }
        return findP(map.get(num), map);
    }

    public static int solution (int[] A, int[] B) {
        int[] nodes = new int[A.length + 1];
        Arrays.fill(nodes, 0);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i=0; i<B.length; i++) {
            nodes[B[i]]++;
            HashSet<Integer> list;
            if(map.containsKey(A[i])) {
                list = map.get(A[i]);
            } else {
                list = new HashSet<>();
            }
            list.add(B[i]);
            map.put(A[i], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<=B.length; i++) {
            if(nodes[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int p = queue.poll();
                if(map.get(p) == null) {
                    return queue.isEmpty() ? p : -1;
                }
                Iterator<Integer> iterator = map.get(p).iterator();
                while (iterator.hasNext()) {
                    int child = iterator.next();
                    nodes[child]--;
                    if(nodes[child] == 0) {
                        queue.add(child);
                    }
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {0, 0, 0};
        System.out.println(solution(a, b));
    }
}
