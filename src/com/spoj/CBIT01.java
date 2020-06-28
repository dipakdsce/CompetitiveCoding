package com.spoj;

import java.util.Scanner;

/**
 * CBIT01 - Game of Square
 * #game-theory-1
 * A and B are playing a game. They are given a number N. They make moves in turn, A playing first. Each move consists of subtracting a perfect square(not less than 1) from the number, the player who faces 0 loses. You are given a number N, you have to find out whether A can win the game, if both A and B play optimally.
 *
 * Input
 * The first line contains T - the number of test cases. The next T lines contain a number n.
 *
 * Output
 * For each test case, print "Win" if A can win the game, or else print "Lose", separated by new line.
 *
 * Constraints:
 *
 * T>=1; N<=10^5
 *
 * Example
 * Input:
 * 5
 * 1
 * 2
 * 3
 * 16
 * 10
 *
 * Output:
 * Win
 * Lose
 * Win
 * Win
 * Lose
 */
public class CBIT01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] result = new String[t];
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            result[i] = calculateWinner(n);
        }

        for(int i=0; i<t; i++) {
            System.out.println(result[i]);
        }
    }

    public static String calculateWinner(int n) {
        int sqrt =  (int) Math.floor(Math.sqrt(n));
        boolean flag = false;
        while(n > 0) {
            n = n - sqrt * sqrt;
            flag = !flag;
            sqrt = sqrt > 1 ? sqrt -1 : sqrt;
        }
        if(flag == false)
            return "Lose";
        else
            return "Win";
    }
}
