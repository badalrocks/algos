package com.badalchowdhary.interviewcake;

import java.util.ArrayList;
import java.util.List;

public class PermutationsIntArr
{
    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums)
    {
        for (int i = 0; i < tempList.size(); i++)
        {
            System.out.print("    ");
        }

        //System.out.println("calling backtrack: final list: " + list + ", tempList: " + tempList);
        System.out.println("calling backtrack: tempList: " + tempList);

        if (tempList.size() == nums.length)
        {
            list.add(new ArrayList<>(tempList));
        }
        else
        {
            for (int i = 0; i < nums.length; i++)
            {
                if (tempList.contains(nums[i]))
                {
                    continue; // element already exists, skip
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                
                for (int j = 0; j < tempList.size(); j++)
                {
                    System.out.print("    ");
                }
                System.out.println("removing: " + tempList.get(tempList.size()-1));
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2 };
        System.out.println(permute(nums));
    }

}
