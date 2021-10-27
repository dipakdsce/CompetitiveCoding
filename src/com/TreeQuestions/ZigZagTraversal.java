package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;

import java.util.Stack;

public class ZigZagTraversal {

    public static void printZigZag(TreeNode root) {
        if(root ==  null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        boolean flag = true;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if(flag) {
                while(!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    System.out.print(node.data + " ");
                    if(node.left != null) {
                        s2.push(node.left);
                    }
                    if(node.right != null) {
                        s2.push(node.right);
                    }
                }
                flag = false;
            } else {
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    System.out.print(node.data + " ");
                    if(node.right != null) {
                        s1.push(node.right);
                    }
                    if(node.left != null) {
                        s1.push(node.left);
                    }
                }
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        printZigZag(root);
    }
}
