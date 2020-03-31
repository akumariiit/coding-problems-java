package com.dogacoder.www.graph;

import org.junit.jupiter.api.Test;

public class CycleInGraph {

    public boolean isCycle(Graph g) {
        boolean[] visited = new boolean[g.getNumberOfNodes()];

        return isCyclePresent(g.getStartNode(), g, visited);
    }

    private boolean isCyclePresent(int node, Graph g, boolean[] visited) {
        if (visited[node]) {
            return true;
        }
        boolean isCycle = false;
        visited[node] = true;

        for (int child: g.getAdjacencyListOfNode(node)) {
            isCycle = isCycle || isCyclePresent(child, g, visited);
        }
        return isCycle;
    }

    @Test
    public void testCycle() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(isCycle(graph))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }

    @Test
    public void testNoCycle() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);

        if(isCycle(graph))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
