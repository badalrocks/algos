package com.badalchowdhary.algos.string;

class SubstringIndex {
    public int strStr(String haystack, String needle) {
        
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        
        for (int i=0; i<haystack.length(); i++)
        {
            int compare = compare(haystack.toCharArray(), needle.toCharArray(), i);
            
            if (compare != -1)
            {
                return i;
            }
        }
        
        return -1;
        
    }
    
    
    private int compare(char[] haystack, char[] needle, int start)
    {
        for (int i=0; i < needle.length; i++)
        {
            if (needle[i] != haystack[start])
            {
                return -1;
            }
            
            start++;
        }
        
        return start - needle.length;
    }
}
