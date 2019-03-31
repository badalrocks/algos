package com.badalchowdhary.algos.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LongestSubstringUnique
{

    public static void main(String[] args)
    {

        String s = "abc";
        for (int i = 0; i < s.length(); i++)
        {
            System.out.println(i + " - " + s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); ++i)
        {
            System.out.println(i + " - " + s.charAt(i));
        }

    }
}