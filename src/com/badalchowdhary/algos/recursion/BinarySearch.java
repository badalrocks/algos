package com.badalchowdhary.algos.recursion;

import java.util.Arrays;

public class BinarySearch
{

    public static boolean binarySearch(int[] nums, int search)
    {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException("nums cannot be null or empty.");

        return binarySearchHelper(nums, search, 0, nums.length - 1);
    }

    private static boolean binarySearchHelper(int[] nums, int search, int start, int end)
    {
        System.out.println("nums: " + Arrays.toString(nums) + ", search: " + search + ", start: " + start + ", end: " + end);
        if (start == end)
        {
            return nums[start] == search;
        }

        int mid = end - (end / 2) + (start / 2);

        if (nums[mid] == search)
        {
            return true;
        }
        else if (nums[mid] > search)
        {
            return binarySearchHelper(nums, search, start, mid - 1);
        }
        else
        {
            return binarySearchHelper(nums, search, mid + 1, end);
        }

    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 3, 4, 10, 12, 50, 55, 65, 70 };
        int search = 5;

        System.out.println(binarySearch(nums, search));

    }

}
