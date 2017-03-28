package com.badalchowdhary.datastructures;

public class LinkedList
{
    private Node head;
    private int  count;

    public void add(Node node)
    {
        if (head == null)
        {
            head = node;
            count++;
            return;
        }

        Node currentNode = head;

        while (currentNode.getNext() != null)
        {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(node);
        count++;
    }

    public void delete(Node node)
    {
        if (head == null)
        {
            return;
        }

        Node currentNode = head;

        if (currentNode.getData() == node.getData())
        {
            head = currentNode.getNext();
            currentNode = null;
            count--;
            return;
        }

        Node nextNode = currentNode.getNext();

        while (currentNode.getNext() != null)
        {
            if (nextNode.getData() == node.getData())
            {
                currentNode.setNext(nextNode.getNext());
                nextNode = null;
                count--;
                return;
            }

            currentNode = currentNode.getNext();
            nextNode = nextNode.getNext();
        }
    }

    public int getNodeCount()
    {
        return this.count;
    }

    @Override
    public String toString()
    {
        if (head == null)
        {
            return null;
        }

        StringBuffer sb = new StringBuffer();

        Node currentNode = head;

        while (currentNode.getNext() != null)
        {
            sb.append(currentNode.getData() + " -> ");
            currentNode = currentNode.getNext();
        }

        sb.append(currentNode.getData()); // add last element in ll.

        return sb.toString();
    }

    public Node getHead()
    {
        return head;
    }

}
