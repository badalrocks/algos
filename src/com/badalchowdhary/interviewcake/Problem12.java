package com.badalchowdhary.interviewcake;

/*Suppose we had an array of nn integers sorted in ascending order. 
 * How quickly could we check if a given integer is in the array?
  */

public class Problem12
{
    public static boolean binarySearch (int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
        {
            throw new IllegalArgumentException("input array must have atleast 1 element.");
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high)
        {
            if (nums[low] == target || nums[high] == target)
            {
                return true;
            }
            
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target)
            {
                return true;
            }
            
            if (nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        
        }
        
        
        return false;
    }

    public static void main(String[] args)
    {
        int [] a = {2, 4, 6, 7, 8, 8, 10, 20, 28, 32, 97};
        int target = 28;
        
        System.out.println(binarySearch(a, target));

    }

}
