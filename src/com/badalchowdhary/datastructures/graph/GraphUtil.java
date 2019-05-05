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
        System.out.println("A connected to D: " + g.isConnected(new Vertex("A"), new Vertex("D")));
        System.out.println("A connected to E: " + g.isConnected(new Vertex("A"), new Vertex("E")));
        
        System.out.println("A -> B connLevel: " + g.getConnLevel(new Vertex("A"), new Vertex("B")));
        System.out.println("B -> A connLevel: " + g.getConnLevel(new Vertex("B"), new Vertex("A")));
        System.out.println("A -> E connLevel: " + g.getConnLevel(new Vertex("A"), new Vertex("E")));
        System.out.println("E -> A connLevel: " + g.getConnLevel(new Vertex("E"), new Vertex("A")));
        System.out.println("A -> C connLevel: " + g.getConnLevel(new Vertex("A"), new Vertex("C")));
        
        // console output
//        A neighbors: [B]
//        A connected to B: true
//        B connected to A: true
//        A connected to D: true
//        A connected to E: true
//        A -> B connLevel: 1
//        B -> A connLevel: 1
//        A -> E connLevel: 4
//        E -> A connLevel: 4
//        A -> C connLevel: 2               
    }

}
