package com.badalchowdhary.datastructures.graph;

public class GraphUtil
{
    public static Graph buildGraph()
    {
        Graph g = new Graph(false);
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        g.addEdge(a, b);
        g.addEdge(b, c);
        g.addEdge(c, d);
        g.addEdge(d, e);

        return g;
    }

    public static void main(String[] args)
    {
        Graph g = GraphUtil.buildGraph();

        System.out.println("A neighbors: " + g.getNeighbors(new Vertex("A")));
        System.out.println("A connected to B: " + g.isConnected(new Vertex("A"), new Vertex("B")));
        System.out.println("B connected to A: " + g.isConnected(new Vertex("B"), new Vertex("A")));
        System.out.println("A connected to E: " + g.isConnected(new Vertex("A"), new Vertex("E")));
    }

}
