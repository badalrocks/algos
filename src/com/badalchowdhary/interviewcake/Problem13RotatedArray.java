package com.badalchowdhary.interviewcake;

/*
 * Write a method for finding the index of the "rotation point" in sorted array.
 */
public class Problem13RotatedArray
{

    /*public static int getRotationIndex(int[] nums)
    {
        // TODO do boundary checks.
        int low = 0;
        int high = nums.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid - 1])
            {
                return mid;
            }

            if (nums[mid] > nums[mid + 1])
            {
                return mid + 1;
            }

            if (nums[mid] < nums[low])
            {
                // low-mid is interesting. move high to mid.
                high = mid;
            }
            else if (nums[mid] > nums[high])
            {
                // mid-high is interesting. move low to mid.
                low = mid;
            }
            else
            {
                // array is sorted but not rotated.
                return 0;
            }

        }

        return -1;
    }*/
    
    public static int getRotationIndex(int[] nums)
    {
        doBoundaryChecks(nums);
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            
            if (mid != 0 && nums[mid] < nums[mid - 1])
            {
                return mid;
            }
            
            if (nums[mid] < nums[low])
            {
                high = mid - 1;
            }
            else if (nums[mid] > nums[high])
            {
                low = mid + 1;
            }
            else
            {
                return -1; // indicates array is sorted and no rotation point.
            }
        }
        
        
    
        return -1; // indicates array is sorted and no rotation point.
    }
    
    private static void doBoundaryChecks(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            throw new IllegalArgumentException("array cannot be null or empty.");
        }
    }

    public static void main(String[] args)
    {
        int[] nums1 = { 28, 30, 40, 2, 4, 7, 10, 15, 22 };
        System.out.println("nums1: " + getRotationIndex(nums1));

        int[] nums2 = { 28, 30, 40, 50, 60, 70, 80, 90, 100, 2, 4, 7, 10, 15, 22 };
        System.out.println("nums2: " + getRotationIndex(nums2));

        int[] nums3 = { 28, 2, 4, 7, 10, 15, 22 };
        System.out.println("nums3: " + getRotationIndex(nums3));

        int[] nums4 = { 2, 4, 7, 10, 15, 22 };
        System.out.println("nums4: " + getRotationIndex(nums4));
        
        // nums 5 in invalid input. array is reverse sorted.
        int[] nums5 = { 10, 8, 6, 4, 2};
        System.out.println("nums5: " + getRotationIndex(nums5));

        int[] nums6 = {2,3,4,5,6,7,1};
        System.out.println("nums6: " + getRotationIndex(nums6));
        
        int[] nums7 = {10, 5};
        System.out.println("nums7: " + getRotationIndex(nums7));
    }

}
