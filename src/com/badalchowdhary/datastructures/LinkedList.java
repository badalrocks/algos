package com.badalchowdhary.datastructures;

public class LinkedList
{
    private Node head;

    public void add(Node node)
    {
        if (head == null)
        {
            head = node;
            return;
        }

        Node currentNode = head;

        while (currentNode.getNext() != null)
        {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(node);
    }

    public void delete(Node node)
    {
        Node currentNode = head;

        if (currentNode.getData() == node.getData())
        {
            head = currentNode.getNext();
            currentNode = null;
            return;
        }

        Node nextNode = currentNode.getNext();

        while (currentNode.getNext() != null)
        {
            if (nextNode.getData() == node.getData())
            {
                currentNode.setNext(nextNode.getNext());
                nextNode = null;
                return;
            }

            currentNode = currentNode.getNext();
            nextNode = nextNode.getNext();
        }
    }

    public int getNodeCount()
    {
        if (head == null)
        {
            return 0;
        }

        int count = 1;

        Node currentNode = head;
        while (currentNode.getNext() != null)
        {
            count++;
            currentNode = currentNode.getNext();
        }

        return count;
    }

    public String getLinkedListNodes()
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

    public void setHead(Node head)
    {
        this.head = head;
    }

}
