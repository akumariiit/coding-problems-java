package com.dogacoder.www.graph;

import java.util.LinkedList;

public class Graph {
    private final int numberOfNodes;
    private final LinkedList<Integer>[] adjacencyLists;
    private int startNode;

    public Graph(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        adjacencyLists = new LinkedList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            adjacencyLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int target) {
        adjacencyLists[source].add(target);
    }
    public void addEdgeUndirected(int source, int target) {
        adjacencyLists[source].add(target);
        adjacencyLists[target].add(source);
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public LinkedList<Integer>[] getAdjacencyLists() {
        return adjacencyLists;
    }

    public LinkedList<Integer> getAdjacencyListOfNode(int node) {
        return adjacencyLists[node];
    }

    public int getStartNode() {
        return startNode;
    }

    public void setStartNode(int startNode) {
        this.startNode = startNode;
    }
}
