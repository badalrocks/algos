package com.badalchowdhary.interviewcake;

import java.util.ArrayList;
import java.util.List;

public class CombinationBackTrack
{

    public static List<List<Integer>> getCombinations(int[] nums)
    {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(results, tempList, nums, 0);

        return results;

    }

    private static void backtrack(List<List<Integer>> results, List<Integer> tempList, int[] nums, int start)
    {
        for (int i = 0; i < tempList.size(); i++)
        {
            System.out.print("    ");
        }
        
        System.out.println("calling backtrack: tempList: " + tempList + ", start: " + start);
        
        results.add(new ArrayList<Integer>(tempList));

        for (int i = start; i < nums.length; i++)
        {
            tempList.add(nums[i]);
            backtrack(results, tempList, nums, i + 1);
            
            //System.out.println("removing from templist: " + tempList.get(tempList.size() - 1));
            
            tempList.remove(tempList.size() - 1);
        }

    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3 };
        System.out.println(getCombinations(nums));

    }

}
