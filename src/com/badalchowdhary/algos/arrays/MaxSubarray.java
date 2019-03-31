package com.badalchowdhary.algos.arrays;

public class MaxSubarray
{

    public static void main(String[] args)
    {
        int [] a = {-2, 3, -1, 4, -2, 7};
        
        int maxSoFar = a[0];
        int currMax = a[0];
        int start = 0;
        int end = 0;
        
        for (int i=1; i<a.length; i++)
        {
            currMax = currMax + a[i];
            
            
            if (a[i] > currMax)
            {
                currMax = a[i];
                start = i;
                end = i;
                
            }
            
            if (maxSoFar < currMax)
            {
                maxSoFar = currMax;
                end = i;
            }
            
        }
        
        System.out.println("max sum: " + maxSoFar);
        System.out.println("start: " + start);
        System.out.println("end: " + end);

    }

}
