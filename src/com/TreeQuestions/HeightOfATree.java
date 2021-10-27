package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;

public class HeightOfATree {
    public static int heightOfTree(TreeNode root, int height) {
        if(root == null) {
            return height;
        }

        int leftHeight = heightOfTree(root.left, height+1);
        int rightHeight = heightOfTree(root.right, height+1);
        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
//        treeNode.left.left.left = new TreeNode(5);
        System.out.println(heightOfTree(treeNode, 0));
    }
}
