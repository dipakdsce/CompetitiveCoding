package com.leetCode.SeptemberChallenge2021;

/*
Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.


Example 1:

Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
Example 2:

Input: arr = [4,8,12,16]
Output: 2
Example 3:

Input: arr = [100]
Output: 1


Constraints:

1 <= arr.length <= 4 * 104
0 <= arr[i] <= 109
 */

public class LongestTurbulentSubarray {
    public static int maxTurbulenceSize(int[] arr) {
        /*boolean greater = true;
        int max = 0;
        int count = 0;
        int i=1;
        if (arr.length >= 2) {
            while (i < arr.length && arr[i - 1] == arr[i]) {
                i++;
            }
            if (i < arr.length) {
                if (arr[0] < arr[1]) {
                    greater = false;
                }
                count = 1;
                max = 1;
                i++;
            }
        } else if (arr.length == 1) {
            return 1;
        } else {
            return 0;
        }
        for (; i < arr.length; i++) {
            if (greater && arr[i - 1] < arr[i]) {
                count++;
                greater = false;
            } else if (!greater && arr[i - 1] > arr[i]) {
                count++;
                greater = true;
            } else {
                max = Math.max(max, count);
                count = 1;
                if (arr[i - 1] < arr[i]) {
                    greater = false;
                } else {
                    greater = true;
                }
            }
        }
        max = Math.max(max, count);
        return max + 1;*/
        int i=0;
        int count = 0;
        int max = 0;
        if(arr.length == 1) {
            return 1;
        } else {
            for(i=1; i<arr.length; i++) {
                if(arr[i] == arr[i-1]) {
                    continue;
                } else {
                    break;
                }
            }
        }
        boolean greater = true;
        if(i<arr.length) {
            if(arr[i-1] < arr[i]) {
                greater = false;
            }
            count = 1;
            i++;
        }
        boolean equalFlag = false;
        for(; i<arr.length; i++) {
            if(arr[i-1] == arr[i]) {
                equalFlag = true;
            }
            else if(equalFlag) {
                greater = arr[i - 1] > arr[i];
                max = Math.max(count, max);
                count = 1;
                equalFlag = false;
            }
            else if(greater && arr[i-1] < arr[i]) {
                count++;
                greater = false;
            } else if(!greater && arr[i-1] > arr[i]) {
                count++;
                greater = true;
            } else {
                max = Math.max(max, count);
                count = 1;
                if (arr[i - 1] < arr[i]) {
                    greater = false;
                } else {
                    greater = true;
                }
            }
        }
        return Math.max(max, count) + 1;

    }

    public static void main(String[] args) {
//        int[] arr = {8,8,9,10,6,8,2,4,2,2,10,6,6,10,10,2,3,5,1,2,10,4,2,0,9,4,9,3,0,6,3,2,3,10,10,6,4,6,4,4,2,5,1,4,1,1,9,8,9,5,3,5,5,4,5,5,6,5,3,3,7,2,0,10,9,7,7,3,5,1,0,9,6,3,1,3,4,4,3,6,3,2,1,4,10,2,3,4,4,3,6,7,6,2,1,7,0,6,8,10};
//        int[] arr = {37, 199, 60, 296, 257, 248, 115, 31, 273, 176};
//        int[] arr = {37,37,38,38,39,49};
        int[] arr = {37,37,37,38};
//        int[] arr = {8,8,9,10,6,8,2,4,2,2,10,7,2,0,10,9,7,7,3,5,1,0,9,6};
        System.out.println(maxTurbulenceSize(arr));

    }
}
