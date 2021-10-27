package com.TreeQuestions;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.utilsDataStructures.TreeNode;

public class BottomView {

    static class pair {
        int data;
        int level;
        pair(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }
    static TreeMap<Integer, pair> map;

    static void fillMap(TreeNode root, int hd, int level) {
        if(root == null) {
            return;
        }

        if(map.get(hd) == null) {
            map.put(hd, new pair(root.data, level));
        } else if(map.get(hd).level <= level) {
            map.put(hd, new pair(root.data, level));
        }
        if(root.left != null) {
            fillMap(root.left, hd - 1, level + 1);
        }
        if(root.right != null) {
            fillMap(root.right, hd + 1, level + 1);
        }
    }

    static ArrayList<Integer> bottomView(TreeNode root) {
        map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        fillMap(root, 0, 0);
        for(Map.Entry<Integer, pair> entry: map.entrySet()) {
            result.add(entry.getValue().data);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        ArrayList<Integer> result = bottomView(root);
        System.out.println(result);
    }
}
