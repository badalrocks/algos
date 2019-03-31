package com.badalchowdhary.interviewcake;

import java.util.Stack;

public class Problem19QueueWith2Stacks
{
    private Stack<Integer> inStack = new Stack<Integer>();
    private Stack <Integer> outStack = new Stack <Integer>();
    
    public void enqueue(int item)
    {
        inStack.push(item);
    }
    
    public int dequeue()
    {
        if (! outStack.isEmpty())
        {
            return outStack.pop();
        }
        
        if (! inStack.isEmpty())
        {
            moveItems(inStack, outStack);
            return outStack.pop();
        }
        
        throw new RuntimeException("Queue is empty.");
    }
    
    private void moveItems(Stack src, Stack dest)
    {
        // do boundary checks.
        while (! src.isEmpty())
        {
            dest.push(src.pop());
        }
        
    }

    public static void main(String[] args)
    {
        Problem19QueueWith2Stacks q = new Problem19QueueWith2Stacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(6);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        

    }

}
