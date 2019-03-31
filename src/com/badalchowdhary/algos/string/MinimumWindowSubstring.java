package com.badalchowdhary.algos.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring{
    public static String minWindow(String s, String t) {
        
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length())
        {
            return "";
        }
        
        int minLen = Integer.MAX_VALUE;
        String minWin = "";
        Map<Character, Integer> pattern = new HashMap<>();
        for (int i=0; i<t.length(); i++)
        {
            char current = t.charAt(i);
            pattern.put(current, pattern.getOrDefault(current, 0) + 1);
        }
        
        int counter = 0;
        int start = 0;
        for (int i=0; i<s.length(); i++)
        {
            char current = s.charAt(i);
            if (pattern.containsKey(current))
            {
                pattern.put(current, pattern.get(current)-1);
                if (pattern.get(current) == 0)
                {
                    counter++;
                }
            }
            
            while (counter == pattern.size())
            {
                
                int currLen = i - start + 1;
                if (currLen < minLen)
                {
                    minLen = currLen;
                    minWin = s.substring(start, i+1);
                }
                
                if (pattern.containsKey(s.charAt(start)))
                {
                    pattern.put(s.charAt(start), pattern.get(s.charAt(start)) + 1);
                    if (pattern.get(s.charAt(start)) > 0)
                    {
                        counter--;
                    }
                }
                
                start++;
            }
        }
        
        return minWin;
        
    }
    
    public static void main(String[] args)
    {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        
        String result = minWindow(S, T);
        System.out.println(result);
        
    }
}