package com.dogacoder.www.graph;

import org.junit.Test;

public class CycleUsingDisjointSets {

    public boolean isCycle(Graph g) {

        int[] parent = new int[g.v];
        for (int i = 0; i < g.v; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < g.e; i++) {
            int xSet = find(parent, g.edges[i].source);
            int ySet = find(parent, g.edges[i].destination);
            if (xSet == ySet) {
                return true;
            }
            else {
                union(parent, g.edges[i].source, g.edges[i].destination);
            }
        }
        return false;


    }

    private int find(int[] parent, int source) {
        if (parent[source] == -1) {
            return source;
        }
        return find(parent, parent[source]);
    }

    void union(int parent[], int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    class Graph {
        int v;
        int e;
        Edge[] edges;

        public Graph(int v, int e) {
            this.v = v;
            this.e = e;
            this.edges = new Edge[e];
            for (int i = 0; i < e; i++) {
                edges[i] = new Edge();
            }
        }
    }

    class Edge {
        int source;
        int destination;
        int weight;

        public Edge() {
        }

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int getSource() {
            return source;
        }

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }
    }

    @Test
    public void test() {
        /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
        int V = 3, E = 2;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edges[0].source = 0;
        graph.edges[0].destination = 1;

        // add edge 1-2
        graph.edges[1].source = 1;
        graph.edges[1].destination = 2;

//        // add edge 0-2
//        graph.edges[2].source = 0;
//        graph.edges[2].destination = 2;

        if (isCycle(graph))
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
