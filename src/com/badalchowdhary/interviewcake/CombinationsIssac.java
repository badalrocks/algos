package com.badalchowdhary.interviewcake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsIssac
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start)
    {
        for (int temp : tempList)
        {
            System.out.print("    ");
        }

        System.out.println("calling backtrack with tempList: " + tempList + ", start: " + start);

        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++)
        {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);

            for (int temp : tempList)
            {
                System.out.print("    ");
            }

            System.out.println("removing: " + tempList.get(tempList.size() - 1));

            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        CombinationsIssac o = new CombinationsIssac();
        int[] nums = { 1, 2, 3 };
        System.out.println(o.subsets(nums));
    }
}