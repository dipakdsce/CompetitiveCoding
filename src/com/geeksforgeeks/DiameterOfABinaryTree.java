package com.geeksforgeeks;

import com.utilsDataStructures.TreeNode;

public class DiameterOfABinaryTree {

    public static class NodePair {
        int height;
        int diameter;
    }

    public static NodePair findDiameterUtil(TreeNode root) {
        if(root == null) {
            NodePair pair = new NodePair();
            pair.height = -1;
            pair.diameter = 0;
            return pair;
        }

        NodePair leftPair = findDiameterUtil(root.left);
        NodePair rightPair = findDiameterUtil(root.right);

        NodePair pair = new NodePair();
        pair.height = Math.max(leftPair.height, rightPair.height) + 1 ;
        pair.diameter = Math.max(leftPair.height + rightPair.height + 2, Math.max(leftPair.diameter, rightPair.diameter));
        return pair;
    }

    public static int findDiameter(TreeNode root) {
        NodePair pair = findDiameterUtil(root);
        return pair.diameter;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(findDiameter(treeNode));
    }
}
