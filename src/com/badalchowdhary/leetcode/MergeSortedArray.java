package com.badalchowdhary.leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (m == 0)
        {
            nums1 = nums2;
            System.out.println(nums1);
            return;
        }
        
        int maxIndex = nums1.length - 1;
        m = m-1;
        n = n-1;
        
        while (n >= 0 && m >= 0)
        {
            if (nums2[n] >= nums1[m])
            {
                nums1[maxIndex] = nums2[n];
                maxIndex--;
                n--;
            }
            else
            {
                nums1[maxIndex] = nums1[m];
                maxIndex--;
                m--;
            }
        }
        
        // if m becomes -1 and n is still not merged.
        while (n >= 0)
        {
            nums1[maxIndex] = nums2[n];
            maxIndex--;
            n--;
        }
        
        
    }
    
    public static void main(String[] args)
    {
        int[] nums1 = {0};
        int m=0;
        int [] nums2 = {1};
        int n=1;
        
        System.out.println(nums1);
        
        merge(nums1, m, nums2, n);
        System.out.println(nums1);
       System.out.println(Arrays.toString(nums1));
        
        
        
    }
}