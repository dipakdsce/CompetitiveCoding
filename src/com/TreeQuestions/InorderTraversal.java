package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;

import java.util.Stack;

public class InorderTraversal {
    public static void printInorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        printInorderTraversal(root.left);
        System.out.print(root.data + " ");
        printInorderTraversal(root.right);
    }

    public static void printIterativeInorder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || stack.size() > 0) {
            while (curr!= null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        printInorderTraversal(root);
        System.out.println();
        printIterativeInorder(root);
    }
}
