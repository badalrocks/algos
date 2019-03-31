package com.badalchowdhary.datastructures;

/**
 * This class represents Node in a LinkedList.
 * 
 * @author badalrocks
 *
 */
public class Node
{
    public int  data;
    public Node next;

    public Node(int data)
    {
        this.data = data;
    }

    public int getData()
    {
        return this.data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return this.next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    @Override
    public String toString()
    {
        return "[" + data + "]";
    }

}
