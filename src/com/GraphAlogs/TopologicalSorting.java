package com.GraphAlogs;

import com.utilsDataStructures.UnWeightedGraph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSorting {

    public static Stack<Integer> topSort(UnWeightedGraph graph) {
        Stack<Integer> resultStack = new Stack<>();
        int V = graph.getNumberOfVertices();
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            if(visited[i]) {
                continue;
            }
            topSortUtil(graph, visited, resultStack, i);
        }
        return resultStack;
    }

    public static void topSortUtil(UnWeightedGraph graph, boolean[] visited, Stack<Integer> stack, int source) {
        visited[source] = true;
        Iterator<Integer> iterator = graph.getAdj()[source].iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if(visited[n]) {
                continue;
            }
            topSortUtil(graph, visited, stack, n);
        }
        stack.push(source);
    }

    public static void main(String[] args) {
        UnWeightedGraph graph = new UnWeightedGraph(7);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(1,5);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        Stack<Integer> topSort = topSort(graph);
        for(int i=0; i<graph.getNumberOfVertices(); i++) {
            System.out.print(topSort.pop() + " ");
        }
    }
}
