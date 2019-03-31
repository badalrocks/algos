package com.badalchowdhary.algos.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SubsetsWithDups
{
    public static List<List<Integer>> subsets(int[] nums)
    {
        List<Integer> current = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>();

        for (int num : nums)
        {
            remaining.add(num);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Set<String> processed = new HashSet<>();

        getSubsets(current, remaining, result, processed);

        return result;
    }

    private static void getSubsets(List<Integer> current, List<Integer> remaining, List<List<Integer>> result,
            Set<String> processed)
    {
        // check if already processed
        String marker = current.toString() + "|" + remaining.toString();
        if (processed.contains(marker))
        {
            return;
        }
        else
        {
            processed.add(marker);
        }

        if (remaining != null && remaining.size() == 0)
        {
            result.add(current);
        }
        else
        {
            // exclude first element from rem.
            getSubsets(current, remaining.subList(1, remaining.size()), result, processed);

            // include first element from rem and add to current.
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(remaining.get(0));
            List<Integer> newRemaining = new ArrayList<>(remaining.subList(1, remaining.size()));

            getSubsets(newCurrent, newRemaining, result, processed);
        }

    }
    
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }
}