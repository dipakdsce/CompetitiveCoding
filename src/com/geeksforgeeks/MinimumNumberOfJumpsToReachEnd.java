package com.geeksforgeeks;

public class MinimumNumberOfJumpsToReachEnd {
    public static int findMinJumpsRequired(int[] arr) {
        if(arr[0] == 0) {
            return  - 1;
        }

        if(arr.length == 1) {
            return 0;
        }

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;
        for(int i=1; i< arr.length; i++) {
            maxReach = Math.max(maxReach, arr[i] + i);
            steps --;
            if(steps == 0) {
                if (i >= maxReach) {
                    return -1;
                }
                jumps++;
                steps = maxReach - i;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(findMinJumpsRequired(arr));
    }
}
