package com.leetCode.OctoberChallenge2021;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, word = "ABCCED"
Output: true
Example 2:


Input: board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}} word = "SEE"
Output: true
Example 3:


Input: board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.


Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearch79 {
    public static boolean wordUtil(char[][] board, String word, int m, int n, int index, boolean[][] visited) {
        boolean found = false;
        if (index == word.length() - 1) {
            return true;
        }
        visited[m][n] = true;
        if (m < board.length - 1 && board[m + 1][n] == word.charAt(index + 1) && !visited[m+1][n] ) {
            found = wordUtil(board, word, m + 1, n, index + 1, visited);
        }
        if (m > 0 && board[m - 1][n] == word.charAt(index + 1) && !visited[m-1][n] && !found) {
            found = wordUtil(board, word, m - 1, n, index + 1, visited);
        }
        if (n < board[0].length - 1 && board[m][n + 1] == word.charAt(index + 1) && !visited[m][n+1] && !found) {
            found = wordUtil(board, word, m, n + 1, index + 1, visited);
        }
        if (n > 0 && board[m][n - 1] == word.charAt(index + 1) && !visited[m][n-1] && !found) {
            found = wordUtil(board, word, m, n - 1, index + 1, visited);
        }
        if(!found) {
            visited[m][n] = false;
        }
        return found;
    }
    public static boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(wordUtil(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };*/
//        String word = "ABCCED";
        char[][] board = {
                {'C', 'A', 'A' },
                {'A', 'A', 'A' },
                {'B', 'C', 'D' }
        };
        String word = "AAB";
        System.out.println(exist(board, word));
    }
}
