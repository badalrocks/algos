package com.badalchowdhary.interviewcake;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an efficient method that checks whether any permutation of an input
 * string is a palindrome.
 * 
 * @author badalrocks
 *
 */
public class Problem30PalindromePermutation
{

    public static boolean hasPalindromePermutation(String input)
    {
        // TODO
        doBoundaryChecks(input);
        
        Set<Character> unpairedChars = new HashSet<Character>();
        
        for (char c : input.toCharArray())
        {
            if (unpairedChars.contains(c))
            {
                unpairedChars.remove(c);
            }
            else
            {
                unpairedChars.add(c);
            }
        }
        
        return unpairedChars.size() <= 1;
        
    }
    
    private static void doBoundaryChecks(String input)
    {
        if (input == null)
        {
            throw new IllegalArgumentException("input string cannot be null.");
        }
    }

    public static void main(String[] args)
    {
        String input1 = "civic";
        System.out.println(hasPalindromePermutation(input1));
        
        String input2 = "cici";
        System.out.println(hasPalindromePermutation(input2));
        
        String input3 = "cicibd";
        System.out.println(hasPalindromePermutation(input3));

    }

}
