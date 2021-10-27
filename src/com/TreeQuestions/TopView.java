package com.TreeQuestions;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.utilsDataStructures.TreeNode;

public class TopView{
    static class pair {
        int data;
        int level;
        pair(int data, int level) {
            this.data = data;
            this.level = level;
        }
        
    }
    
    static TreeMap<Integer, pair> map = new TreeMap<>();

    static void fillMap(TreeNode root, int level, int hd) {
        if(root == null) {
            return;
        }
        if(map.get(hd) ==  null) {
            map.put(hd, new pair(root.data, level));
        } else if(map.get(hd).level > level) {
            map.put(hd, new pair(root.data, level));
        }
        
        if(root.left != null) {
            fillMap(root.left, level+1, hd - 1);
        }
        
        if(root.right != null) {
            fillMap(root.right, level+1, hd + 1);
        }
    }
    
    static ArrayList<Integer> topView(TreeNode root)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null) {
            return arrayList;
        }
        
        fillMap(root, 0, 0);
        
        for(Map.Entry<Integer, pair> entry : map.entrySet()) {
            arrayList.add(entry.getValue().data);
        }
        return arrayList;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        ArrayList<Integer> result = topView(root);
        System.out.println(result);
    }
}