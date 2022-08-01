package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;


public class BoundaryTraversal {
    public static void printBoundaryElements(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    public static void printLeaves(TreeNode root) {
        if(root == null) {
            return;
        }
        printLeaves(root.left);
        if(root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeaves(root.right);
    }
    public static void printLeftBoundary(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.left);
        } else if(root.right != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.right);
        }
    }

    public static void printRightBoundary(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.right != null) {
            printRightBoundary(root.right);
            System.out.print(root.data + " ");
        } else if (root.left != null) {
            printRightBoundary(root.left);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
        printBoundaryElements(root);
    }
}
