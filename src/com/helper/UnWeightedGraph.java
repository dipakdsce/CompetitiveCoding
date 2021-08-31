package com.helper;

import java.util.LinkedList;

public class UnWeightedGraph {
    private int v;
    private LinkedList<Integer> adj[];

    public UnWeightedGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public int getNumberOfVertices() {
        return v;
    }
}
