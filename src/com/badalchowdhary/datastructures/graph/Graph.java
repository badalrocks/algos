package com.badalchowdhary.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph
{
    Set<Vertex>            vertices   = new HashSet<>();
    Map<Vertex, Set<Edge>> edges      = new HashMap<>();
    boolean                isDirected = false;

    public Graph(boolean isDirected)
    {
        this.isDirected = isDirected;
    }

    public void addEdge(Vertex src, Vertex dest)
    {
        vertices.add(src);
        vertices.add(dest);
        
        edges.computeIfAbsent(src, key -> new HashSet<Edge>());
        edges.get(src).add(new Edge(dest)); // unweighted edge
        
        if (!isDirected)
        {
            edges.computeIfAbsent(dest, key -> new HashSet<Edge>());
            edges.get(dest).add(new Edge(src));
        }
    }
    
    public boolean isConnected(Vertex src, Vertex dest)
    {
        if (!vertices.contains(src) || !vertices.contains(dest)) {
            throw new IllegalArgumentException();
        }
        
        return edges.get(src).contains(new Edge(dest));
    }
    
    public Set<Vertex> getNeighbors(Vertex v)
    {
        Set<Vertex> neighbors = new HashSet<>();
        
        for (Edge e: edges.get(v)) {
            neighbors.add(e.dest);
        }
        
        return neighbors;
    }
    
    
    public Graph buildGraph(boolean isDirected)
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
        g.addEdge(e, a);
        
        return g;
    }
    

}
