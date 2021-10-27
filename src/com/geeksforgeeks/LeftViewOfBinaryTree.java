package com.geeksforgeeks;

import com.utilsDataStructures.TreeNode;

public class LeftViewOfBinaryTree {
    static int maxLevel = 0;
    public static void leftView(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(maxLevel < level) {
            System.out.println(root.data);
            maxLevel = level;
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        leftView(treeNode, 1);
    }
}
