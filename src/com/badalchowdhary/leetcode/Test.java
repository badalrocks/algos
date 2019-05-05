package com.badalchowdhary.leetcode;

public class Test
{

    public static void main(String[] args)
    {
        int end = 0;
        int[] nums = { 1, 3, 5, 2, 10 };
        int s = 6;
        int currentSum = 0;
        while (end < nums.length)
        {
            while (currentSum < s && end < nums.length)
            {
                currentSum = currentSum + nums[end];
                end++;
            }

            break;
        }

        System.out.println("currentSum: " + currentSum);
        System.out.println("end: " + end);

    }

}
