package com.badalchowdhary.algos.linkedlist;

import com.badalchowdhary.datastructures.LinkedList;
import com.badalchowdhary.datastructures.Node;

/**
 * Demonstrates following linked list operations: add, delete, count.
 * 
 * @author badalrocks
 *
 */
public class LinkedListBasicOperations
{
    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.add(new Node(1));
        ll.add(new Node(2));
        ll.add(new Node(3));
        ll.add(new Node(4));

        System.out.println("after adding 1,2,3,4: " + ll);

        ll.delete(new Node(2));
        System.out.println("after deleting 2: " + ll);

        ll.delete(new Node(1));
        System.out.println("after deleting 1: " + ll);

        System.out.println("node count: " + ll.getNodeCount());

        ll.delete(new Node(3));
        System.out.println("after deleting 3: " + ll);

        System.out.println("node count: " + ll.getNodeCount());

        ll.delete(new Node(4));
        System.out.println("after deleting 4: " + ll);
        System.out.println("node count: " + ll.getNodeCount());

    }

}
