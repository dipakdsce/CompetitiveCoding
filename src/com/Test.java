package com;

import com.utilsDataStructures.TreeNode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void printPostorder(TreeNode root) {
        if(root == null) {
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void printIterativePostorder(TreeNode root) {
        printPostorder(root);
        System.out.println();
        if (root ==  null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left != null) {
                stack1.push(node.left);
            }

            if(node.right != null) {
                stack1.push(node.right);
            }
        }

        while(!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    public static void printPostorderOneStack(TreeNode root) {
        printPostorder(root);
        System.out.println();
        if(root == null) {
            return;
        }

        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if(prev == null || curr == prev.left || curr == prev.right) {
                if(curr.left != null) {
                    stack.push(curr.left);
                } else if(curr.right != null) {
                    stack.push(curr.right);
                } else {
                    System.out.print(curr.data + " ");
                    stack.pop();
                }
            } else if(prev == curr.left) {
                if(curr.right != null) {
                    stack.push(curr.right);
                } else {
                    System.out.print(curr.data + " ");
                    stack.pop();
                }
            } else if(prev == curr.right) {
                System.out.print(curr.data + " ");
                stack.pop();
            }
            prev = curr;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
//        treeNode.right.left = new TreeNode(6);
//        treeNode.right.right= new TreeNode(7);
        printPostorderOneStack(treeNode);
    }
}
