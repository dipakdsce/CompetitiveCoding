package com.leetCode.TopInterviewQuestions.Easy.Array;

import java.util.*;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */
public class IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> resultList = new ArrayList<>();
        HashMap<Integer, Integer> oneSet = new HashMap<>();
        int[] setToBeInsert, setToBeTraversed;
        if(nums1.length > nums2.length) {
            setToBeInsert = nums1;
            setToBeTraversed = nums2;
        } else {
            setToBeInsert = nums2;
            setToBeTraversed = nums1;
        }

        for(int i=0; i<setToBeInsert.length; i++){
            if(oneSet.containsKey(setToBeInsert[i])) {
                oneSet.put(setToBeInsert[i], oneSet.get(setToBeInsert[i]) + 1);
            } else {
                oneSet.put(setToBeInsert[i], 1);
            }
        }
        for(int i=0; i<setToBeTraversed.length; i++) {
            if(oneSet.containsKey(setToBeTraversed[i])) {
                resultList.add(setToBeTraversed[i]);
                if(oneSet.get(setToBeTraversed[i]) > 1) {
                    oneSet.put(setToBeTraversed[i], oneSet.get(setToBeTraversed[i]) - 1);
                } else {
                    oneSet.remove(setToBeTraversed[i]);
                }
            }
        }
        int[] resultArray = new int[resultList.size()];
        int  i=0;
        for(int num : resultList) {
            resultArray[i++] = num;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,1,2};
        int[] nums2 = {1,1};
        int[] intersection = intersect(nums1, nums2);
        for(int i=0; i<intersection.length; i++) {
            System.out.print(intersection[i] + " ");
        }
    }
}
