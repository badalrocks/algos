package com.badalchowdhary.interviewcake;

import java.util.Arrays;

public class Problem26ReverseCharArrayInPlace
{
    public static void reverse (char[] chars)
    {
        // TODO 
        doBoundaryChecks(chars);
        
        int leftIndex = 0;
        int rightIndex = chars.length-1;
        
        while (leftIndex < rightIndex)
        {
            char leftChar = chars[leftIndex];
            char rightChar = chars[rightIndex];
            char temp = leftChar;
            
            chars[leftIndex] = rightChar;
            chars[rightIndex] = temp;
            
            leftIndex++;
            rightIndex--;
            
        }
        
    }
    
    private static void doBoundaryChecks(char[] chars)
    {
        if (chars == null || chars.length< 1)
        {
            throw new IllegalArgumentException("Invalid input. chars cannot be null and cannot be empty.");
        }
    } 
            

    public static void main(String[] args)
    {
        char[] chars = {'a' ,'b', 'c', 'd', 'e'};
        
        reverse(chars);
        
        System.out.println(Arrays.toString(chars));
        

    }

}
