package com.leetCode.AugustChallenge2022;

import java.util.Arrays;

public class Day1UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }

    private static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return countUniquePaths(m, n, 0, 0, dp);
    }

    private static int countUniquePaths(int m, int n, int i, int j, int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            return dp[i][j] = countUniquePaths(m, n, i+1, j, dp) + countUniquePaths(m, n, i, j+1, dp);
        }
    }
}
