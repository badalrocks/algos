package com.badalchowdhary.interviewcake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSumZero
{
    public List<List<Integer>> threeSum(int[] nums)
    {

        List<List<Integer>> allTriplets = new ArrayList();
        if (nums == null || nums.length < 3)
        {
            return allTriplets;
        }

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 3; i++)
        {
            if (i == 0 || nums[i] != nums[i - 1])
            {
                getTriplets(allTriplets, nums, nums[i], i + 1, nums.length - 1);
            }
        }

        return allTriplets;

    }

    private void getTriplets(List<List<Integer>> allTriplets, int[] nums, int currentVal, int start, int end)
    {
        int searchSum = 0 - currentVal;

        while (start < end)
        {
            int currentSum = nums[start] + nums[end];

            if (currentSum == searchSum)
            {
                List<Integer> triplet = Arrays.asList(new Integer[] { currentVal, nums[start], nums[end] });
                allTriplets.add(triplet);

                while (start < end && nums[start] == nums[start + 1])
                {
                    start++;
                }

                while (start < end && nums[end] == nums[end - 1])
                {
                    end--;
                }

                start++;
                end--;
            }
            else if (currentSum < searchSum)
            {
                start++;
            }
            else
            {
                end--;
            }
        }

    }

    public static void main(String[] args)
    {
        int[] nums = { -1, 0, 1, 2, -1, -4 };

        ThreeSumZero o = new ThreeSumZero();
        List<List<Integer>> triplets = o.threeSum(nums);

        System.out.println(triplets);

    }

}