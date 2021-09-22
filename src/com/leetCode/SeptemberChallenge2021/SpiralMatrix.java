package com.leetCode.SeptemberChallenge2021;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int noOfRow = matrix.length;
        int noOfCol = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        /*if(noOfRow == 1) {
            for (int i=0; i<noOfCol; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        } else if(noOfCol == 1) {
            for (int i=0; i<noOfRow; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        } else if(noOfCol == 1 && noOfRow == 1) {
            result.add(matrix[0][0]);
            return result;
        }
        for(int i=0; i<=noOfRow/2; i++) {
            for(int j=i; j<noOfCol-i; j++) {
                result.add(matrix[i][j]);
            }
            for(int j=i+1; j<noOfRow-i; j++) {
                result.add(matrix[j][noOfCol-1-i]);
            }
            for(int j=noOfCol-2-i; j>=i; j--) {
                result.add(matrix[noOfRow-1-i][j]);
            }
            for(int j=noOfRow-2-i; j>i; j--) {
                result.add(matrix[j][i]);
            }
        }*/
        int row = 0;
        int col = 0;
        while(row <noOfRow && col<noOfCol) {
            for (int i = col; i < noOfCol; i++) {
                result.add(matrix[row][i]);
            }
            row++;

            for (int i = row; i < noOfRow; i++) {
                result.add(matrix[i][noOfCol - 1]);
            }
            noOfCol--;

            if (row < noOfRow) {
                for (int i = noOfCol - 1; i >= col; i--) {
                    result.add(matrix[noOfRow - 1][i]);
                }
                noOfRow--;
            }

            if(col < noOfCol) {
                for (int i = noOfRow - 1; i >= row; i--) {
                    result.add(matrix[i][col]);
                }
                col++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{1},{2}};
        int[][] matrix = {{2,5,8},{4,0,-1}};


//        System.out.println(matrix.length);
        List<Integer> spiralOrder = spiralOrder(matrix);
        for(int num : spiralOrder) {
            System.out.print(num + " ");
        }
    }
}
