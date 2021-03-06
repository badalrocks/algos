package com.badalchowdhary.algos.arrays;

import java.util.HashMap;

public class MaxSubarraySumK
{
    public static int maxSubArrayLen(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int max = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];

            if (sum == k)
            {
                max = Math.max(max, i + 1);
            }

            int diff = sum - k;

            if (map.containsKey(diff))
            {
                max = Math.max(max, i - map.get(diff));
            }

            if (!map.containsKey(sum))
            {
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(maxSubArrayLen(new int[] { -5, 8, -14, 2, 4, 12 }, -5));
    }

}
