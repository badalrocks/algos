package com.badalchowdhary.interviewcake;

import com.badalchowdhary.datastructures.LinkedList;
import com.badalchowdhary.datastructures.Node;

/**
 * Write a method for reversing a linked list. Do it in-place.
 * 
 * @author badalrocks
 *
 */
public class Problem24LinkedListReverse
{

    public static Node reverseLinkedList(Node head)
    {
        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null)
        {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args)
    {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        Node newHead = reverseLinkedList(n1);

        while (newHead != null)
        {
            System.out.println(newHead.getData());
            newHead = newHead.getNext();
        }

    }

}
