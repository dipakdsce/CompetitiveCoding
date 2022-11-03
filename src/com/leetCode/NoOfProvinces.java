package com.leetCode;

/**
 * @author Dipak Kumar
 */
public class NoOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,1},{1,1,1},{1,1,1}};
        NoOfProvinces noOfProvinces = new NoOfProvinces();
        System.out.println(noOfProvinces.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }

    class UnionFind {
        int[] rank;
        int[] root;
        int count = 0;

        public UnionFind(int n) {
            count = n;
            rank = new int[n];
            root = new int[n];

            for (int i = 0; i < n; i++) {
                rank[i] = 1;
                root[i] = i;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }

            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX ==  rootY)
                return;
            if (rank[rootY]> rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[x] = rootY;
                if(rank[rootX] == rank[rootY]) {
                    rank[rootX]++;
                }
            }
            count--;
        }

        public int getCount() {
            return count;
        }
     }
}
