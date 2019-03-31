package com.badalchowdhary.algos.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationWithBacktracking
{
    public static List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start)
    {
        // System.out.println(tempList);

        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++)
        {
            tempList.add(nums[i]);

            for (int j = 0; j < start * 2; j++)
            {
                System.out.print(" ");
            }
            System.out.println(tempList);

            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = subsets(nums);
        // System.out.println("result: " + result);

    }

}
