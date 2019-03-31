package com.badalchowdhary.leetcode;

public class MinimumSizeSubarraySum
{
    public static int minSubArrayLen(int s, int[] nums)
    {

        // TODO boundary checks.
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++)
        {
            int runningSum = nums[i];
            int currentLength = 1;

            for (int j = i + 1; j < nums.length; j++)
            {

                if (runningSum < s && currentLength < minLength)
                {
                    runningSum = runningSum + nums[j];
                    currentLength++;
                }

            }

            if (runningSum == s)
            {
                minLength = Math.min(minLength, currentLength);
            }
        }

        return minLength;

    }

    public static int minSubArrayLen2(int s, int[] a)
    {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length)
        {
            sum += a[j++];

            while (sum >= s)
            {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public static int subArraySum(int arr[], int n, int sum) 
    {
        int curr_sum, i, j;
 
        // Pick a starting point
        for (i = 0; i < n; i++) 
        {
            curr_sum = arr[i];
 
            // try all subarrays starting with 'i'
            for (j = i + 1; j <= n; j++) 
            {
                if (curr_sum == sum) 
                {
                    int p = j - 1;
                    System.out.println("Sum found between indexes " + i
                            + " and " + p);
                    return 1;
                }
                if (curr_sum > sum || j == n)
                    break;
                curr_sum = curr_sum + arr[j];
            }
        }
 
        System.out.println("No subarray found");
        return 0;
    }

    public static void main(String[] args)
    {
        //System.out.println(minSubArrayLen2(11, new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(subArraySum(new int[] { 1, 2, 3, 4, 5 }, 6, 11));

    }

}
