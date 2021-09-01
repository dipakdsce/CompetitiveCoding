package com.GraphAlogs;

import com.helper.UnWeightedGraph;

public class DetectCycle {

    public static boolean DFSUtil(int source, UnWeightedGraph graph, boolean[] visited) {
        if(visited[source]) {
            System.out.println(source);
            return true;
        }

        visited[source] = true;

        for (int node : graph.getAdj()[source]) {
            if (visited[node]) {
                System.out.println("in For Loop of DFS Util: " + node);
                return true;
            } else {
                DFSUtil(node, graph, visited);
            }
        }
        return false;
    }

    public static boolean isCyclic(UnWeightedGraph graph) {
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        for(int i=0; i< graph.getNumberOfVertices(); i++) {
            if(DFSUtil(i, graph, visited)) {
                System.out.println("in is cyclic: " + i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println(isCyclic(graph));
    }

}
