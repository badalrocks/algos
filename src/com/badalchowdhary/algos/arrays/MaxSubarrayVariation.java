package com.badalchowdhary.algos.arrays;

import java.util.ArrayList;
import java.util.List;

// variation: return the subarray with max summ instead of sum.
public class MaxSubarrayVariation
{

    private static List<Integer> getMaxSubarray(int[] nums)
    {
    
        List<Integer> maxList = new ArrayList<>();
        List<Integer> runningList = new ArrayList<>();
        
        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;
        
        for (int num : nums)
        {
            runningSum = runningSum + num;
            if (num > runningSum)
            {
                runningList.clear();
            }
            
            runningList.add(num);
            
            runningSum = Math.max(runningSum, num);
            
            if (runningSum > maxSum)
            {
                maxSum = runningSum;
                maxList = new ArrayList<>(runningList);
            }
        }
        
        return maxList;
        
    
    }

    public static void main(String[] args)
    {
        
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        
        System.out.println(getMaxSubarray(nums));

    }

}
