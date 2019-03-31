package com.badalchowdhary.algos.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CombinationWithDups {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> current = new ArrayList<>();
        
        List<Integer> remaining = new ArrayList<>();
        for (int num : nums)
        {
            remaining.add(num);
        }
        
        
        
        Set<List<Integer>> result = new HashSet<>();
        
        subsetsWithDupHelper(current, remaining, result);
        
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.addAll(result);
        
        return allSubsets;
        
    }
    
    private static void subsetsWithDupHelper(List<Integer> current, List<Integer> remaining, Set<List<Integer>> result) 
    {
        //System.out.println("current: " + current + ", remaining: " + remaining + ", result: "+ result);
        if (remaining != null && remaining.size() == 0)
        {
            System.out.println(current);
            result.add(current);
        }
        else 
        {
            // include first element from rem.
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(remaining.get(0));
            subsetsWithDupHelper(newCurrent, remaining.subList(1, remaining.size()), result);
            
            // exclude first element from rem.
            subsetsWithDupHelper(current, remaining.subList(1, remaining.size()), result);
            
        }
    }
    
    public static void main(String[] args)
    {
        int[] nums = {1,2, 2};
        subsetsWithDup(nums);
    }
}