package com.dogacoder.www.graph;

import org.junit.Test;

public class ConnectedComponents {

    public void findConnectedComponents(Graph g) {
        int numberOfNodes = g.getNumberOfNodes();
        System.out.println(numberOfNodes);
        boolean[] visited = new boolean[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            if (!visited[i]) {
                printDFS(g, visited, i);
                System.out.println();
            }

        }

    }

    private void printDFS(Graph g, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }
        System.out.print(i + "->");
        visited[i] = true;
        for (int child : g.getAdjacencyListOfNode(i)) {
            if (!visited[child]) {
                printDFS(g, visited, child);
            }
        }
    }

    @Test
    public void test() {
        Graph g = new Graph(5); // 5 vertices numbered from 0 to 4

        g.addEdgeUndirected(1, 0);
        g.addEdgeUndirected(2, 3);
        g.addEdgeUndirected(3, 4);
        System.out.println("Following are connected components");
        findConnectedComponents(g);
    }
}
