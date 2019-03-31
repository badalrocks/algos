package com.badalchowdhary.algos.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        
        if (s==null) return t==null;
        if (t==null) return s==null;
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (int i=0; i < s.length(); i++)
        {
            char current = s.charAt(i);
            
            if (charCount.containsKey(current))
            {
                charCount.put(current, charCount.get(current)+1);
            }
            else
            {
                charCount.put(current, 1);
            }
            
        }
        
        for (int i=0; i<t.length(); i++)
        {
            char current = s.charAt(i);
            
            if (!charCount.containsKey(current))
            {
                return false;
            }
            else
            {
                charCount.put(current, charCount.get(current) - 1);
                if (charCount.get(current) == 0)
                {
                    charCount.remove(current);
                }
            }
            
        }
        
        return charCount.size() == 0;
        
    }
    
    public static void main(String[] args)
    {
        String s = "a";
        String t = "b";
        
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram(s, t));
    }
}