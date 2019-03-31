package com.badalchowdhary.leetcode;

import com.badalchowdhary.datastructures.BinaryNode;
import com.badalchowdhary.datastructures.BinaryTree;
import com.badalchowdhary.datastructures.DoublyLinkedList;

public class BinarySearchTreeToSortedDoublyLinkedList
{

    private static DoublyLinkedList previous = null;
    private static DoublyLinkedList head = null;
    public static DoublyLinkedList convertBstToDll(BinaryNode root)
    {
        convertBstToDllHelper(root);
        
        return head;
    }
    
    private static void convertBstToDllHelper(BinaryNode node)
    {
        if (node == null)
        {
            return;
        }
        
        // go left
        convertBstToDllHelper(node.getLeft());
        
        // process
        DoublyLinkedList dllNode = new DoublyLinkedList(node.getData());
        
        if (previous == null)
        {
            head = dllNode;
            previous = dllNode;
        }
        else
        {
            previous.setNext(dllNode);
            dllNode.setPrevious(previous);
            previous = dllNode;
        }
        
        // go right
        convertBstToDllHelper(node.getRight());
        
    
    }

    public static void main(String[] args)
    {
        BinaryNode root = BinaryTree.getBinaryTree();
        
        DoublyLinkedList head = convertBstToDll(root);
        
        while (head != null)
        {
            System.out.print(head.getVal() + " -> ");
            head = head.getNext();
        } 
        
        
    }

}
