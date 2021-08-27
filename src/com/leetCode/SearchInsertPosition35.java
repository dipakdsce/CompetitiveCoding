package com.leetCode;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 *
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 *
 * Input: nums = [1], target = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n -1;
        if(target > nums[high]) {
            return n;
        } else if (target < nums[0]) {
            return 0;
        }
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target) {
                if((mid+1 <= n - 1) && nums[mid+1] > target) {
                    return mid + 1;
                }
                low = mid + 1;
            } else {
                if(((mid - 1) >= 0) && nums[mid-1] < target) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return 0;
    }
}
