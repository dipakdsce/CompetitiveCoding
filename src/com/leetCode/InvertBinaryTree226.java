package com.leetCode;

import com.TreeQuestions.LevelOrderTraversal;
import com.utilsDataStructures.TreeNode;

public class InvertBinaryTree226 {
    public static TreeNode invertBinaryTree(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }
        TreeNode mirror = new TreeNode(treeNode.data);
        mirror.left = invertBinaryTree(treeNode.right);
        mirror.right = invertBinaryTree(treeNode.left);
        return mirror;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right= new TreeNode(7);
        LevelOrderTraversal.printLevelOrder(treeNode);
        TreeNode mirror = invertBinaryTree(treeNode);
        System.out.println();
        LevelOrderTraversal.printLevelOrder(mirror);
    }
}
