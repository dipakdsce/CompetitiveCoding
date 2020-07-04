package com.geeksforgeeks;

import com.helper.Graph;

import java.util.Iterator;

public class SumOfMinimumAtEachDepth {
    private static int V;
    private static Graph graph;

    static int maxDepth = 0;

    public static void findDepth(Graph graph, boolean[] visited, int source, int depth) {
        visited[source] = true;
        maxDepth = Math.max(maxDepth, depth);
        for(Integer n : graph.getAdj()[source]) {
            if(!visited[n]) {
                findDepth(graph, visited, n, depth + 1);
            }
        }
    }

    public static void dfs(Graph graph, int source, boolean[] visited, int[] store_min_elements, int depth) {
        visited[source] = true;
        store_min_elements[depth] = Math.min(store_min_elements[depth], source);
        Iterator<Integer> iterator = graph.getAdj()[source].iterator();
        while(iterator.hasNext()) {
            int n = iterator.next();
            if(!visited[n]) {
                dfs(graph, n, visited, store_min_elements, depth + 1);
            }
        }
    }

    public static void minSum_depth(Graph graph, int source) {
        boolean[] visited = new boolean[V];
        findDepth(graph, visited, source, 0);
        int[] store_min_elements = new int[maxDepth + 1];
        for(int i=0; i< maxDepth + 1; i++) {
            store_min_elements[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<V; i++) {
            visited[i] = false;
        }
        dfs(graph, source, visited, store_min_elements, 0);

        int minSum = 0;
        for(int i=0; i< maxDepth + 1; i++) {
            minSum += store_min_elements[i];
        }
        System.out.println(minSum);
    }

    public static void main(String[] args) {
        graph = new Graph(8);
        V = 8;
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 6);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 7);

        minSum_depth(graph, 0);
    }
}
