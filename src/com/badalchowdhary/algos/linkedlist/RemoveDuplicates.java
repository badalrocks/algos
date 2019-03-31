package com.badalchowdhary.algos.linkedlist;

public class RemoveDuplicates
{

  public static int removeDuplicates(int[] nums) {
        
        if (nums == null) return 0;
        if (nums.length==1) return 1;
        
        int length=0;
        
        for (int i=0; i<nums.length-1; i++)
        {
            if (nums[i] != nums[i+1])
            {
                length++;
            }
            
        }
        
        return ++length;
        
    }

    public static void main(String[] args)
    {
        int [] a = {1, 1, 2};
        System.out.println(removeDuplicates(a));
        
        int [] b = {1, 1, 1};
        System.out.println(removeDuplicates(b));
        
        int [] c = {1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(c));
        
        int [] d = {1, 1, 2, 2};
        System.out.println(removeDuplicates(d));

    }

}
