package com.badalchowdhary.algos.linkedlist;

import com.badalchowdhary.datastructures.LinkedList;
import com.badalchowdhary.datastructures.Node;

/**
 * Reversing a linked list in place.
 * 
 * @author badalrocks
 *
 */
public class ReverseLinkedList
{
    public static void reverse(LinkedList ll)
    {
        Node head = ll.getHead();

        if (head == null)
        {
            return;
        }

        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null)
        {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head = prev;
    }

    public static void main(String[] args)
    {
        // normal ll.
        LinkedList ll = new LinkedList();
        ll.add(new Node(1));
        ll.add(new Node(2));
        ll.add(new Node(3));
        ll.add(new Node(4));

        System.out.println(ll);
        reverse(ll);
        System.out.println("after reverse: " + ll);

        System.out.println("----------------------------------");

        // ll with 1 node.
        LinkedList ll2 = new LinkedList();
        ll2.add(new Node(1));

        System.out.println(ll2);
        reverse(ll2);
        System.out.println("after reverse: " + ll2);

        System.out.println("----------------------------------");

        // ll with no nodes.
        LinkedList ll3 = new LinkedList();

        System.out.println(ll3);
        reverse(ll3);
        System.out.println("after reverse: " + ll3);

    }

}
