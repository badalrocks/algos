package com.badalchowdhary.algos.design;

import java.util.HashMap;
import java.util.Map;

class LRUCache
{

    private DoublyLinkedNode       head;
    private DoublyLinkedNode       tail;
    int                            capacity;
    Map<Integer, DoublyLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity)
    {
        // System.out.println("capacity: " + capacity);
        this.capacity = capacity;
    }

    public int get(int key)
    {
        System.out.println("get: " + key);

        if (!cache.containsKey(key))
        {
            return -1;
        }

        DoublyLinkedNode node = cache.get(key);
        moveToTail(node);

        printDll();

        return node.val;

    }

    public void put(int key, int value)
    {
        System.out.println("put: " + key + "-" + value);

        if (!cache.containsKey(key))
        {
            DoublyLinkedNode node = addToTail(key, value);
            cache.put(key, node);

            if (cache.size() > capacity)
            {
                System.out.println("removing head: " + head);
                cache.remove(head.key);
                head = head.next;
                head.prev = null;

            }
        }
        else
        {
            moveToTail(cache.get(key));
        }

        printDll();

    }

    public DoublyLinkedNode addToTail(int key, int val)
    {
        // System.out.println("addToTail: " + data);
        DoublyLinkedNode node = new DoublyLinkedNode(key, val);
        if (tail == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = tail.next;
        }

        return node;
    }

    public void moveToTail(DoublyLinkedNode node)
    {
        // System.out.println("moveToTail: " + node.val);
        if (tail == node)
        {
            return;
        }

        if (head == node)
        {
            head = node.next;
        }
        else
        {
            node.prev.next = node.next;
        }

        addToTail(node.key, node.val);
        node = null;
    }

    public void printDll()
    {
        DoublyLinkedNode temp = head;
        while (temp != null)
        {
            System.out.print(temp + " -> ");
            temp = temp.next;
        }

         System.out.print("head: " + head + ", tail: " + tail +"\n");
         
    }

    public static void main(String[] args)
    {
        LRUCache cache = new LRUCache(2 /* capacity */ );

        cache.put(2, 1);
        cache.put(1, 1);
        cache.get(2);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }

}

class DoublyLinkedNode
{
    int              key;
    int              val;
    DoublyLinkedNode prev;
    DoublyLinkedNode next;

    public DoublyLinkedNode(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
    
    public String toString()
    {
        return this.key + "-" + this.val;
    }
}