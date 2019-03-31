package com.badalchowdhary.algos.arrays;

public class RotatedSearch
{
 public static int search(int[] nums, int target) {
        
        // find mid. if mid=target, return mid.
        // else if start...mid is sorted. if target between start and mid: binary search between start and mid. else search mid+1...end.
        // else mid+1...end must be sorted. if target between mid+1 and end: binary search between mid+1 and end. else search start...mid.
        
        // 4 5 6 7 0 1 2 3
        // 7 0 1 2 3 4 5 6
        
        if (nums == null || nums.length == 0) return -1;
        
        return rotatedBinarySearch(nums, target, 0, nums.length-1);
        
    }
    
    private static int rotatedBinarySearch(int[] a, int x, int start, int end)
    {
        
        if (start == end && a[start] != x) return -1;
        
        int mid = start + (end-start)/2;
        
        if (a[mid] == x)
        {
            return mid;
        }
        
        if (a[start] <= a[mid])
        {
            // left array is sorted.
            if (a[start] <= x && a[mid] >= x)
            {
                return rotatedBinarySearch(a, x, start, mid);
            }
            
            return rotatedBinarySearch(a, x, mid+1, end);
            
        }
        
        // right array is sorted.
        if (a[mid] <= x && a[end] >= x)
        {
            return rotatedBinarySearch(a, x, mid+1, end);
        }
            
        return rotatedBinarySearch(a, x, start, mid-1);
        
        
    }
    public static void main(String[] args)
    {
        int[] nums = {5, 1, 3};
        int target = 5;
        
        System.out.println(search(nums, target));

    }

}
