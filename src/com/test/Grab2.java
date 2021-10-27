package com.test;

import com.utilsDataStructures.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/*

 */
public class Grab2 {
    public static int largestUniquePathUtil(TreeNode root, HashSet<Integer> set) {
        if (root == null || set.contains(root.data)) {
            return set.size();
        }

        //Add the root to the set
        set.add(root.data);
        int l = largestUniquePathUtil(root.left, set);
        int r = largestUniquePathUtil(root.right, set);
        //Backtrack and remove the element from the set
        set.remove(root.data);

        //return the max path
        return Math.max(l, r);
    }
    public static int largestUniquePath(TreeNode root) {
        if (root == null)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        return largestUniquePathUtil(root,set);
    }

    public static void main(String[] args)
    {
        // Create binary tree shown in above figure
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        System.out.println(largestUniquePath(root));


    }
}
