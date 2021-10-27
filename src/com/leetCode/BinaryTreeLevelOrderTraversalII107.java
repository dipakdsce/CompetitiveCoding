package com.leetCode;

import com.utilsDataStructures.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII107 {
    public static List<List<Integer>> reverseLevelOrderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        queue.add(null);
        List<Integer> current = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                current.add(node.data);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            } else {
                List<Integer> levelNodes = new ArrayList<>(current);
                result.add(levelNodes);
                current.clear();
                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }

        Collections.reverse(result);
        return result;
    }

//    que = 15 7   stk = 3 9 20 15 7
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<List<Integer>> result = reverseLevelOrderTraversal(treeNode);
        System.out.println(result);
    }
}
