package com.badalchowdhary.datastructures.graph;

public class Vertex
{
    public String name;

    public Vertex(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Vertex))
        {
            return false;
        }

        Vertex v = (Vertex) obj;
        return this.name.equals(v.name);
    }

    @Override
    public String toString()
    {
        return name;
    }
    
    

}
