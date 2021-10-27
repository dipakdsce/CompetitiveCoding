package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;

public class LargestPerfectSubTree {
    public static class AnswerType {
        boolean isPerfect;
        int height;
        TreeNode root;
    }

    public static AnswerType finMaxSizePerfectBinaryTree(TreeNode root) {
        AnswerType answerType = new AnswerType();
        if(root == null) {
            answerType.isPerfect =  true;
            answerType.height = 0;
            answerType.root = null;
            return answerType;
        }

        AnswerType leftAnswerType = finMaxSizePerfectBinaryTree(root.left);
        AnswerType rightAnswerType = finMaxSizePerfectBinaryTree(root.right);

        if(leftAnswerType.isPerfect && rightAnswerType.isPerfect && leftAnswerType.height == rightAnswerType.height) {
            rightAnswerType.height = leftAnswerType.height + 1;
            rightAnswerType.root = root;
            return rightAnswerType;
        }

        rightAnswerType.isPerfect = false;
        rightAnswerType.height = Math.max(rightAnswerType.height, leftAnswerType.height);
        rightAnswerType.root = (rightAnswerType.height > leftAnswerType.height) ? rightAnswerType.root : leftAnswerType.root;
        return rightAnswerType;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(18);
        root.left = new TreeNode(15);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(100);
        root.right.right = new TreeNode(40);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(9);
        AnswerType answer = finMaxSizePerfectBinaryTree(root);
        System.out.println("Length of MaximumPerfectSubtree= " + (int)(Math.pow(2, answer.height) - 1));
    }
}
