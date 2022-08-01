package com.leetCode;

import java.util.Arrays;

public class ReshapeTheMatrix566 {
    /*public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int k=0;
        int m=0;
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(m == c) {
                    k++;
                    m=0;
                }
                if(k == r) {
                    return res;
                }
                res[k][m++] = mat[i][j];
            }
        }
        return res;
    }*/

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;

        if((m*n)!=(r*c))
            return mat;

        int reshape[][]=new int[r][c];
        int a=0, b=0;

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                reshape[i][j]=mat[a][b++];
                if(b==n)
                {
                    a++;
                    b=0;
                }
            }
        }

        return reshape;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3,4}};
        int r = 2;
        int c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
    }
}
