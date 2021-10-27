package com.leetCode.TopInterviewQuestions.Easy.BinaryTree;

import com.utilsDataStructures.TreeNode;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:
                5
              /   \
             1     4
                  /  \
                3     6

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */
public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if(root.left != null) {
            if (root.left.data < root.data) {
                isValidBST(root.left);
            }
            else {
                return false;
            }
        }

        if(root.right != null) {
            if(root.right.data > root.data) {
                isValidBST(root.right);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/
        System.out.println(isValidBST(root));
    }
}
