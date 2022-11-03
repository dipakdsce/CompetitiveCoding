package com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dipak Kumar
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix).forEach(n -> System.out.print(n + " "));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int up =0;
        int down = m - 1;
        int left = 0;
        int right = n-1;

        while(result.size() < m * n) {
            for(int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }

            for(int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            }

            if(up != down) {
                for(int col = right - 1; col >= left; col --) {
                    result.add(matrix[down][col]);
                }
            }

            if(left != right) {
                for(int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            up++;
            left++;
            right--;
            down--;
        }

        return result;
    }
}
