package com.hackerearth;

import java.util.*;

/*
Problem
In a tournament there are  players,  players have already played and their scores are denoted by an array . Here,  is the score of the first player,  of the second, ...,  of the  player.

Now, the organizers decide the ranks according to the following rules:

The player  scored more than player , player  gets a better rank.

In case of tie, the player with lower indices gets a better rank.

Now, it is the turn of the  player to play. Before playing, he wants to know the number of ranks that he can secure so that he can decide his strategy.

Now, the jury has some scoreboard updates. Therefore, your task is to tell the jury after every update the number of distinct possible ranks that he can get.

Input format

The first line contains the number of test cases .
The first line of each test case contains two integers  and  denoting the number of players who have already played and the number of updates by jury.
The second line of each test case contains  space-separated integers of array .
Next  lines of each test case contain two integers  and  denoting the score of the  player has changed to .
Output format

For each test case:

Print  lines denoting the number of possible ranks which  player can get after every update.
Constraints:






The sum of  and  in over all test cases does not exceed 100000.

Sample Input
1
4 1
2 1 1 5
2 3
Sample Output
5
Time Limit: 2.5
Memory Limit: 256
Source Limit:
Explanation
After first query scoreboard will look like 2,3,1,5.

Rank will be 3,2,4,1. Now first player can acheive Ny rank from 1 to 5.

If he scores 6 he will get first rank, if he scores 5 he will rank second, if he scores 3 he will rank third, if he scores he scores 2 he will get fourth rank, if he scores 0 he will get 5th rank.
 */
public class ScoreboardQueries {
    /*public static class Pair {
        int l;
        int r;
        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }*/
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<n; j++) {
                arr[j] = scanner.nextInt();
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            for(int j=0; j<q; j++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int val = map.get(arr[l-1]);
                if(val >1) {
                    map.put(arr[l-1], val - 1);
                } else {
                    map.remove(arr[l-1]);
                }
                map.put(r, map.getOrDefault(r, 0) + 1);
                arr[l-1] = r;
                System.out.println(map.size()+1);
            }
        }
    }

}
