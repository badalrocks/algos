package com.badalchowdhary.algos.string;

public class MinimumWindowSubsequence
{

    public static String minWindow(String S, String T)
    {
        String result = "";
        if (S == null || T == null || S.length() < T.length())
        {
            return result;
        }

        int sStart = 0;
        int tStart = 0;

        int minWindow = Integer.MAX_VALUE;

        while (sStart < S.length() && S.charAt(sStart) != T.charAt(0))
        {
            sStart++;
        }
    
        int sEnd = sStart;
        while (sEnd < S.length())
        {
            if (S.charAt(sEnd) == T.charAt(tStart))
            {
                tStart++;

                if (tStart == T.length())
                {
                    int currWindow = sEnd - sStart + 1;
                    tStart = 0;
                    if (currWindow < minWindow)
                    {
                        minWindow = currWindow;

                        result = S.substring(sStart, sEnd + 1);

                        

                        // move sStart to match 1st char of T
                        sStart++;
                        while (sStart < S.length() && S.charAt(sStart) != T.charAt(tStart))
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

        return result;

    }

    public static void main(String[] args)
    {
        String S = "cnhczmccqouqadqtmjjzl";
        String T = "cm";
        
        System.out.println(minWindow(S, T));
    }

}
