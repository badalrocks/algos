package com.badalchowdhary.leetcode;

public class MinimumStringSubsequence
{

    public static String getMinSubsequence(String s, String t)
    {
        String smallestSubsequence = "";
        int minWindowLen = s.length() + 1;
        int sStart = 0;
        int sEnd = 0;
        int tStart = 0;
        
        while (s.charAt(sStart) != t.charAt(0) )
        {
            sStart++;
            sEnd++;
        }
        
        while (sEnd < s.length())
        {
            if (s.charAt(sEnd) == t.charAt(tStart))
            {
                sEnd++;
                tStart++;
                
                if (tStart == t.length())
                {
                    // check window size.
                    int windowLen = sEnd - sStart;
                    if (windowLen <= minWindowLen)
                    {
                        minWindowLen = windowLen;
                        smallestSubsequence = s.substring(sStart, sEnd);
                        tStart = 0;
                        sStart++;
                        // move sStart to next occurance of beginning of t.
                        while (sStart < s.length() && s.charAt(sStart) != t.charAt(tStart))
                        {
                            sStart++;
                        }
                        sEnd = sStart;
                    }
                    
                }
                
            }
            else
            {
                sEnd++;
            }
        }
        
        return smallestSubsequence;
    
    }

    public static void main(String[] args)
    {
        String s = "cnhczmccqouqadqtmjjzl";
        String t = "cm";
        
        System.out.println(getMinSubsequence(s, t));

    }

}
