package com.badalchowdhary.interviewcake;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTest
{

    public static void main(String[] args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3);
        
        pq.add(10);
        pq.add(30);
        pq.add(20);
        pq.add(40);
        pq.add(5);
        System.out.println(pq.poll());
        pq.add(1);
        System.out.println(pq.poll());
        pq.add(100);
        System.out.println(pq.poll());
        

    }

}
