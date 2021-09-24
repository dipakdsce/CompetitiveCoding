package com.TreeQuestions;

import com.sun.source.tree.Tree;
import com.utilsDataStructures.TreeNode;

import java.util.Stack;

public class PostOrderTraversal {
    public static void printPostorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        printPostorderTraversal(root.left);
        printPostorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void printIterativePostorderTraversal(TreeNode root) {
        if(root ==  null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if(temp.left != null) {
                stack1.push(temp.left);
            }
            if(temp.right != null) {
                stack1.push(temp.right);
            }
        }
        while(!stack2.isEmpty()) {
            TreeNode temp = stack2.pop();
            System.out.print(temp.data + " ");
        }
    }
// 10 30 70
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        printPostorderTraversal(root);
        System.out.println();
        printIterativePostorderTraversal(root);
    }
}
