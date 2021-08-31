package com.GraphAlogs;

import com.helper.UnWeightedGraph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    public static void bfs(int source, UnWeightedGraph graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        visited[source] = true;
        while(!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            Iterator<Integer> iterator = graph.getAdj()[v].iterator();
            while (iterator.hasNext()) {
                int nextVertex = iterator.next();
                if(!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        bfs(2, graph);*/

        UnWeightedGraph graph = new UnWeightedGraph(6);

    }
}
