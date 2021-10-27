package com.geeksforgeeks;

import com.utilsDataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBinaryTree {
    public static void topView(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i=1; i<=queueSize; i++) {
                TreeNode node = queue.poll();
                if(queueSize == 1) {
                    System.out.println(node.data);
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                    break;
                }
                if(i == 1) {
                    System.out.println(node.data);
                }

                if(i == queueSize) {
                    System.out.println(node.data);
                }

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        topView(treeNode);
    }
}
