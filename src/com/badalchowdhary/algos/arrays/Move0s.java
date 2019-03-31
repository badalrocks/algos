package com.badalchowdhary.algos.arrays;

import java.util.Arrays;

public class Move0s
{

    public static void main(String[] args)
    {
        int[] nums = { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void moveZeroes(int[] nums)
    {

        int i = 0;
        int j = 0;

        while (i < nums.length)
        {
            if (nums[i] != 0)
            {
                i++;
            }
            else
            {
                j = i + 1;

                while (j < nums.length - 1 && nums[j] == 0)
                {
                    j++;
                }

                if (j < nums.length)
                {

                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                
                i++;

            }
        }

    }

}
