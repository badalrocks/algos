package com.badalchowdhary.interviewcake;

import java.util.Arrays;

/**
 * You have an array of integers, and for each index you want to find the
 * product of every integer except the integer at that index.
 * 
 * @author badalrocks
 *
 */
public class Problem2AllProdsExceptIndex
{

    public static long[] getAllProdsExceptIndex(int[] nums)
    {
        // TODO do boundary checks.
        doBoundaryChecksGetAllProdsExceptIndex(nums);

        long[] leftProds = new long[nums.length];
        long runningLeftProd = 1;
        leftProds[0] = 1;

        for (int i = 1; i < nums.length; i++)
        {
            runningLeftProd = runningLeftProd * nums[i - 1];
            leftProds[i] = runningLeftProd;
        }

        long[] allProdsExceptIndex = new long[nums.length];

        long runningRightProd = 1;

        for (int i = allProdsExceptIndex.length - 1; i >= 0; i--)
        {
            allProdsExceptIndex[i] = leftProds[i] * runningRightProd;
            runningRightProd = runningRightProd * nums[i];
        }

        return allProdsExceptIndex;

    }

    private static void doBoundaryChecksGetAllProdsExceptIndex(int[] nums)
    {
        if (nums == null || nums.length <= 1)
        {
            throw new IllegalArgumentException("nums array should not be null and have more than 1 element.");
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, 10 };

        long[] allProdsExceptIndex = getAllProdsExceptIndex(nums);
        System.out.println(Arrays.toString(allProdsExceptIndex));
    }

}
