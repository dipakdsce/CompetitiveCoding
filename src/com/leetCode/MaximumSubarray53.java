package com.leetCode;

import java.util.Scanner;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 */
public class MaximumSubarray53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int curMax = nums[0];
        for(int i=1; i<nums.length; i++) {
            curMax = Math.max(nums[i], nums[i] + curMax);
            maxSoFar = Math.max(curMax, maxSoFar);
        }
        return maxSoFar;
    }
}
