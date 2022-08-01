package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

public class CheckBinaryTreeBalanced {
    public static int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean isBinaryTreeBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) <= 1 && isBinaryTreeBalanced(root.left) && isBinaryTreeBalanced(root.right)) {
            return true;
        }
        return false;
    }

    static class Height {
        int height;
    }

    public static boolean isBalanced(TreeNode root, Height height) {
        if(root == null) {
            height.height = 0;
            return true;
        }
        Height lHeight = new Height();
        Height rHeight = new Height();

        boolean leftSubtree = isBalanced(root.left, lHeight);
        boolean rightSubtree = isBalanced(root.right, rHeight);

        height.height = (Math.max(lHeight.height, rHeight.height)) + 1;
        if(Math.abs(lHeight.height - rHeight.height) >= 2)  {
            return false;
        }
        return leftSubtree && rightSubtree;
    }

    public static int modifiedHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = modifiedHeight(root.left);
        int rh = modifiedHeight(root.right);
        if(Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }

    public static boolean thirdMethod(TreeNode root) {
        return modifiedHeight(root) != -1;
    }
    transient int a;

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        System.out.println(isBinaryTreeBalanced(root));
        System.out.println(isBalanced(root, new Height()));
        System.out.println(thirdMethod(root));*/
       int a = 500/0;
        System.out.println(a);

    }
}
