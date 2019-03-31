package com.badalchowdhary.interviewcake;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class SolutionMaxProductOf3Integers
{
    public int maximumProduct(int[] nums)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(3, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);

        for (int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            processMinHeap(minHeap, num);
            processMaxHeap(maxHeap, num);
        }

        System.out.println("minHeap: " + minHeap);
        System.out.println("maxHeap: " + maxHeap);

        int maxNumber = 1;
        int maxProduct = 1;
        while (!minHeap.isEmpty())
        {
            maxNumber = minHeap.poll();
            maxProduct = maxProduct * maxNumber;
        }

        int minProduct = 1;
        maxHeap.poll();
        for (int i = 0; i < 2; i++)
        {
            minProduct = minProduct * maxHeap.poll();
        }

        return Math.max(maxProduct, minProduct * maxNumber);
    }

    private void processMinHeap(Queue<Integer> minHeap, int num)
    {
        if (minHeap.size() < 3)
        {
            minHeap.add(num);
            return;
        }

        int qNum = minHeap.peek();
        if (num > qNum)
        {
            minHeap.poll();
            minHeap.add(num);
        }
    }

    private void processMaxHeap(Queue<Integer> maxHeap, int num)
    {
        if (maxHeap.size() < 3)
        {
            maxHeap.add(num);
            return;
        }

        int qNum = maxHeap.peek();
        if (num < qNum)
        {
            maxHeap.poll();
            maxHeap.add(num);
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 12, 1, 2, -3, -2, -1 };
        SolutionMaxProductOf3Integers s = new SolutionMaxProductOf3Integers();
        System.out.println(s.maximumProduct(nums));

    }

}
