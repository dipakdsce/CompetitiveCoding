package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreorderTraversal {
    public static void printPreorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreorderTraversal(root.left);
        printPreorderTraversal(root.right);
    }

    public static void printIterativePreorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr!=null) {
                System.out.print(curr.data + " ");
                if(curr.right != null) {
                    stack.push(curr.right);
                }
                curr = curr.left;
            }
            if(!stack.isEmpty()) {
                curr = stack.pop();
            }
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
        printPreorderTraversal(root);
        System.out.println();
        printIterativePreorderTraversal(root);
    }
}
