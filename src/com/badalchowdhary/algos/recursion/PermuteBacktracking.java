package com.badalchowdhary.algos.recursion;

import java.util.ArrayList;
import java.util.List;

class PermuteBacktracking
{
    public static List<List<Integer>> permute(int[] nums)
    {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];

        permuteHelper(nums, tempList, result, used);

        return result;

    }

    private static void permuteHelper(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used)
    {
        if (nums.length == tempList.size())
        {
            result.add(new ArrayList<>(tempList));
        }
        else
        {
            for (int i = 0; i < nums.length; i++)
            {
                /*
                 * if (tempList.contains(nums[i])) { continue; }
                 */
                if (used[i])
                {
                    continue;
                }

                used[i] = true;
                tempList.add(nums[i]);

                permuteHelper(nums, tempList, result, used);

                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args)
    {
        int nums[] = { 1, 2 };
        System.out.println(permute(nums));
    }
}