package com.badalchowdhary.interviewcake;

import com.badalchowdhary.datastructures.Node;

public class Problem25LinkedListKthToLastNode
{

    public static Node kthToLastNode(int k, Node head)
    {
        // TODO
        doBoundaryChecks(k, head);
        
        Node behind = head;
        Node ahead = head;
     
        // move ahead k times.   
        for (int i=0; i<k; i++)
        {
            if (ahead == null)
            {
                throw new IllegalArgumentException("length of linkedlist is smaller than k.");
            }
            
            ahead = ahead.getNext();
        }
        
        while (ahead != null)
        {
            ahead = ahead.getNext();
            behind = behind.getNext();
        }
        
        return behind;
        
    }
        
    private static void doBoundaryChecks(int k, Node head)
    {
        if (k < 1)
        {
            throw new IllegalArgumentException("k must be greater than 0.");
        }
        
        if (head == null)
        {
            throw new IllegalArgumentException("Invalid input. head cannot be null.");
        }
        
    }    
        

    public static void main(String[] args)
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        
        System.out.println(kthToLastNode(2, n1));
        

    }

}
