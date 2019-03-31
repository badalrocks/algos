package com.badalchowdhary.interviewcake;

import com.badalchowdhary.datastructures.Node;

/**
 * You have a singly-linked list and want to check if it contains a cycle.
 * 
 * @author badalrocks
 *
 */
public class Problem23LinkedListContainsCycle
{

    public static boolean containsCycle(Node head)
    {
        // TODO do boundary checks.
        doBoundaryChecks(head);
        
        Node fastRunner = head;
        Node slowRunner = head;
        
        while (fastRunner.getNext() != null && fastRunner.getNext().getNext() != null)
        {
            fastRunner = fastRunner.getNext().getNext();
            slowRunner = slowRunner.getNext();
            
            if (fastRunner == slowRunner)
            {
                return true;
            }
        }
        
        return false;
    }
    
    private static void doBoundaryChecks(Node head)
    {
        if (head == null)
        {
            throw new IllegalArgumentException("head cannot be null.");
        }
    }
    public static void main(String[] args)
    {
        Node n1 = new Node(10);
        Node n2 = new Node(10);
        Node n3 = new Node(10);
        Node n4 = new Node(10);
        
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n1);
        
        System.out.println(containsCycle(n1));
        
    }

}
