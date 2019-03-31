package com.badalchowdhary.algos.linkedlist;

import com.badalchowdhary.datastructures.LinkedList;
import com.badalchowdhary.datastructures.Node;

public class LinkedListPalindrome
{

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.add(new Node(1));
        ll.add(new Node(2));
        ll.add(new Node(2));
        ll.add(new Node(1));
        
        System.out.println(isPalindrome(ll.getHead()));
        

    }
    
public static boolean isPalindrome(Node head) {
        
        if (head == null || head.next == null) return true; // size 0 and size 1.
        
        if (head.next.next == null)
        {
            return head.data == head.next.data;
        }
        
        
        // slow and fast pointer. 
        // move fast point to beginning of 2nd half.
        // reverse 2nd half.
        // compare 1st half and 2nd half.
        
        
        // 1, 0, 1
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null)
        {
            // odd size
            slow = slow.next;
        }
        
        // reverse 2nd half.
        slow = reverse(slow);
        
        fast = head;
        
        while (slow != null)
        {
            if (fast.data != slow.data)
            {
                return false;
            }
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
            
        
    }
    
    
    
    public static Node reverse(Node head)
    {
        if (head == null || head.next == null) return head;
        Node temp = null;
        Node prev = null;
        Node current = head;
        
        while (current.next != null)
        {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        current.next = prev;
        
        return current;
        
    }

}
