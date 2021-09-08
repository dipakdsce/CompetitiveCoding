package com.leetCode;

import java.util.Arrays;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */
//Input:  n = "218765"  2 1 8 7 6 5 >> 2 5 8 7 6 1
//Output: "251678"
public class NextPermutation31 {

    public static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int startIndex) {
        int endIndex = nums.length-1;
        for(int i=startIndex; i<=(startIndex + endIndex)/2; i++) {
            swap(nums, i, endIndex+startIndex-i);
        }
    }
    public static void nextPermutation(int[] nums) {
        if(nums.length == 1) {
            return;
        }
        int i = nums.length -1;
        for(; i>=1; i--) {
            if(nums[i] > nums[i-1]) {
                break;
            }
        }
        if(i!=0) {
            for(int j=nums.length-1; j>=i; j--) {
                if(nums[i-1] < nums[j]) {
                    swap(nums, i-1, j);
                    break;
                }
            }
        }
        reverse(nums, i);
    }

    public static void main(String[] args) {
        int[] nums = {2,1,8,7,6,5};
        nextPermutation(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
