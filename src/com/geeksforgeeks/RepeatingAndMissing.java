package com.geeksforgeeks;

/*
Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.

Examples:

 Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3
Explanation: In the array,
2 is missing and 3 occurs twice

Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1
 */
public class RepeatingAndMissing {

    public static void findMissingAndRepeatingNumber(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[Math.abs(nums[i]) - 1] < 0) {
                System.out.println("repeating number is=" + Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }

        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                System.out.println("missing number is=" + (i+1));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3};
        findMissingAndRepeatingNumber(nums);
    }
}
