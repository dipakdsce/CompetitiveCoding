package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class DiagonalTraversal {
    public static void diagonalTraverse(TreeNode root, int d, TreeMap<Integer, Vector<Integer>> treeMap) {
        if(root == null) {
            return;
        }

        Vector<Integer> nodes = treeMap.get(d);
        if(nodes == null) {
            nodes = new Vector<>();
            nodes.add(root.data);
            treeMap.put(d, nodes);
        } else {
            nodes.add(root.data);
        }
        treeMap.put(d, nodes);
        diagonalTraverse(root.left, d+1, treeMap);
        diagonalTraverse(root.right, d, treeMap);
    }
    public static void diagonalPrint(TreeNode root) {
        TreeMap<Integer, Vector<Integer>> treeMap = new TreeMap<>();
        diagonalTraverse(root, 0, treeMap);
        for(Map.Entry<Integer, Vector<Integer>> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        diagonalPrint(root);
    }
}
