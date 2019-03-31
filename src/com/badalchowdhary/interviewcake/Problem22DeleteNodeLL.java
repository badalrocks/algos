package com.badalchowdhary.interviewcake;

import com.badalchowdhary.datastructures.LinkedList;
import com.badalchowdhary.datastructures.Node;

/**
 * Delete a node from a singly-linked list, given only a variable pointing to
 * that node.
 * 
 * @author badalrocks
 *
 */
public class Problem22DeleteNodeLL
{

    public static boolean deleteNode(Node nodeToBeDeleted)
    {
        // TODO do boundary checks.
        doBoundaryChecksDeleteNode(nodeToBeDeleted);

        if (nodeToBeDeleted.getNext() == null)
        {
            // can't delete last node with this method.
            // even if you point last node's reference to null, it will just
            // repoint the reference of last node.
            // it won't null the object reference that linked list uses. thus it
            // won't have any impact on linkedlist already created.
            throw new IllegalArgumentException("Can't delete last node");
        }

        Node nextNode = nodeToBeDeleted.getNext();
        nodeToBeDeleted.setData(nextNode.getData());
        nodeToBeDeleted.setNext(nextNode.getNext());

        return true;
    }

    public static void doBoundaryChecksDeleteNode(Node nodeToBeDeleted)
    {
        if (nodeToBeDeleted == null)
        {
            throw new IllegalArgumentException("Node to be deleted cannot be null");
        }
    }

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        ll.add(n1);
        ll.add(n2);
        ll.add(n3);
        ll.add(n4);

        boolean deleten2 = deleteNode(n2);
        System.out.println(deleten2);

        // can't delete last node.
        boolean deleten4 = deleteNode(n4);
        System.out.println(deleten4);

        System.out.println(ll.toString());

    }

}
