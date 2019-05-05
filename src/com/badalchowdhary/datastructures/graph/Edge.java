package com.badalchowdhary.datastructures.graph;

public class Edge
{
    public Vertex dest;
    public int    weight;

    public Edge(Vertex dest)
    {
        this.dest = dest;
    }

    public Edge(Vertex dest, int weight)
    {
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int hashCode()
    {
        return this.dest.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Edge))
        {
            return false;
        }
        Edge e = (Edge) obj;
        return this.dest.equals(e.dest);
    }

}
