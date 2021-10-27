package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;
/*
Given Binary tree, in it we call a perfect tree as when it has 0 or 2 childern for a node.
Question: We need to return the maximum possible perfect subtree size ( i.e count of all nodes in a perfect subtree ) that can formed in a given binary tree by removing some nodes.

Example:

		  18
       /       \
     15         30
    /  \        /  \
  40    50    100   40
 /  \   /
8   7  9

 	By removing node 9, we get the maximum possible perfect tree with size  is 9

		   18
       /       \
     15         30
    /  \        /  \
  40    50    100   40
 /  \
8   7
 */
public class ModifiedPerfectBinaryTree {
    public static class Result {
        int maxSize;
        int size;
    }

    public static boolean isPerfectBinaryTree(TreeNode root) {
        int children = 0;
        children += root.left != null ? 1 : 0;
        children += root.right != null ? 1 : 0;
        return children != 1;
    }

    public static Result findMaxSizeOfModifiedPerfectBinaryTree(TreeNode root) {
        Result curr = new Result();
        if(root == null) {
            return curr;
        }

        Result left = findMaxSizeOfModifiedPerfectBinaryTree(root.left);
        Result right = findMaxSizeOfModifiedPerfectBinaryTree(root.right);
//        curr = is
        return  curr;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(18);
        root.left = new TreeNode(15);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(100);
        root.right.right = new TreeNode(40);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(9);
        Result answer = findMaxSizeOfModifiedPerfectBinaryTree(root);
    }
}
