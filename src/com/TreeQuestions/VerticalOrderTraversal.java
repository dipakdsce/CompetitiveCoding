package com.TreeQuestions;

import com.utilsDataStructures.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    private static void verticalOrderUtil(TreeNode treeNode, int vd, TreeMap<Integer, Vector<Integer>> integerVectorTreeMap) {
        if(treeNode == null) {
            return;
        }

        Vector<Integer> nodes = integerVectorTreeMap.get(vd);
        if(nodes == null) {
            nodes = new Vector<Integer>();
        }
        nodes.add(treeNode.data);
        integerVectorTreeMap.put(vd, nodes);
        verticalOrderUtil(treeNode.left, vd - 1, integerVectorTreeMap);
        verticalOrderUtil(treeNode.right, vd + 1, integerVectorTreeMap);
    }

    private static void printVerticalOrder(TreeNode treeNode) {
        TreeMap<Integer, Vector<Integer>> indexedNodes = new TreeMap<>();
        verticalOrderUtil(treeNode, 0, indexedNodes);
        for(Map.Entry<Integer, Vector<Integer>> entry : indexedNodes.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Integer>> indexedNodes = new TreeMap<>();
//        verticalOrderUtil(root, 0, indexedNodes);
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry : indexedNodes.entrySet()) {
            List<Integer> values = entry.getValue();
            Collections.sort(values);
            result.add(values);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.left.left.left = new TreeNode(55);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        printVerticalOrder(root);
    }
}
