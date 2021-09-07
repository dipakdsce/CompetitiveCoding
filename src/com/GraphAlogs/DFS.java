package com.GraphAlogs;

import com.utilsDataStructures.UnWeightedGraph;

import java.util.Iterator;

public class DFS {

    public static void DFSUtil(int source, UnWeightedGraph graph, boolean[] visited) {
        System.out.print(source + " ");
        visited[source] = true;

        Iterator<Integer> iterator = graph.getAdj()[source].iterator();
        while (iterator.hasNext()) {
            int node = iterator.next();
            if(!visited[node]) {
                DFSUtil(node, graph, visited);
            }
        }
    }

    public static void dfs(int source, UnWeightedGraph graph) {
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        DFSUtil(source, graph, visited);
    }

    public static void dfsForDisconnectedGraph(UnWeightedGraph graph) {
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        for(int i=0; i<graph.getNumberOfVertices(); i++) {
            if(!visited[i]) {
                DFSUtil(i, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        UnWeightedGraph graph = new UnWeightedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        dfs(2, graph);
        System.out.println();
        dfsForDisconnectedGraph(graph);
    }
}
