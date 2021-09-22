package com.leetCode;

import java.util.*;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class ThreeSum15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length - 1; i++) {
            int firstEle = nums[i];
            HashSet<Integer> map = new HashSet<>();
            for(int j=i+1; j<nums.length; j++) {
                if(map.contains(-(firstEle + nums[j]))) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(firstEle);
                    triplet.add(nums[j]);
                    triplet.add(-(firstEle + nums[j]));
                    result.add(triplet);
                } else {
                    map.add(nums[j]);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumWithSorting(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length - 1; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            if(nums[i] > 0) {
                break;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while(l<r) {
                if(l > i+1 && nums[l] == nums[l-1]) {
                    l++;
                    continue;
                }
                if( r < nums.length -1 && nums[r] == nums[r+1]) {
                    r--;
                    continue;
                }
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    result.add(triplet);
                    l++;
                    r--;
                } else if(sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSumWithSorting(nums);
        for(List<Integer> triplet : result) {
            System.out.println(triplet.get(0) + " " + triplet.get(1) + " " + triplet.get(2));
        }
    }
}
