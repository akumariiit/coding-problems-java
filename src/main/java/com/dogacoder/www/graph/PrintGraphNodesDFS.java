package com.dogacoder.www.graph;

import org.junit.Test;

public class PrintGraphNodesDFS {

    public void printGraphDFS(Graph g) {
        boolean[] visited = new boolean[g.getNumberOfNodes()];
        print(g.getStartNode(), visited, g);
    }

    private void print(int node, boolean[] visited, Graph g) {
        visited[node] = true;
        System.out.println(node);

        for (int v: g.getAdjacencyListOfNode(node)) {
            if (!visited[v]) {
                print(v, visited, g);
            }
        }

    }

    @Test
    public void testPrintGraphDFS() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.setStartNode(0);
        printGraphDFS(g);
    }
}
