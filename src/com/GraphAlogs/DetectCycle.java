package com.GraphAlogs;

import com.utilsDataStructures.UnWeightedGraph;

import java.util.Iterator;
import java.util.LinkedList;

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

    public static boolean isCyclicWithDFS(UnWeightedGraph graph) {
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        for(int i=0; i< graph.getNumberOfVertices(); i++) {
            if(!visited[i]) {
                if(DFSUtil(i, graph, visited)) {
                    System.out.println("in is cyclic: " + i);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean BFSUtil(UnWeightedGraph graph, boolean[] visited, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            Iterator<Integer> iterator = graph.getAdj()[node].iterator();
            while(iterator.hasNext()) {
                int nextNode = iterator.next();
                if(visited[nextNode]) {
                    return true;
                } else {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
        return false;
    }

    public static boolean isCyclicWithBFS(UnWeightedGraph graph) {
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        for(int i=0; i<graph.getNumberOfVertices(); i++) {
            /*if(BFSUtil(graph, visited, i)) {
                System.out.println("in is cyclic: " + i);
                return true;
            }*/
            if(!visited[i]) {
                if(BFSUtil(graph, visited, i)) {
                    System.out.println("in is cyclic: " + i);
                    return true;
                }
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
        UnWeightedGraph graph1 = new UnWeightedGraph(4);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        System.out.println(isCyclicWithDFS(graph1));
        System.out.println(isCyclicWithBFS(graph1));
        System.out.println(isCyclicWithBFS(graph));
        System.out.println(isCyclicWithDFS(graph));
    }

}
