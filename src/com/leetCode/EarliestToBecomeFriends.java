package com.leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Dipak Kumar
 */
public class EarliestToBecomeFriends {
    public static void main(String[] args) {
//        int[][] logs = {{0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}};
//        int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int[][] logs = {{9,3,0},{0,2,1},{8,0,1},{1,3,2},{2,2,0},{3,3,1}};
        System.out.println(earliestAcq(logs, 4));
    }

    public static int find(int x, int[] root) {
        if(x == root[x]) {
            return x;
        }
        return root[x] = find(root[x], root);
    }

    public static boolean union(int p, int q, int[] root, int[] rank) {
        int rootP = find(p, root);
        int rootQ = find(q, root);

        if(rootP == rootQ) {
            return false;
        }

        if(rank[rootP] > rank[rootQ]) {
            root[rootQ] = rootP;
        } else if(rank[rootP] < rank[rootQ]) {
            root[rootP] = rootQ;
        } else {
            root[rootQ] = rootP;
            rank[rootP] += 1;
        }
        return true;
    }
    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[] root = new int[n];
        int[] rank = new int[n];
        for(int i=0; i<n; i++) {
            root[i] = i;
            rank[i] = 0;
        }
        int result = n;
        for(int[] log: logs) {
            if(union(log[1], log[2], root, rank)) {
                result--;
                if(result == 1) {
                    return log[0];
                }
            }
        }
        return -1;
    }
}
