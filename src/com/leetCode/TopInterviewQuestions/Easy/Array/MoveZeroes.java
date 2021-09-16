package com.leetCode.TopInterviewQuestions.Easy.Array;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;
        while(nonZeroIndex < nums.length && zeroIndex < nums.length){
            if(nums[zeroIndex] == 0 && nums[nonZeroIndex] != 0) {
                swap(nums, zeroIndex, nonZeroIndex);
                zeroIndex++;
                nonZeroIndex++;
            } else if(nums[zeroIndex] == 0) {
                nonZeroIndex++;
            } else {
                zeroIndex++;
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
