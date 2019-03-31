package com.badalchowdhary.datastructures;

public class DoublyLinkedList
{

    private int              val;
    private DoublyLinkedList previous;
    private DoublyLinkedList next;

    public DoublyLinkedList(int val, DoublyLinkedList previous, DoublyLinkedList next)
    {
        super();
        this.val = val;
        this.previous = previous;
        this.next = next;
    }

    public DoublyLinkedList(int val)
    {
        super();
        this.val = val;
    }

    public int getVal()
    {
        return val;
    }

    public void setVal(int val)
    {
        this.val = val;
    }

    public DoublyLinkedList getPrevious()
    {
        return previous;
    }

    public void setPrevious(DoublyLinkedList previous)
    {
        this.previous = previous;
    }

    public DoublyLinkedList getNext()
    {
        return next;
    }

    public void setNext(DoublyLinkedList next)
    {
        this.next = next;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("val: " + val);
        
        if (previous != null)
        {
            sb.append(" previous: " + previous.val);
        }
        
        if (next != null)
        {
            sb.append(" next: " + next.val);
        }
        
        return sb.toString();
    }
    
    

}
