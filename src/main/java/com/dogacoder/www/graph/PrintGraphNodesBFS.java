package com.dogacoder.www.graph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class PrintGraphNodesBFS {

    public void printGraphNodes(Graph graph) {
        boolean[] visited = new boolean[graph.getNumberOfNodes()];
        for (int i = 0; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(graph.getStartNode());
        visited[graph.getStartNode()] = true;
        while (!queue.isEmpty()) {
            int currentElement = queue.poll();
            System.out.println(currentElement);

            for (int i = 0; i < graph.getAdjacencyListOfNode(currentElement).size(); i++) {
                if (!visited[graph.getAdjacencyListOfNode(currentElement).get(i)]) {
                    queue.add(graph.getAdjacencyListOfNode(currentElement).get(i));
                    visited[graph.getAdjacencyListOfNode(currentElement).get(i)] = true;
                }
            }
        }
    }

    @Test
    public void testPrintGraphBFS() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.setStartNode(0);
        printGraphNodes(g);
    }
}
